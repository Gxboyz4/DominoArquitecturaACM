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
import org.itson.proyectoarquitecturadominoacm.DTOs.PaqueteDatos;
import org.itson.proyectoarquitecturadominoacm.DTOs.TipoPaquete;


/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyServidor, Runnable{
    
    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    int puerto = 9090;
    Socket servidorSocket;
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
            servidorSocket = new Socket(ip, puerto);
            servidorSocket.connect(new InetSocketAddress(ip,puerto));
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
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void desempaquetarDatos() {
        System.out.println(paqueteReciboDatos.getTipo());
    }
    
//     public void cambiarEstadoSocket(Boolean estado){
//       servidorSocket.setEstaEnPartida(estado);
//    }
    
    @Override
    public void iniciarHilo() {
    Thread conexion = new Thread(this);
    conexion.start();
    }
//    
    @Override
    public void run() {
        recibirDatos();
    }
}
