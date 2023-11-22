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
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaControlador;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

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
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(clienteSocket.getOutputStream());
            System.out.println("El paquete que va a enviar es: " + paqueteEnvioDatos.getTipo());
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
    public void eliminarJugador(JugadorDTO jugador) {
        empaquetarParametros(TipoPaquete.ELIMINAR_JUGADOR, jugador);
        enviarDatos();
    }

    @Override
    public synchronized void recibirDatos() {
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
    public synchronized void desempaquetarDatos() {
        System.out.println("El tipo de paquete es: " + paqueteReciboDatos.getTipo());
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            partidaDTO = partida;
            if (partida == null) {
                if (mediador.getFrmUnirse() != null) {
                    mediador.getFrmUnirse().vaciarListaPartidas();
                    mediador.getFrmUnirse().cargarTabla();
                }
            } else {
                if (mediador.getFrmLobby() != null) {
                    modificarPartidaLocal(partida);
                    mediador.getFrmLobby().cambirInformacionLider();
                    mediador.getPartida().setNumFichas(partida.getNumFichas());
                    mediador.getFrmLobby().mostrarInformacion();
                } else {
                    if (mediador.getFrmUnirse() != null && partida.getPartidaIniciada()) {
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

        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.RECUPERAR_PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            partidaDTO = partida;
            if (partida != null && !partida.getPartidaIniciada()) {

                if (mediador.getFrmUnirse() != null) {
                    modificarPartidaLocal(partida);
                    mediador.getFrmUnirse().cargarListaPartidas();
                }
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA_UNIRSE) || paqueteReciboDatos.getTipo() == (TipoPaquete.LISTO)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            if (partida != null) {
                if (mediador.getFrmLobby() != null) {
                    modificarPartidaLocal(partida);
                    mediador.getPartida().setNumFichas(partida.getNumFichas());
                    mediador.getFrmLobby().mostrarInformacion();
                }
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.CONFIGURACION_PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            if (partida != null) {
                if (mediador.getFrmLobby() != null) {

                    mediador.getPartida().setNumFichas(partida.getNumFichas());
                    mediador.getFrmLobby().mostrarInformacion();
                }
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.HAY_PARTIDA)) {
            if (mediador.getFrmMenu() != null) {
                mediador.abrirPantallaMenu();
                mediador.cerrarPantallaLobby();
                mediador.getFrmMenu().mostrarMensaje();
            }
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA_LLENA)) {
            mediador.abrirPantallaUnirse();
            mediador.recuperarPartidas();
            mediador.cerrarPantallaLobby();
            mediador.getFrmUnirse().mostrarMensaje();
        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.INICIAR_PARTIDA)) {
            if (mediador.getFrmLobby() != null) {
                mediador.getFrmLobby().abrirPantallaPartida();
                PartidaDTO partidaDTO = (PartidaDTO) paqueteReciboDatos.getObjeto();
                List<JugadorDTO> jugadores = partidaDTO.getJugadores();
                for (JugadorDTO jugador : jugadores) {
                    if (mediador.getJugador().getId() == jugador.getId()) {
                        List<FichaDTO> fichas = jugador.getFichas();
                        for (FichaDTO ficha : fichas) {
                            Ficha fichaAgregar = crearFichaDireccion(ficha);
                            mediador.getJugador().agregarFicha(fichaAgregar);
                        }
                        mediador.getPartida().suscribirFichas();
                        break;
                    }
                }
                //Esto es solo para pintar a los contrincantes
                //Necesitamos abrir el frmPartida ya que asigne la cantidad de fichas en la partida
                //Porque ahí asigna las fichas a todos
                //O lo podemos mover a partida, solo para que le de la cantidad de fichas
                //a los contrincantes: BORRAR ESTO DESPUÉS
                listaJugadorDTOJugador(jugadores);
                mediador.modificarTurno(jugadores);
                int numFichas = partidaDTO.getJugadores().get(0).getFichas().size();
                for (Contrincante contrincante : mediador.getPartida().getContrincantes()) {
                    contrincante.agregarFichasRestantes(numFichas);
                }

            }

        } else if (paqueteReciboDatos.getTipo() == (TipoPaquete.GENERAR_ID)) {

            int id = (int) paqueteReciboDatos.getObjeto();
            System.out.println(id);
            mediador.asignarIDJugadorLocal(id);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.DEVOLVER_FICHA) {
            FichaDTO fichaObtenida = (FichaDTO) paqueteReciboDatos.getObjeto();
            Ficha ficha = crearFichaDireccion(fichaObtenida);
            mediador.getJugador().agregarFicha(ficha);
            mediador.getPartida().suscribirFichas();
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.POZO_VACIO) {
            mediador.obtenerPozo().ocultarPozo();
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_CONTRINCANTE) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            Contrincante contrincante = obtenerContrincante(jugador);
            if (contrincante != null) {
                contrincante.agregarFichaRestante();
            }

        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_DERECHA) {
            FichaDTO fichaObtenida = (FichaDTO) paqueteReciboDatos.getObjeto();
            Ficha ficha = crearFicha(fichaObtenida);
            mediador.agregarFichaDerechaTablero(ficha);

        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA_IZQUIERDA) {
            FichaDTO fichaObtenida = (FichaDTO) paqueteReciboDatos.getObjeto();
            Ficha ficha = crearFicha(fichaObtenida);
            mediador.agregarFichaIzquierdaTablero(ficha);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.PASAR_TURNO) {
            PartidaDTO partidaDTO = (PartidaDTO) paqueteReciboDatos.getObjeto();
            List<JugadorDTO> jugadores = partidaDTO.getJugadores();
            System.out.println("Lista turnos justo llegan" + jugadores);
            listaJugadorDTOJugador(jugadores);
            System.out.println("Despues de convertirse" + mediador.getPartida().getJugadores());
            mediador.modificarTurno(jugadores);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.AGREGAR_FICHA) {
            FichaDTO fichaObtenida = (FichaDTO) paqueteReciboDatos.getObjeto();
            Ficha ficha = crearFicha(fichaObtenida);
            mediador.agregarFichaTablero(ficha);
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            Contrincante contrincante = obtenerContrincante(jugador);
            if (contrincante != null) {
                contrincante.quitarFicha();
            }
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.FINALIZAR_PARTIDA) {
            JugadorDTO jugadorFinalizo = 
                    (JugadorDTO) paqueteReciboDatos.getObjeto();
            int idJugadorLocal = mediador.getJugador().getId();
            int idJugadorFinalizoPartida = jugadorFinalizo.getId();
            //if(idJugadorLocal != idJugadorFinalizoPartida){
                mediador.enviarTotalPuntos();
            //}
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.RECIBIR_PUNTOS) {
            List<JugadorDTO> podio = 
                    (ArrayList<JugadorDTO>) this.paqueteReciboDatos.getObjeto();
            mediador.getFrmPodio().setPodio(podio);
            mediador.abrirPantallaPodio();
            mediador.cerrarPantallaPartida();
            //mediador.enviarSalirPartida();
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.SACAR_JUGADOR) {
            System.out.println("SACAR JUGADOR-CLIENTE");
            JugadorDTO jugador
                    = (JugadorDTO) this.paqueteReciboDatos.getObjeto();
            int idLocal = mediador.getJugador().getId();
            if (idLocal != jugador.getId()) {
                mediador.sacarJugadorPartidaPorId(jugador.getId());
                mediador.recargarPantallaPartida();
            }
        } else if (paqueteReciboDatos.getTipo() == TipoPaquete.NO_HAY_JUGADORES_EN_PARTIDA) {
            System.out.println("NO HAY JUGADORES EN PARTIDA-CLIENTE");
            mediador.noHayJugadoresPartida();
        }
    }

    public Ficha crearFicha(FichaDTO ficha) {
        FichaModelo fichaModelo = new FichaModelo(ficha.getNumeroSup(), ficha.getNumeroInf(), ficha.getImagen());
        FichaVista fichaVista = new FichaVista(fichaModelo, null);
        FichaControlador fichaControlador = new FichaControlador(fichaModelo, fichaVista);
        Ficha fichaCreada = new Ficha(fichaControlador, fichaModelo, fichaVista);

        return fichaCreada;
    }

    public void listaJugadorDTOJugador(List<JugadorDTO> jugadoresDTO) {
        for (int i = 0; i < jugadoresDTO.size(); i++) {
            for (int ii = 0; ii < jugadoresDTO.size(); ii++) {
                if (mediador.getPartida().getJugadores().get(i).getId() == jugadoresDTO.get(ii).getId()) {
                    mediador.getPartida().getJugadores().get(i).setTurno(jugadoresDTO.get(ii).getTurno());
                }
            }
        }

    }

    public Ficha crearFichaDireccion(FichaDTO ficha) {
        String rutaImagen = ficha.getDireccionImg();
        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
        FichaModelo fichaModelo = new FichaModelo(ficha.getNumeroSup(), ficha.getNumeroInf(), imagen);
        FichaVista fichaVista = new FichaVista(fichaModelo, null);
        FichaControlador fichaControlador = new FichaControlador(fichaModelo, fichaVista);
        Ficha fichaCreada = new Ficha(fichaControlador, fichaModelo, fichaVista);
        return fichaCreada;
    }

    public Contrincante obtenerContrincante(JugadorDTO jugador) {
        for (Contrincante contrincante : mediador.getPartida().getContrincantes()) {
            if (jugador.getId() == contrincante.obtenerID()) {
                return contrincante;
            }
        }
        return null;
    }

    public void modificarPartidaLocal(PartidaDTO partida) {
        if (partida != null) {
            List<Jugador> jugadores = new ArrayList();
            for (JugadorDTO jugadorDTO : partida.getJugadores()) {
                Jugador jugador = new Jugador(jugadorDTO.getNombre(), jugadorDTO.getAvatar(), jugadorDTO.getListo(), jugadorDTO.getTurno(), jugadorDTO.getId());
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

    @Override
    public PartidaDTO getPartidaDTO() {
        return partidaDTO;
    }

    public void setPartidaDTO(PartidaDTO partidaDTO) {
        this.partidaDTO = partidaDTO;
    }

}
