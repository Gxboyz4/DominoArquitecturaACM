/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.PaqueteDatos;

/**
 *
 * @author julio
 */
public interface IDesempaquetar {
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos);

    public void establecerSiguiente(IDesempaquetar siguiente);
}
