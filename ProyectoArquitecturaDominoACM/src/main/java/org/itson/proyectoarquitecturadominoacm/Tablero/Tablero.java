/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import javax.swing.JPanel;

/**
 *
 * @author Gabriel Mancinas
 */
public class Tablero {
     private JPanel lienzo;
     TableroModelo modelo;
     TableroVista vista;
     TableroControlador controlador;
     
     public Tablero(JPanel lienzo){
         this.lienzo=lienzo;
     }
     public void actualizar(){
         
     }
}
