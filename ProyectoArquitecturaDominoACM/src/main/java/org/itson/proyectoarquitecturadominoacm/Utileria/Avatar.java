package org.itson.proyectoarquitecturadominoacm.Utileria;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Gabriel Mancinas
 */
public class Avatar {

    private JButton btnCambiarAvatar;
    
    AvatarModelo modelo;
    AvatarVista vista;
    AvatarControlador controlador;

    public Avatar(JButton btnCambiarAvatar) {
        this.btnCambiarAvatar = btnCambiarAvatar;
      
        this.actualizar();
    }

    public void actualizar() {
        modelo = new AvatarModelo();
        vista = new AvatarVista(modelo);
        controlador = new AvatarControlador(modelo, vista);
        vista.setOpaque(false);
        //this.jPanel1.add(vista, new AbsoluteConstraints(480, 50, 240, 230), 0);
        this.btnCambiarAvatar.addActionListener(controlador);
        
    }
    
    public ImageIcon getAvatar(){
        return this.modelo.getAvatarEstado();
    }

    public AvatarVista getVista() {
        return vista;
    }
    

}
