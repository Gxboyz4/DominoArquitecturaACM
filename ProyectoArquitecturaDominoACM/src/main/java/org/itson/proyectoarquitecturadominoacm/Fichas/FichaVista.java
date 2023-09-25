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
    public int x;
    public FichaVista(FichaModelo modelo,JPanel fichas,int x){
        this.modelo=modelo;
        this.x = x;
        //this.ficha.setIcon(modelo.getFicha());getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_DEFAULT);
        
        this.setBounds(x, 0, 25,25);
        Icon icon = new ImageIcon(modelo.getFicha().getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
      
        //this.setIcon(icon);
        //this.setOpaque(true);
        fichas.add(this);
        
        System.out.println(this);
        
    }
    
    public void actualizarVistaPanel(){
         repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        System.out.println("pintado");
        super.paint(g);

        // Verificar si hay un ícono antes de intentar dibujarlo
//        if(modelo.getEstado() != null && modelo.getEstado().equalsIgnoreCase("Clickeado"))
//        {
//            ImageIcon ficha = modelo.getFicha();
//            g.drawImage(ficha.getImage(), 0, 5, getWidth(), getHeight(), this);
//            System.out.println("LOCAMBIOOO");
//        }else
        if (modelo.getFicha() != null) {
            ImageIcon ficha = modelo.getFicha();
            g.drawImage(ficha.getImage(), 0, 0, getWidth(), getHeight(), this);
            System.out.println(this.getBounds());
            System.out.println(modelo.getEstado());
            
        }
        
        

        setOpaque(false);
    }
    


    
}
