/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.brokerdominoacmp.Broker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.itson.brokerdominoacmp.Broker.Broker.puertoServidor;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.proyectoarquitecturadominoacm.socket.SocketJugador;

/**
 *
 * @author Gabriel Mancinas
 */
public class BrokerServidor implements Runnable {
    static Socket servidorSocket;
    static Socket socketRemitente;

    public static Socket getServidorSocket() {
        return servidorSocket;
    }

    public static void setServidorSocket(Socket servidorSocket) {
        BrokerServidor.servidorSocket = servidorSocket;
    }

    public Socket getSocketRemitente() {
        return socketRemitente;
    }

    public void setSocketRemitente(SocketJugador socketRemitente) {
        this.socketRemitente = socketRemitente;
    }
    
    public BrokerServidor() {
        servidorSocket = new Socket();
    }

    public  void iniciarSocketServidor() {
        try {
            ServerSocket socketServer = new ServerSocket(puertoServidor);
            servidorSocket = socketServer.accept();
            System.out.println("Aceptó conexión servidor");
            Broker.direccionesServerSocket.add(servidorSocket);
            while (true) {
                this.enviarInformacionCliente(servidorSocket);
            }
            //socketServidor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public  void enviarInformacionCliente(Socket socketServidor) {
        try {
           PaqueteDatos paqueteDatosRecibido;
            ObjectInputStream paqueteDatos = new ObjectInputStream(socketServidor.getInputStream());
             paqueteDatosRecibido = (PaqueteDatos) paqueteDatos.readObject();
//            if (paqueteDatosRecibido.getPara() == Mensaje.CLIENTE) {
                //String ipRemitente = paqueteDatosRecibido.getIp();
                System.out.println("Lista sockets clientes: "+Broker.direccionesClienteSocket);
                for (int i = 0; i < Broker.direccionesClienteSocket.size(); i++) {
                    //if (!socketRemitente.equals(Broker.direccionesClienteSocket.get(i))) {
                        System.out.println("Envio los paquetes a cada cliente "+paqueteDatosRecibido.getTipo());
                        Socket socketEnviarCliente = Broker.direccionesClienteSocket.get(i);
                        System.out.println(Broker.direccionesClienteSocket.size());
                        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarCliente.getOutputStream());
                        paqueteDatosEnvio.writeObject(paqueteDatosRecibido);
                    //}
                }
//            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());        }
    }

    @Override
    public void run() {
        iniciarSocketServidor();
    }

}
