/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Zaurus
 */
public class Ficha {
    FichaControlador fichaControlador;
    FichaModelo fichaModelo;
    FichaVista fichaVista;
    JPanel panelFichasUsuario;
    int numeroSuperior;
    int numeroInferior;
    ImageIcon imagenFicha;
    int posicionX;
    int posicionY;

    
    public Ficha(JPanel panelFicha,int numeroSuperior, int numeroInferior,ImageIcon imagenFicha,int posicionX,int posicionY){
        this.numeroSuperior=numeroSuperior;
        this.numeroInferior=numeroInferior;
        this.imagenFicha=imagenFicha;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
        this.panelFichasUsuario=panelFicha;
    }
    
    public void dibujarEnPanelUsuario(){
        fichaModelo = new FichaModelo(numeroSuperior,numeroInferior,imagenFicha,posicionX,posicionY); 
        fichaVista = new FichaVista(fichaModelo, panelFichasUsuario);
        fichaControlador = new FichaControlador(fichaModelo,fichaVista);
        fichaControlador.dibujarFicha();  
        fichaVista.addMouseListener(fichaControlador);
    }

    public JPanel getPanelFichasUsuario() {
        return panelFichasUsuario;
    }

    public void setPanelFichasUsuario(JPanel panelFichasUsuario) {
        this.panelFichasUsuario = panelFichasUsuario;
    }

    public int getNumeroSuperior() {
        return numeroSuperior;
    }

    public void setNumeroSuperior(int numeroSuperior) {
        this.numeroSuperior = numeroSuperior;
    }

    public int getNumeroInferior() {
        return numeroInferior;
    }

    public void setNumeroInferior(int numeroInferior) {
        this.numeroInferior = numeroInferior;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    
}

