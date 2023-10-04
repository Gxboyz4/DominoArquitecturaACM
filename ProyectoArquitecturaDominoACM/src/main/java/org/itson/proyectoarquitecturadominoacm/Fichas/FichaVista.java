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
        System.out.println("este es el rotar   " + imagen.getIconWidth());
        imagen = rotarImagen(imagen, grados);
        System.out.println("este ya toar   " + imagen.getIconWidth());
        Icon icon = imagen;
        this.setIcon(icon);

    }

    public ImageIcon rotarImagen(ImageIcon imagenOriginal, int grados) {
        int anchoOriginal = imagenOriginal.getIconWidth();
        int altoOriginal = imagenOriginal.getIconHeight();

        BufferedImage imagenBuffered = new BufferedImage(altoOriginal, anchoOriginal, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) imagenBuffered.getGraphics();

        g2d.rotate(Math.toRadians(grados), altoOriginal / 2, anchoOriginal / 2);
        g2d.drawImage(imagenOriginal.getImage(), 0, 0, null);

        return new ImageIcon(imagenBuffered);
    }

}
