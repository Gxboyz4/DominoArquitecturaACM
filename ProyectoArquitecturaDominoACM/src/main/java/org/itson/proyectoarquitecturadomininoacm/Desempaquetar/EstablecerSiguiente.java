/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadomininoacm.Desempaquetar;

import org.itson.libreriatiposdominoacmp.PaqueteDatos;

/**
 *
 * @author julio
 */
public class EstablecerSiguiente implements IDesempaquetar {
    
    private IDesempaquetar siguiente;
    
    @Override
    public void manejarSolicitud(PaqueteDatos paqueteReciboDatos) {
        TipoPaquete_Partida tipoPaquete_Partida = new TipoPaquete_Partida();
        TipoPaquete_Jugador tipoPaquete_Jugador = new TipoPaquete_Jugador();
        TipoPaquete_AgregarFichaContrincante tipoPaquete_AgregarFichaContrincante = new TipoPaquete_AgregarFichaContrincante();
        TipoPaquete_AgregarFicha tipoPaquete_AgregarFicha = new TipoPaquete_AgregarFicha();
        TipoPaquete_AgregarFichaDerecha tipoPaquete_AgregarFichaDerecha = new TipoPaquete_AgregarFichaDerecha();
        TipoPaquete_AgregarFichaIzquierda tipoPaquete_AgregarFichaIzquierda = new TipoPaquete_AgregarFichaIzquierda();
        TipoPaquete_ConfigurarPartida tipoPaquete_ConfigurarPartida = new TipoPaquete_ConfigurarPartida();
        TipoPaquete_DevolverFicha tipoPaquete_DevolverFicha = new TipoPaquete_DevolverFicha();
        TipoPaquete_EliminarFichaContrincante tipoPaquete_EliminarFichaContrincante = new TipoPaquete_EliminarFichaContrincante();
        TipoPaquete_GenerarId tipoPaquete_GenerarId = new TipoPaquete_GenerarId();
        TipoPaquete_HayPartida tipoPaquete_HayPartida = new TipoPaquete_HayPartida();
        TipoPaquete_IniciarPartida tipoPaquete_IniciarPartida = new TipoPaquete_IniciarPartida();
        TipoPaquete_PartidaLlena tipoPaquete_PartidaLlena = new TipoPaquete_PartidaLlena();
        TipoPaquete_PartidaUnirse_Listo tipoPaquete_PartidaUnirse_Listo = new TipoPaquete_PartidaUnirse_Listo();
        TipoPaquete_PozoVacio tipoPaquete_PozoVacio = new TipoPaquete_PozoVacio();
        TipoPaquete_RecibirPuntos tipoPaquete_RecibirPuntos = new TipoPaquete_RecibirPuntos();
        TipoPaquete_RecuperarPartida tipoPaquete_RecuperarPartida = new TipoPaquete_RecuperarPartida();
        TipoPaquete_PasarTurno tipoPaquete_PasarTurno = new TipoPaquete_PasarTurno();
        TipoPaquete_SacarJugador tipoPaquete_SacarJugador = new TipoPaquete_SacarJugador();
        TipoPaquete_NoHayJugadoresPartida tipoPaquete_NoHayJugadoresPartida = new TipoPaquete_NoHayJugadoresPartida();
        
        tipoPaquete_Partida.establecerSiguiente(tipoPaquete_Jugador);
        tipoPaquete_Jugador.establecerSiguiente(tipoPaquete_AgregarFichaContrincante);
        tipoPaquete_AgregarFichaContrincante.establecerSiguiente(tipoPaquete_AgregarFicha);
        tipoPaquete_AgregarFicha.establecerSiguiente(tipoPaquete_AgregarFichaDerecha);
        tipoPaquete_AgregarFichaDerecha.establecerSiguiente(tipoPaquete_AgregarFichaIzquierda);
        tipoPaquete_AgregarFichaIzquierda.establecerSiguiente(tipoPaquete_ConfigurarPartida);
        tipoPaquete_ConfigurarPartida.establecerSiguiente(tipoPaquete_DevolverFicha);
        tipoPaquete_DevolverFicha.establecerSiguiente(tipoPaquete_EliminarFichaContrincante);
        tipoPaquete_EliminarFichaContrincante.establecerSiguiente(tipoPaquete_GenerarId);
        tipoPaquete_GenerarId.establecerSiguiente(tipoPaquete_HayPartida);
        tipoPaquete_HayPartida.establecerSiguiente(tipoPaquete_IniciarPartida);
        tipoPaquete_IniciarPartida.establecerSiguiente(tipoPaquete_PartidaLlena);
        tipoPaquete_PartidaLlena.establecerSiguiente(tipoPaquete_PartidaUnirse_Listo);
        tipoPaquete_PartidaUnirse_Listo.establecerSiguiente(tipoPaquete_PozoVacio);
        tipoPaquete_PozoVacio.establecerSiguiente(tipoPaquete_RecibirPuntos);
        tipoPaquete_RecibirPuntos.establecerSiguiente(tipoPaquete_RecuperarPartida);
        tipoPaquete_RecuperarPartida.establecerSiguiente(tipoPaquete_PasarTurno);
        tipoPaquete_PasarTurno.establecerSiguiente(tipoPaquete_SacarJugador);
        tipoPaquete_SacarJugador.establecerSiguiente(tipoPaquete_NoHayJugadoresPartida);
        
        this.siguiente = tipoPaquete_Partida;
        System.out.println(siguiente);
        siguiente.manejarSolicitud(paqueteReciboDatos);
    }
    
    @Override
    public void establecerSiguiente(IDesempaquetar siguiente) {
        this.siguiente = siguiente;
    }
    
}
