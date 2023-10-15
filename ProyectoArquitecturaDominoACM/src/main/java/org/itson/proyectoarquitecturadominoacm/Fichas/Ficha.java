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
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Zaurus
 */
public class Ficha {
    FichaControlador fichaControlador;
    FichaModelo fichaModelo;
    FichaVista fichaVista;
    JPanel panel;
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
        this.panel=panelFicha;
    }
    
    public Ficha(FichaControlador fichaControlador, FichaModelo fichaModelo, FichaVista fichaVista){
        this.fichaControlador = fichaControlador;
        this.fichaModelo= fichaModelo;
        this.fichaVista = fichaVista;
        
    }

    public Ficha(FichaControlador fichaControlador) {
        this.fichaControlador = fichaControlador;
        this.fichaModelo = this.fichaControlador.getFichaModelo();
        this.fichaVista = this.fichaControlador.getFichaVista();
    }

    
    public void escalado(int escala)
    {
        this.fichaModelo.escalado(escala);
    }
    
    
    public void dibujarEnPanel(){
        fichaControlador.dibujarFicha();  
        fichaVista.addMouseListener(fichaControlador);
    }
    public void dibujarEnPanelRotada(int grados){
        fichaControlador.dibujarFichaRotada(grados);
        fichaVista.addMouseListener(fichaControlador);
    }
    
    public void agregarObservador(FichaObserver observador){
        fichaControlador.getFichaObservable().agregarObservador(observador);
    }

    public JPanel getPanelFichas() {
        return panel;
    }

    public void setPanelFichas(JPanel panelFichas) {
        this.panel = panelFichas;
        this.fichaVista.setPanel(panelFichas);;
    }

    public int getNumeroSuperior() {
        return fichaModelo.getNumeroSuperior();
                
    }

    public void setNumeroSuperior(int numeroSuperior) {
        this.numeroSuperior = numeroSuperior;
    }

    public int getNumeroInferior() {
        return fichaModelo.getNumeroInferior();
    }

    public void setNumeroInferior(int numeroInferior) {
        this.numeroInferior = numeroInferior;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.fichaModelo.setPosicionX(posicionX);
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
       this.fichaModelo.setPosicionY(posicionY);
    }
    
    
}

