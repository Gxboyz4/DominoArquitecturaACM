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
        if (modelo.validarColocacionDerecha(ficha) != 0 && modelo.validarColocacionIzquierda(ficha) != 0) {
            if (modelo.getFichas().size() == 0) {
                modelo.agregarFichaDerecha(ficha);
                mediador.enviarFicha(ficha);
                return true;
            }
            int opcion = desplegarOpcion();
            if (opcion == 1) {

                modelo.agregarFichaIzquierda(ficha);
                if (jugadorLocal) {
                mediador.enviarFichaIzquierda(ficha);
                }
                return true;
            }
            if (opcion == 2) //else if
            {
                modelo.agregarFichaDerecha(ficha);
                if (jugadorLocal) {
                mediador.enviarFichaDerecha(ficha);
                }
                return true;
            }
            if (opcion == 3) { //else if
                return false;
            }
        } else if (modelo.validarColocacionDerecha(ficha) != 0) {
            modelo.agregarFichaDerecha(ficha);
            if (jugadorLocal) {
                mediador.enviarFichaDerecha(ficha);
            }

            return true;
        } else if (modelo.validarColocacionIzquierda(ficha) != 0) {
            modelo.agregarFichaIzquierda(ficha);
            if (jugadorLocal) {
                mediador.enviarFichaIzquierda(ficha);
            }
            return true;
        }
        return false;
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
