/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.libreriatiposdominoacmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel Mancinas
 */
public class JugadorDTO implements Serializable {

    int id;
    ImageIcon avatar;
    String nombre;
    int cantidadFichas;
    boolean listo;
    boolean turno;
    int puntos;
    List<FichaDTO> fichas = new ArrayList<>();

    public JugadorDTO(String nombre, ImageIcon avatar) {
        this.avatar = avatar;
        this.nombre = nombre;
    }

    public JugadorDTO(String nombre, ImageIcon avatar, int id) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.id = id;
    }

    public JugadorDTO(ImageIcon avatar, String nombre, boolean listo, int id) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.listo = listo;
        this.id = id;
    }

    public JugadorDTO(ImageIcon avatar, String nombre, int cantidadFichas, boolean listo) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.cantidadFichas = cantidadFichas;
        this.listo = listo;
    }

    public JugadorDTO(int id, ImageIcon avatar, String nombre, Integer puntos) {
        this.id = id;
        this.avatar = avatar;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public List<FichaDTO> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaDTO> fichas) {
        this.fichas = fichas;
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

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void anadirFichas(List<FichaDTO> fichasAnadir) {
        this.fichas.addAll(fichasAnadir);
    }
    
    public void agregarFicha(FichaDTO fichaDTO){
        this.fichas.add(fichaDTO);
    }
    
    public void eliminarFicha(FichaDTO fichaDTO){
        this.fichas.remove(fichaDTO);
    }
    
    public Integer getTotalPuntos(){
        Integer totalPuntos = 0;
        for (FichaDTO ficha : fichas) {
            totalPuntos += ficha.getPuntos();
        }
  
        return totalPuntos;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" + "id=" + id + ", nombre=" + nombre + "turno " + turno + '}';
    }

}
