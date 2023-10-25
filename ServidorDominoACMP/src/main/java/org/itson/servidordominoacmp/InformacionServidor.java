/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import org.itson.libreriatiposdominoacmp.PartidaDTO;

/**
 *
 * @author Gabriel Mancinas
 */
public class InformacionServidor {
    PartidaDTO partidaEnServidor;   
    
    public InformacionServidor(){
        
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
}
