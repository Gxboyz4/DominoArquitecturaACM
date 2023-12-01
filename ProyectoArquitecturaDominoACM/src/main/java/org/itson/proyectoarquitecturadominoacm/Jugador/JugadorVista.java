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
public class JugadorVista implements Serializable {

    JugadorModelo modelo;

    public JugadorVista(JugadorModelo modelo) {
        this.modelo = modelo;
    }

//    public void agregarFicha() {
//        if (modelo.getFichas().isEmpty()) {
//            modelo.limpiarPanel();
//        }
//    }
//
//    public void dibujarFicha(Ficha ficha) {
//        ficha.escalado(37);
//        modelo.getPanelFichas().add(ficha.getPanelFichas());
//    }
}
