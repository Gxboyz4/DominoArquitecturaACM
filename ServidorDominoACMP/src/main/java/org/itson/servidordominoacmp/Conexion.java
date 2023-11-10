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
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;



/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyServidor, Runnable{
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
    public void empaquetarParametros(TipoPaquete tipo,Object objeto) {
       paqueteEnvioDatos = new PaqueteDatos(tipo,objeto);
       enviarDatos();
    }

    @Override
    public void iniciarSocket() {
        try {
            servidorSocket = new Socket(ip, puerto);
            servidorSocket.connect(new InetSocketAddress(ip,puerto));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    @Override
    public void enviarDatos() {
        try {
            System.out.println("Servidor: Envio datos al cliente");
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
        System.out.println("Desempaquetar en server: "+paqueteReciboDatos.getTipo());
        if(paqueteReciboDatos.getTipo()==(TipoPaquete.PARTIDA)){
        this.infoServer.setPartidaEnServidor((PartidaDTO) paqueteReciboDatos.getObjeto());
        empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA,infoServer.getPartidaEnServidor());
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.RECUPERAR_PARTIDA)){
        empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA,infoServer.getPartidaEnServidor());
        }if(paqueteReciboDatos.getTipo()==(TipoPaquete.CONFIGURACION_PARTIDA)){
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
             this.infoServer.getPartidaEnServidor().setNumFichas(partida.getNumFichas());
             empaquetarParametros(TipoPaquete.CONFIGURACION_PARTIDA,infoServer.getPartidaEnServidor());
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.UNIRSE_PARTIDA)){
        JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
        infoServer.getPartidaEnServidor().agregarJugador(jugadorDTO);
        empaquetarParametros(TipoPaquete.PARTIDA_UNIRSE,infoServer.getPartidaEnServidor());
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.ELIMINAR_JUGADOR)){
        JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
        infoServer.getPartidaEnServidor().eliminarJugador(jugadorDTO);
        System.out.println(jugadorDTO);
        System.out.println(infoServer.getPartidaEnServidor().getJugadores());
        if(infoServer.getPartidaEnServidor().getJugadores().size()==0){
        infoServer.eliminarPartida();
        }
        empaquetarParametros(TipoPaquete.PARTIDA,infoServer.getPartidaEnServidor());
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.LISTO)){
            JugadorDTO jugadorDTO = (JugadorDTO) paqueteReciboDatos.getObjeto();
            infoServer.getPartidaEnServidor().actualizarJugador(jugadorDTO);
            empaquetarParametros(TipoPaquete.LISTO,infoServer.getPartidaEnServidor());
            if(LogicaServidor.comprobarVotacion(infoServer.getPartidaEnServidor()))
            {
                infoServer.getPartidaEnServidor().setPartidaIniciada(true);
                
                
                logicaServidor.repartirFichasJugadores(infoServer);
                empaquetarParametros(TipoPaquete.INICIAR_PARTIDA,infoServer.getPartidaEnServidor());
                empaquetarParametros(TipoPaquete.PARTIDA,infoServer.getPartidaEnServidor());
            }
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.GENERAR_ID)){
            int id = logicaServidor.generarIdJugador();
            empaquetarParametros(TipoPaquete.GENERAR_ID,id);
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
