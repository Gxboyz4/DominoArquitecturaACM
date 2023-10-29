/**
 * ContrincanteControlador.java
 * Oct 28, 2023 8:19:51 PM
 */
package org.itson.proyectoarquitecturadominoacm.contrincante;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ContrincanteControlador {

    private ContrincanteVista vista;
    private ContrincanteModelo modelo;

    /**
     *
     */
    public ContrincanteControlador() {
    }

    public ContrincanteControlador(ContrincanteVista vista, ContrincanteModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public ContrincanteVista getVista() {
        return vista;
    }

    public void setVista(ContrincanteVista vista) {
        this.vista = vista;
    }

    public ContrincanteModelo getModelo() {
        return modelo;
    }

    public void setModelo(ContrincanteModelo modelo) {
        this.modelo = modelo;
    }
}
