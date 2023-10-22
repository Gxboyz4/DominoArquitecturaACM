/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
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
public class Mediador implements IMediador{
    Jugador jugador;
    FrmPrincipal frmPrincipal;
    FrmMenu frmMenu;
    FrmLobby frmLobby;
    FrmPartida frmPartida;
    FrmUnirse frmUnirse;
    Partida partida;
    ProxyCliente proxyCliente = new ProxyCliente();
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
    public void crearPartida(Jugador jugador) {
    this.partida = new Partida(jugador);
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
    
    @Override
    public void abrirPantallaUnirse(){
        FrmUnirse frmUnirse = new FrmUnirse();
        frmUnirse.setVisible(true);
        this.frmUnirse=frmUnirse;
        
    }
    public void iniciarHiloConexion(){
        proxyCliente.iniciarSocket();
        proxyCliente.iniciarHilo();
    }

    public ProxyCliente getProxyCliente() {
        return proxyCliente;
    }
    public FrmUnirse getFrmUnirse(){
        return frmUnirse;
    }
    
    
    
    

   


    
}
