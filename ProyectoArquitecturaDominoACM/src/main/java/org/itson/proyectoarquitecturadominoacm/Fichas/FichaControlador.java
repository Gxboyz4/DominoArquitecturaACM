/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;

/**
 *
 * @author Zaurus
 */
public class FichaControlador implements MouseListener{
    FichaModelo fichaModelo;
    FichaVista fichaVista;
    FichaObservable fichaObservable = new FichaObservable();
    
    public FichaControlador(FichaModelo fichaModelo, FichaVista fichaVista){
        this.fichaModelo=fichaModelo;
        this.fichaVista=fichaVista;
    }

    public FichaObservable getFichaObservable() {
        return fichaObservable;
    }

    public void setFichaObservable(FichaObservable ficha) {
        this.fichaObservable = ficha;
    }

    public void dibujarFicha(){
        this.fichaVista.dibujar();
    }

    public FichaModelo getFichaModelo() {
        return fichaModelo;
    }

    public void setFichaModelo(FichaModelo fichaModelo) {
        this.fichaModelo = fichaModelo;
    }

    public FichaVista getFichaVista() {
        return fichaVista;
    }

    public void setFichaVista(FichaVista fichaVista) {
        this.fichaVista = fichaVista;
    }
    
    
    public void dibujarFichaTablero(float x, float y){
        
    }
    public void dibujarFichaRotada(int grados){
        this.fichaVista.dibujarRotada(grados);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

       this.fichaObservable.notificar(new Ficha(this));
    }

    @Override
    public void mousePressed(MouseEvent e) {
   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }
    
    public class FichaObservable{
        List<FichaObserver> observadores = new ArrayList<>();
        
        public void agregarObservador(FichaObserver observador){
            this.observadores.add(observador);
        }
        
        public void notificar(Ficha ficha){
            for (FichaObserver observadore : observadores) {
                observadore.fichaSeleccionada(ficha);
            }
        }
        
    }
}
