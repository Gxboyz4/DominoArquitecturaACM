/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Jugador;

import java.io.Serializable;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author julio
 */
public class JugadorControlador implements Serializable{
    JugadorModelo modelo;
    JugadorVista vista;

    public JugadorControlador(JugadorModelo modelo, JugadorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void agregarFicha(Ficha ficha){
        modelo.agregarFicha(ficha);
        vista.agregarFicha();
        vista.dibujarFicha(ficha);
    }
    
    public void eliminarFicha(Ficha ficha){
        modelo.eliminarFicha(ficha);
        vista.eliminarFicha();
    }
    
   
}
