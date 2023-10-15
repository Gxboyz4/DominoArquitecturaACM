/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Mediador implements IMediador{
    Jugador jugador;
    FrmPrincipal frmPrincipal;
    FrmMenu frmMenu;
    FrmLobby frmLobby;
    FrmPartida frmPartida;
    
    @Override
    public void registrarJugador(Jugador jugador) {
    this.jugador=jugador;
    }

    @Override
    public void registrarPantallaPrincipal(FrmPrincipal frmPrincipal) {
        this.frmPrincipal=frmPrincipal;
    }

    @Override
    public void registrarPantallaMenu(FrmMenu frmMenu) {
        this.frmMenu=frmMenu;
    }

    @Override
    public void registrarPantallaLobby(FrmLobby frmLobby) {
        this.frmLobby=frmLobby;
    }

    @Override
    public void registrarPantallaPartida(FrmPartida frmPartida) {
        this.frmPartida=frmPartida;
    }
    
    @Override
    public void iniciarPrograma(){
    frmPrincipal.setVisible(true);
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public FrmPrincipal getFrmPrincipal() {
        return frmPrincipal;
    }

    @Override
    public FrmMenu getFrmMenu() {
        return frmMenu;
    }

    @Override
    public FrmLobby getFrmLobby() {
        return frmLobby;
    }

    @Override
    public FrmPartida getFrmPartida() {
        return frmPartida;
    }

   


    
}
