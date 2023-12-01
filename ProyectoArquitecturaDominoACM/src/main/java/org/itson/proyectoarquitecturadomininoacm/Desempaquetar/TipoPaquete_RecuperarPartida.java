/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author julio
 */
public class TipoPaquete_RecuperarPartida implements IDesempaquetar{
    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.RECUPERAR_PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            PartidaDTO partidaDTO = partida;
            if (partida != null && !partida.getPartidaIniciada()) {

                if (mediador.getFrmUnirse() != null) {
                    mediador.modificarPartidaLocal(partida);
                    mediador.getFrmUnirse().cargarListaPartidas();
                }
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
