/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Jugador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author julio
 */
public class JugadorModelo {

    List<Ficha> fichas = new ArrayList<>();
    JPanel panelFichas;
    int x;
    int y;

    public JugadorModelo(List<Ficha> fichas, JPanel panelFichas) {
        this.fichas = fichas;
        this.panelFichas = panelFichas;
        x = 0;
        y = 0;
        if (!this.fichas.isEmpty()) {
            for (Ficha ficha1 : fichas) {
                this.dibujar(ficha1);
            }
        }
    }

    public JugadorModelo(JPanel panelFichas) {
        this.panelFichas = panelFichas;
        x = 0;
        y = 0;
        if (!this.fichas.isEmpty()) {
            for (Ficha ficha1 : fichas) {
                this.dibujar(ficha1);
            }
        }
    }

    public void eliminarFicha(Ficha ficha) {
        fichas.remove(ficha);
        x = 0;
        for (Ficha ficha1 : fichas) {
            this.dibujar(ficha1);
        }
    }

    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
        this.dibujar(ficha);
    }

    public void dibujar(Ficha ficha) {
        ficha.setPanelFichasUsuario(panelFichas);
        if(x+20>panelFichas.getWidth()){
            y = y +42;
            x=0;
            
        }
        System.out.println(x);
        ficha.setPosicionY(y);
        ficha.setPosicionX(x);
        ficha.dibujarEnPanelUsuario();
        x = x + 25;
    }
}
