/**
 * FrmMenu.java creado el 19/09/2023.
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
/**
 *
 * @author Gabriel Mancinas,Julio Chon,Luis Ayon
 */
public class FrmMenu extends javax.swing.JFrame {
    
    private String nombreJugador;
    private int idJugador;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmMenu() {
        initComponents();
        this.setVisible(true);
        this.setSize(750, 540); //736 x 500
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
    }
    public void mostrarMensaje(){
        JOptionPane.showMessageDialog(this,"Ya hay una partida creada.", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
//    public void asignarTitulo(){
//        this.nombreJugador = mediador.getJugador().getNombre();
//        this.idJugador = mediador.getJugador().getId();
//        this.setTitle("Dominó " + this.nombreJugador +", "+this.idJugador);
//    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnFondo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnUnirse = new javax.swing.JButton();
        btnCrearPartida = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominó " + this.nombreJugador);
        setMaximumSize(new java.awt.Dimension(733, 500));
        setMinimumSize(new java.awt.Dimension(733, 500));
        setPreferredSize(new java.awt.Dimension(733, 510));
        setResizable(false);

        jpnFondo.setMaximumSize(new java.awt.Dimension(733, 500));
        jpnFondo.setMinimumSize(new java.awt.Dimension(733, 500));
        jpnFondo.setPreferredSize(new java.awt.Dimension(733, 500));
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgIconosGenerales/iconoRegresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgIconosGenerales/iconoRegresar_2.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jpnFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 100, 80));

        btnUnirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmMenu/iconoUnirse.png"))); // NOI18N
        btnUnirse.setBorderPainted(false);
        btnUnirse.setContentAreaFilled(false);
        btnUnirse.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmMenu/iconoUnirse_2.png"))); // NOI18N
        btnUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirseActionPerformed(evt);
            }
        });
        jpnFondo.add(btnUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 360, 130));

        btnCrearPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmMenu/iconoCrearPartida.png"))); // NOI18N
        btnCrearPartida.setBorderPainted(false);
        btnCrearPartida.setContentAreaFilled(false);
        btnCrearPartida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmMenu/iconoCrearPartida_2.png"))); // NOI18N
        btnCrearPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidaActionPerformed(evt);
            }
        });
        jpnFondo.add(btnCrearPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 360, 130));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgIconosGenerales/fondoFrmMenu.png"))); // NOI18N
        jpnFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    this.setVisible(false);
    mediador.abrirPantallaPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCrearPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidaActionPerformed
    this.setVisible(false);
    mediador.crearPartida(mediador.getJugador());
    mediador.abrirPantallaLobby();
    mediador.exponerPartida();
    mediador.getFrmLobby().mostrarInformacion();
    }//GEN-LAST:event_btnCrearPartidaActionPerformed

    private void btnUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirseActionPerformed
    this.setVisible(false);
    mediador.crearPartida();
    mediador.cerrarPantallaMenu();
    mediador.abrirPantallaUnirse();
    mediador.recuperarPartidas();
    
    }//GEN-LAST:event_btnUnirseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUnirse;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
