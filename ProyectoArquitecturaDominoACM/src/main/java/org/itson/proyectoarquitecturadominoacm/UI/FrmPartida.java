/**
 * FrmLobby.java creado el 19/09/2023.
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import javax.swing.ImageIcon;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;

/**
 *
 * @author Gabriel Mancinas,Julio Chon,Luis Ayon
 */
public class FrmPartida extends javax.swing.JFrame {

    /**
     * Creates new form FrmLobby
     */
    public FrmPartida() {
        initComponents();
        
        this.setVisible(true);
        this.setSize(750, 540); //736 x 500
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        setTitle("Dominó");
   
        String dir = "/imgFrmPartidaFichas/ficha1_1.png";
       ImageIcon imagen = new ImageIcon(getClass().getResource(dir));
        Ficha ficha = new Ficha(jpnFichas,1,1,imagen,0,0);
        ficha.dibujarEnPanelUsuario();
        
        String dir2 = "/imgFrmPartidaFichas/ficha6_6.png";
        ImageIcon imagen2 = new ImageIcon(getClass().getResource(dir2));
        Ficha ficha2 = new Ficha(jpnFichas,6,6,imagen2,30,0);
        ficha2.dibujarEnPanelUsuario();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTablero = new javax.swing.JPanel();
        jpnFichas = new javax.swing.JPanel();
        btnAcabarPartida = new javax.swing.JButton();
        lblTableroFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnTableroLayout = new javax.swing.GroupLayout(jpnTablero);
        jpnTablero.setLayout(jpnTableroLayout);
        jpnTableroLayout.setHorizontalGroup(
            jpnTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        jpnTableroLayout.setVerticalGroup(
            jpnTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jpnFichas.setLayout(null);

        btnAcabarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmPartida/iconoAcabarPartida.png"))); // NOI18N
        btnAcabarPartida.setBorderPainted(false);
        btnAcabarPartida.setContentAreaFilled(false);
        btnAcabarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcabarPartidaActionPerformed(evt);
            }
        });

        lblTableroFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmPartida/imgFondoPartida.png"))); // NOI18N
        lblTableroFondo.setMaximumSize(new java.awt.Dimension(700, 500));
        lblTableroFondo.setMinimumSize(new java.awt.Dimension(700, 500));
        lblTableroFondo.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jpnFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAcabarPartida)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jpnTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblTableroFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jpnTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnAcabarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpnFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblTableroFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcabarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcabarPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcabarPartidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcabarPartida;
    private javax.swing.JPanel jpnFichas;
    private javax.swing.JPanel jpnTablero;
    private javax.swing.JLabel lblTableroFondo;
    // End of variables declaration//GEN-END:variables
}
