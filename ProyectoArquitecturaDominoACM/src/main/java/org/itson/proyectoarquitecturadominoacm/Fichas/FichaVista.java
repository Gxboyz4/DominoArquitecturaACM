/**
 * Clase FichaVista.java.
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
    /**
     * Atributo que representa el modelo de la ficha.
     */
    FichaModelo modelo;
    /**
     * Atributo que representa el panel donde se dibuja.
     */
   // JPanel panel;
    /**
     * Constructor por defecto que inicializa el modelo y el panel.
     * @param modelo modelo de la ficha.
     * @param fichas panel de la ficha.
     */
    public FichaVista(FichaModelo modelos) {
        this.modelo = modelos;
        //this.panel = fichas;
    }
   
    public void dibujar() {
        //panel.add(this);
        System.out.println("Entro al dibujar" + modelo);
        this.setBounds(modelo.getPosicionX(), modelo.getPosicionY(), this.modelo.getAncho(), this.modelo.getAlto());
        Image imagenModelo = modelo.getImage();
        Icon iconADibujar = new ImageIcon(imagenModelo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(iconADibujar);
    }
   
    public void dibujarRotada(int grados) {
       // panel.add(this);
        this.setBounds(modelo.getPosicionX(), modelo.getPosicionY(), this.modelo.getAncho(), this.modelo.getAlto());
        Image imagenModelo = modelo.getImage();
        ImageIcon imagen = new ImageIcon(imagenModelo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        imagen = rotarImagen(imagen, grados);
        Icon iconADibujar = imagen;
        this.setIcon(iconADibujar);

    }

    public FichaModelo getModelo() {
        return modelo;
    }
    
    /*
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
    */
/**
 * Rota una imagen a un cierto número de grados.
 *
 * @param icon El ImageIcon que se va a rotar.
 * @param grados Los grados a los que se va a rotar la imagen.
 * @return Un nuevo ImageIcon que es la imagen original rotada.
 */
    public ImageIcon rotarImagen(ImageIcon icon, double grados) {
        Image img = icon.getImage();
        int ancho = img.getWidth(null);
        int alto = img.getHeight(null);

        double radianes = convertirGradosARadianes(grados);
        double[] dimensionesNuevas = calcularDimensionesNuevas(ancho, alto, radianes);
        double nuevoAncho = dimensionesNuevas[0];
        double nuevoAlto = dimensionesNuevas[1];

        BufferedImage bi = crearBufferedImage(nuevoAncho, nuevoAlto);
        Graphics2D g2d = bi.createGraphics();

        AffineTransform transformacion = crearTransformacion(nuevoAncho, nuevoAlto, radianes, ancho, alto);
        g2d.setTransform(transformacion);
        g2d.drawImage(img, 0, 0, null);

        return new ImageIcon(bi);
    }

    /**
     * Convierte grados a radianes.
     *
     * @param grados Los grados que se van a convertir.
     * @return Los grados convertidos a radianes.
     */
    public double convertirGradosARadianes(double grados) {
        return Math.toRadians(grados);
    }

    /**
     * Calcula las nuevas dimensiones de la imagen después de la rotación.
     *
     * @param ancho El ancho original de la imagen.
     * @param alto El alto original de la imagen.
     * @param radianes Los radianes a los que se va a rotar la imagen.
     * @return Un arreglo con el nuevo ancho y alto de la imagen.
     */
    public double[] calcularDimensionesNuevas(int ancho, int alto, double radianes) {
        double nuevoAncho = Math.abs(Math.cos(radianes) * ancho) + Math.abs(Math.sin(radianes) * alto);
        double nuevoAlto = Math.abs(Math.sin(radianes) * ancho) + Math.abs(Math.cos(radianes) * alto);
        return new double[]{nuevoAncho, nuevoAlto};
    }

    /**
     * Crea un nuevo BufferedImage.
     *
     * @param ancho El ancho del BufferedImage.
     * @param alto El alto del BufferedImage.
     * @return Un nuevo BufferedImage.
     */
    public BufferedImage crearBufferedImage(double ancho, double alto) {
        return new BufferedImage((int) ancho, (int) alto, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Crea una nueva transformación para rotar la imagen.
     *
     * @param nuevoAncho El nuevo ancho de la imagen después de la rotación.
     * @param nuevoAlto El nuevo alto de la imagen después de la rotación.
     * @param radianes Los radianes a los que se va a rotar la imagen.
     * @param ancho El ancho original de la imagen.
     * @param alto El alto original de la imagen.
     * @return Una nueva transformación AffineTransform.
     */
    public AffineTransform crearTransformacion(double nuevoAncho, double nuevoAlto, double radianes, int ancho, int alto) {
        AffineTransform transformacion = AffineTransform.getRotateInstance(radianes, nuevoAncho / 2, nuevoAlto / 2);
        transformacion.translate((nuevoAncho - ancho) / 2, (nuevoAlto - alto) / 2);
        return transformacion;
    }

//    public JPanel getPanel() {
//        return panel;
//    }
//
//    public void setPanel(JPanel fichas) {
//        this.panel = fichas;
//    }

}
