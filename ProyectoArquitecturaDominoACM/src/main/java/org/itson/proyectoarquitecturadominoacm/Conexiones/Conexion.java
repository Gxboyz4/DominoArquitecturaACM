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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.socket.SocketJugador;

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
            
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(clienteSocket.getOutputStream());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            ex.getStackTrace();
            
        }
    }

    @Override
    public void cerrarSocket() {
        try {
            clienteSocket.close();
        } catch (IOException ex) {
            
        }
    }

    @Override
    public void eliminarJugador(JugadorDTO jugador) {
        empaquetarParametros(TipoPaquete.ELIMINAR_JUGADOR, jugador);
        enviarDatos();
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
            
        }
    }

    @Override
    public void desempaquetarDatos() {
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            partidaDTO = partida;
            if (partida == null ) {
                if (mediador.getFrmUnirse() != null ) {
                    mediador.getFrmUnirse().vaciarListaPartidas();
                    mediador.getFrmUnirse().cargarTabla();                    
                }
            }else{
                if(mediador.getFrmLobby()!=null){
                    modificarPartidaLocal(partida);
                    mediador.getFrmLobby().mostrarInformacion();   
                }else{
                    if(mediador.getFrmUnirse()!=null&&partida.getPartidaIniciada())
                    {
                        mediador.getFrmUnirse().vaciarListaPartidas();
                        mediador.getFrmUnirse().cargarTabla();  
                    }
                }
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.JUGADOR)) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            jugadorDTO = jugador;
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.FICHA)) {
//        FichaDTO ficha = (FichaDTO) paqueteReciboDatos.getObjecto();

        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.RECUPERAR_PARTIDA) ) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            partidaDTO = partida;
            if (partida != null && !partida.getPartidaIniciada()) {
                
                if (mediador.getFrmUnirse() != null) {
                    modificarPartidaLocal(partida);
                    mediador.getFrmUnirse().cargarListaPartidas();
                }
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA_UNIRSE)|| paqueteReciboDatos.getTipo() == (TipoPaquete.LISTO)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            if (partida != null) {
                if (mediador.getFrmLobby() != null) {
                    modificarPartidaLocal(partida);
                    mediador.getFrmLobby().mostrarInformacion();
                }
            }
        }else if(paqueteReciboDatos.getTipo()== (TipoPaquete.HAY_PARTIDA)){
                if (mediador.getFrmMenu() != null) {
                    mediador.abrirPantallaMenu();
                    mediador.cerrarPantallaLobby();
                    mediador.getFrmMenu().mostrarMensaje();
                }
        }else if(paqueteReciboDatos.getTipo()== (TipoPaquete.PARTIDA_LLENA)){
                    mediador.abrirPantallaUnirse();
                    mediador.recuperarPartidas();
                    mediador.cerrarPantallaLobby();
                    mediador.getFrmUnirse().mostrarMensaje();
        }
        else if(paqueteReciboDatos.getTipo() == (TipoPaquete.INICIAR_PARTIDA))
        {
            if(mediador.getFrmLobby() != null)
            {
                mediador.getFrmLobby().abrirPantallaPartida();
                PartidaDTO partidaDTO = (PartidaDTO) paqueteReciboDatos.getObjeto();
                System.out.println(partidaDTO.getJugadores().get(0).getFichas());
            }
            
        }else if (paqueteReciboDatos.getTipo() == (TipoPaquete.GENERAR_ID)){
            System.out.println("ID Jugador parte cliente");
            int id = (int)paqueteReciboDatos.getObjeto();
            System.out.println(id);
            mediador.asignarIDJugadorLocal(id);
        }
    }
    
    public void modificarPartidaLocal(PartidaDTO partida) {
        if(partida!=null){
        List<Jugador> jugadores = new ArrayList();
        for (JugadorDTO jugadorDTO : partida.getJugadores()) {
            Jugador jugador = new Jugador(jugadorDTO.getNombre(), jugadorDTO.getAvatar(),jugadorDTO.getListo());
            jugadores.add(jugador);
        }
        mediador.getPartida().setJugadores(jugadores);
        }
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

    public PartidaDTO getPartidaDTO() {
        return partidaDTO;
    }

    public void setPartidaDTO(PartidaDTO partidaDTO) {
        this.partidaDTO = partidaDTO;
    }

}
