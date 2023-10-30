/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Jugador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author julio
 */
public class JugadorModelo implements Serializable{
    String nombre;
    ImageIcon avatar;
    List<Ficha> fichas = new ArrayList<>();
    JPanel panelFichas;
    int x;
    int y;
    boolean listo;
    
    public JugadorModelo(String nombre, ImageIcon avatar){
        this.nombre=nombre;
        this.avatar=avatar;
    }
    
    public JugadorModelo(List<Ficha> fichas, JPanel panelFichas) {
        this.fichas = fichas;
        this.panelFichas = panelFichas;
        x = 0;
        y = 0;
        if (!this.fichas.isEmpty()) {
            for (Ficha ficha1 : fichas) {
                this.dibujar(ficha1);
            }
        }
    }

    public JugadorModelo(JPanel panelFichas) {
        this.panelFichas = panelFichas;
        x = 0;
        y = 0;
        if (!this.fichas.isEmpty()) {
            for (Ficha ficha1 : fichas) {
                this.dibujar(ficha1);
            }
        }
    }

    public void eliminarFicha(Ficha ficha) {
        panelFichas.removeAll();
        fichas.remove(ficha);
        x = 0;
        y = 0;
        panelFichas.repaint();
        for (Ficha ficha1 : fichas) {
            this.dibujar(ficha1);
        }
        
    }

    public void agregarFicha(Ficha ficha) {
        if(fichas.isEmpty()){
            panelFichas.removeAll();
            panelFichas.repaint();
            x=0;
            y=0;
        }
        fichas.add(ficha);
        this.dibujar(ficha);    
    }

    public void dibujar(Ficha ficha) {
        ficha.escalado(37);
        ficha.setPanelFichas(panelFichas);
        if(x+20>panelFichas.getWidth()){
            y = y +42;
            x=0;
            
        }
        ficha.setPosicionY(y);
        ficha.setPosicionX(x);
        ficha.dibujarEnPanel();
        x = x + 26;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = new ArrayList<>();
    }

    public JPanel getPanelFichas() {
        return panelFichas;
    }

    public void setPanelFichas(JPanel panelFichas) {
        this.panelFichas = panelFichas;
    }
     public boolean getListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }
    
}
