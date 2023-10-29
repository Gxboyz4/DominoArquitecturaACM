/**
 * ContrincanteVista.java
 * Oct 28, 2023 8:20:00 PM
 */
package org.itson.proyectoarquitecturadominoacm.contrincante;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ContrincanteVista {

    private ContrincanteModelo modelo;
    private JPanel panelFichas;

    /**
     *
     * @param panelFichas
     */
    public ContrincanteVista(JPanel panelFichas) {
        this.panelFichas = panelFichas;
    }

    private void cargarPanelFichas() {
        this.panelFichas.removeAll();
        this.panelFichas.repaint();
    }

    private JLabel construirFichaLimpia(int alto, int ancho) {
        JLabel fichaLimpia = new JLabel();
        String rutaImagen = "/imgFrmPartidaFichas/ficha%0_%0.png";
        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
        Icon icon = null;

        if (this.modelo.getPosicionPanel() == PosicionPanel.SUPERIOR_INFERIOR) {
            icon = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        }

        if (this.modelo.getPosicionPanel() == PosicionPanel.LATERAL) {
            icon = this.rotarImagen(imagen, 90);
        }

        fichaLimpia.setIcon(icon);

        return fichaLimpia;
    }

    private ImageIcon rotarImagen(ImageIcon icon, double grados) {
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

    public void pintarFichas() {
        this.cargarPanelFichas();
        int x = 0;
        int y = 0;
        int ancho = 37;
        int alto = 37;
        JLabel fichaPintar = null;
        for (int i = 0; i < modelo.getFichasRestantes(); i++) {

            if (modelo.getPosicionPanel() == PosicionPanel.LATERAL) {

                if (y + 20 > panelFichas.getWidth()) {
                    x += 42;
                    y = 0;
                }
                
                fichaPintar = this.construirFichaLimpia(alto, ancho);
                fichaPintar.setBounds(y, x, ancho, alto);
            }

            if (modelo.getPosicionPanel() == PosicionPanel.SUPERIOR_INFERIOR) {
                
                if (x + 20 > panelFichas.getWidth()) {
                    y += 42;
                    x = 0;
                }
                fichaPintar = this.construirFichaLimpia(alto, ancho);
                fichaPintar.setBounds(x, y, ancho, alto);
            }

            y += 42;
        }
        this.panelFichas.add(fichaPintar);
    }

    public ContrincanteModelo getModelo() {
        return modelo;
    }

    public void setModelo(ContrincanteModelo modelo) {
        this.modelo = modelo;
    }

    public JPanel getPanelFichas() {
        return panelFichas;
    }

    public void setPanelFichas(JPanel panelFichas) {
        this.panelFichas = panelFichas;
    }
}
