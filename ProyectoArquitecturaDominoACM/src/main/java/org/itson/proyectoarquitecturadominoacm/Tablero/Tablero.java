/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Gabriel Mancinas
 */
public class Tablero {

    private JPanel lienzo;
    TableroModelo modelo;
    TableroVista vista;
    TableroControlador controlador;

    public Tablero(JPanel lienzo) {
        this.lienzo = lienzo;
        modelo = new TableroModelo(lienzo);

        controlador = new TableroControlador(modelo, vista);
    }

    public boolean agregarFicha(Ficha ficha, Boolean jugadorLocal) {
       return this.controlador.agregarFicha(ficha, jugadorLocal);
    }

   public byte desplegarOpcion(){
      return controlador.desplegarOpcion();
   }

    public void agregarFichaDerecha(Ficha ficha) {
        modelo.agregarFichaDerecha(ficha);
    }

    public void agregarFichaIzquierda(Ficha ficha) {
        modelo.agregarFichaIzquierda(ficha);
    }

    public LinkedList<Ficha> getFichas() {
        return modelo.getFichas();
    }

    public int getNumeroDerecha() {
        return modelo.getNumeroDerecha();
    }

    public int getNumeroIzquierda() {
        return modelo.getNumeroIzquierda();
    }
}
