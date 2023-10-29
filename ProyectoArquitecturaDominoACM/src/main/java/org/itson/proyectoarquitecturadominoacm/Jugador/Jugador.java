/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Jugador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author julio
 */
public class Jugador implements Serializable{
    List<Ficha> fichas = new ArrayList<>();
    JPanel panelFichas; 
    JugadorControlador controlador;
    JugadorModelo modelo;
    JugadorVista vista;
    ImageIcon avatar;
    String nombre;
    
    public Jugador(){
        this.setearResponsabilidades();
    }
    
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
       return modelo.getFichas();
    }

    public void setFichas(List<Ficha> fichas) {
        this.modelo.setFichas(fichas);
    }

    public JPanel getPanelFichas() {
        return modelo.getPanelFichas();
    }

    public void setPanelFichas(JPanel panelFichas) {
        this.panelFichas = panelFichas;
        modelo.setPanelFichas(panelFichas);
    }

    public ImageIcon getAvatar() {
        return modelo.getAvatar();
    }

    public void setAvatar(ImageIcon avatar) {
        modelo.setAvatar(avatar);
    }

    public String getNombre() {
        return modelo.getNombre();
    }

    public void setNombre(String nombre) {
        modelo.setNombre(nombre);
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }
    
    

}
