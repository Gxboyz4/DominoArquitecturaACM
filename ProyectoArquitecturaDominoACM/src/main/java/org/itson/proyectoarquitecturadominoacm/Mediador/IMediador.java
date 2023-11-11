/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import org.itson.proyectoarquitecturadominoacm.UI.FrmLobby;
import org.itson.proyectoarquitecturadominoacm.UI.FrmMenu;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPartida;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPrincipal;
import org.itson.proyectoarquitecturadominoacm.UI.FrmUnirse;

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
    public void cerrarPantallaMenu();
    public void cerrarPantallaLobby();
    public void cerrarPantallaUnirse();
    public void cerrarPantallaPartida();
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
      public void exponerPartida();
      public void recuperarPartidas();
      public void unirsePartida();
      public void jugadorListo();
      public void asignarIDJugadorLocal(int id);
      public void generarIDJugador();
      public void obtenerFichaPozo();
      public Pozo obtenerPozo();
}
