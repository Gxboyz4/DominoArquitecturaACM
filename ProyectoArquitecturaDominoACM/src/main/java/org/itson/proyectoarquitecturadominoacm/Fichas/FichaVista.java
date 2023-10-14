/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Fichas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.geom.AffineTransform;
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
public class FichaVista extends JLabel {

    FichaModelo modelo;
    JPanel fichas;

    public FichaVista(FichaModelo modelo, JPanel fichas) {
        this.modelo = modelo;
        this.fichas = fichas;
    }

    public void dibujar() {
        fichas.add(this);
        this.setBounds(modelo.getPosicionX(), modelo.getPosicionY(), this.modelo.getAncho(), this.modelo.getAlto());
        Icon icon = new ImageIcon(modelo.getImagenFicha().getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(icon);

    }

    public void dibujarRotada(int grados) {
        fichas.add(this);
        this.setBounds(modelo.getPosicionX(), modelo.getPosicionY(), this.modelo.getAncho(), this.modelo.getAlto());
        ImageIcon imagen = new ImageIcon(modelo.getImagenFicha().getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        imagen = rotarImagen(imagen, grados);
        Icon icon = imagen;
        this.setIcon(icon);

    }

    public ImageIcon rotarImagen(ImageIcon icon, double grados) {
        Image img = icon.getImage();
        int ancho = img.getWidth(null);
        int alto = img.getHeight(null);

        double radianes = Math.toRadians(grados);
        double nuevoAncho = Math.abs(Math.cos(radianes) * ancho) + Math.abs(Math.sin(radianes) * alto);
        double nuevoAlto = Math.abs(Math.sin(radianes) * ancho) + Math.abs(Math.cos(radianes) * alto);

        BufferedImage bi = new BufferedImage((int) nuevoAncho, (int) nuevoAlto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();

        AffineTransform transformacion = AffineTransform.getRotateInstance(radianes, nuevoAncho / 2, nuevoAlto / 2);
        transformacion.translate((nuevoAncho - ancho) / 2, (nuevoAlto - alto) / 2); 

        g2d.setTransform(transformacion);
        g2d.drawImage(img, 0, 0, null);

        return new ImageIcon(bi);
    }

    public JPanel getFichas() {
        return fichas;
    }

    public void setFichas(JPanel fichas) {
        this.fichas = fichas;
    }
    
    

}
