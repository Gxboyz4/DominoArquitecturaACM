/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Mediador.Mediador;
import org.itson.proyectoarquitecturadominoacm.Observadores.FichaObserver;
import org.itson.proyectoarquitecturadominoacm.Observadores.PozoObserver;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author julio
 */
public class Partida implements FichaObserver, PozoObserver, Serializable {

    Pozo pozo;
    Ficha ficha;
    List<Jugador> jugadores = new ArrayList();
    List<Contrincante> contrincantes = new ArrayList();
    Jugador jugadorLocal;
    Tablero tablero;
    int numFichas;
    int numJugadores;
    final int cantidadMax=7;

    public Partida(Jugador jugador, int numFichas) {
        this.jugadorLocal = mediador.getJugador();
        this.numFichas = numFichas;
    }

    public Partida(Jugador jugador) {
        this.jugadorLocal = jugador;
        this.jugadores.add(jugador);
    }
    
    public Partida() {
        this.jugadorLocal = mediador.getJugador();
    }

    public void suscribirse() {
        this.suscribirFichas();
        this.suscribirPozo();
    }

    public void suscribirFichas() {
        for (Ficha ficha : mediador.getJugador().getFichas()) {
            ficha.agregarObservador(this);
        }
        System.out.println("Entró a suscribirse fichas.");
        System.out.println("Fichas del jugador: " + jugadorLocal.getFichas());
    }

    public void suscribirPozo() {
        pozo.agregarObservador(this);
    }

    @Override
    public void fichaSeleccionada(Ficha ficha) {
        System.out.println("Entró a ficha seleccionada.");
        if (mediador.getJugador().getTurno() && tablero.agregarFicha(ficha, true)) {
            if (finalizacionTablero(tablero.getNumeroIzquierda()) && finalizacionTablero(tablero.getNumeroDerecha())) {
                mediador.enviarFinalizarPartida();
            }
            mediador.getJugador().setTurno(false);
            mediador.pasarTurno();
            mediador.getJugador().eliminarFicha(ficha);
            if (finalizacionJugador()) {
                mediador.enviarFinalizarPartida();
            }
        }

    }

    public boolean finalizacionJugador() {
        if (jugadorActivoNoTieneFichas()) {
            return true;
        }
        return false;
    }
    public boolean jugadorActivoNoTieneFichas(){
        return mediador.getJugador().getFichas().size() == 0;
    }

    public boolean finalizacionTablero(int numeroBuscado) {
        int cantidad = 0;
        for (Ficha ficha1 : tablero.getFichas()) {
            if (numeroBuscado == ficha1.getNumeroInferior() || numeroBuscado == ficha1.getNumeroSuperior()) {
                cantidad++;
            }

        }
        if (cantidad == cantidadMax) {
            return true;
        }
        return false;
    }

    @Override
    public void fichaElegida() {
//        jugadorLocal.agregarFicha(ficha);
        System.out.println("Obtener Ficha del pozo del servidor cuando le das click al pozo");
        mediador.obtenerFichaPozo();
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
        return jugadorLocal;
    }

    public void setJugadorCreador(Jugador jugador) {
        this.jugadorLocal = jugador;
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

    public List<Contrincante> getContrincantes() {
        return contrincantes;
    }

    public void setContrincantes(List<Contrincante> contrincantes) {
        this.contrincantes = contrincantes;
    }
    
    public Jugador sacarJugadorPorId(int id){
        for (Jugador jugador : jugadores) {
            if(jugador.getId() == id){
                this.jugadores.remove(jugador);
                return jugador;
            }
        }
        return null;
    }
    
    public Contrincante sacarContrincantePorId(int id){
        for (Contrincante contrincante : this.contrincantes) {
            if(contrincante.getIdContrincante() == id){
                this.contrincantes.remove(contrincante);
                return contrincante;
            }
        }
        return null;
    }
//    public void repartirFichas() {
//        for (Jugador jugador : jugadores) {
//            List<Ficha> fichas = this.pozo.repartirFichas(numFichas);
//            System.out.println(fichas.size());
//            jugador.setFichas(fichas);
//        }
//    }
}
