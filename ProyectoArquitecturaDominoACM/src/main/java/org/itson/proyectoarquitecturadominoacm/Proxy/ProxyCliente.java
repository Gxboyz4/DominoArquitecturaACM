/**
 * Clase ProxyCliente.java
 */
package org.itson.proyectoarquitecturadominoacm.Proxy;

import java.util.Map;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Conexiones.Conexion;

/**
 *
 * @author Gabriel Mancinas 233410, Julio Chon 233242, Luis Ayon 233145 y Daniel Peña 229185.
 */
public class ProxyCliente implements IProxyCliente{
    /**
     * Atributo que representa la conexión del cliente.
     */
    private Conexion conexionCliente = new Conexion();
    /**
     * Método para empaquetar parámetros a enviar, que llama al método empaquetarParametros() de la conexión.
     * @param tipo tipo del paquete.
     * @param objeto objeto a enviar.
     */
    @Override
    public void empaquetarParametros(TipoPaquete tipo,Object objeto) {
        conexionCliente.empaquetarParametros(tipo,objeto);
    }
    /**
     * Método para iniciar el socket del cliente, que llama al método iniciarSocket() de la conexión.
     */
    @Override
    public void iniciarSocket() {
        conexionCliente.iniciarSocket();
    }

    @Override
    public void eliminarJugador(JugadorDTO jugador) {
        conexionCliente.eliminarJugador(jugador);
    }
    /**
     * Método para cerrar el socket del cliente que llama al método cerrarSocket() de la conexión.
     */
    @Override
    public void cerrarSocket(){
        conexionCliente.cerrarSocket();
    }
    /**
     * Método para recibir datos, que llama al método recibirDatos() de la conexión.
     */
    @Override
    public void recibirDatos() {
        conexionCliente.recibirDatos();
    }
    /**
     * Método para enviar datos mediante un ObjectOutputStream, los datos a enviar se encuentran dentro del paqueteEnvioDatos, que llama al método enviarDatos() de la conexión.
     */
        @Override
    public void enviarDatos() {
        conexionCliente.enviarDatos();
    }
    /**
     * Método para desempaquetar datos mediante un manejo de solicitud con la cadena de responsabilidades, que llama al método desempaquetarDatos() de la conexión .
     */
    @Override
    public void desempaquetarDatos() {
        conexionCliente.desempaquetarDatos();
    }
    /**
     * Método para iniciar el hilo de la conexión, que llama al método iniciarHilo() de la conexión.
     */
    @Override
    public void iniciarHilo(){
        conexionCliente.iniciarHilo();
    }
    
}

