/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.DTOs;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel Mancinas
 */
public class JugadorDTO implements Serializable{
    ImageIcon avatar;
    String nombre;
    int cantidadFichas;

    public JugadorDTO(String nombre,ImageIcon avatar) {
        this.avatar = avatar;
        this.nombre = nombre;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }
    
}
