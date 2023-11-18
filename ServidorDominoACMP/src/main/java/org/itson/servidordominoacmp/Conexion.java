/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;

/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyServidor, Runnable {

    InformacionServidor infoServer = new InformacionServidor();
    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    int puerto = 9090;
    Socket servidorSocket;
    LogicaServidor logicaServidor = new LogicaServidor();
    final String ip = "localhost";

    //PartidaDTO partidaDTO;
    public Conexion() {

    }

    @Override
    public void empaquetarParametros(TipoPaquete tipo, Object objeto) {
        paqueteEnvioDatos = new PaqueteDatos(tipo, objeto);
        enviarDatos();
    }

    @Override
    public void iniciarSocket() {
        try {
            servidorSocket = new Socket(ip, puerto);
            servidorSocket.connect(new InetSocketAddress(ip, puerto));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidorSocket.getOutputStream());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void cerrarSocket() {
        try {
            servidorSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(servidorSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
                paqueteEnvioDatos = paqueteReciboDatos;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void desempaquetarDatos() {
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA)) {
            this.infoServer.setPartidaEnServidor((PartidaDTO) paqueteReciboDatos.getObjeto());
            empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA, infoServer.getPartidaEnServidor());
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.RECUPERAR_PARTIDA)) {
            empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA, infoServer.getPartidaEnServidor());
        }
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.CONFIGURACION_PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            this.infoServer.getPartidaEnServidor().setNumFichas(partida.getNumFichas());
            empaquetarParametros(TipoPaquete.CONFIGURACION_PARTIDA, infoServer.getPartidaEnServidor());
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.UNIRSE_PARTIDA)) {
            JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
            infoServer.getPartidaEnServidor().agregarJugador(jugadorDTO);
            empaquetarParametros(TipoPaquete.PARTIDA_UNIRSE, infoServer.getPartidaEnServidor());
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.ELIMINAR_JUGADOR)) {
            JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
            infoServer.getPartidaEnServidor().eliminarJugador(jugadorDTO);
            if (infoServer.getPartidaEnServidor().getJugadores().isEmpty()
                    && !infoServer.getPartidaEnServidor().getPartidaIniciada()) {
                infoServer.eliminarPartida();
                empaquetarParametros(TipoPaquete.PARTIDA, infoServer.getPartidaEnServidor());
            }
            if (infoServer.getCantidadJugadores() == 1
                    && !infoServer.getPartidaEnServidor().getPartidaIniciada()) {
                this.empaquetarParametros(TipoPaquete.PARTIDA, infoServer.getPartidaEnServidor());
            }
            if (this.infoServer.getCantidadJugadores() > 1
                    && infoServer.getPartidaEnServidor().getPartidaIniciada()) {
                infoServer.agregarFichasPozo(jugadorDTO.getFichas());
                this.empaquetarParametros(TipoPaquete.SACAR_JUGADOR, jugadorDTO);
            }
            if (infoServer.getCantidadJugadores() <= 1
                    && infoServer.getPartidaEnServidor().getPartidaIniciada()) {
                this.infoServer.eliminarPartida();
                this.empaquetarParametros(TipoPaquete.NO_HAY_JUGADORES_EN_PARTIDA, null);
            }

        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.LISTO)) {
            JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
            infoServer.getPartidaEnServidor().actualizarJugador(jugadorDTO);
            empaquetarParametros(TipoPaquete.LISTO, infoServer.getPartidaEnServidor());
            if (LogicaServidor.comprobarVotacion(infoServer.getPartidaEnServidor())) {
                infoServer.getPartidaEnServidor().setPartidaIniciada(true);
                infoServer.getPozoServidor().reiniciarPozo();
                logicaServidor.repartirFichasJugadores(infoServer);
                logicaServidor.repartirTurnos(infoServer);
                empaquetarParametros(TipoPaquete.INICIAR_PARTIDA, infoServer.getPartidaEnServidor());
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.GENERAR_ID)) {
            int id = logicaServidor.generarIdJugador();
            empaquetarParametros(TipoPaquete.GENERAR_ID, id);
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.PASAR_TURNO)) {
            logicaServidor.pasarTurno(infoServer);
            empaquetarParametros(TipoPaquete.PASAR_TURNO, infoServer.getPartidaEnServidor());
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.OBTENER_FICHA)) {
            if (logicaServidor.pozoEstaVacio(infoServer)) {
                empaquetarParametros(TipoPaquete.POZO_VACIO, null);
            } else {
                FichaDTO ficha = logicaServidor.devolverFicha(infoServer);
                JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
                empaquetarParametros(TipoPaquete.DEVOLVER_FICHA, ficha);
                empaquetarParametros(TipoPaquete.AGREGAR_FICHA_CONTRINCANTE, jugador);
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.AGREGAR_FICHA_DERECHA)) {
            FichaDTO ficha = (FichaDTO) paqueteReciboDatos.getObjeto();
            empaquetarParametros(TipoPaquete.AGREGAR_FICHA_DERECHA, ficha);
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.AGREGAR_FICHA_IZQUIERDA)) {
            FichaDTO ficha = (FichaDTO) paqueteReciboDatos.getObjeto();
            empaquetarParametros(TipoPaquete.AGREGAR_FICHA_IZQUIERDA, ficha);
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.AGREGAR_FICHA)) {
            FichaDTO ficha = (FichaDTO) paqueteReciboDatos.getObjeto();
            empaquetarParametros(TipoPaquete.AGREGAR_FICHA, ficha);
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE)) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            empaquetarParametros(TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE, jugador);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.FINALIZAR_PARTIDA) {
            JugadorDTO jugadorGanador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            empaquetarParametros(TipoPaquete.FINALIZAR_PARTIDA, jugadorGanador);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.ENVIAR_PUNTOS) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            this.empaquetarParametros(
                    TipoPaquete.RECIBIR_PUNTOS,
                    jugador
            );
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.FINALIZO_PARTIDA) {
            JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
            infoServer.getPartidaEnServidor().eliminarJugador(jugadorDTO);
            if (infoServer.getCantidadJugadores() == 0) {
                this.infoServer.eliminarPartida();
            }
        }
    }

    @Override
    public void iniciarHilo() {
        Thread conexion = new Thread(this);
        conexion.start();
    }

    @Override
    public void run() {
        recibirDatos();
    }
}
