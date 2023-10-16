/**
 * ProyectoArquitecturaDominoACM.java creado el 19/09/2023.
 */

package org.itson.proyectoarquitecturadominoacm;

import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Mediador.IMediador;
import org.itson.proyectoarquitecturadominoacm.Mediador.Mediador;
import org.itson.proyectoarquitecturadominoacm.UI.FrmLobby;
import org.itson.proyectoarquitecturadominoacm.UI.FrmMenu;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPartida;
import org.itson.proyectoarquitecturadominoacm.UI.FrmPrincipal;

/**
 *
 * @author Gabriel Mancinas
 */
public class ProyectoArquitecturaDominoACM {
    public static IMediador mediador;

    public static void main(String[] args) {
      mediador = new Mediador();
      mediador.registrarJugador(new Jugador());
      mediador.iniciarPrograma();
     // FrmPrincipal frmPrincipal= new FrmPrincipal();
    }
}
