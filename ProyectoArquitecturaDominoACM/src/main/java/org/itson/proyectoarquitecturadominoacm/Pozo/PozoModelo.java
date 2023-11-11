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
//        listaFichas = new ArrayList();        
//        for (int i = 0; i <= 6; i++) {
//            for (int j = i; j <= 6; j++) {
//                String rutaImagen = String.format("/imgFrmPartidaFichas/ficha%d_%d.png", i, j);
//                ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
//                FichaModelo fichaModelo = new FichaModelo(j, i, imagen);
//                FichaVista fichaVista = new FichaVista(fichaModelo,null);
//                FichaControlador fichaControlador = new FichaControlador(fichaModelo, fichaVista);
//                Ficha ficha = new Ficha(fichaControlador, fichaModelo, fichaVista);
//                listaFichas.add(ficha);
//            }
//            }
        

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

   
//    public Ficha devolverFicha(){
//     int numeroRandom = (int) (Math.random() * getListaFichas().size() + 0);
//     return listaFichas.get(numeroRandom);
//    }
    
//    public void eliminarFicha(Ficha ficha){
//        listaFichas.remove(ficha);
//        verificarNumFichas();
//    }
//    public void verificarNumFichas(){
//        if(listaFichas.size()==0){
//            this.estadoVisible=false;
//        }
//    }
//    public List<Ficha> repartirFichas(int numFichas){
//    List<Ficha> fichas = new ArrayList();
//            for (int j = 0; j < numFichas; j++) {
//                Ficha ficha;
//                ficha=devolverFicha();
//                eliminarFicha(ficha);
//                fichas.add(ficha);
//            }
//            return fichas;
//    }

}
