/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Jugador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author julio
 */
public class Jugador {
     List<Ficha> fichas = new ArrayList<>();
    JPanel panelFichas; 
    JugadorControlador controlador;
    JugadorModelo modelo;
    JugadorVista vista;
    ImageIcon avatar;
    String nombre;

    public Jugador(String nombre,ImageIcon avatar){
        this.nombre=nombre;
        this.avatar=avatar;
        this.setearResponsabilidades();
    }
    
    public Jugador(JPanel panelFichas) {
        this.panelFichas = panelFichas;
        this.setearResponsabilidades();
    }
    
    public Jugador(JPanel panelFichas,List<Ficha> fichas) {
        this.panelFichas = panelFichas;
        this.fichas = fichas;
        this.setearResponsabilidades();
    }
    
    private void setearResponsabilidades(){
        this.modelo = new JugadorModelo(nombre,avatar);
        this.vista = new JugadorVista();
        this.controlador = new JugadorControlador(modelo, vista);
    }
    
    public void agregarFicha(Ficha ficha){
        controlador.agregarFicha(ficha);
    }
    
    public void eliminarFicha(Ficha ficha){
        controlador.eliminarFicha(ficha);
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public JPanel getPanelFichas() {
        return panelFichas;
    }

    public void setPanelFichas(JPanel panelFichas) {
        this.panelFichas = panelFichas;
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
    
    

}
