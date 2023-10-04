/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import javax.swing.JButton;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class Pozo {
    PozoControlador pozoControlador;
    PozoModelo pozoModelo;
    PozoVista pozoVista;
    private JButton botonPozo;
   
    public Pozo(JButton botonPozo){
        pozoModelo = new PozoModelo();
        pozoVista = new PozoVista(botonPozo,pozoModelo);
        pozoControlador = new PozoControlador(pozoModelo, pozoVista);
        this.botonPozo=botonPozo; 
        devolverFicha();
        mostrarPozo();
    
    }
    public Ficha devolverFicha(){
        return pozoControlador.devolverFicha();
    }
    public void mostrarPozo(){
        pozoControlador.mostrarPozo();
    }
    public PozoModelo getPozoModelo() {
        return pozoModelo;
    }
    
}
