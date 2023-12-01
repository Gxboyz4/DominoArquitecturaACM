/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class TableroControlador {
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
    public byte desplegarOpcion() {
        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Qué opción prefieres?",
                "Opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Izquierda", "Derecha"},
                "Opción 1"
        );

        if (opcion == JOptionPane.YES_OPTION) {
            return 1;
        } else if (opcion == JOptionPane.NO_OPTION) {
            return 2;
        } else {
            return 3;
        }
    }
    

}
