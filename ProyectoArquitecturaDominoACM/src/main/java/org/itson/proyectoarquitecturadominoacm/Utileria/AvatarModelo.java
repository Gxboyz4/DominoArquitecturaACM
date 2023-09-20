/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Utileria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author julio
 */
public class AvatarModelo {
    private List<ImageIcon> avatares;
    private ImageIcon avatarEstado;
    
    
    public AvatarModelo() {
        avatarEstado= new ImageIcon();
        avatares = new ArrayList();
        for (int i = 0; i < 22; i++) {
            String rutaImagen = "/imgAvatar/avatar_" + i + ".png";  // La barra diagonal (/) es importante
            ImageIcon avatar = new javax.swing.ImageIcon(getClass().getResource(rutaImagen));
            avatares.add(avatar);

        }
    }
    
    public void generarAvatar() {
        int numero = (int) (Math.random() * 22 + 0);
        avatarEstado =  avatares.get(numero);
    }

    public ImageIcon getAvatarEstado() {
        return avatarEstado;
    }
    
    
}
