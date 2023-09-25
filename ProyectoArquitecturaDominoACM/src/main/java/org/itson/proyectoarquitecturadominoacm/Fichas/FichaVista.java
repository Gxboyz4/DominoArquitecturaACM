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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zaurus
 */
public class FichaVista extends JLabel{
    FichaModelo modelo;
    
    public FichaVista(FichaModelo modelo,JPanel fichas,int x){
        this.modelo=modelo;
        
        //this.ficha.setIcon(modelo.getFicha());getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_DEFAULT);
        
        this.setBounds(x, 5, 25,25);
        Icon icon = new ImageIcon(modelo.getFicha().getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
      
        this.setIcon(icon);
        //this.setOpaque(true);
        fichas.add(this);
        
        System.out.println(this);
        
    }
    
    public void actualizarVistaPanel(JPanel fichas){
         repaint();
    }
    
    @Override
        public void paint(Graphics g) {
            System.out.println("pintado");
            super.paint(g);
            ImageIcon ficha = modelo.getFicha();
            //g.drawImage(ficha.getImage(), 5, -5, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
        }
    


    
}
