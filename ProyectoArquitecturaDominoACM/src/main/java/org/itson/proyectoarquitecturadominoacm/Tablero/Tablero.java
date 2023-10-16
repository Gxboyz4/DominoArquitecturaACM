/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

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
        
        controlador = new TableroControlador(modelo,vista);
    }
    public boolean agregarFicha(Ficha ficha)
    {
        if(modelo.validarColocacionDerecha(ficha) !=0 && modelo.validarColocacionIzquierda(ficha) !=0){
            int opcion = desplegarOpcion();
            if(opcion == 1)
            {
                modelo.agregarFichaIzquierda(ficha);
                return true;
            }
            if(opcion == 2) //else if
            {
                modelo.agregarFichaDerecha(ficha);
                return true;
            }
            if(opcion == 3){ //else if
                return false;
            }
        }else
        if(modelo.validarColocacionDerecha(ficha) !=0){
             modelo.agregarFichaDerecha(ficha);
            return true;
        }else
        if(modelo.validarColocacionIzquierda(ficha) !=0){
            modelo.agregarFichaIzquierda(ficha);
            return true;
        }
        return false;
    }
    public byte desplegarOpcion(){
        int opcion = JOptionPane.showOptionDialog(
            null,
            "¿Qué opción prefieres?",
            "Opciones",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] {"Izquierda", "Derecha"},
            "Opción 1"
        );

        if (opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Presionaste izquierda 1");
            return 1;
        } else if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Presionaste derecha 2");
            return 2;
        } else {
            JOptionPane.showMessageDialog(null, "Cerraste la ventana");
            return 3;
        }
    }
    public void agregarFichaDerecha(Ficha ficha) {
        modelo.agregarFichaDerecha(ficha);
    }
    
    public void agregarFichaIzquierda(Ficha ficha) {
        modelo.agregarFichaIzquierda(ficha);
    }
}
