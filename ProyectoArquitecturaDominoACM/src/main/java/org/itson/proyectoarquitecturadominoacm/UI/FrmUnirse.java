/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import javax.swing.ImageIcon;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Gabriel Mancinas
 */
public class FrmUnirse extends javax.swing.JFrame {

    /**
     * Creates new form FrmUnirse
     */
    public FrmUnirse() {
        initComponents();
        this.setSize(750, 540); //736 x 500
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnFondo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        lblUnirseA = new javax.swing.JLabel();
        jpnPartidas = new javax.swing.JPanel();
        scbPartidas = new javax.swing.JScrollBar();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominó");
        setMaximumSize(new java.awt.Dimension(733, 500));
        setMinimumSize(new java.awt.Dimension(733, 500));
        setPreferredSize(new java.awt.Dimension(733, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(733, 500));

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
        jpnFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 100, 80));

        lblUnirseA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmUnirse/textoUnirseA.png"))); // NOI18N
        jpnFondo.add(lblUnirseA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 20));

        javax.swing.GroupLayout jpnPartidasLayout = new javax.swing.GroupLayout(jpnPartidas);
        jpnPartidas.setLayout(jpnPartidasLayout);
        jpnPartidasLayout.setHorizontalGroup(
            jpnPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPartidasLayout.createSequentialGroup()
                .addGap(0, 600, Short.MAX_VALUE)
                .addComponent(scbPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnPartidasLayout.setVerticalGroup(
            jpnPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scbPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jpnFondo.add(jpnPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 610, 170));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmUnirse/fondoFrmUnirse.png"))); // NOI18N
        jpnFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JPanel jpnPartidas;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblUnirseA;
    private javax.swing.JScrollBar scbPartidas;
    // End of variables declaration//GEN-END:variables
}
