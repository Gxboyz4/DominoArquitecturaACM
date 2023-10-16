/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

import java.util.List;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;

/**
 *
 * @author julio
 */
public class Partida implements FichaObserver, PozoObserver{
    
    Pozo pozo;
    Ficha ficha;
    Jugador jugador;
    Tablero tablero;
    int numFichas;
    int numJugadores;
    public Partida(Jugador jugador, int numFichas) {
        this.jugador = jugador;
        this.numFichas=numFichas;
 
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
        jugador.eliminarFicha(ficha);
    }

    @Override
    public void fichaElegida(Ficha ficha) {
         //System.out.println("La ficha elegida por el pozo fue: "+ficha.getNumeroInferior() +" "+ " "+ficha.getNumeroSuperior());  
         jugador.agregarFicha(ficha);
       //  System.out.println(jugador.getFichas());
         pozo.eliminarFicha(ficha);
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
