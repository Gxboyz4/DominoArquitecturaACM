/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Utileria;


import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julio
 */
public class AvatarVista extends JPanel {
    private JLabel labelAvatar;
    private AvatarModelo modelo;
    public AvatarVista(AvatarModelo modelo) {
        this.modelo= modelo;
        labelAvatar = new JLabel();
        this.add(labelAvatar);
    }
    
    public void actualizarAvatar(){
        labelAvatar.setIcon(modelo.getAvatarEstado());  
    }

    public JLabel getLabelAvatar() {
        return labelAvatar;
    }

    
}
