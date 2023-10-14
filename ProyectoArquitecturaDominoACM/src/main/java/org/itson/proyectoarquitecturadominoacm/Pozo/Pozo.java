/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import java.util.List;
import javax.swing.JButton;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;

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
        this.botonPozo.addActionListener(pozoControlador);
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
    
    public List<Ficha> obtenerTodasFichas(){
        return this.pozoModelo.getListaFichas();
    }
    public void agregarObservador(PozoObserver observador){
        pozoControlador.getPozoObservable().agregarObservador(observador);
    }
    
}
