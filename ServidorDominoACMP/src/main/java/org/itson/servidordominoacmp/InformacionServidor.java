/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;

/**
 *
 * @author Gabriel Mancinas
 */
public class InformacionServidor {
    PartidaDTO partidaEnServidor;   
    List<FichaDTO> fichas;

    public InformacionServidor(){
        fichas = new ArrayList();        
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                String rutaImagen = String.format("/imgFrmPartidaFichas/ficha%d_%d.png", i, j);
                FichaDTO ficha = new FichaDTO(i, j, rutaImagen);
                fichas.add(ficha);
            }
        }
    }

    public List<FichaDTO> getFichas() {
        return fichas;
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
    public FichaDTO devolverFicha(){
     int numeroRandom = (int) (Math.random() * getFichas().size() + 0);
     return fichas.get(numeroRandom);
    }
    
    public void eliminarFicha(FichaDTO ficha){
        fichas.remove(ficha);
    }
   
    public List<FichaDTO> repartirFichas(int numFichas){
        List<FichaDTO> fichasRepartidas = new ArrayList();
            for (int j = 0; j < numFichas; j++) {
                FichaDTO ficha;
                ficha=devolverFicha();
                eliminarFicha(ficha);
                fichasRepartidas.add(ficha);
            }
            return fichasRepartidas;
    }
}
