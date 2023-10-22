/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.Map;
import org.itson.proyectoarquitecturadominoacm.DTOs.TipoPaquete;

/**
 *
 * @author Gabriel Mancinas
 */
public interface IProxyServidor {
    public void empaquetarParametros(TipoPaquete tipo,Object objeto);

    public void iniciarSocket();

    public void cerrarSocket();

    public void recibirDatos();
    
    public void enviarDatos();

    public void desempaquetarDatos();
    
    public void iniciarHilo();
}
