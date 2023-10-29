/**
 * FrmLobby.java creado el 19/09/2023.
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaModelo;
import org.itson.proyectoarquitecturadominoacm.Fichas.FichaVista;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Partida.Partida;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;

/**
 *
 * @author Gabriel Mancinas,Julio Chon,Luis Ayon
 */
public class FrmPartida extends javax.swing.JFrame {

    private String nombreJugador;

    /**
     * Creates new form FrmLobby
     */
    public FrmPartida() {
        this.nombreJugador = mediador.getJugador().getNombre();
        initComponents();
        this.ocultarPanelesJugadores();
        //this.setSize(850, 575); //800 x 550
        this.setLayout(new BorderLayout());
        this.pack();

        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        this.crearPartida();
        this.cargarPartida();
        mediador.getJugador().setPanelFichas(jpnFichasP1);
        mediador.getPartida().setJugadorCreador(mediador.getPartida().getJugadores().get(0));
        mediador.getPartida().repartirFichas();
        setFocusable(true);
        requestFocusInWindow();
        scrollPanel.getHorizontalScrollBar().setValue((scrollPanel.getHorizontalScrollBar().getMaximum() - scrollPanel.getHorizontalScrollBar().getVisibleAmount()) / 2);
    }

    private void cargarPartida() {
        int cantidadJugadores = mediador.getPartida().getJugadores().size();
        this.asignarInformacionJugadores(cantidadJugadores);
        this.mostrarPanelesPorCantidadJugadores(cantidadJugadores);
    }

    public void crearPartida() {
        Pozo pozo = new Pozo(btnPozo);
        Tablero tablero = new Tablero(jpnTablero);
        mediador.getPartida().setPozo(pozo);
        mediador.getPartida().setTablero(tablero);
        mediador.getPartida().suscribirse();
    }

    public void acabarPartida() {
        mediador.abrirPantallaMenu();
        this.dispose();

    }

    private void ocultarPanelesJugadores() {
        this.jpnFichasP1.setVisible(false);
        this.jpnFichasP2.setVisible(false);
        this.jpnFichasP3.setVisible(false);
        this.jpnFichasP4.setVisible(false);
    }

    private void mostrarPanelesPorCantidadJugadores(int cantidadJugadores) {
        switch (cantidadJugadores) {
            case 1:
                this.jpnFichasP1.setVisible(true);
                break;
            case 2:
                this.jpnFichasP1.setVisible(true);
                this.jpnFichasP2.setVisible(true);
                break;
            case 3:
                this.jpnFichasP1.setVisible(true);
                this.jpnFichasP2.setVisible(true);
                this.jpnFichasP3.setVisible(true);
                break;
            case 4:
                this.jpnFichasP1.setVisible(true);
                this.jpnFichasP2.setVisible(true);
                this.jpnFichasP3.setVisible(true);
                this.jpnFichasP4.setVisible(true);
                break;
        }
    }

    private void asignarInformacionJugadores(int cantidadJugadores) {
        switch (cantidadJugadores) {
            case 1 -> {
                mediador.getPartida().getJugadores().get(0).setPanelFichas(jpnFichasP1);
                asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
            }
            case 2 -> {
                mediador.getPartida().getJugadores().get(0).setPanelFichas(jpnFichasP1);
                asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
                mediador.getPartida().getJugadores().get(1).setPanelFichas(jpnFichasP2);
                asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
            }
            case 3 -> {
                mediador.getPartida().getJugadores().get(0).setPanelFichas(jpnFichasP1);
                asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
                mediador.getPartida().getJugadores().get(1).setPanelFichas(jpnFichasP2);
                asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
                mediador.getPartida().getJugadores().get(2).setPanelFichas(jpnFichasP3);
                asignarInformacionJugador3(mediador.getPartida().getJugadores().get(2));
            }
            default -> {
                mediador.getPartida().getJugadores().get(0).setPanelFichas(jpnFichasP1);
                asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
                mediador.getPartida().getJugadores().get(1).setPanelFichas(jpnFichasP2);
                asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
                mediador.getPartida().getJugadores().get(2).setPanelFichas(jpnFichasP3);
                asignarInformacionJugador3(mediador.getPartida().getJugadores().get(2));
                mediador.getPartida().getJugadores().get(3).setPanelFichas(jpnFichasP4);
                asignarInformacionJugador4(mediador.getPartida().getJugadores().get(3));
            }
        }
    }

    private void asignarInformacionJugador1(Jugador jugador1) {
        Icon icon;
        icon = new ImageIcon(jugador1.getAvatar().getImage().getScaledInstance(lblAvatarP2.getWidth(), lblAvatarP2.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP1.setIcon(icon);
        lblNombreP1.setText(jugador1.getNombre());
        lblNombreP1.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void asignarInformacionJugador2(Jugador jugador2) {
        jugador2.setPanelFichas(jpnFichasP2);
        Icon icon;
        icon = new ImageIcon(jugador2.getAvatar().getImage().getScaledInstance(lblAvatarP2.getWidth(), lblAvatarP2.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP2.setIcon(icon);
        lblNombreP2.setText(jugador2.getNombre());
        lblNombreP2.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void asignarInformacionJugador3(Jugador jugador3) {
        jugador3.setPanelFichas(jpnFichasP3);
        Icon icon;
        icon = new ImageIcon(jugador3.getAvatar().getImage().getScaledInstance(lblAvatarP2.getWidth(), lblAvatarP2.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP2.setIcon(icon);
        lblNombreP2.setText(jugador3.getNombre());
        lblNombreP2.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void asignarInformacionJugador4(Jugador jugador4) {
        jugador4.setPanelFichas(jpnFichasP4);
        Icon icon;
        icon = new ImageIcon(jugador4.getAvatar().getImage().getScaledInstance(lblAvatarP2.getWidth(), lblAvatarP2.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP2.setIcon(icon);
        lblNombreP2.setText(jugador4.getNombre());
        lblNombreP2.setHorizontalAlignment(SwingConstants.CENTER);
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
        scrollPanel = new javax.swing.JScrollPane();
        jpnTablero = new javax.swing.JPanel();
        jpnFichasP1 = new javax.swing.JPanel();
        jpnFichasP2 = new javax.swing.JPanel();
        jpnFichasP3 = new javax.swing.JPanel();
        jpnFichasP4 = new javax.swing.JPanel();
        lblNombreP4 = new javax.swing.JLabel();
        lblNombreP3 = new javax.swing.JLabel();
        lblNombreP2 = new javax.swing.JLabel();
        lblNombreP1 = new javax.swing.JLabel();
        lblAvatarP1 = new javax.swing.JLabel();
        lblAvatarP2 = new javax.swing.JLabel();
        lblAvatarP3 = new javax.swing.JLabel();
        lblAvatarP4 = new javax.swing.JLabel();
        btnAcabarPartida = new javax.swing.JButton();
        btnPozo = new javax.swing.JButton();
        lblTableroFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡Partida en curso! " + this.nombreJugador );
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        jpnFondo.setMaximumSize(new java.awt.Dimension(900, 600));
        jpnFondo.setMinimumSize(new java.awt.Dimension(900, 600));
        jpnFondo.setPreferredSize(new java.awt.Dimension(900, 600));
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jpnTablero.setBackground(new java.awt.Color(8, 78, 171));
        jpnTablero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnTablero.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        javax.swing.GroupLayout jpnTableroLayout = new javax.swing.GroupLayout(jpnTablero);
        jpnTablero.setLayout(jpnTableroLayout);
        jpnTableroLayout.setHorizontalGroup(
            jpnTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1586, Short.MAX_VALUE)
        );
        jpnTableroLayout.setVerticalGroup(
            jpnTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(jpnTablero);

        jpnFondo.add(scrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 368, 260));

        jpnFichasP1.setBackground(new java.awt.Color(8, 78, 171));
        jpnFichasP1.setLayout(null);
        jpnFondo.add(jpnFichasP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 368, 88));

        jpnFichasP2.setBackground(new java.awt.Color(8, 78, 171));

        javax.swing.GroupLayout jpnFichasP2Layout = new javax.swing.GroupLayout(jpnFichasP2);
        jpnFichasP2.setLayout(jpnFichasP2Layout);
        jpnFichasP2Layout.setHorizontalGroup(
            jpnFichasP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jpnFichasP2Layout.setVerticalGroup(
            jpnFichasP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jpnFondo.add(jpnFichasP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 260));

        jpnFichasP3.setBackground(new java.awt.Color(8, 78, 171));
        jpnFichasP3.setLayout(null);
        jpnFondo.add(jpnFichasP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 368, 88));

        jpnFichasP4.setBackground(new java.awt.Color(8, 78, 171));

        javax.swing.GroupLayout jpnFichasP4Layout = new javax.swing.GroupLayout(jpnFichasP4);
        jpnFichasP4.setLayout(jpnFichasP4Layout);
        jpnFichasP4Layout.setHorizontalGroup(
            jpnFichasP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jpnFichasP4Layout.setVerticalGroup(
            jpnFichasP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jpnFondo.add(jpnFichasP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, 260));

        lblNombreP4.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 130, 20));

        lblNombreP3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 130, 20));

        lblNombreP2.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 20));

        lblNombreP1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 130, 20));
        jpnFondo.add(lblAvatarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 100, 90));
        jpnFondo.add(lblAvatarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 100, 90));
        jpnFondo.add(lblAvatarP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 100, 90));
        jpnFondo.add(lblAvatarP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 100, 90));

        btnAcabarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmPartida/iconoAcabarPartida.png"))); // NOI18N
        btnAcabarPartida.setBorderPainted(false);
        btnAcabarPartida.setContentAreaFilled(false);
        btnAcabarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcabarPartidaActionPerformed(evt);
            }
        });
        jpnFondo.add(btnAcabarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 180, 60));

        btnPozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmPartida/iconoTomarFicha.png"))); // NOI18N
        btnPozo.setBorderPainted(false);
        btnPozo.setContentAreaFilled(false);
        jpnFondo.add(btnPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 180, 70));

        lblTableroFondo.setBackground(new java.awt.Color(1, 114, 171));
        lblTableroFondo.setAlignmentY(0.0F);
        lblTableroFondo.setMaximumSize(new java.awt.Dimension(900, 600));
        lblTableroFondo.setMinimumSize(new java.awt.Dimension(900, 600));
        lblTableroFondo.setOpaque(true);
        lblTableroFondo.setPreferredSize(new java.awt.Dimension(900, 600));
        jpnFondo.add(lblTableroFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcabarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcabarPartidaActionPerformed
        this.dispose();
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_btnAcabarPartidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcabarPartida;
    private javax.swing.JButton btnPozo;
    private javax.swing.JPanel jpnFichasP1;
    private javax.swing.JPanel jpnFichasP2;
    private javax.swing.JPanel jpnFichasP3;
    private javax.swing.JPanel jpnFichasP4;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JPanel jpnTablero;
    private javax.swing.JLabel lblAvatarP1;
    private javax.swing.JLabel lblAvatarP2;
    private javax.swing.JLabel lblAvatarP3;
    private javax.swing.JLabel lblAvatarP4;
    private javax.swing.JLabel lblNombreP1;
    private javax.swing.JLabel lblNombreP2;
    private javax.swing.JLabel lblNombreP3;
    private javax.swing.JLabel lblNombreP4;
    private javax.swing.JLabel lblTableroFondo;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables

}
