/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.Iterator;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;

/**
 *
 * @author Zaurus
 */
public class LogicaServidor {
    public static boolean comprobarVotacion(PartidaDTO partida)
    {
        int listos = 0;
        for (JugadorDTO jugador : partida.getJugadores()) {
            if(jugador.getListo())
            {
                listos++;
            }
        }
        if(listos == partida.getJugadores().size() && partida.getJugadores().size() >=2)
        {
            return true;
        }
        
        return false;
    }
}
