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
import java.util.HashMap;
import java.util.Map;
import org.itson.proyectoarquitecturadominoacm.DTOs.PaqueteDatos;
import org.itson.proyectoarquitecturadominoacm.DTOs.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import org.itson.proyectoarquitecturadominoacm.socket.SocketJugador;

/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyCliente{
    
    PaqueteDatos paqueteEnvioDatos;
    int puerto = 9091;
    SocketJugador clienteSocket;
    final String ip = "localhost";

    public Conexion() {
    
    }

    @Override
    public void empaquetarParametros(TipoPaquete tipo,Object objeto) {
       paqueteEnvioDatos = new PaqueteDatos(tipo,objeto);
    }

    @Override
    public void iniciarSocket() {
        try {
            clienteSocket = new SocketJugador(ip, puerto);
            clienteSocket.connect(new InetSocketAddress(ip,puerto));
        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }
   
    @Override
    public void enviarDatos() {
        try {

            ObjectOutputStream paqueteDatos = new ObjectOutputStream(clienteSocket.getOutputStream());
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

//    @Override
//    public void recibirDatos() {
//        try {
//            while (true) {
//                ObjectInputStream paqueteDatos = new ObjectInputStream(clienteSocket.getInputStream());
//                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
//                desempaquetarDatos();
//            }
//        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//    }

//    @Override
//    public void desempaquetarDatos() {
//        String nombre, mensaje, ip;
//        nombre = paqueteReciboDatos.getNombre();
//        mensaje = paqueteReciboDatos.getMensaje();
//        ip = paqueteReciboDatos.getIp();
//        System.out.println(nombre + ": " + mensaje);
//    }
    
     public void cambiarEstadoSocket(Boolean estado){
       clienteSocket.setEstaEnPartida(estado);
    }
//    @Override
//    public void iniciarHilo() {
//    Thread conexionCliente = new Thread(this);
//    conexionCliente.start();
//    }
//    
//    @Override
//    public void run() {
//        recibirDatos();
//    }
}
