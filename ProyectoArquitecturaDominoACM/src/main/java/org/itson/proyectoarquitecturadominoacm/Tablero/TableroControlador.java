/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class TableroControlador implements KeyListener{
    TableroModelo modelo;
    TableroVista vista;
    
    public TableroControlador(TableroModelo modelo, TableroVista vista){
        this.modelo = modelo;
        this.vista = vista;
        
        
    }
    public void agregarFichaDerecha(Ficha ficha)
    {
        modelo.agregarFichaDerecha(ficha);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == e.VK_A) {
            System.out.println("A");
            
        }
        if (e.getKeyCode() == e.VK_D) {
            System.out.println("E");
            modelo.moverDerecha();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_A) {
            System.out.println("A");
            
        }
        if (e.getKeyCode() == e.VK_D) {
            System.out.println("E");
            modelo.moverDerecha();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == e.VK_A) {
            System.out.println("A");
            
        }
        if (e.getKeyCode() == e.VK_D) {
            System.out.println("E");
            modelo.moverDerecha();
        }
    }
}
