/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.LinkedHashMap;
import java.util.List;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;

/**
 *
 * @author Gabriel Mancinas
 */
public class InformacionServidor {

    PartidaDTO partidaEnServidor;
    //List<FichaDTO> fichas;
    PozoServidor pozoServidor;
    LinkedHashMap<JugadorDTO, Integer> podio;

    public InformacionServidor() {
        pozoServidor = new PozoServidor();
    }

    public PartidaDTO getPartidaEnServidor() {
        return partidaEnServidor;
    }

    public void setPartidaEnServidor(PartidaDTO partidaEnServidor) {
        this.partidaEnServidor = partidaEnServidor;
    }

    public void eliminarPartida() {
        this.partidaEnServidor = null;
    }

    public PozoServidor getPozoServidor() {
        return pozoServidor;
    }

    public void setPozoServidor(PozoServidor pozoServidor) {
        this.pozoServidor = pozoServidor;
    }

    public int getCantidadJugadores() {
        return partidaEnServidor.getJugadores().size();
    }

    public JugadorDTO getJugadorPartida(int numLista) {
        return partidaEnServidor.getJugadores().get(numLista);
    }

    public int getNumeroFichasPartida() {
        return partidaEnServidor.getNumFichas();
    }

    public LinkedHashMap<JugadorDTO, Integer> getPodio() {
        return podio;
    }

    public void setPodio(LinkedHashMap<JugadorDTO, Integer> ranking) {
        this.podio = ranking;
    }

    public void agregarJugadorPodio(JugadorDTO jugador){
        if(this.podio == null){
            this.podio = new LinkedHashMap<>();
        }
        this.podio.put(jugador, jugador.getPuntos());
    }
    
    public int getCantidadJugadoresPodio(){
        return this.podio.size();
    }
    
    public void agregarFichasPozo(List<FichaDTO> fichas){
        this.pozoServidor.agregarFichas(fichas);
    }
}
