/**
* JugadorContrincanteModelo.java
* Oct 28, 2023 8:18:56 PM
*/ 

package org.itson.proyectoarquitecturadominoacm.contrincante;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ContrincanteModelo {
    
    private int fichasRestantes;
    private PosicionPanel posicionPanel;

    public ContrincanteModelo(int fichasRestantes, PosicionPanel posicionPanel) {
        this.fichasRestantes = fichasRestantes;
        this.posicionPanel = posicionPanel;
    }

    public int getFichasRestantes() {
        return fichasRestantes;
    }

    public void setFichasRestantes(int fichasRestantes) {
        this.fichasRestantes = fichasRestantes;
    }

    public PosicionPanel getPosicionPanel() {
        return posicionPanel;
    }

    public void setPosicionPanel(PosicionPanel posicionPanel) {
        this.posicionPanel = posicionPanel;
    }
    
    public void agregarFichaRestante(){
        this.fichasRestantes++;
    }
    
    public void agregarFichasRestantes(int fichasAgregadas){
        this.fichasRestantes =+ fichasAgregadas;
    }
}
