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

    
    public Ficha(JPanel panelFicha,int numeroSuperior, int numeroInferior,ImageIcon imagenFicha){
        this.numeroSuperior=numeroSuperior;
        this.numeroInferior=numeroInferior;
        this.imagenFicha=imagenFicha;
        this.panel=panelFicha;
    }
    
    public Ficha(FichaControlador fichaControlador, FichaModelo fichaModelo, FichaVista fichaVista){
        this.fichaControlador = fichaControlador;
        this.fichaModelo= fichaModelo;
        this.fichaVista = fichaVista;
        this.numeroSuperior = fichaModelo.getNumeroSuperior();
        this.numeroInferior = fichaModelo.getNumeroInferior();
    }

    public Ficha(FichaControlador fichaControlador) {
        this.fichaControlador = fichaControlador;
        this.fichaModelo = this.fichaControlador.getFichaModelo();
        this.fichaVista = this.fichaControlador.getFichaVista();
        this.numeroSuperior = fichaModelo.getNumeroSuperior();
        this.numeroInferior = fichaModelo.getNumeroInferior();
    }

    
    public void escalado(int escala)
    {
        this.fichaModelo.escalado(escala);
    }
    public void establecerTamano(){
        System.out.println("Entro a establecer");
        fichaModelo.setAlto(37);
        fichaModelo.setAncho(37);
    }
    
    public void dibujarEnPanel(){
        fichaControlador.dibujarFicha();  
        fichaVista.addMouseListener(fichaControlador);
    }
    public void dibujarEnPanelRotada(int grados){
        System.out.println(grados);
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

    public Ficha(ImageIcon imagenFicha) {
        this.fichaModelo.setImagenFicha(imagenFicha);
    }

    public ImageIcon getImagenFicha() {
        return fichaModelo.getImagenFicha();
    }

    
    
    public int getNumeroSuperior() {
        return fichaModelo.getNumeroSuperior();
                
    }

    public int getNumeroInferior() {
        return fichaModelo.getNumeroInferior();
    }
    
    public int getPosicionX() {
        return fichaModelo.getPosicionX();
    }

    public void setPosicionX(int posicionX) {
        this.fichaModelo.setPosicionX(posicionX);
    }

    public int getPosicionY() {
        return fichaModelo.getPosicionY();
    }

    public void setPosicionY(int posicionY) {
       this.fichaModelo.setPosicionY(posicionY);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.numeroSuperior;
        hash = 19 * hash + this.numeroInferior;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        if (this.numeroSuperior != other.numeroSuperior) {
            return false;
        }
        if (this.numeroInferior != other.numeroInferior) {
            return false;
        }
        return true;
    }
    
    public Integer getPuntos(){
        return this.fichaModelo.getPuntos();
    }

    @Override
    public String toString() {
        return "Ficha{" + "numeroSuperior=" + numeroSuperior + ", numeroInferior=" + numeroInferior + '}';
    }

    
    
}

