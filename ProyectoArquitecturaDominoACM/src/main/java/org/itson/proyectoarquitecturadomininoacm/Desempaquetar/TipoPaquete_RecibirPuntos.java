/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import java.util.ArrayList;
import java.util.List;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author julio
 */
public class TipoPaquete_RecibirPuntos implements IDesempaquetar{

    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == TipoPaquete.RECIBIR_PUNTOS) {
            List<JugadorDTO> podio = 
                    (ArrayList<JugadorDTO>) paqueteReciboDatos.getObjeto();
            mediador.getFrmPodio().setPodio(podio);
            mediador.abrirPantallaPodio();
            mediador.cerrarPantallaPartida();
        } else {
            this.siguiente.manejarSolicitud(paqueteReciboDatos);
        }
    }

    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }
}
