/**
 * Clase Conexión.java
 */
package org.itson.proyectoarquitecturadominoacm.Conexiones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.FichaDTO;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.PaqueteDatos;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadomininoacm.Desempaquetar.EstablecerSiguiente;
import org.itson.proyectoarquitecturadomininoacm.Desempaquetar.IDesempaquetar;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaControlador;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Proxy.IProxyCliente;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;

/**
 *
 * @author Gabriel Mancinas 233410, Julio Chon 233242, Luis Ayon 233145 y Daniel Peña 229185.
 */
public class Conexion implements IProxyCliente, Runnable {
    /**
     * Paquete que contiene los datos a enviar.
     */
    PaqueteDatos paqueteEnvioDatos;
    /**
     * Paquete que contiene los datos recibidos.
     */
    PaqueteDatos paqueteReciboDatos;
    /**
     * Dirección del puerto.
     */
    int puerto = 9091;
    /**
     * Socket del cliente.
     */
    Socket clienteSocket;
    /**
     * Dirección ip.
     */
    final String ip = "localhost";
    /**
     * Variable para desempaquetar los datos (cadena de responsabilidad)
     */
    IDesempaquetar desempaquetar = new EstablecerSiguiente();
    /**
     * Constructor por defecto.
     */
    public Conexion() {
    }
    /**
     * Método para empaquetar parámetros a enviar.
     * @param tipo tipo del paquete.
     * @param objeto objeto a enviar.
     */
    @Override
    public void empaquetarParametros(TipoPaquete tipo, Object objeto) {
        if (objeto != null) {
            paqueteEnvioDatos = new PaqueteDatos(tipo, objeto);
        } else {
            paqueteEnvioDatos = new PaqueteDatos(tipo);
        }
    }
    /**
     * Método para iniciar el socket del cliente.
     */
    @Override
    public void iniciarSocket() {
        try {
            clienteSocket = new Socket(ip, puerto);
            clienteSocket.connect(new InetSocketAddress(ip, puerto));
        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método para enviar datos mediante un ObjectOutputStream, los datos a enviar se encuentran dentro del paqueteEnvioDatos.
     */
    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(clienteSocket.getOutputStream());
            System.out.println("El paquete que va a enviar es: " + paqueteEnvioDatos.getTipo());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método para cerrar el socket del cliente.
     */
    @Override
    public void cerrarSocket() {
        try {
            clienteSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void eliminarJugador(JugadorDTO jugador) {
        empaquetarParametros(TipoPaquete.ELIMINAR_JUGADOR, jugador);
        enviarDatos();
    }
    /**
     * Método para recibir datos, una vez recibidos y guardados en la variable paqueteReciboDatos, se llama al método desempaquetarDatos().
     */
    @Override
    public synchronized void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(clienteSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método para desempaquetar datos mediante un manejo de solicitud con la cadena de responsabilidades.
     */
    @Override
    public synchronized void desempaquetarDatos() {
       System.out.println("El tipo de paquete es: " + paqueteReciboDatos.getTipo());
        desempaquetar.manejarSolicitud(paqueteReciboDatos);
    }
    /**
     * Método para iniciar el hilo de la conexión.
     */
    @Override
    public void iniciarHilo() {
        Thread hiloConexion = new Thread(this);
        hiloConexion.start();
    }
    /**
     * Método run que ejecuta constantemente el método recibirDatos().
     */
    @Override
    public void run() {
        recibirDatos();
    }
}
