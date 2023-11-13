/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.Collections;
import java.util.Iterator;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;

/**
 *
 * @author Zaurus
 */
public class LogicaServidor {
    int ultimoID = 0;
    public static boolean comprobarVotacion(PartidaDTO partida) {
        int listos = 0;
        for (JugadorDTO jugador : partida.getJugadores()) {
            if (jugador.getListo()) {
                listos++;
            }
        }
        if (listos == partida.getJugadores().size() && partida.getJugadores().size() >= 2) {
            return true;
        }
        return false;
    }

    //Limpiar codigo 
    public void repartirFichasJugadores(InformacionServidor infoServer) {
        for (int i = 0; infoServer.getCantidadJugadores() > i; i++) {
            infoServer.getJugadorPartida(i).anadirFichas(infoServer.getPozoServidor().repartirFichas(infoServer.getNumeroFichasPartida()));
        }
    }
    public void repartirTurnos(InformacionServidor infoServer)
    {
        Collections.shuffle(infoServer.getPartidaEnServidor().getJugadores());
        infoServer.getPartidaEnServidor().getJugadores().get(0).setTurno(true);
    }
    public void pasarTurno(InformacionServidor infoServer)
    {
        for (int i = 0; i<infoServer.getPartidaEnServidor().getJugadores().size(); i++) {
            if(infoServer.getPartidaEnServidor().getJugadores().get(i).getTurno()== true)
            {
                infoServer.getPartidaEnServidor().getJugadores().get(i).setTurno(false);
                if(i == infoServer.getPartidaEnServidor().getJugadores().size()-1)
                {
                    infoServer.getPartidaEnServidor().getJugadores().get(0).setTurno(true);
                    break;
                }
                infoServer.getPartidaEnServidor().getJugadores().get(i+1).setTurno(true);
                break;
            }
        }
        
    }
    public int generarIdJugador() {
        this.ultimoID = this.ultimoID + 1;        
        return ultimoID;
    }

    public FichaDTO devolverFicha(InformacionServidor infoServer) {
        FichaDTO ficha = infoServer.getPozoServidor().devolverFicha();
        infoServer.getPozoServidor().eliminarFicha(ficha);
        return ficha;
    }

    public Boolean pozoEstaVacio(InformacionServidor infoServer) {
        return infoServer.getPozoServidor().verificarNumFichas();
    }
}
