/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Proxy;

import java.util.Map;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Conexiones.Conexion;

/**
 *
 * @author Gabriel Mancinas
 */
public class ProxyCliente implements IProxyCliente{
    private Conexion conexionCliente = new Conexion();
    @Override
    public void empaquetarParametros(TipoPaquete tipo,Object objeto) {
        conexionCliente.empaquetarParametros(tipo,objeto);
    }

    @Override
    public void iniciarSocket() {
        conexionCliente.iniciarSocket();
    }

    @Override
    public void cerrarSocket(JugadorDTO jugador) {
        conexionCliente.cerrarSocket(jugador);
    }
    @Override
    public void cerrarSocket(){
        conexionCliente.cerrarSocket();
    }
    
    @Override
    public void recibirDatos() {
        conexionCliente.recibirDatos();
    }
        @Override
    public void enviarDatos() {
        conexionCliente.enviarDatos();
    }
    @Override
    public void desempaquetarDatos() {
        conexionCliente.desempaquetarDatos();
    }
    
    @Override
    public void iniciarHilo(){
        conexionCliente.iniciarHilo();
    }

    @Override
    public JugadorDTO getJugadorDTO() {
       return conexionCliente.getJugadorDTO();
    }

    @Override
    public PartidaDTO getPartidaDTO() {
     return conexionCliente.getPartidaDTO();
    }
    
}

