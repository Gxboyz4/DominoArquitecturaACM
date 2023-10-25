/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.libreriatiposdominoacmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mancinas
 */
public class PartidaDTO implements Serializable{
    

    private List<JugadorDTO> jugadores = new ArrayList();
    private int numFichas;
    
    public PartidaDTO(List<JugadorDTO> jugadores){
        this.jugadores=jugadores;
    }  
      public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }
    
    public void agregarJugador(JugadorDTO jugador){
        jugadores.add(jugador);
    }
    public void eliminarJugador(JugadorDTO jugador){
        jugadores.remove(jugador);
    }
}
