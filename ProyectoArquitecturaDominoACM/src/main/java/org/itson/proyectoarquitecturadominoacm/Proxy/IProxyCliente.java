/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Proxy;

import java.util.Map;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;


/**
 *
 * @author Gabriel Mancinas
 */
public interface IProxyCliente {
    public void empaquetarParametros(TipoPaquete tipo,Object objeto);

    public void iniciarSocket();
    
    public void cerrarSocket();
   
    public void eliminarJugador(JugadorDTO jugador);

    public void recibirDatos();
    
    public void enviarDatos();

    public void desempaquetarDatos();
    
    public void iniciarHilo();
    
    public JugadorDTO getJugadorDTO();
    
    public PartidaDTO getPartidaDTO();
}
