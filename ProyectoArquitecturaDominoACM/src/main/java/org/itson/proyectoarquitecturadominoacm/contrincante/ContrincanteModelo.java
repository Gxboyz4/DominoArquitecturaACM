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
    private String nombreContrincante;
    private int idContrincante;

    public ContrincanteModelo(int fichasRestantes, PosicionPanel posicionPanel, String nombreContrincante, int idJugador) {
        this.fichasRestantes = fichasRestantes;
        this.posicionPanel = posicionPanel;
        this.nombreContrincante = nombreContrincante;
        this.idContrincante = idJugador;
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
    
    public void quitarFicha(){
        this.fichasRestantes--;
    }
    
    public void quitarFichas(int fichasEliminadas){
        this.fichasRestantes-= fichasEliminadas;
    }

    public String getNombreContrincante() {
        return nombreContrincante;
    }

    public void setNombreContrincante(String nombreContrincante) {
        this.nombreContrincante = nombreContrincante;
    }

    public int getIdContrincante() {
        return idContrincante;
    }

    public void setIdJugador(int idJugador) {
        this.idContrincante = idJugador;
    }
    
}
