/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Conexiones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadomininoacm.Desempaquetar.EstablecerSiguiente;
import org.itson.proyectoarquitecturadomininoacm.Desempaquetar.IDesempaquetar;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaControlador;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyCliente, Runnable {

    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    JugadorDTO jugadorDTO;
    PartidaDTO partidaDTO;
    int puerto = 9091;
    Socket clienteSocket;
    final String ip = "localhost";
 IDesempaquetar desempaquetar = new EstablecerSiguiente();
    public Conexion() {

    }

    @Override
    public void empaquetarParametros(TipoPaquete tipo, Object objeto) {
        if (objeto != null) {
            paqueteEnvioDatos = new PaqueteDatos(tipo, objeto);
        } else {
            paqueteEnvioDatos = new PaqueteDatos(tipo);
        }
    }

    @Override
    public void iniciarSocket() {
        try {
            clienteSocket = new Socket(ip, puerto);
            clienteSocket.connect(new InetSocketAddress(ip, puerto));
        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(clienteSocket.getOutputStream());
            System.out.println("El paquete que va a enviar es: " + paqueteEnvioDatos.getTipo());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void cerrarSocket() {
        try {
            clienteSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminarJugador(JugadorDTO jugador) {
        empaquetarParametros(TipoPaquete.ELIMINAR_JUGADOR, jugador);
        enviarDatos();
    }

    @Override
    public synchronized void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(clienteSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public synchronized void desempaquetarDatos() {
       System.out.println("El tipo de paquete es: " + paqueteReciboDatos.getTipo());
        desempaquetar.manejarSolicitud(paqueteReciboDatos);
    }

    @Override
    public void iniciarHilo() {
        Thread hiloConexion = new Thread(this);
        hiloConexion.start();
    }

    @Override
    public void run() {
        recibirDatos();
    }

    @Override
    public JugadorDTO getJugadorDTO() {
        return jugadorDTO;
    }

    public void setJugadorDTO(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    @Override
    public PartidaDTO getPartidaDTO() {
        return partidaDTO;
    }

    public void setPartidaDTO(PartidaDTO partidaDTO) {
        this.partidaDTO = partidaDTO;
    }

}
