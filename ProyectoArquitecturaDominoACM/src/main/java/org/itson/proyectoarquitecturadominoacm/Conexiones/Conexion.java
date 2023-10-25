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
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.socket.SocketJugador;

/**
 *
 * @author Gabriel Mancinas
 */
public class Conexion implements IProxyCliente, Runnable{
    
    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    JugadorDTO jugadorDTO;
    PartidaDTO partidaDTO;
    int puerto = 9091;
    Socket clienteSocket;
    final String ip = "localhost";

    public Conexion() {
    
    }

    @Override
    public void empaquetarParametros(TipoPaquete tipo,Object objeto) {
        if(objeto!=null){
        paqueteEnvioDatos = new PaqueteDatos(tipo,objeto);
        }else{
        paqueteEnvioDatos = new PaqueteDatos(tipo);
        }
    }

    @Override
    public void iniciarSocket() {
        try {
            clienteSocket = new Socket(ip, puerto);
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

    @Override
    public void recibirDatos() {
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
    public void desempaquetarDatos() {
        if(paqueteReciboDatos.getTipo()==(TipoPaquete.PARTIDA)){
        PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
//      System.out.println( partida.getJugadores().get(0));
        partidaDTO = partida;
        mediador.getFrmUnirse().colocarPartida();
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.JUGADOR)){
        JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
        System.out.println(jugador.getNombre());
        jugadorDTO = jugador;
        }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.FICHA)){
//        FichaDTO ficha = (FichaDTO) paqueteReciboDatos.getObjecto();
//        System.out.println(ficha);
    }else if(paqueteReciboDatos.getTipo()==(TipoPaquete.RECUPERAR_PARTIDA)){ 
        PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
        partidaDTO = partida;
        mediador.getFrmUnirse().cargarListaPartidas();
        mediador.getFrmUnirse().cargarTabla();
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

    @Override
    public JugadorDTO getJugadorDTO() {
        return jugadorDTO;
    }
    
    public void setJugadorDTO(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    public PartidaDTO getPartidaDTO() {
        return partidaDTO;
    }

    public void setPartidaDTO(PartidaDTO partidaDTO) {
        this.partidaDTO = partidaDTO;
    }
    
    
}
