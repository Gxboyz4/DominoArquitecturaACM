/**
 * JugadorContrincante.java
 * Oct 28, 2023 8:18:43 PM
 */
package org.itson.proyectoarquitecturadominoacm.contrincante;

import javax.swing.JPanel;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Contrincante {

    private ContrincanteModelo modelo;
    private ContrincanteVista vista;
    private ContrincanteControlador controlador;

    /**
     * 
     * @param fichasRestantes
     * @param posicionPanel
     * @param panelFichas 
     */
    public Contrincante(int fichasRestantes, PosicionPanel posicionPanel, JPanel panelFichas) {
        this.modelo = new ContrincanteModelo(fichasRestantes, posicionPanel);
        this.vista = new ContrincanteVista(panelFichas);
        this.controlador = new ContrincanteControlador(vista, modelo);
    }

    /**
     * 
     * @param modelo
     * @param vista
     * @param controlador 
     */
    public Contrincante(ContrincanteModelo modelo, ContrincanteVista vista, ContrincanteControlador controlador) {
        this.modelo = modelo;
        this.vista = vista;
        this.controlador = controlador;
    }

    public void agregarFichaRestante(){
        this.modelo.agregarFichaRestante();
    }
    
    public void agregarFichasRestantes(int fichasAgregadas){
        this.modelo.agregarFichasRestantes(fichasAgregadas);
        this.vista.pintarFichas();
    }
}
