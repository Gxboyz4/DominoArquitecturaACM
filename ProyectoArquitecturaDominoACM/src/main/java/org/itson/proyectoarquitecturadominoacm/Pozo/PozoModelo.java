/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaControlador;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoModelo {

    List<Ficha> listaFichas;
    Boolean estadoVisible=true;

    public PozoModelo() {

    }

    public List<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(List<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    public Boolean getEstadoVisible() {
        return estadoVisible;
    }

    public void setEstadoVisible(Boolean estadoVisible) {
        this.estadoVisible = estadoVisible;
    }


}
