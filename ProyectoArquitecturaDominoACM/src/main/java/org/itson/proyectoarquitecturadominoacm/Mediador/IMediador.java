/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
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
    public void registrarPantallaPrincipal(FrmPrincipal frmPrincpal);
    public void registrarPantallaMenu(FrmMenu frmMenu);
    public void registrarPantallaLobby(FrmLobby frmLobby);
    public void registrarPantallaPartida(FrmPartida frmPartida);
    public Jugador getJugador();
    public FrmPrincipal getFrmPrincipal();
    public FrmMenu getFrmMenu();
    public FrmLobby getFrmLobby();
    public FrmPartida getFrmPartida();
}
