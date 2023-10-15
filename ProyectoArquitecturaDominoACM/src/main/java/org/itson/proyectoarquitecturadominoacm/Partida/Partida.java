/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

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
    public Partida(Jugador jugador) {
        this.jugador = jugador;
    }
 
    public Partida(Pozo pozo) {
        this.pozo = pozo;
    }
    

    public Partida(Pozo pozo, Jugador jugador,Tablero tablero) {
        this.pozo = pozo;
        this.jugador = jugador;
        this.tablero = tablero;
        this.suscribirse();
        this.suscribirPozo();
    }

    public void suscribirse(){
        for (Ficha ficha : pozo.obtenerTodasFichas()) {
            ficha.agregarObservador(this);
        }
    }
    public void suscribirPozo(){
       pozo.agregarObservador(this);
    }
    @Override
    public void fichaSeleccionada(Ficha ficha) {
        jugador.eliminarFicha(ficha);
        tablero.agregarFichaDerecha(ficha);
    }

    @Override
    public void fichaElegida(Ficha ficha) {
         System.out.println("La ficha elegida por el pozo fue: "+ficha.getNumeroInferior() +" "+ " "+ficha.getNumeroSuperior());  
         jugador.agregarFicha(ficha);
         pozo.eliminarFicha(ficha);
    }
    
    
}
