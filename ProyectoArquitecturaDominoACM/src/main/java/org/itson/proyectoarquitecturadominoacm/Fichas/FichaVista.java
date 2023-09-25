/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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
    JPanel panelFichasUsuario;
    JPanel panelFicha;
    
    public FichaVista(FichaModelo modelo){
        this.panelFicha=this;
        this.modelo=modelo;
        this.ficha = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(ficha);
        this.setVisible(true);
        this.setBackground(Color.MAGENTA);
        this.setSize(20,25 );
       // this.ficha.setIcon(modelo.getFicha());
    }
    
    public void actualizarVistaPanel(JPanel fichas){
         repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            ImageIcon ficha = modelo.getFicha();
            g.drawImage(ficha.getImage(), 0,0, 20, 25, null);
            //this.ficha.setIcon(ficha);
            System.out.println("Paintcomponent");
            
    }

    public JPanel getPanelFicha() {
        return panelFicha;
    }

    public void setPanelFicha(JPanel panelFicha) {
        this.panelFicha = panelFicha;
    }
    
}
