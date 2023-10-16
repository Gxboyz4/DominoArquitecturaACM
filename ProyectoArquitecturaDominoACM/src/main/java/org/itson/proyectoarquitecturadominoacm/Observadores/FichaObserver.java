/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Observadores;

import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.excepciones.PartidaTerminadaException;

/**
 *
 * @author julio
 */
public interface FichaObserver {  
    public void fichaSeleccionada(Ficha ficha);
}
