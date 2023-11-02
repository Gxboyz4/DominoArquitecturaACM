/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.libreriatiposdominoacmp;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel Mancinas
 */
public class JugadorDTO implements Serializable{
    int id;
    ImageIcon avatar;
    String nombre;
    int cantidadFichas;
   boolean listo;

    public JugadorDTO(String nombre,ImageIcon avatar) {
        this.avatar = avatar;
        this.nombre = nombre;
    }
       public JugadorDTO(String nombre,ImageIcon avatar,int id) {
        this.avatar = avatar;
        this.nombre = nombre;
    }
    public JugadorDTO(ImageIcon avatar, String nombre, boolean listo) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.listo = listo;
    }
    
    public JugadorDTO(ImageIcon avatar, String nombre, int cantidadFichas, boolean listo) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.cantidadFichas = cantidadFichas;
        this.listo = listo;
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
    
    public boolean getListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final JugadorDTO other = (JugadorDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
   
    
    
    
}
