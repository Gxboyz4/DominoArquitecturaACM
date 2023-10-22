/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.DTOs;

import java.io.Serializable;

/**
 *
 * @author Gabriel Mancinas
 */
public class PaqueteDatos <E> implements Serializable{
   TipoPaquete tipo;
    Object objecto;

    public PaqueteDatos(TipoPaquete tipo, Object objecto) {
        this.tipo = tipo;
        this.objecto = objecto;
    }
     public TipoPaquete getTipo() {
        return tipo;
    }

    public void setTipo(TipoPaquete tipo) {
        this.tipo = tipo;
    }

    public Object getObjecto() {
        return objecto;
    }

    public void setObjecto(Object objecto) {
        this.objecto = objecto;
    }
    
}
