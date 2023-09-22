/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Usuario;


import org.itson.proyectoarquitecturadominoacm.Utileria.Avatar;

/**
 *
 * @author Zaurus
 */
public class Usuario {
    private String apodo;
    private Avatar avatar;

    public Usuario(String apodo, Avatar avatar) {
        this.apodo = apodo;
        this.avatar = avatar;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    
    
}
