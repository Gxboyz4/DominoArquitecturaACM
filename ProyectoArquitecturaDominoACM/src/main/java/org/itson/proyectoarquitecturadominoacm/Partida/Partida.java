/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;
import org.itson.proyectoarquitecturadominoacm.excepciones.PartidaTerminadaException;

/**
 *
 * @author julio
 */
public class Partida implements FichaObserver, PozoObserver, Serializable{
    
    Pozo pozo;
    Ficha ficha;
    List<Jugador> jugadores;
    Jugador jugador;
    Tablero tablero;
    int numFichas;
    int numJugadores;
    
    public Partida(List<Jugador> jugadores){
        this.jugadores=jugadores;
    }
    public Partida(Jugador jugador, int numFichas) {
        this.jugador = jugador;
        this.numFichas=numFichas;
    }
    public Partida(Jugador jugador){
        this.jugador=jugador;
    }
 
    public Partida(Pozo pozo) {
        this.pozo = pozo;
    }
    
    public Partida(Pozo pozo, Jugador jugador,Tablero tablero) {
        this.pozo = pozo;
        this.jugador = jugador;
        this.tablero = tablero;
        this.suscribirFichas();
        this.suscribirPozo();
    }
    
    public void suscribirse(){
        this.suscribirFichas();
        this.suscribirPozo();
    }
    
    public void suscribirFichas(){
        for (Ficha ficha : pozo.obtenerTodasFichas()) {
            ficha.agregarObservador(this);
        }
    }
    
    public void suscribirPozo(){
       pozo.agregarObservador(this);
    }
    @Override
    public void fichaSeleccionada(Ficha ficha) {
        if(tablero.agregarFicha(ficha))
        {
            if(finalizacionTablero(tablero.getNumeroIzquierda())&&finalizacionTablero(tablero.getNumeroDerecha()))
            {
               JOptionPane.showMessageDialog(null, "Se ha bloqueado el tablero (este mensaje es momentaneo no se vaya a creer que quede asi profe)", "Tablero UnU", JOptionPane.INFORMATION_MESSAGE);
               
            }
            jugador.eliminarFicha(ficha);
            if(finalizacionJugador())
            {
               JOptionPane.showMessageDialog(null, "Gano el jugador(este mensaje es momentaneo no se vaya a creer que quede asi profe)", "Jugador Gano OwO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    public boolean finalizacionJugador()
    {
        if(jugador.getFichas().size() == 0)
        {
            return true;
        }
        return false;
    }
    public boolean finalizacionTablero(int numeroBuscado)
    {
        int cantidad= 0;
        
        for (Ficha ficha1 : tablero.getFichas()) {
            if(numeroBuscado==ficha1.getNumeroInferior()||numeroBuscado==ficha1.getNumeroSuperior())
            {
                cantidad++;
            }
            
        }
        if(cantidad == 7)
        {
            return true;
        }
        return false;
    }
    @Override
    public void fichaElegida(Ficha ficha) {
         //System.out.println("La ficha elegida por el pozo fue: "+ficha.getNumeroInferior() +" "+ " "+ficha.getNumeroSuperior());  
         jugador.agregarFicha(ficha);
       //  System.out.println(jugador.getFichas());
         pozo.eliminarFicha(ficha);
    }
    public void exponerPartida(){
        List<JugadorDTO> listaJugadores = new ArrayList<JugadorDTO>();
        JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNombre(),jugador.getAvatar());
        listaJugadores.add(jugadorDTO);
        IProxyCliente proxyCliente = new ProxyCliente();
        proxyCliente.iniciarSocket();
        PartidaDTO partidaDTO = new PartidaDTO(listaJugadores);
        proxyCliente.empaquetarParametros(TipoPaquete.PARTIDA,partidaDTO);
        proxyCliente.enviarDatos();
    }
    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }
    public void repartirFichas(){
    List<Ficha> fichas = pozo.repartirFichas(numFichas);
        for (Ficha ficha1 : fichas) {
            jugador.agregarFicha(ficha1);
        }
    }
    
    
}
