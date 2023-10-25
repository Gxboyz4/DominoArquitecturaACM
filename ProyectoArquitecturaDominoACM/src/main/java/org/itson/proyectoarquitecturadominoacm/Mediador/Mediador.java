/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Mediador;

import java.util.ArrayList;
import java.util.List;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
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
    public void crearPartida() {
    this.partida = new Partida();
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
    this.frmLobby=frmLobby;
    mediador.getFrmLobby().asignarInformacionJugadores();
    }
    
    @Override
    public void abrirPantallaUnirse(){
        FrmUnirse frmUnirse = new FrmUnirse();
        frmUnirse.setVisible(true);
        this.frmUnirse=frmUnirse;
        
    }
    public void iniciarHiloConexion(){
        proxyCliente.iniciarHilo();
    }

    @Override
    public ProxyCliente getProxyCliente() {
        return proxyCliente;
    }
    @Override
    public FrmUnirse getFrmUnirse(){
        return frmUnirse;
    }
    @Override
    public FrmLobby getFrmLobby(){
        return frmLobby;
    }
    @Override
    public void exponerPartida(){
        List<JugadorDTO> listaJugadores = new ArrayList<JugadorDTO>();
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(),jugador.getAvatar());
        listaJugadores.add(jugadorDTO);
        proxyCliente.iniciarSocket();
        PartidaDTO partidaDTO = new PartidaDTO(listaJugadores);
        proxyCliente.empaquetarParametros(TipoPaquete.PARTIDA,partidaDTO);
        proxyCliente.enviarDatos();
    }

    @Override
    public void recuperarPartidas() {
        proxyCliente.iniciarSocket();
        proxyCliente.empaquetarParametros(TipoPaquete.RECUPERAR_PARTIDA, null);
        proxyCliente.enviarDatos();
    }
    public void unirsePartida(){
        System.out.println("Entra al unirsePartida del mediador");
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(),jugador.getAvatar());
        proxyCliente.empaquetarParametros(TipoPaquete.UNIRSE_PARTIDA, jugadorDTO);
        proxyCliente.enviarDatos();
    }
    public void dibujarJugadoresLobby(){
        frmLobby.asignarInformacionJugadores();
    }
    
    
    
    
    

   


    
}
