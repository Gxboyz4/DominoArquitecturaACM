/**
 * FrmLobby.java creado el 19/09/2023.
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import org.itson.proyectoarquitecturadominoacm.Pozo.Pozo;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;
import org.itson.proyectoarquitecturadominoacm.Tablero.Tablero;
import org.itson.proyectoarquitecturadominoacm.contrincante.Contrincante;
import org.itson.proyectoarquitecturadominoacm.contrincante.PosicionPanel;

/**
 *
 * @author Gabriel Mancinas,Julio Chon,Luis Ayon
 */
public class FrmPartida extends javax.swing.JFrame {
    
    private String nombreJugador;
    private JdlgPuntajes tableroRanking;

    /**
     * Creates new form FrmLobby
     */
    public FrmPartida() {
        this.nombreJugador = mediador.getJugador().getNombre();
        initComponents();
        this.ocultarPanelesContrincantes();
        //this.setSize(850, 575); //800 x 550
        this.setLayout(new BorderLayout());
        this.pack();
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        this.crearPartida();
//        mediador.getPartida().repartirFichas();
        this.cargarPartida();
        mediador.getPartida().setJugadorCreador(mediador.getPartida().getJugadores().get(0));
        setFocusable(true);
        requestFocusInWindow();
        scrollPanel.getHorizontalScrollBar().setValue((scrollPanel.getHorizontalScrollBar().getMaximum() - scrollPanel.getHorizontalScrollBar().getVisibleAmount()) / 2);
        
    }
    
    private void establecerDatosJugadorLocal() {
        
        Jugador jugadorLocal = mediador.getJugador();
        mediador.getJugador().setPanelFichas(this.jpnFichasJugadorLocal);
        int contPrueba = 0;
        for (Jugador jugador : mediador.getPartida().getJugadores()) {
            if (jugador.getId() == jugadorLocal.getId()) {
                System.out.println("cant fich: " + jugador.getFichas().size());
                for (Ficha ficha : jugador.getFichas()) {
                    jugadorLocal.agregarFicha(ficha);
                    contPrueba++;
                    System.out.println(contPrueba);
                }
                break;
            }
        }
        
        this.asignarInformacionJugadorLocal(jugadorLocal);
    }
    
    private void establecerContrincantes() {
        List<Contrincante> contrincantes = new LinkedList<>();
        Jugador jugadorLocal = mediador.getJugador();
        int numeroContrincante = 1;
        for (Jugador jugador : mediador.getPartida().getJugadores()) {
            if (jugador.getId() != jugadorLocal.getId()) {
                Contrincante contrincanteNuevo = new Contrincante(
                        jugador.getId(),
                        jugador.getNombre(),
                        mediador.getPartida().getNumFichas(),
                        this.getPosicionPorPanelContrincante(numeroContrincante),
                        this.getPanelContrincante(numeroContrincante));
                contrincantes.add(contrincanteNuevo);
                this.asignarInformacionContrincante(numeroContrincante, jugador);
                this.mostrarPanelContrincante(numeroContrincante);
                numeroContrincante++;
                System.out.println("esta: " + contrincanteNuevo.getModelo().getFichasRestantes());
            }
        }
        mediador.getPartida().setContrincantes(contrincantes);
    }
    
    private PosicionPanel getPosicionPorPanelContrincante(int numPanel) {
        return switch (numPanel) {
            case 1 ->
                PosicionPanel.IZQUIERDA;
            case 2 ->
                PosicionPanel.ARRIBA;
            case 3 ->
                PosicionPanel.IZQUIERDA;
            //Alemnos hasta saber si cambio de lugar las fichas del panel derecho
            default ->
                PosicionPanel.IZQUIERDA;
        };
    }
    
    private JPanel getPanelContrincante(int numPanel) {
        return switch (numPanel) {
            case 1 ->
                this.jpnFichasContrincante1;
            case 2 ->
                this.jpnFichasContrincante2;
            case 3 ->
                this.jpnFichasContrincante3;
            default ->
                null;
        };
    }
    
    public void actualizarInfo() {
        System.out.println(mediador.getPartida().getJugadores());
        btnPozo.setVisible(mediador.getJugador().getTurno());
        this.mostrarBtnPasarTurno(mediador.getJugador().getTurno());
        asignarInformacionJugadorLocal(mediador.getJugador());
        Jugador jugadorLocal = mediador.getJugador();
        int numeroContrincante = 1;
        for (Jugador jugador : mediador.getPartida().getJugadores()) {
            if (jugador.getId() != jugadorLocal.getId()) {
                System.out.println("Este estoy mandando" + jugador);
                this.asignarInformacionContrincante(numeroContrincante, jugador);
                numeroContrincante++;
            }
        }
        jpnFondo.repaint();
    }
    
    public void cargarPartida() {
        this.ocultarInformacionContrincantes();
        this.ocultarPanelesContrincantes();
        this.establecerDatosJugadorLocal();
        this.establecerContrincantes();
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
    
    private void ocultarInformacionContrincantes() {
        for (int i = 0; i < 4; i++) {
            this.ocultarLabelsContrincantes(i);
        }
    }
    
    
    private void ocultarPanelesContrincantes() {
        this.jpnFichasContrincante1.setVisible(false);
        this.jpnFichasContrincante2.setVisible(false);
        this.jpnFichasContrincante3.setVisible(false);
    }
    
    private void mostrarPanelContrincante(int cantidadJugadores) {
        this.getPanelContrincante(cantidadJugadores).setVisible(true);
    }
    
    private void asignarInformacionContrincante(int numContrincante, Jugador jugadorContrincante) {
        switch (numContrincante) {
            case 1 ->
                this.asignarInformacionContrincante1(jugadorContrincante);
            case 2 ->
                this.asignarInformacionContrincante2(jugadorContrincante);
            case 3 ->
                this.asignarInformacionContrincante3(jugadorContrincante);
        }
    }
    
    private void ocultarLabelsContrincantes(int numContrincante) {
        switch (numContrincante) {
            case 1 -> {
                this.lblAvatarContrincante1.setVisible(false);
                this.lblNombreContrincante1.setVisible(false);
            }
            case 2 -> {
                this.lblAvatarContrincante2.setVisible(false);
                this.lblNombreContrincante2.setVisible(false);
            }
            case 3 -> {
                this.lblAvatarContrincante3.setVisible(false);
                this.lblNombreContrincante3.setVisible(false);
            }
        }
    }
    
    private void asignarInformacionJugadorLocal(Jugador jugadorContrincante) {
        Icon icon;
        icon = new ImageIcon(jugadorContrincante.getAvatar().getImage().getScaledInstance(lblAvatarContrincante1.getWidth(), lblAvatarContrincante1.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarJugadorLocal.setIcon(icon);
        lblNombreJugadorLocal.setHorizontalAlignment(SwingConstants.CENTER);
        if (jugadorContrincante.getTurno()) {
            lblNombreJugadorLocal.setText("∎ " + jugadorContrincante.getNombre());
            lblNombreJugadorLocal.setForeground(Color.green);
        } else {
            lblNombreJugadorLocal.setText(jugadorContrincante.getNombre());
            lblNombreJugadorLocal.setForeground(Color.black);
        }
    }
    
    private void asignarInformacionContrincante1(Jugador jugador2) {
        Icon icon;
        icon = new ImageIcon(jugador2.getAvatar().getImage().getScaledInstance(lblAvatarContrincante1.getWidth(), lblAvatarContrincante1.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarContrincante1.setIcon(icon);
        lblNombreContrincante1.setText(jugador2.getNombre());
        lblNombreContrincante1.setHorizontalAlignment(SwingConstants.CENTER);
        if (jugador2.getTurno()) {
            lblNombreContrincante1.setText("∎ " + jugador2.getNombre());
            lblNombreContrincante1.setForeground(Color.green);
        } else {
            lblNombreContrincante1.setText(jugador2.getNombre());
            lblNombreContrincante1.setForeground(Color.black);
        }
        this.lblAvatarContrincante1.setVisible(true);
        this.lblNombreContrincante1.setVisible(true);
    }
    
    private void asignarInformacionContrincante2(Jugador jugador3) {
        Icon icon;
        icon = new ImageIcon(jugador3.getAvatar().getImage().getScaledInstance(lblAvatarContrincante1.getWidth(), lblAvatarContrincante1.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarContrincante2.setIcon(icon);
        lblNombreContrincante2.setHorizontalAlignment(SwingConstants.CENTER);
        if (jugador3.getTurno()) {
            lblNombreContrincante2.setText("∎ " + jugador3.getNombre());
            lblNombreContrincante2.setForeground(Color.green);
        } else {
            lblNombreContrincante2.setText(jugador3.getNombre());
            lblNombreContrincante2.setForeground(Color.black);
        }
        this.lblAvatarContrincante2.setVisible(true);
        this.lblNombreContrincante2.setVisible(true);
    }
    
    private void asignarInformacionContrincante3(Jugador jugador4) {
        Icon icon;
        icon = new ImageIcon(jugador4.getAvatar().getImage().getScaledInstance(lblAvatarContrincante1.getWidth(), lblAvatarContrincante1.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarContrincante3.setIcon(icon);
        lblNombreContrincante3.setHorizontalAlignment(SwingConstants.CENTER);
        if (jugador4.getTurno()) {
            lblNombreContrincante3.setText("∎ " + jugador4.getNombre());
            lblNombreContrincante3.setForeground(Color.green);
        } else {
            lblNombreContrincante3.setText(jugador4.getNombre());
            lblNombreContrincante3.setForeground(Color.black);
        }
        this.lblAvatarContrincante3.setVisible(true);
        this.lblNombreContrincante3.setVisible(true);
    }
    
    public void mostrarRanking() {
        this.tableroRanking.mostrarPuntajesJugadores();
        this.tableroRanking.setVisible(true);
    }
    
    public JdlgPuntajes getTableroRanking() {
        return tableroRanking;
    }
    
    public void setTableroRanking(JdlgPuntajes tableroRanking) {
        this.tableroRanking = tableroRanking;
    }
    
    private void mostrarBtnPasarTurno(boolean mostrar) {
        this.btnPasarTurno.setVisible(mostrar);
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
        jpnFichasJugadorLocal = new javax.swing.JPanel();
        jpnFichasContrincante1 = new javax.swing.JPanel();
        jpnFichasContrincante2 = new javax.swing.JPanel();
        jpnFichasContrincante3 = new javax.swing.JPanel();
        lblNombreContrincante3 = new javax.swing.JLabel();
        lblNombreContrincante2 = new javax.swing.JLabel();
        lblNombreContrincante1 = new javax.swing.JLabel();
        lblNombreJugadorLocal = new javax.swing.JLabel();
        lblAvatarJugadorLocal = new javax.swing.JLabel();
        lblAvatarContrincante1 = new javax.swing.JLabel();
        lblAvatarContrincante2 = new javax.swing.JLabel();
        lblAvatarContrincante3 = new javax.swing.JLabel();
        btnAcabarPartida = new javax.swing.JButton();
        btnPozo = new javax.swing.JButton();
        btnPasarTurno = new javax.swing.JButton();
        lblTableroFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Partida en curso! " + this.nombreJugador );
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jpnFichasJugadorLocal.setBackground(new java.awt.Color(8, 78, 171));
        jpnFichasJugadorLocal.setLayout(null);
        jpnFondo.add(jpnFichasJugadorLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 368, 88));

        jpnFichasContrincante1.setBackground(new java.awt.Color(8, 78, 171));

        javax.swing.GroupLayout jpnFichasContrincante1Layout = new javax.swing.GroupLayout(jpnFichasContrincante1);
        jpnFichasContrincante1.setLayout(jpnFichasContrincante1Layout);
        jpnFichasContrincante1Layout.setHorizontalGroup(
            jpnFichasContrincante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpnFichasContrincante1Layout.setVerticalGroup(
            jpnFichasContrincante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jpnFondo.add(jpnFichasContrincante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 140, 260));

        jpnFichasContrincante2.setBackground(new java.awt.Color(8, 78, 171));
        jpnFichasContrincante2.setLayout(null);
        jpnFondo.add(jpnFichasContrincante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 368, 88));

        jpnFichasContrincante3.setBackground(new java.awt.Color(8, 78, 171));

        javax.swing.GroupLayout jpnFichasContrincante3Layout = new javax.swing.GroupLayout(jpnFichasContrincante3);
        jpnFichasContrincante3.setLayout(jpnFichasContrincante3Layout);
        jpnFichasContrincante3Layout.setHorizontalGroup(
            jpnFichasContrincante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpnFichasContrincante3Layout.setVerticalGroup(
            jpnFichasContrincante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jpnFondo.add(jpnFichasContrincante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 140, 260));

        lblNombreContrincante3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreContrincante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 130, 20));

        lblNombreContrincante2.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreContrincante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 130, 20));

        lblNombreContrincante1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreContrincante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 20));

        lblNombreJugadorLocal.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jpnFondo.add(lblNombreJugadorLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 130, 20));
        jpnFondo.add(lblAvatarJugadorLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 100, 90));
        jpnFondo.add(lblAvatarContrincante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 100, 90));
        jpnFondo.add(lblAvatarContrincante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 100, 90));
        jpnFondo.add(lblAvatarContrincante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 100, 90));

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

        btnPasarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmPartida/iconoPasarTurno.png"))); // NOI18N
        btnPasarTurno.setBorder(null);
        btnPasarTurno.setBorderPainted(false);
        btnPasarTurno.setContentAreaFilled(false);
        btnPasarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarTurnoActionPerformed(evt);
            }
        });
        jpnFondo.add(btnPasarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

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
        mediador.salirDurantePartida();
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_btnAcabarPartidaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        mediador.salirDurantePartida();
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_formWindowClosing

    private void btnPasarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarTurnoActionPerformed
        mediador.pasarTurno();
    }//GEN-LAST:event_btnPasarTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcabarPartida;
    private javax.swing.JButton btnPasarTurno;
    private javax.swing.JButton btnPozo;
    private javax.swing.JPanel jpnFichasContrincante1;
    private javax.swing.JPanel jpnFichasContrincante2;
    private javax.swing.JPanel jpnFichasContrincante3;
    private javax.swing.JPanel jpnFichasJugadorLocal;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JPanel jpnTablero;
    private javax.swing.JLabel lblAvatarContrincante1;
    private javax.swing.JLabel lblAvatarContrincante2;
    private javax.swing.JLabel lblAvatarContrincante3;
    private javax.swing.JLabel lblAvatarJugadorLocal;
    private javax.swing.JLabel lblNombreContrincante1;
    private javax.swing.JLabel lblNombreContrincante2;
    private javax.swing.JLabel lblNombreContrincante3;
    private javax.swing.JLabel lblNombreJugadorLocal;
    private javax.swing.JLabel lblTableroFondo;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables

}
