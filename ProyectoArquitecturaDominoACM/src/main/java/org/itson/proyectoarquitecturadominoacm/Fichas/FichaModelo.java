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
    private float posicionX;
    private float posiciony;
    private float ancho;
    private float alto;
    private int numeroSuperior;
    private int numeroInferior;
    private String estado;
    private ImageIcon ficha;
    public FichaModelo(int sup, int inf){
       String dir = "/imgFrmPartidaFichas/ficha1_1.png";
       ImageIcon imagen = new ImageIcon(getClass().getResource(dir));
       this.ficha = imagen;
       numeroSuperior=sup;
       numeroInferior=inf;
    }
    public FichaModelo(float posicionX, float posiciony, float ancho, float alto, int numeroSuperior, int numeroInferior, String estado, ImageIcon ficha) {
        this.posicionX = posicionX;
        this.posiciony = posiciony;
        this.ancho = ancho;
        this.alto = alto;
        this.numeroSuperior = numeroSuperior;
        this.numeroInferior = numeroInferior;
        this.estado = estado;
        this.ficha = ficha;
    }
   
    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public float getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(float posiciony) {
        this.posiciony = posiciony;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
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

    public ImageIcon getFicha() {
        return ficha;
    }

    public void setFicha(ImageIcon ficha) {
        this.ficha = ficha;
    }
    
    public void dibujar(){
        
    }
    
    
    
    public void dibujar(float x, float y){
        
    }
    
}
