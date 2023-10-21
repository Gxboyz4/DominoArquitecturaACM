/**
 * SocketJugador.java
 * Oct 20, 2023 7:31:20 PM
 */
package org.itson.proyectoarquitecturadominoacm.socket;

import java.net.Socket;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SocketJugador extends Socket {

    private boolean estaEnPartida;
    private int puerto;
    private String ip;

    /**
     * Constructor para iniciar el socket del jugador.
     *
     * @param ip Ip del socket
     * @param puerto Puerto en el que se encuentra el socket.
     */
    public SocketJugador(String ip, int puerto) {
        this.puerto = puerto;
        this.ip = ip;
    }
}
