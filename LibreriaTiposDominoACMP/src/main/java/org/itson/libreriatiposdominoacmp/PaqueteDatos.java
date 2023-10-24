/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.libreriatiposdominoacmp;

import java.io.Serializable;

/**
 *
 * @author Gabriel Mancinas
 */
public class PaqueteDatos implements Serializable{
   TipoPaquete tipo;
   Object objeto;

    public PaqueteDatos(TipoPaquete tipo, Object objeto) {
        this.tipo = tipo;
        this.objeto = objeto;
    }
     public TipoPaquete getTipo() {
        return tipo;
    }

    public void setTipo(TipoPaquete tipo) {
        this.tipo = tipo;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objecto) {
        this.objeto = objecto;
    }
    
}
