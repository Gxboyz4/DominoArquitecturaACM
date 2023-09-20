/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Utileria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author julio
 */
public class AvatarControlador implements ActionListener {

    private AvatarModelo modelo;
    private AvatarVista vista;

    public AvatarControlador(AvatarModelo modelo, AvatarVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      modelo.generarAvatar();
      vista.actualizarAvatar();
    }
    
}
