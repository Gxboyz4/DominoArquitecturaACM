/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import org.itson.proyectoarquitecturadominoacm.Proxy.ProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;
import org.itson.proyectoarquitecturadominoacm.excepciones.PartidaTerminadaException;

/**
 *
 * @author julio
 */
public class Partida implements FichaObserver, PozoObserver, Serializable {

    Pozo pozo;
    Ficha ficha;
    List<Jugador> jugadores = new ArrayList();
    Jugador jugadorCreador;
    Tablero tablero;
    int numFichas;
    int numJugadores;

    public Partida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Partida(Jugador jugador, int numFichas) {
        this.jugadorCreador = jugador;
        this.numFichas = numFichas;
    }

    public Partida(Jugador jugador) {
        this.jugadorCreador = jugador;
        this.jugadores.add(jugador);
    }

    public Partida(Pozo pozo) {
        this.pozo = pozo;
    }

    public Partida(Pozo pozo, Jugador jugador, Tablero tablero) {
        this.pozo = pozo;
        this.jugadorCreador = jugador;
        this.tablero = tablero;
        this.suscribirFichas();
        this.suscribirPozo();
    }

    public Partida() {

    }

    public void suscribirse() {
        this.suscribirFichas();
        this.suscribirPozo();
    }

    public void suscribirFichas() {
        for (Ficha ficha : pozo.obtenerTodasFichas()) {
            ficha.agregarObservador(this);
        }
    }

    public void suscribirPozo() {
        pozo.agregarObservador(this);
    }

    @Override
    public void fichaSeleccionada(Ficha ficha) {
        if (tablero.agregarFicha(ficha)) {
            if (finalizacionTablero(tablero.getNumeroIzquierda()) && finalizacionTablero(tablero.getNumeroDerecha())) {
                JOptionPane.showMessageDialog(null, "Se ha bloqueado el tablero (este mensaje es momentaneo no se vaya a creer que quede asi profe)", "Tablero UnU", JOptionPane.INFORMATION_MESSAGE);

            }
            jugadorCreador.eliminarFicha(ficha);
            if (finalizacionJugador()) {
                JOptionPane.showMessageDialog(null, "Gano el jugador(este mensaje es momentaneo no se vaya a creer que quede asi profe)", "Jugador Gano OwO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public boolean finalizacionJugador() {
        if (jugadorCreador.getFichas().size() == 0) {
            return true;
        }
        return false;
    }

    public boolean finalizacionTablero(int numeroBuscado) {
        int cantidad = 0;

        for (Ficha ficha1 : tablero.getFichas()) {
            if (numeroBuscado == ficha1.getNumeroInferior() || numeroBuscado == ficha1.getNumeroSuperior()) {
                cantidad++;
            }

        }
        if (cantidad == 7) {
            return true;
        }
        return false;
    }

    @Override
    public void fichaElegida(Ficha ficha) {
        //System.out.println("La ficha elegida por el pozo fue: "+ficha.getNumeroInferior() +" "+ " "+ficha.getNumeroSuperior());  
        jugadorCreador.agregarFicha(ficha);
        //  System.out.println(jugadorCreador.getFichas());
        pozo.eliminarFicha(ficha);
    }

    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Jugador getJugadorCreador() {
        return jugadorCreador;
    }

    public void setJugadorCreador(Jugador jugador) {
        this.jugadorCreador = jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void repartirFichas(){
    List<Ficha> fichas = pozo.repartirFichas(numFichas);
        for (Ficha fichaNueva : fichas) {
            jugadorCreador.agregarFicha(fichaNueva);
        }
    }
}
