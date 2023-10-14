/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;

/**
 *
 * @author julio
 */
public class Partida implements FichaObserver{
    
    Pozo pozo;
    Ficha ficha;
    Jugador jugador;

    public Partida(Jugador jugador) {
        this.jugador = jugador;
    }
 
    public Partida(Pozo pozo) {
        this.pozo = pozo;
    }

    public Partida(Pozo pozo, Jugador jugador) {
        this.pozo = pozo;
        this.jugador = jugador;
        this.suscribirse();
    }

    public void suscribirse(){

        for (Ficha ficha : pozo.obtenerTodasFichas()) {
            ficha.agregarObservador(this);
        }
        
    }
    
    @Override
    public void fichaSeleccionada(Ficha ficha) {
         System.out.println(ficha.getNumeroInferior() +" "+ " "+ficha.getNumeroSuperior());  

    }
    
    
}
