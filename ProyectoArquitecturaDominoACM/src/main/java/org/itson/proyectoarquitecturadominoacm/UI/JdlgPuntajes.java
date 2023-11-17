/**
 * JdlgPuntajes.java
 * Nov 14, 2023 6:10:13 PM
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class JdlgPuntajes extends javax.swing.JDialog {

    LinkedHashMap<JugadorDTO, Integer> puntajesJugadores;
    FrmPartida frmPartida;

    /**
     * Creates new form JdlgPuntajes
     */
    public JdlgPuntajes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.frmPartida = (FrmPartida) parent;
        initComponents();
        this.ocultarLabelsInformacionJugadores();
        this.puntajesJugadores = new LinkedHashMap<>();
    }

    public JdlgPuntajes(LinkedHashMap<JugadorDTO, Integer> puntajesJugadores, Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.puntajesJugadores = puntajesJugadores;
        this.ocultarLabelsInformacionJugadores();
    }

    private void ocultarLabelsInformacionJugadores() {
        this.lblPrimerLugar.setVisible(false);
        this.lblAvatarP1.setVisible(false);
        this.lblNombreP1.setVisible(false);
        this.lblSegundoLugar.setVisible(false);
        this.lblAvatarP2.setVisible(false);
        this.lblNombreP2.setVisible(false);
        this.lblPuntajeP2.setVisible(false);
        this.lblTercerLugar.setVisible(false);
        this.lblAvatarP3.setVisible(false);
        this.lblNombreP3.setVisible(false);
        this.lblPuntajeP3.setVisible(false);
        this.lblCuartoLugar.setVisible(false);
        this.lblAvatarP4.setVisible(false);
        this.lblNombreP4.setVisible(false);
        this.lblPuntajeP4.setVisible(false);
    }

    private void mostrarLabelsInformacionJugadores(int rankingJugador) {
        switch (rankingJugador) {
            case 1:
                this.lblPrimerLugar.setVisible(true);
                this.lblAvatarP1.setVisible(true);
                this.lblNombreP1.setVisible(true);
                break;
            case 2:
                this.lblSegundoLugar.setVisible(true);
                this.lblAvatarP2.setVisible(true);
                this.lblNombreP2.setVisible(true);
                this.lblPuntajeP2.setVisible(true);
                break;
            case 3:
                this.lblTercerLugar.setVisible(true);
                this.lblAvatarP3.setVisible(true);
                this.lblNombreP3.setVisible(true);
                this.lblPuntajeP3.setVisible(true);
                break;
            default:
                this.lblCuartoLugar.setVisible(true);
                this.lblAvatarP4.setVisible(true);
                this.lblNombreP4.setVisible(true);
                this.lblPuntajeP4.setVisible(true);
                break;
        }
    }

    public int cantJugadoresEnRanking() {
        return this.puntajesJugadores.size();
    }

    public LinkedHashMap<JugadorDTO, Integer> getPuntajesJugadores() {
        return puntajesJugadores;
    }

    public void setPuntajesJugadores(LinkedHashMap<JugadorDTO, Integer> puntajesJugadores) {
        this.puntajesJugadores = puntajesJugadores;
    }

    public void agregarPuntajesJugadores(JugadorDTO jugador, Integer puntaje) {
        this.puntajesJugadores.put(jugador, puntaje);
    }

    private void ordenarJugadoresPuntajes() {
        List<Map.Entry<JugadorDTO, Integer>> listaEntradas = new ArrayList<>(puntajesJugadores.entrySet());
        listaEntradas.sort(Map.Entry.comparingByValue());
        LinkedHashMap<JugadorDTO, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<JugadorDTO, Integer> entrada : listaEntradas) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }
        puntajesJugadores.clear();
        puntajesJugadores.putAll(mapaOrdenado);
    }

    public void mostrarPuntajesJugadores() {
        this.ordenarJugadoresPuntajes();
        this.asignarPuestosJugadores();
    }

    private void asignarPuestosJugadores() {
        int cont = 1;
        for (Map.Entry<JugadorDTO, Integer> entry : puntajesJugadores.entrySet()) {
            JugadorDTO jugador = entry.getKey();
            Integer puntos = entry.getValue();
            this.asignarJugadorPosicionRanking(jugador, puntos, cont);
            cont++;
        }
    }

    private void asignarJugadorPosicionRanking(JugadorDTO jugador, Integer puntos, int posicionRanking) {
        Icon icon;
        icon = new ImageIcon(jugador.getAvatar().getImage().getScaledInstance(lblAvatarP1.getWidth(), lblAvatarP1.getHeight(), Image.SCALE_DEFAULT));
        this.mostrarLabelsInformacionJugadores(posicionRanking);
        switch (posicionRanking) {
            case 1:
                this.lblAvatarP1.setIcon(icon);
                this.lblNombreP1.setText(jugador.getNombre());
                break;
            case 2:
                this.lblAvatarP2.setIcon(icon);
                this.lblNombreP2.setText(jugador.getNombre());
                this.lblPuntajeP2.setText(String.valueOf(puntos));
                break;
            case 3:
                this.lblAvatarP3.setIcon(icon);
                this.lblNombreP3.setText(jugador.getNombre());
                this.lblPuntajeP3.setText(String.valueOf(puntos));
                break;
            default:
                this.lblAvatarP4.setIcon(icon);
                this.lblNombreP4.setText(jugador.getNombre());
                this.lblPuntajeP4.setText(String.valueOf(puntos));
                break;
        }
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
        lblPrimerLugar = new javax.swing.JLabel();
        lblNombreP1 = new javax.swing.JLabel();
        lblAvatarP1 = new javax.swing.JLabel();
        lblSegundoLugar = new javax.swing.JLabel();
        lblAvatarP2 = new javax.swing.JLabel();
        lblNombreP2 = new javax.swing.JLabel();
        lblPuntajeP2 = new javax.swing.JLabel();
        lblTercerLugar = new javax.swing.JLabel();
        lblAvatarP3 = new javax.swing.JLabel();
        lblNombreP3 = new javax.swing.JLabel();
        lblPuntajeP3 = new javax.swing.JLabel();
        lblCuartoLugar = new javax.swing.JLabel();
        lblAvatarP4 = new javax.swing.JLabel();
        lblNombreP4 = new javax.swing.JLabel();
        lblPuntajeP4 = new javax.swing.JLabel();
        lblSlots = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrimerLugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrimerLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblPrimerLugar.setText("Primer Lugar");
        jpnFondo.add(lblPrimerLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, 30));

        lblNombreP1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblNombreP1.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreP1.setText("P1");
        jpnFondo.add(lblNombreP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 30));
        jpnFondo.add(lblAvatarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 110));

        lblSegundoLugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSegundoLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundoLugar.setText("Segundo Lugar");
        jpnFondo.add(lblSegundoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 130, 30));
        jpnFondo.add(lblAvatarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 130, 110));

        lblNombreP2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblNombreP2.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreP2.setText("P2");
        jpnFondo.add(lblNombreP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 30));

        lblPuntajeP2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblPuntajeP2.setForeground(new java.awt.Color(0, 0, 0));
        lblPuntajeP2.setText("0");
        jpnFondo.add(lblPuntajeP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 130, 30));

        lblTercerLugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTercerLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblTercerLugar.setText("Tercer Lugar");
        jpnFondo.add(lblTercerLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 110, 30));
        jpnFondo.add(lblAvatarP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 130, 110));

        lblNombreP3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblNombreP3.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreP3.setText("P3");
        jpnFondo.add(lblNombreP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 30));

        lblPuntajeP3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblPuntajeP3.setForeground(new java.awt.Color(0, 0, 0));
        lblPuntajeP3.setText("0");
        jpnFondo.add(lblPuntajeP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 130, 30));

        lblCuartoLugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCuartoLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblCuartoLugar.setText("Cuarto Lugar");
        jpnFondo.add(lblCuartoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 110, 30));
        jpnFondo.add(lblAvatarP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 130, 110));

        lblNombreP4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblNombreP4.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreP4.setText("P4");
        jpnFondo.add(lblNombreP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 130, 30));

        lblPuntajeP4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblPuntajeP4.setForeground(new java.awt.Color(0, 0, 0));
        lblPuntajeP4.setText("0");
        jpnFondo.add(lblPuntajeP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 130, 30));

        lblSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmLobby/iconoSlots.png"))); // NOI18N
        jpnFondo.add(lblSlots, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 710, 250));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmUnirse/fondoFrmUnirse.png"))); // NOI18N
        jpnFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        mediador.abrirPantallaMenu();
        this.frmPartida.dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JLabel lblAvatarP1;
    private javax.swing.JLabel lblAvatarP2;
    private javax.swing.JLabel lblAvatarP3;
    private javax.swing.JLabel lblAvatarP4;
    private javax.swing.JLabel lblCuartoLugar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombreP1;
    private javax.swing.JLabel lblNombreP2;
    private javax.swing.JLabel lblNombreP3;
    private javax.swing.JLabel lblNombreP4;
    private javax.swing.JLabel lblPrimerLugar;
    private javax.swing.JLabel lblPuntajeP2;
    private javax.swing.JLabel lblPuntajeP3;
    private javax.swing.JLabel lblPuntajeP4;
    private javax.swing.JLabel lblSegundoLugar;
    private javax.swing.JLabel lblSlots;
    private javax.swing.JLabel lblTercerLugar;
    // End of variables declaration//GEN-END:variables

}
