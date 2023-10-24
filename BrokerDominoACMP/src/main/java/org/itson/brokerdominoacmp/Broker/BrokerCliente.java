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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.itson.brokerdominoacmp.Broker.Broker.puertoCliente;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.proyectoarquitecturadominoacm.socket.SocketJugador;

/**
 *
 * @author Gabriel Mancinas
 */
public class BrokerCliente implements Runnable {

    public void iniciarSocketCliente() {
        try {
            ServerSocket socketBroker = new ServerSocket(puertoCliente);
            while (true) {
                Socket socketCliente;
                socketCliente = socketBroker.accept();
                System.out.println("Aceptó conexión de jugador");
                //direccionCliente = socketCliente.getInetAddress().getHostAddress();
                //Broker.direccionesClientes.add(direccionCliente);
                Broker.direccionesClienteSocket.add(socketCliente);
                Thread hilo = new Thread(new enviarInformacionCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        this.iniciarSocketCliente();
    }

    
    
    public class enviarInformacionCliente implements Runnable {

        Socket socketCliente;

        public enviarInformacionCliente(Socket socketCliente) {
            this.socketCliente = socketCliente;

        }

        public void enviarInformacionServidor(Socket socketCliente) {
            try {
                while (true) {  
                    BrokerServidor.socketRemitente = socketCliente;
                    ObjectInputStream paqueteDatos = new ObjectInputStream(socketCliente.getInputStream());
                    PaqueteDatos paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                    Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                    ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                    paqueteDatosEnvio.writeObject(paqueteReciboDatos);
                    System.out.println("Final delmetodo enviar info al server");
                }
            } catch (IOException ex) {
               this.eliminarConexion();
        }   catch (ClassNotFoundException ex) {
                ex.printStackTrace();            
        }
   
        }
        public void eliminarConexion() {
            try {
                Broker.direccionesClienteSocket.remove(socketCliente);
                this.socketCliente.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar la conexion");
            }
        }

        @Override
        public void run() {
            enviarInformacionServidor(socketCliente);
        }

    }

}
