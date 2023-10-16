/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.UI.FrmLobby;
import org.itson.proyectoarquitecturadominoacm.UI.FrmMenu;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPartida;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPrincipal;

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
    public Jugador getJugador();
    public void crearPartida(Jugador jugador, int fichas);
    public Partida getPartida();
}