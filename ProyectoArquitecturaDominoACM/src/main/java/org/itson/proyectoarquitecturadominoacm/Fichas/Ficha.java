/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Zaurus
 */
public class Ficha {
    FichaControlador fichaControlador;
    FichaModelo fichaModelo;
    FichaVista fichaVista;
    JPanel panelFichasUsuario;
    int sup;
    int inf;
    
    public Ficha(JPanel panelFicha,int sup, int inf){
        this.sup=sup;
        this.inf=inf;
        this.panelFichasUsuario=panelFicha;;
    }
    public void dibujarEnPanelUsuario(){
        fichaModelo= new FichaModelo(sup,inf);
        fichaVista = new FichaVista(fichaModelo);
        fichaControlador = new FichaControlador(fichaModelo,fichaVista);
         fichaControlador.dibujarFicha(panelFichasUsuario);
        this.panelFichasUsuario.add(fichaVista, 0);
       // this.panelFichasUsuario.add(fichaVista, 0);
        
        fichaVista.addMouseListener(fichaControlador);
    }
}