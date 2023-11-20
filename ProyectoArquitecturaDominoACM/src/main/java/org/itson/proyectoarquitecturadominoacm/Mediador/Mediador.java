/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import org.itson.proyectoarquitecturadominoacm.UI.FrmLobby;
import org.itson.proyectoarquitecturadominoacm.UI.FrmMenu;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPartida;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPrincipal;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPodio;
import org.itson.proyectoarquitecturadominoacm.UI.FrmUnirse;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author Gabriel Mancinas
 */
public class Mediador implements IMediador {

    Jugador jugador;
    FrmPrincipal frmPrincipal;
    FrmMenu frmMenu;
    FrmLobby frmLobby;
    FrmPartida frmPartida;
    FrmUnirse frmUnirse;
    Partida partida;
    FrmPodio frmPodio;
    ProxyCliente proxyCliente = new ProxyCliente();

    @Override
    public void reiniciarJugador() {
        String nombre = this.jugador.getNombre();
        ImageIcon avatar = this.jugador.getAvatar();
        int id = this.jugador.getId();
        this.jugador = new Jugador(nombre, avatar);
        this.jugador.setListo(false);
        this.jugador.setId(id);
        this.frmPodio = FrmPodio.getInstance();
    }

    @Override
    public void registrarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void abrirPantallaPartida() {
        this.frmPartida = new FrmPartida();
        frmPartida.setVisible(true);
    }

    @Override
    public void iniciarPrograma() {
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public void crearPartida(Jugador jugador, int fichas) {
        this.partida = new Partida(jugador, fichas);
    }

    @Override
    public void crearPartida(Jugador jugador) {
        this.partida = new Partida(jugador);
    }

    @Override
    public void crearPartida() {
        this.partida = new Partida();
    }

    @Override
    public Partida getPartida() {
        return partida;
    }

    @Override
    public void abrirPantallaPrincipal() {
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }

    @Override
    public void abrirPantallaMenu() {
        FrmMenu frmMenu = new FrmMenu();
        this.frmMenu = frmMenu;
    }

    @Override
    public void abrirPantallaLobby() {
        FrmLobby frmLobby = new FrmLobby();
        this.frmLobby = frmLobby;
        //mediador.getFrmLobby().asignarInformacionJugadores();
    }

    @Override
    public void abrirPantallaUnirse() {
        FrmUnirse frmUnirse = new FrmUnirse();
        this.frmUnirse = frmUnirse;
    }

    @Override
    public void abrirPantallaPodio() {
        this.frmPodio.abrirVentanaPodio();
    }

    @Override
    public void iniciarHiloConexion() {
        proxyCliente.iniciarHilo();
    }

    @Override
    public ProxyCliente getProxyCliente() {
        return proxyCliente;
    }

    @Override
    public FrmMenu getFrmMenu() {
        return frmMenu;
    }

    @Override
    public FrmUnirse getFrmUnirse() {
        return frmUnirse;
    }

    @Override
    public FrmLobby getFrmLobby() {
        return frmLobby;
    }

    @Override
    public void cerrarPantallaLobby() {
        this.frmLobby.setVisible(false);
        this.frmLobby = null;
    }

    @Override
    public void cerrarPantallaUnirse() {
        this.frmUnirse = null;
    }

    @Override
    public void cerrarPantallaPartida() {
        this.frmPartida.setVisible(false);
        this.frmPartida = null;
    }

    @Override
    public void cerrarPantallaMenu() {
        this.frmMenu = null;
    }

    @Override
    public void cerrarPantallaPodio() {
        this.frmPodio.cerrarVentanaPodio();
    }

    @Override
    public FrmPodio getFrmPodio() {
        return this.frmPodio;
    }

    @Override
    public void exponerPartida() {

        List<JugadorDTO> listaJugadores = new ArrayList<JugadorDTO>();
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(), jugador.getAvatar(), jugador.getId());
        listaJugadores.add(jugadorDTO);
        PartidaDTO partidaDTO = new PartidaDTO(listaJugadores);
        partidaDTO.setNumFichas(2);
        proxyCliente.empaquetarParametros(TipoPaquete.PARTIDA, partidaDTO);
        proxyCliente.enviarDatos();
    }

    @Override
    public void recuperarPartidas() {
        //proxyCliente.iniciarSocket();
        proxyCliente.empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA, null);
        proxyCliente.enviarDatos();
        //proxyCliente.iniciarHilo();
    }

    @Override
    public void configuracionPartida() {

        List<JugadorDTO> listaJugadores = new ArrayList<JugadorDTO>();
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(), jugador.getAvatar(), jugador.getId());
        listaJugadores.add(jugadorDTO);
        PartidaDTO partidaDTO = new PartidaDTO(listaJugadores);
        partidaDTO.setNumFichas(this.partida.getNumFichas());
        proxyCliente.empaquetarParametros(TipoPaquete.CONFIGURACION_PARTIDA, partidaDTO);
        proxyCliente.enviarDatos();
    }

    @Override
    public void unirsePartida() {
        proxyCliente.empaquetarParametros(TipoPaquete.UNIRSE_PARTIDA, crearJugadorDTO());
        proxyCliente.enviarDatos();
    }

    public void dibujarJugadoresLobby() {
        frmLobby.asignarInformacionJugadores();
    }

    @Override
    public void jugadorListo() {
        JugadorDTO jugador;
        jugador = new JugadorDTO(this.jugador.getAvatar(), this.jugador.getNombre(), this.jugador.getListo(), this.jugador.getId());
        proxyCliente.empaquetarParametros(TipoPaquete.LISTO, jugador);
        proxyCliente.enviarDatos();
    }

    @Override
    public void asignarIDJugadorLocal(int id) {
        jugador.setId(id);
    }

    @Override
    public void generarIDJugador() {
        proxyCliente.empaquetarParametros(TipoPaquete.GENERAR_ID, null);
        proxyCliente.enviarDatos();
    }

    @Override
    public void obtenerFichaPozo() {
        proxyCliente.empaquetarParametros(TipoPaquete.OBTENER_FICHA, crearJugadorDTO());
        proxyCliente.enviarDatos();
    }

    @Override
    public Pozo obtenerPozo() {
        return partida.getPozo();
    }

    public JugadorDTO crearJugadorDTO() {
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(), jugador.getAvatar(), jugador.getId());
        return jugadorDTO;
    }

    @Override
    public void enviarFicha(Ficha ficha) {

        FichaDTO fichaEnviar = new FichaDTO(ficha.getNumeroInferior(), ficha.getNumeroSuperior(), ficha.getImagenFicha());
        proxyCliente.empaquetarParametros(TipoPaquete.AGREGAR_FICHA, fichaEnviar);
        proxyCliente.enviarDatos();
        this.enviarEliminarFichaContrincante();
    }

    @Override
    public void enviarFichaIzquierda(Ficha ficha) {

        FichaDTO fichaEnviar = new FichaDTO(ficha.getNumeroInferior(), ficha.getNumeroSuperior(), ficha.getImagenFicha());
        proxyCliente.empaquetarParametros(TipoPaquete.AGREGAR_FICHA_IZQUIERDA, fichaEnviar);
        proxyCliente.enviarDatos();
        this.enviarEliminarFichaContrincante();
    }

    @Override
    public void enviarFichaDerecha(Ficha ficha) {

        FichaDTO fichaEnviar = new FichaDTO(ficha.getNumeroInferior(), ficha.getNumeroSuperior(), ficha.getImagenFicha());
        proxyCliente.empaquetarParametros(TipoPaquete.AGREGAR_FICHA_DERECHA, fichaEnviar);
        proxyCliente.enviarDatos();
        this.enviarEliminarFichaContrincante();
    }

    @Override
    public void enviarEliminarFichaContrincante() {
        proxyCliente.empaquetarParametros(TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE, this.crearJugadorDTO());
        proxyCliente.enviarDatos();
    }

    @Override
    public void agregarFichaDerechaTablero(Ficha ficha) {
        partida.getTablero().agregarFichaDerecha(ficha);
    }

    @Override
    public void agregarFichaIzquierdaTablero(Ficha ficha) {
        partida.getTablero().agregarFichaIzquierda(ficha);
    }

    @Override
    public void agregarFichaTablero(Ficha ficha) {
        partida.getTablero().agregarFicha(ficha, false);
    }

    public void modificarTurno(List<JugadorDTO> jugadores) {
        for (JugadorDTO jugadore : jugadores) {
            if (jugadore.getId() == jugador.getId()) {
                jugador.setTurno(jugadore.getTurno());

            }
        }
        this.frmPartida.actualizarInfo();
    }

    @Override
    public void pasarTurno() {
        jugador.setTurno(false);
        System.out.println("Entro pasarturnoMediador");
        proxyCliente.empaquetarParametros(TipoPaquete.PASAR_TURNO, null);
        proxyCliente.enviarDatos();

    }

    @Override
    public void enviarFinalizarPartida() {
        JugadorDTO jugadorPuntos = new JugadorDTO(
                this.jugador.getId(),
                this.jugador.getAvatar(),
                this.jugador.getNombre(),
                this.jugador.getTotalPuntos());
        proxyCliente.empaquetarParametros(
                TipoPaquete.FINALIZAR_PARTIDA,
                jugadorPuntos
        );
        proxyCliente.enviarDatos();
    }

    @Override
    public void enviarTotalPuntos() {
        JugadorDTO jugadorPuntos = new JugadorDTO(
                this.jugador.getId(),
                this.jugador.getAvatar(),
                this.jugador.getNombre(),
                this.jugador.getTotalPuntos()
        );
        proxyCliente.empaquetarParametros(TipoPaquete.ENVIAR_PUNTOS, jugadorPuntos);
        proxyCliente.enviarDatos();
    }

    @Override
    public void salirDurantePartida() {
        if (this.jugador.getTurno()) {
            this.pasarTurno();
        }
        JugadorDTO jugadorSalir = new JugadorDTO(
                this.jugador.getNombre(),
                this.jugador.getAvatar(),
                this.jugador.getId()
        );
        jugadorSalir.setFichas(this.convertirFichasDTO(this.jugador.getFichas()));
        this.proxyCliente.empaquetarParametros(
                TipoPaquete.ELIMINAR_JUGADOR,
                jugadorSalir
        );
        this.proxyCliente.enviarDatos();
    }

    @Override
    public void sacarJugadorPartidaPorId(int idJugador) {
        this.partida.sacarJugadorPorId(idJugador);
        this.partida.sacarContrincantePorId(idJugador);
    }

    @Override
    public void noHayJugadoresPartida() {
        this.cerrarPantallaPartida();
        this.abrirPantallaMenu();
        JugadorDTO jugadorEliminar = new JugadorDTO(
                this.jugador.getNombre(),
                this.jugador.getAvatar(),
                this.jugador.getId()
        );
        this.proxyCliente.empaquetarParametros(
                TipoPaquete.ELIMINAR_JUGADOR,
                jugadorEliminar
        );
        this.proxyCliente.enviarDatos();
    }

    @Override
    public void recargarPantallaPartida() {
        this.frmPartida.cargarPartida();
    }

    @Override
    public void enviarFinalizarPartidaCerrarPartida() {
        JugadorDTO jugador = new JugadorDTO(
                this.jugador.getId(),
                this.jugador.getAvatar(),
                this.jugador.getNombre(),
                this.jugador.getTotalPuntos());
        proxyCliente.empaquetarParametros(
                TipoPaquete.FINALIZO_PARTIDA,
                jugador
        );
        proxyCliente.enviarDatos();
    }

    private List<FichaDTO> convertirFichasDTO(List<Ficha> fichas) {
        List<FichaDTO> fichasDTO = new ArrayList<>();

        for (Ficha ficha : fichas) {
            String rutaImagen = String.format("/imgFrmPartidaFichas/ficha%d_%d.png", ficha.getNumeroInferior(), ficha.getNumeroSuperior());
            FichaDTO fichaDTO = new FichaDTO(
                    ficha.getNumeroInferior(),
                    ficha.getNumeroSuperior(),
                    rutaImagen
            );

            fichasDTO.add(fichaDTO);
        }
        return fichasDTO;
    }

    @Override
    public void enviarSalirPartida() {
        JugadorDTO jugadorSalir = new JugadorDTO(
                this.jugador.getId(),
                this.jugador.getAvatar(),
                this.jugador.getNombre(),
                this.jugador.getTotalPuntos());
        proxyCliente.empaquetarParametros(
                TipoPaquete.SALIR_PARTIDA,
                jugadorSalir
        );
        proxyCliente.enviarDatos();
    }
}
