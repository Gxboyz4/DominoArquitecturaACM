/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import java.util.List;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import org.itson.proyectoarquitecturadominoacm.UI.FrmLobby;
import org.itson.proyectoarquitecturadominoacm.UI.FrmMenu;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPodio;
import org.itson.proyectoarquitecturadominoacm.UI.FrmUnirse;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author Gabriel Mancinas
 */
public interface IMediador {

    public void iniciarPrograma();

    public void registrarJugador(Jugador jugador);

    public void abrirPantallaPrincipal();

    public void abrirPantallaMenu();

    public void abrirPantallaLobby();

    public void abrirPantallaPartida();

    public void abrirPantallaUnirse();
    
    public void abrirPantallaPodio();

    public void cerrarPantallaMenu();

    public void cerrarPantallaLobby();

    public void cerrarPantallaUnirse();

    public void cerrarPantallaPartida();
    
    public void cerrarPantallaPodio();

    public Jugador getJugador();

    public void crearPartida(Jugador jugador, int fichas);

    public void crearPartida(Jugador jugador);

    public void crearPartida();

    public Partida getPartida();

    public void iniciarHiloConexion();

    public ProxyCliente getProxyCliente();

    public FrmMenu getFrmMenu();

    public FrmUnirse getFrmUnirse();

    public void configuracionPartida();

    public FrmLobby getFrmLobby();
    
    public FrmPodio getFrmPodio();

    public void exponerPartida();

    public void recuperarPartidas();

    public void unirsePartida();

    public void jugadorListo();

    public void asignarIDJugadorLocal(int id);

    public void generarIDJugador();

    public void obtenerFichaPozo();

    public Pozo obtenerPozo();

    public void enviarFichaIzquierda(Ficha ficha);

    public void enviarFichaDerecha(Ficha ficha);

    public void enviarFicha(Ficha ficha);

    public void agregarFichaDerechaTablero(Ficha ficha);

    public void agregarFichaIzquierdaTablero(Ficha ficha);

    public void agregarFichaTablero(Ficha ficha);

    public void enviarEliminarFichaContrincante();

    public void modificarTurno(List<JugadorDTO> jugadores);

    public void pasarTurno();

    public void enviarFinalizarPartida();

    public void enviarTotalPuntos();

    public void salirDurantePartida();

    public void sacarJugadorPartidaPorId(int id);

    public void noHayJugadoresPartida();
    
    public void reiniciarJugador();
    
    public void recargarPantallaPartida();
    
    public void enviarFinalizarPartidaCerrarPartida();
    
    public void enviarSalirPartida();
     public void modificarPartidaLocal(PartidaDTO partida) ;
     public Ficha crearFicha(FichaDTO ficha);
     public Contrincante obtenerContrincante(JugadorDTO jugador);
      public Ficha crearFichaDireccion(FichaDTO ficha);
      public void listaJugadorDTOJugador(List<JugadorDTO> jugadoresDTO);
      public void recargarTablaFrmUnirse();
}
