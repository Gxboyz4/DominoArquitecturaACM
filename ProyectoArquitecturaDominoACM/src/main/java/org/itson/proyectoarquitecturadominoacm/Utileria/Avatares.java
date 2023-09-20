
package org.itson.proyectoarquitecturadominoacm.Utileria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel Mancinas
 */
public class Avatares {

    List<ImageIcon> avatares;

    public Avatares() {
        avatares = new ArrayList();
        for (int i = 0; i < 22; i++) {
            String rutaImagen = "/imgAvatar/avatar_" + i + ".png";  // La barra diagonal (/) es importante
            ImageIcon avatar = new javax.swing.ImageIcon(getClass().getResource(rutaImagen));
            avatares.add(avatar);

        }
    }

    public ImageIcon generarAvatar() {
        int numero = (int) (Math.random() * 22 + 0);
        return avatares.get(numero);
    }
    public void actualizarAvatar(javax.swing.JLabel label){
        label.setIcon(generarAvatar());
    }
    
}
