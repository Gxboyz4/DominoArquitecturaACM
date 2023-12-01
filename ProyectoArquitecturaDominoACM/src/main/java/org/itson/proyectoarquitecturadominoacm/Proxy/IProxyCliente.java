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
 * @author Gabriel Mancinas 233410, Julio Chon 233242, Luis Ayon 233145 y Daniel Peña 229185.
 */
public interface IProxyCliente {
    /**
     * Método para empaquetarParametros.
     * @param tipo tipo del paquete.
     * @param objeto objeto a empaquetar.
     */
    public void empaquetarParametros(TipoPaquete tipo,Object objeto);
    /**
     * Método para iniciar el socket del cliente.
     */
    public void iniciarSocket();
    /**
     * Método para cerrar el socket del cliente.
     */
    public void cerrarSocket();
   
    public void eliminarJugador(JugadorDTO jugador);
    /**
     * Método para recibir datos, una vez recibidos y guardados en la variable paqueteReciboDatos, se llama al método desempaquetarDatos().
     */
    public void recibirDatos();
    /**
     * Método para enviar datos mediante un ObjectOutputStream, los datos a enviar se encuentran dentro del paqueteEnvioDatos.
     */
    public void enviarDatos();
    /**
     * Método para desempaquetar datos mediante un manejo de solicitud con la cadena de responsabilidades.
     */
    public void desempaquetarDatos();
    /**
     * Método para iniciar el hilo de la conexión.
     */
    public void iniciarHilo();
}
