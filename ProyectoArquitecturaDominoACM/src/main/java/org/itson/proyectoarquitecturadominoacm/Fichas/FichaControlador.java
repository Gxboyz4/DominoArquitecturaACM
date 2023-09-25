/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Zaurus
 */
public class FichaControlador implements MouseListener{
    FichaModelo fichaModelo;
    FichaVista fichaVista;
    
    public FichaControlador(FichaModelo fichaModelo, FichaVista fichaVista){
        this.fichaModelo=fichaModelo;
        this.fichaVista=fichaVista;
    }
    public void dibujarFicha(JPanel fichas){
        System.out.println("XD");
        this.fichaVista.actualizarVistaPanel(fichas);
    }
    public void dibujarFichaTablero(float x, float y){
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Ficha: "+ fichaModelo.getNumeroInferior()+", "+fichaModelo.getNumeroSuperior());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
