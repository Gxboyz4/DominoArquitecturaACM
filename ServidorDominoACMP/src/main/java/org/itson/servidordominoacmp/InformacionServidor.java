/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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

    public InformacionServidor(){
       pozoServidor = new PozoServidor();
    }

    public PartidaDTO getPartidaEnServidor() {
        return partidaEnServidor;
    }

    public void setPartidaEnServidor(PartidaDTO partidaEnServidor) {
        this.partidaEnServidor = partidaEnServidor;
    }
    
    public void eliminarPartida(){
        this.partidaEnServidor=null;
    }

    public PozoServidor getPozoServidor() {
        return pozoServidor;
    }

    public void setPozoServidor(PozoServidor pozoServidor) {
        this.pozoServidor = pozoServidor;
    }
    public int getCantidadJugadores(){
        return partidaEnServidor.getJugadores().size();
    }
    public JugadorDTO getJugadorPartida(int numLista){
        return partidaEnServidor.getJugadores().get(numLista);
    }
    public int getNumeroFichasPartida(){
        return partidaEnServidor.getNumFichas();
    }
    
    
}
