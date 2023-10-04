/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Pozo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoModelo {

    List<Ficha> listaFichas;
    String estado="Visible";

    public PozoModelo() {
        listaFichas = new ArrayList();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                String rutaImagen = String.format("/imgFrmPartidaFichas/ficha%d_%d.png", i, j);
                ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
                Ficha ficha = new Ficha(i, j, imagen);
                listaFichas.add(ficha);
            }
        }

    }

    public List<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(List<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Ficha devolverFicha(){
     int numeroRandom = (int) (Math.random() * getListaFichas().size() + 0);
     return listaFichas.get(numeroRandom);
    }

}
