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
    private boolean partidaIniciada;

    public boolean getPartidaIniciada() {
        return partidaIniciada;
    }

    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }
    public PartidaDTO(List<JugadorDTO> jugadores){
        this.jugadores=jugadores;
    }  
      public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void reiniciarJugadores(){
        this.jugadores = new ArrayList();
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
    public void actualizarJugador(JugadorDTO jugador)
    {
        System.out.println(jugador);
        System.out.println(jugadores.indexOf(jugador));
        System.out.println(jugador.getListo());
        jugadores.set(jugadores.indexOf(jugador), jugador);
        
    }
}
