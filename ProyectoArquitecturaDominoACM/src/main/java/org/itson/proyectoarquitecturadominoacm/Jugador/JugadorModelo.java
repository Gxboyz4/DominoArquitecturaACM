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
public class JugadorModelo implements Serializable {

    int id;
    String nombre;
    ImageIcon avatar;
    List<Ficha> fichas = new ArrayList<>();
    JPanel panelFichas;
    int x;
    int y;
    boolean listo;
    boolean turno;

    public JugadorModelo(String nombre, ImageIcon avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public boolean jugadorConFichas(){
        return !this.fichas.isEmpty();
    }
   

    public void eliminarFicha(Ficha ficha) {     
        fichas.remove(ficha);
        

    }
    public void limpiarPanel(){
        panelFichas.removeAll();
            panelFichas.repaint();
            x = 0;
            y = 0;
    }

    public void agregarFicha(Ficha ficha) {
        System.out.println("Entro a aagregar fichas modelo");
        fichas.add(ficha);
        //this.dibujar(ficha);
    }

    public void dibujar(Ficha ficha) {
//        ficha.escalado(37);
//        ficha.setPanelFichas(panelFichas);
        if (debeCambiarDeFila(ficha)) {
            cambiarDeFila();
        }
//        establecerPosicionFicha(ficha);
//        ficha.dibujarEnPanel();
//        actualizarPosicionHorizontal();
    }

    public boolean debeCambiarDeFila(Ficha ficha) {
        return x + 20 > panelFichas.getWidth();
    }

    public void cambiarDeFila() {
        y = y + 42;
        x = 0;
    }

    public void establecerPosicionFicha(Ficha ficha) {
        ficha.setPosicionY(y);
        ficha.setPosicionX(x);
    }

    public void actualizarPosicionHorizontal() {
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

    public Integer getTotalPuntos() {
        Integer totalPuntos = 0;
        for (Ficha ficha : fichas) {
            totalPuntos += ficha.getPuntos();
        }
        return totalPuntos;
    }
}
