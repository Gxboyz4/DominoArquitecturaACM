/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zaurus
 */
public class FichaVista extends JPanel{
    JLabel ficha;
    FichaModelo modelo;
    JPanel fichas;
    
    public FichaVista(JPanel fichas){
       // this.modelo=modelo;
        this.ficha = new JLabel();
        this.fichas = fichas;
        this.add(ficha);
        this.setBackground(Color.MAGENTA);
        this.setSize(50,50 );
    }
    
    public void actualizar(){
         fichas.add(this);     
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String dir = "/imgFrmPartidaFichas/ficha1_1.png";
            ImageIcon imagen = new ImageIcon(getClass().getResource(dir));
            g.drawImage(imagen.getImage(), 0, 0, 20, 25, this);
           
    }
}
