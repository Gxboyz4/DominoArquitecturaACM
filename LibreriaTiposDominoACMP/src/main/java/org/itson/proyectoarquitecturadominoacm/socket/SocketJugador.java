/**
 * SocketJugador.java
 * Oct 20, 2023 7:31:20 PM
 */
package org.itson.proyectoarquitecturadominoacm.socket;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SocketJugador extends Socket {

    private boolean estaEnPartida;
    private int puerto;
    private String ip;
    
    public SocketJugador(){
        
    }
    /**
     * Constructor para iniciar el socket del jugador.
     *
     * @param ip Ip del socket
     * @param puerto Puerto en el que se encuentra el socket.
     * @throws java.io.IOException
     */
    public SocketJugador(String ip, int puerto) throws IOException {
        super(ip,puerto);
        this.puerto = puerto;
        this.ip = ip;
    }

    public boolean isEstaEnPartida() {
        return estaEnPartida;
    }

    public void setEstaEnPartida(boolean estaEnPartida) {
        this.estaEnPartida = estaEnPartida;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}
