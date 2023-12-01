/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.TipoPaquete;

/**
 *
 * @author julio
 */
public class TipoPaquete_Jugador implements IDesempaquetar {

    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.JUGADOR)) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            JugadorDTO jugadorDTO = jugador;
        } else {
            this.siguiente.manejarSolicitud(paqueteReciboDatos);
        }
    }

    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }

}
