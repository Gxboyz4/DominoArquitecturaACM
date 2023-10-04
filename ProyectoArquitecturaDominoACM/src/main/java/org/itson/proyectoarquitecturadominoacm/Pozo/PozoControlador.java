/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoControlador implements ActionListener{
    private PozoModelo pozoModelo;
    private PozoVista pozoVista;
    
    public PozoControlador(PozoModelo pozoModelo, PozoVista pozoVista){
        this.pozoModelo=pozoModelo;
        this.pozoVista=pozoVista;
    }
    public void mostrarPozo(){
        this.pozoVista.mostrarPozo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       pozoModelo.getListaFichas().get(0);
    }
    public Ficha devolverFicha(){
        return pozoModelo.devolverFicha();
    }
}
