/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoControlador implements ActionListener{
    private PozoModelo pozoModelo;
    private PozoVista pozoVista;
    private PozoObservable pozoObservable = new PozoObservable();
    private JButton botonPozo;
    
    public PozoControlador(PozoModelo pozoModelo, PozoVista pozoVista,JButton botonPozo){
        this.pozoModelo=pozoModelo;
        this.pozoVista=pozoVista;
        this.botonPozo = botonPozo;
        this.botonPozo.addActionListener(this);
    }
    public void mostrarPozo(){
        this.pozoVista.mostrarPozo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     //  System.out.println("Entro al action de botón pozo");
     //  Ficha ficha = pozoModelo.devolverFicha();
       pozoObservable.notificar();
     //  pozoModelo.getListaFichas().get(0);
    }
//    public Ficha devolverFicha(){
//        return pozoModelo.devolverFicha();
//    }

    public PozoObservable getPozoObservable() {
        return pozoObservable;
    }

    public void setPozoObservable(PozoObservable pozoObservable) {
        this.pozoObservable = pozoObservable;
    }
    public void eliminarFicha(Ficha ficha){
        //pozoModelo.eliminarFicha(ficha);
        pozoVista.mostrarPozo();
    }
    public class PozoObservable{
        List<PozoObserver> observadores = new ArrayList<>();
        public void agregarObservador(PozoObserver observador){
            observadores.add(observador);
        }
        public void notificar(){
            for (PozoObserver observador : observadores) {
                observador.fichaElegida();
            }
        }
    }
}
