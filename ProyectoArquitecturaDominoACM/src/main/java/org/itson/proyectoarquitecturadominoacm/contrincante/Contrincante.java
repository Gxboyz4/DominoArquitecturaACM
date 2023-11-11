/**
 * JugadorContrincante.java
 * Oct 28, 2023 8:18:43 PM
 */
package org.itson.proyectoarquitecturadominoacm.contrincante;

import java.util.Objects;
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
     * @param idJugador
     * @param nombre
     * @param fichasRestantes
     * @param posicionPanel
     * @param panelFichas 
     */
    public Contrincante(int idJugador, String nombre, int fichasRestantes, PosicionPanel posicionPanel, JPanel panelFichas) {
        this.modelo = new ContrincanteModelo(fichasRestantes, posicionPanel, nombre, idJugador);
        this.vista = new ContrincanteVista(panelFichas, modelo);
        this.controlador = new ContrincanteControlador(this.vista, this.modelo);
        this.vista.pintarFichas();
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
        System.out.println(modelo.getFichasRestantes());
        this.vista.pintarFichas();
    }
    
    public void agregarFichasRestantes(int fichasAgregadas){
        this.modelo.agregarFichasRestantes(fichasAgregadas);
        this.vista.pintarFichas();
    }
    
    public void quitarFicha(){
        this.modelo.quitarFicha();
        this.vista.pintarFichas();
    }
    
    public void quitarFichas(int fichasEliminadas){
        this.modelo.quitarFichas(fichasEliminadas);
        this.vista.pintarFichas();
    }
    
    public int obtenerIdContrincante(){
        return this.modelo.getIdContrincante();
    }

    public ContrincanteModelo getModelo() {
        return modelo;
    }

    public void setModelo(ContrincanteModelo modelo) {
        this.modelo = modelo;
    }

    public ContrincanteVista getVista() {
        return vista;
    }

    public void setVista(ContrincanteVista vista) {
        this.vista = vista;
    }

    public ContrincanteControlador getControlador() {
        return controlador;
    }

    public void setControlador(ContrincanteControlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.modelo);
        hash = 17 * hash + Objects.hashCode(this.vista);
        hash = 17 * hash + Objects.hashCode(this.controlador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrincante other = (Contrincante) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.vista, other.vista)) {
            return false;
        }
        return Objects.equals(this.controlador, other.controlador);
    }
    public int obtenerID(){
        return modelo.getIdContrincante();
    }
}
