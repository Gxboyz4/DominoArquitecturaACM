/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.libreriatiposdominoacmp.PartidaDTO;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Gabriel Mancinas
 */
public class FrmUnirse extends javax.swing.JFrame{
    
    List<Partida> partidas;
    private String nombreJugador;

    /**
     * Creates new form FrmUnirse
     */
    public FrmUnirse() {
        this.nombreJugador = mediador.getJugador().getNombre();
        initComponents();
        this.setVisible(true);
        this.setSize(750, 540); //736 x 500
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        this.partidas = new LinkedList<>(); 
        this.cargarListaPartidas();
    }
    
    public void mostrarMensaje(){
        JOptionPane.showMessageDialog(this,"La partida está llena.", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    public void cargarListaPartidas(){
        
        Partida partida = mediador.getPartida();
        //Hicimos esto porque después vamos a realizar lo de la repartición de información en el broker, ya que se añade la partida dos veces a la lista. (Porque le llega a todos)
        System.out.println(partida);
        if(partida.getJugadores().size() != 0&&partidas.size()==0){
        this.partidas.add(partida);
        }
        cargarTabla();
    }
    
    public void cargarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPartidas.getModel();
        modeloTabla.setRowCount(0);
        this.tblPartidas.removeAll();
        if(mediador.getPartida()!=null && partidas.size()>0){
            
            btnUnirse.setVisible(true);
            
        for (Partida partida : partidas) {
            Object[] row = {
                //Debería haber un método para traer al dueño de la partida
                
                partida.getJugadores().get(0).getNombre(),
                //partida.getCantidadFichasConfiguradas(),
                //partida.getCantidadJugadoresEnSala()
            };
            
            modeloTabla.addRow(row);       
        }
        
         
         
//        this.partidas.forEach(partida -> {
//            Object[] fila = {
//                //Debería haber un método para traer al dueño de la partida
//                partida.getJugadores().get(0).getNombre(),
//                //partida.getCantidadFichasConfiguradas(),
//                //partida.getCantidadJugadoresEnSala()
//            };
//            modeloTabla.addColumn(fila);
//        });
        }
        else
        {
            btnUnirse.setVisible(false);
        }
    }
    public void vaciarListaPartidas(){
        partidas.clear();
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
        scrollPanelPartidas = new javax.swing.JScrollPane();
        tblPartidas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnUnirse = new javax.swing.JButton();
        lblUnirseA = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominó " + this.nombreJugador);
        setMaximumSize(new java.awt.Dimension(733, 500));
        setMinimumSize(new java.awt.Dimension(733, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(733, 500));

        jpnFondo.setMaximumSize(new java.awt.Dimension(733, 500));
        jpnFondo.setMinimumSize(new java.awt.Dimension(733, 500));
        jpnFondo.setPreferredSize(new java.awt.Dimension(733, 500));
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Creador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelPartidas.setViewportView(tblPartidas);

        jpnFondo.add(scrollPanelPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 610, 180));

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

        btnUnirse.setText("Unirse");
        btnUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirseActionPerformed(evt);
            }
        });
        jpnFondo.add(btnUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lblUnirseA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmUnirse/textoUnirseA.png"))); // NOI18N
        jpnFondo.add(lblUnirseA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 20));

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
    this.dispose();
    mediador.cerrarPantallaUnirse();
    mediador.abrirPantallaMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirseActionPerformed
    this.dispose();
    mediador.cerrarPantallaUnirse();
    mediador.abrirPantallaLobby();
    mediador.unirsePartida();
    //mediador.abrirPantallaLobby();
    }//GEN-LAST:event_btnUnirseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUnirse;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblUnirseA;
    private javax.swing.JScrollPane scrollPanelPartidas;
    private javax.swing.JTable tblPartidas;
    // End of variables declaration//GEN-END:variables

}
