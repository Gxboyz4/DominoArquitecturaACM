/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;


import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author julio
 */
public class TipoPaquete_SacarJugador implements IDesempaquetar{
    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == TipoPaquete.SACAR_JUGADOR) {
            System.out.println("SACAR JUGADOR-CLIENTE");
            JugadorDTO jugador
                    = (JugadorDTO) paqueteReciboDatos.getObjeto();
            int idLocal = mediador.getJugador().getId();
            if (idLocal != jugador.getId()) {
                mediador.sacarJugadorPartidaPorId(jugador.getId());
                mediador.recargarPantallaPartida();
            }
        } else {
            this.siguiente.manejarSolicitud(paqueteReciboDatos);

        }
    }

    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }
}
