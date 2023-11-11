/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.libreriatiposdominoacmp;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Zaurus
 */
public class FichaDTO implements Serializable{
    int numeroInf;
    int numeroSup;
    String direccionImg;
    ImageIcon imagen;

    public FichaDTO(int numeroInf, int numeroSup, String direccionImg) {
        this.numeroInf = numeroInf;
        this.numeroSup = numeroSup;
        this.direccionImg = direccionImg;
    }

    public FichaDTO(int numeroInf, int numeroSup,  ImageIcon imagen) {
        this.numeroInf = numeroInf;
        this.numeroSup = numeroSup;
        this.imagen = imagen;
    }
    public int getNumeroInf() {
        return numeroInf;
    }

    public void setNumeroInf(int numeroInf) {
        this.numeroInf = numeroInf;
    }

    public int getNumeroSup() {
        return numeroSup;
    }

    public void setNumeroSup(int numeroSup) {
        this.numeroSup = numeroSup;
    }

    public String getDireccionImg() {
        return direccionImg;
    }

    public void setDireccionImg(String direccionImg) {
        this.direccionImg = direccionImg;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    
    @Override
    public String toString() {
        return "FichaDTO{" + "numeroInf=" + numeroInf + ", numeroSup=" + numeroSup + '}';
    }
    
}
