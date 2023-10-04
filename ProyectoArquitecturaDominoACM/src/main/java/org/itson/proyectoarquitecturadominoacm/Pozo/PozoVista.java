/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import javax.swing.JButton;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoVista{
    private PozoModelo pozoModelo;
    private JButton botonPozo;
    public PozoVista(JButton botonPozo, PozoModelo pozoModelo){
        this.pozoModelo=pozoModelo;
        this.botonPozo = botonPozo;
    }
    public void mostrarPozo(){
        if(pozoModelo.getEstado().equalsIgnoreCase("Visible")){
            this.botonPozo.setVisible(true);
        }else{
            this.botonPozo.setVisible(false);
        }
            
    }
}
