/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import java.util.List;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author julio
 */
public class TipoPaquete_IniciarPartida implements IDesempaquetar {

    private IDesempaquetar siguiente;

    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        if (paqueteReciboDatos.getTipo() == (TipoPaquete.INICIAR_PARTIDA)) {
            if (mediador.getFrmLobby() != null) {
                mediador.getFrmLobby().abrirPantallaPartida();
                PartidaDTO partidaDTO = (PartidaDTO) paqueteReciboDatos.getObjeto();
                List<JugadorDTO> jugadores = partidaDTO.getJugadores();
                for (JugadorDTO jugador : jugadores) {
                    if (mediador.getJugador().getId() == jugador.getId()) {
                        List<FichaDTO> fichas = jugador.getFichas();
                        for (FichaDTO ficha : fichas) {
                            Ficha fichaAgregar = mediador.crearFichaDireccion(ficha);
                            mediador.getJugador().agregarFicha(fichaAgregar);
                        }
                        mediador.getPartida().suscribirFichas();
                        break;
                    }
                }
                
                mediador.listaJugadorDTOJugador(jugadores);
                mediador.modificarTurno(jugadores);
                int numFichas = partidaDTO.getJugadores().get(0).getFichas().size();
                for (Contrincante contrincante : mediador.getPartida().getContrincantes()) {
                    contrincante.agregarFichasRestantes(numFichas);
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
