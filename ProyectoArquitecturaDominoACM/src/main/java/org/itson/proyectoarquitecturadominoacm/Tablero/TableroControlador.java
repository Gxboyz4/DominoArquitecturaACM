/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import javax.swing.JOptionPane;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Gabriel Mancinas
 */
public class TableroControlador {

    TableroModelo modelo;
    TableroVista vista;

    private static final int IZQUIERDA = 1;
    private static final int DERECHA = 2;
    private static final int CANCELAR = 3;

    public TableroControlador(TableroModelo modelo, TableroVista vista) {
        this.modelo = modelo;
        this.vista = vista;

    }

    public boolean agregarFicha(Ficha ficha, Boolean jugadorLocal) {
        if (validarColocacionFicha(ficha)) {
            if (modelo.getFichas().isEmpty()) {
                this.agregarFichaDerecha(ficha, jugadorLocal);
                return true;
            }
            int opcion = this.desplegarOpcion();
            return this.agregarFichaOpcion(opcion, ficha, jugadorLocal);
        } else if (modelo.validarColocacionDerecha(ficha) != modelo.getFalso()) {
            this.agregarFichaDerecha(ficha, jugadorLocal);
            return true;
        } else if (modelo.validarColocacionIzquierda(ficha) != modelo.getFalso()) {
            this.agregarFichaIzquierda(ficha, jugadorLocal);
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
            return IZQUIERDA;
        } else if (opcion == JOptionPane.NO_OPTION) {
            return DERECHA;
        } else {
            return CANCELAR;
        }
    }

    private boolean validarColocacionFicha(Ficha ficha) {
        if ((modelo.validarColocacionDerecha(ficha) != modelo.getFalso())
                && modelo.validarColocacionIzquierda(ficha) != modelo.getFalso()) {
            return true;
        }
        return false;
    }

    private boolean agregarFichaOpcion(int opcion, Ficha ficha, Boolean JugadorLocal) {
        switch (opcion) {
            case IZQUIERDA:
                this.agregarFichaIzquierda(ficha, JugadorLocal);
                return true;
            case DERECHA:
                this.agregarFichaDerecha(ficha, JugadorLocal);
                return true;
            default:
                return false;
        }
    }

    private void agregarFichaIzquierda(Ficha ficha, Boolean JugadorLocal) {
        modelo.agregarFichaIzquierda(ficha);
        if (JugadorLocal) {
            this.movimientoJugadorLocal(ficha, IZQUIERDA);
        }
    }

    private void agregarFichaDerecha(Ficha ficha, Boolean JugadorLocal) {
        modelo.agregarFichaDerecha(ficha);
        if (JugadorLocal) {
            this.movimientoJugadorLocal(ficha, DERECHA);
        }
    }

    private void movimientoJugadorLocal(Ficha ficha, int ladoFicha) {
        switch (ladoFicha) {
            case IZQUIERDA:
                mediador.enviarFichaIzquierda(ficha);
                break;
            case DERECHA:
                mediador.enviarFichaDerecha(ficha);
                break;
        }
    }
}
