/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Zaurus
 */
public class FichaModelo {
    private int posicionX;
    private int posicionY;
    private int ancho;
    private int alto;
    private int numeroSuperior;
    private int numeroInferior;
    private String estado;
    private ImageIcon imagenFicha;

    public FichaModelo(int numeroSuperior, int numeroInferior, ImageIcon imagen){
        this.numeroSuperior=numeroSuperior;
        this.numeroInferior=numeroInferior;
        this.imagenFicha = imagen;
        this.alto=45;
        this.ancho=46;
    }
    public FichaModelo(int numeroSuperior, int numeroInferior, ImageIcon imagen,int posicionX,int posicionY){
        this.numeroSuperior=numeroSuperior;
        this.numeroInferior=numeroInferior;
        this.imagenFicha = imagen;
        this.estado="En pozo";
        this.alto=45;
        this.ancho=46;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }
    public FichaModelo(int posicionX, int posiciony,int  ancho,int alto, int numeroSuperior, int numeroInferior, String estado, ImageIcon ficha) {
        this.posicionX = posicionX;
        this.posicionY = posiciony;
        this.ancho = ancho;
        this.alto = alto;
        this.numeroSuperior = numeroSuperior;
        this.numeroInferior = numeroInferior;
        this.estado = estado;
        this.imagenFicha = ficha;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ImageIcon getImagenFicha() {
        return imagenFicha;
    }

    public void setImagenFicha(ImageIcon imagenFicha) {
        this.imagenFicha = imagenFicha;
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

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
}
