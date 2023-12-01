/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Mediador.Mediador;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author julio
 */
public class TipoPaquete_Partida implements IDesempaquetar{
     private IDesempaquetar siguiente;
    
    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
      if (paqueteReciboDatos.getTipo() == (TipoPaquete.PARTIDA)) {
            PartidaDTO partida = (PartidaDTO) paqueteReciboDatos.getObjeto();
            PartidaDTO partidaDTO = partida;
            if (partida == null) {
                if (mediador.getFrmUnirse() != null) {
                    mediador.recargarTablaFrmUnirse();
                }
            } else {
                if (mediador.getFrmLobby() != null) {
                    mediador.modificarPartidaLocal(partida);
                    mediador.getFrmLobby().cambirInformacionLider();
                    mediador.getPartida().setNumFichas(partida.getNumFichas());
                    mediador.getFrmLobby().mostrarInformacion();
                } else {
                    if (mediador.getFrmUnirse() != null && partida.getPartidaIniciada()) {
                        mediador.getFrmUnirse().vaciarListaPartidas();
                        mediador.getFrmUnirse().cargarTabla();
                    }
                }
            }
        }else{
          this.siguiente.manejarSolicitud(paqueteReciboDatos);
        }
    }

    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }
}
