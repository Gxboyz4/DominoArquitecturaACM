/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.logicaAplicacion;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.itson.proyectoarquitecturadominoacm.Usuario.Usuario;

/**
 *
 * @author Zaurus
 */
public class logicaAplicacion {
    private Usuario usuario;

    public logicaAplicacion(Usuario usuario) {
        this.usuario = usuario;
    }

    public void dibujarUsuario(JLabel lblApodo,JLabel lblAvatar) {
        lblApodo.setText(usuario.getApodo());
        Icon icon = new ImageIcon(usuario.getAvatar().getAvatar().getImage().getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_DEFAULT));
        lblAvatar.setIcon(icon);
    }
    
}
