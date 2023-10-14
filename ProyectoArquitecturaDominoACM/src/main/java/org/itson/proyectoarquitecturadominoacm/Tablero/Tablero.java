/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.awt.event.KeyListener;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class Tablero {

    private JPanel lienzo;
    TableroModelo modelo;
    TableroVista vista;
    TableroControlador controlador;

    public Tablero(JPanel lienzo) {
        this.lienzo = lienzo;
        modelo = new TableroModelo(lienzo);
        
        controlador = new TableroControlador(modelo,vista);
    }
    public KeyListener obtenerKeyListener()
    {
        return controlador;
    }
    public void agregarFichaDerecha(Ficha ficha) {
        modelo.agregarFichaDerecha(ficha);
    }
    
    public void agregarFichaIzquierda(Ficha ficha) {
        modelo.agregarFichaIizquierda(ficha);
    }
}
