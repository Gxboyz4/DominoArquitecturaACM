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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.itson.brokerdominoacmp.Broker.Broker.puertoServidor;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
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

    public void iniciarSocketServidor() {
        try {
            ServerSocket socketServer = new ServerSocket(puertoServidor);
            servidorSocket = socketServer.accept();
            System.out.println("Aceptó conexión servidor");
            Broker.direccionesServerSocket.add(servidorSocket);
            this.enviarInformacionCliente(servidorSocket);
            //socketServidor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public synchronized void enviarInformacionCliente(Socket socketServidor) {
        try {
            while (true) {
                PaqueteDatos paqueteReciboDatos;
                ObjectInputStream paqueteDatos = new ObjectInputStream(socketServidor.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();

                //Limpiar este método
                if (paqueteReciboDatos.getTipo() == TipoPaquete.PARTIDA_UNIRSE
                        || paqueteReciboDatos.getTipo() == TipoPaquete.LISTO || paqueteReciboDatos.getTipo() == TipoPaquete.PARTIDA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.INICIAR_PARTIDA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.CONFIGURACION_PARTIDA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.POZO_VACIO
                        || paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_CONTRINCANTE
                        || paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_DERECHA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_IZQUIERDA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE
                        || paqueteReciboDatos.getTipo() == TipoPaquete.PASAR_TURNO
                        || paqueteReciboDatos.getTipo() == TipoPaquete.FINALIZAR_PARTIDA
                        || paqueteReciboDatos.getTipo() == TipoPaquete.RECIBIR_PUNTOS
                        || paqueteReciboDatos.getTipo() == TipoPaquete.SACAR_JUGADOR
                        || paqueteReciboDatos.getTipo() == TipoPaquete.NO_HAY_JUGADORES_EN_PARTIDA) {
                    enviarInformacionJugadoresPartida(paqueteDatos, paqueteReciboDatos);
                }
                if (paqueteReciboDatos.getTipo() == TipoPaquete.RECUPERAR_PARTIDA || paqueteReciboDatos.getTipo() == TipoPaquete.PARTIDA) {
                    enviarInformacionTodos(paqueteDatos, paqueteReciboDatos);
                }
                if (paqueteReciboDatos.getTipo() == TipoPaquete.GENERAR_ID || paqueteReciboDatos.getTipo() == TipoPaquete.DEVOLVER_FICHA) {
                    enviarInformacionSoloUno(paqueteDatos, paqueteReciboDatos);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public synchronized void enviarInformacionTodos(ObjectInputStream paqueteDatos, PaqueteDatos paqueteReciboDatos) throws IOException {
        for (int i = 0; i < Broker.direccionesClienteSocket.size(); i++) {
            System.out.println("Envio los paquetes a cada cliente " + paqueteReciboDatos.getTipo());
            Socket socketEnviarCliente = Broker.direccionesClienteSocket.get(i);
            ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarCliente.getOutputStream());
            paqueteDatosEnvio.writeObject(paqueteReciboDatos);
        }
    }

    public synchronized void enviarInformacionJugadoresPartida(ObjectInputStream paqueteDatos, PaqueteDatos paqueteReciboDatos) throws IOException {
        System.out.println(Broker.direccionesClienteSocketPartida);
        for (int i = 0; i < Broker.direccionesClienteSocketPartida.size(); i++) {

            System.out.println("Envio los paquetes a cada cliente " + paqueteReciboDatos.getTipo());
            Socket socketEnviarCliente = Broker.direccionesClienteSocketPartida.get(i);
            ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarCliente.getOutputStream());
            paqueteDatosEnvio.writeObject(paqueteReciboDatos);
        }
       // List<Socket> socketsARemover = new ArrayList<>();
        if (paqueteReciboDatos.getTipo() == TipoPaquete.RECIBIR_PUNTOS) {
            for (Socket socket : Broker.direccionesClienteSocketPartida) {
                Broker.direccionesClienteSocket.add(socket);
                //socketsARemover.add(socket);
            }
            Broker.direccionesClienteSocketPartida.clear();
        }
    }

    public synchronized void enviarInformacionSoloUno(ObjectInputStream paqueteDatos, PaqueteDatos paqueteReciboDatos) throws IOException {
        Socket socketEnviarCliente = Broker.socketID;
        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarCliente.getOutputStream());
        paqueteDatosEnvio.writeObject(paqueteReciboDatos);
    }

    @Override
    public void run() {
        iniciarSocketServidor();
    }

}
