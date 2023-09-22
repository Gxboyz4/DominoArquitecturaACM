package org.itson.proyectoarquitecturadominoacm.Utileria;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel Mancinas
 */
public class Avatar {

    private javax.swing.JButton btnCambiarAvatar;
    private javax.swing.JPanel jPanel1;
    AvatarModelo modelo;
    AvatarVista vista;
    AvatarControlador contralador;

    public Avatar(JButton btnCambiarAvatar, JPanel jPanel1) {
        this.btnCambiarAvatar = btnCambiarAvatar;
        this.jPanel1 = jPanel1;
        this.actualizar();
    }

    public void actualizar() {
        modelo = new AvatarModelo();

        vista = new AvatarVista(modelo);
        contralador = new AvatarControlador(modelo, vista);
        vista.setOpaque(false);

        this.jPanel1.add(vista, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 240, 230), 0);
        this.btnCambiarAvatar.addActionListener(contralador);
    }
    
    public ImageIcon getAvatar(){
        return this.modelo.getAvatarEstado();
    }

}
