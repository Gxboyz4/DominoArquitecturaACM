/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author julio
 */
public class TipoPaquete_EliminarFichaContrincante implements IDesempaquetar {

    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == TipoPaquete.ELIMINAR_FICHA_CONTRINCANTE) {
            JugadorDTO jugador = (JugadorDTO) paqueteReciboDatos.getObjeto();
            Contrincante contrincante = mediador.obtenerContrincante(jugador);
            if (contrincante != null) {
                contrincante.quitarFicha();
            }
        }else {
            this.siguiente.manejarSolicitud(paqueteReciboDatos);

        }
    }

    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }

}
