/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Mediador implements IMediador{
    Jugador jugador;
    FrmPrincipal frmPrincipal;
    FrmMenu frmMenu;
    FrmLobby frmLobby;
    FrmPartida frmPartida;
    Partida partida;
    @Override
    public void registrarJugador(Jugador jugador) {
    this.jugador=jugador;
    }

    @Override
    public void abrirPantallaPartida(){
    FrmPartida frmPartida= new FrmPartida();
    frmPartida.setVisible(true);
    }
    
    @Override
    public void iniciarPrograma(){
    FrmPrincipal frmPrincipal = new FrmPrincipal();
    frmPrincipal.setVisible(true);
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public void crearPartida(Jugador jugador, int fichas) {
    this.partida = new Partida(jugador,fichas);
    }
    @Override
    public Partida getPartida() {
        return partida;
    }

    @Override
    public void abrirPantallaPrincipal() {
    FrmPrincipal frmPrincipal= new FrmPrincipal();
    frmPrincipal.setVisible(true);
    }

    @Override
    public void abrirPantallaMenu() {
    FrmMenu frmMenu = new FrmMenu();
    frmMenu.setVisible(true);
    }

    @Override
    public void abrirPantallaLobby() {
    FrmLobby frmLobby = new FrmLobby();
    frmLobby.setVisible(true);
    }
    
    
    

   


    
}
