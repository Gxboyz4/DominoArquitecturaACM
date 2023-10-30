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
import org.itson.libreriatiposdominoacmp.TipoPaquete;
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
                    if (paqueteReciboDatos.getTipo() == TipoPaquete.PARTIDA) {
                        verificarPartidaCreada(socketCliente, paqueteDatos, paqueteReciboDatos);
                    } else if (paqueteReciboDatos.getTipo() == TipoPaquete.UNIRSE_PARTIDA) {
                        verificarPartidaLlena(socketCliente, paqueteDatos, paqueteReciboDatos);
                    } else if (paqueteReciboDatos.getTipo() == TipoPaquete.ELIMINAR_JUGADOR) {
                        Broker.direccionesClienteSocket.add(socketCliente);
                        Broker.direccionesClienteSocketPartida.remove(socketCliente);
                        Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                        paqueteDatosEnvio.writeObject(paqueteReciboDatos);
                    } else {
                        Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                        paqueteDatosEnvio.writeObject(paqueteReciboDatos);
                    }
                    System.out.println("Enviar info al servidor " + paqueteReciboDatos.getTipo());
                }
            } catch (IOException ex) {
                System.out.println("Eliminé el socket en la tercera vuelta");
                ex.printStackTrace();
                this.eliminarConexion();
            } catch (ClassNotFoundException ex) {
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

        public void verificarPartidaCreada(Socket socketCliente, ObjectInputStream paqueteDatos, PaqueteDatos paqueteReciboDatos) throws IOException {
            if (Broker.direccionesClienteSocketPartida.size() == 0) {
                Broker.direccionesClienteSocketPartida.add(socketCliente);
                Broker.direccionesClienteSocket.remove(socketCliente);
                Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                paqueteDatosEnvio.writeObject(paqueteReciboDatos);
            } else {
                PaqueteDatos paqueteRegreso = new PaqueteDatos(TipoPaquete.HAY_PARTIDA, null);
                ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketCliente.getOutputStream());
                paqueteDatosEnvio.writeObject(paqueteRegreso);
            }
        }

        public void verificarPartidaLlena(Socket socketCliente, ObjectInputStream paqueteDatos, PaqueteDatos paqueteReciboDatos) throws IOException {
            if (Broker.direccionesClienteSocketPartida.size() < 4) {
                Broker.direccionesClienteSocketPartida.add(socketCliente);
                Broker.direccionesClienteSocket.remove(socketCliente);
                Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                paqueteDatosEnvio.writeObject(paqueteReciboDatos);
            } else {
                PaqueteDatos paqueteRegreso = new PaqueteDatos(TipoPaquete.PARTIDA_LLENA, null);
                ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketCliente.getOutputStream());
                paqueteDatosEnvio.writeObject(paqueteRegreso);
            }
        }

        @Override
        public void run() {
            enviarInformacionServidor(socketCliente);
        }

    }

}
