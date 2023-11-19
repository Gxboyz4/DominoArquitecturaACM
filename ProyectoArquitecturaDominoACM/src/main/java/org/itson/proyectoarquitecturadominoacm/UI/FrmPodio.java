/**
 * FrmPuntajes.java
 * Nov 18, 2023 9:02:37 PM
 *
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.itson.libreriatiposdominoacmp.JugadorDTO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FrmPodio extends javax.swing.JFrame {

    private LinkedHashMap<JugadorDTO, Integer> podio;
    private static FrmPodio frmPodio;

    /**
     * Creates new form FrmPuntajes
     */
    private FrmPodio() {
        initComponents();
        this.iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.podio = new LinkedHashMap<>();
        this.ocultarInformacionLabelsPodio();
        this.setIconImage(new ImageIcon(getClass()
                .getResource("/imgFrmPrincipal/iconoGeneral.png"))
                .getImage());
    }

    private void ocultarInformacionLabelsPodio() {
        this.lblPrimerLugar.setVisible(false);
        this.lblAvatarP1.setVisible(false);
        this.lblNombreP1.setVisible(false);
        this.lblPuntajeP1.setVisible(false);
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

    private void actualizarPodio(){
        this.ocultarInformacionLabelsPodio();
        this.ordenarPodioPuntos();
        this.asignarInformacionLabelsPodio();
    }
    
    public void abrirVentanaPodio(){
        this.actualizarPodio();
        this.mostrarInformacionLabels();
        this.setVisible(true);
    }
    
    public void cerrarVentanaPodio(){
        this.ocultarInformacionLabelsPodio();
        this.setVisible(false);
    }
    
    public void reiniciarPodio(){
        this.podio = new LinkedHashMap<>();
        this.ocultarInformacionLabelsPodio();
    }
    
    private void mostrarInformacionLabels(){
        int enPodio = this.podio.size();
        for (int i = 1; i <= enPodio; i++) {
            mostrarInformacionLabels(i);
        }
    }
    
    private void mostrarInformacionLabels(int posicion) {
        switch (posicion) {
            case 1:
                this.lblPrimerLugar.setVisible(true);
                this.lblAvatarP1.setVisible(true);
                this.lblNombreP1.setVisible(true);
                break;
            case 2:
                this.lblSegundoLugar.setVisible(true);
                this.lblAvatarP2.setVisible(true);
                this.lblNombreP2.setVisible(true);
                break;
            case 3:
                this.lblTercerLugar.setVisible(true);
                this.lblAvatarP3.setVisible(true);
                this.lblNombreP3.setVisible(true);
                break;
            default:
                this.lblCuartoLugar.setVisible(true);
                this.lblAvatarP4.setVisible(true);
                this.lblNombreP4.setVisible(true);
                break;
        }
    }

    private void ordenarPodioPuntos() {
        List<Map.Entry<JugadorDTO, Integer>> listaOrdena = 
                new ArrayList<>(this.podio.entrySet());
        listaOrdena.sort(Map.Entry.comparingByValue());
        LinkedHashMap<JugadorDTO, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<JugadorDTO, Integer> datosPosicion : listaOrdena) {
            mapaOrdenado.put(datosPosicion.getKey(), datosPosicion.getValue());
        }
        this.podio.clear();
        this.podio.putAll(mapaOrdenado);
    }
    
    private void asignarInformacionLabelsPodio() {
        int posicision = 1;
        for (Map.Entry<JugadorDTO, Integer> entry : podio.entrySet()) {
            JugadorDTO jugador = entry.getKey();
            Integer puntos = entry.getValue();
            this.asignarInformacionLabelsPodio(jugador, puntos, posicision);
            posicision++;
        }
    }

    private void asignarInformacionLabelsPodio(JugadorDTO jugador,
            Integer puntos,
            int posicion) {
        Icon iconoJugador = new ImageIcon(
                jugador.getAvatar().
                        getImage().
                        getScaledInstance(lblAvatarP1.
                                getWidth(), 
                                lblAvatarP1.getHeight(), 
                                Image.SCALE_DEFAULT));
        switch (posicion) {
            case 1 -> {
                this.lblAvatarP1.setIcon(iconoJugador);
                this.lblNombreP1.setText(jugador.getNombre());
                this.lblPuntajeP1.setText(String.valueOf(puntos));
            }
            case 2 -> {
                this.lblAvatarP2.setIcon(iconoJugador);
                this.lblNombreP2.setText(jugador.getNombre());
                this.lblPuntajeP2.setText(String.valueOf(puntos));
            }
            case 3 -> {
                this.lblAvatarP3.setIcon(iconoJugador);
                this.lblNombreP3.setText(jugador.getNombre());
                this.lblPuntajeP3.setText(String.valueOf(puntos));
            }
            default -> {
                this.lblAvatarP4.setIcon(iconoJugador);
                this.lblNombreP4.setText(jugador.getNombre());
                this.lblPuntajeP4.setText(String.valueOf(puntos));
            }
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
        lblPuntajeP1 = new javax.swing.JLabel();
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

        setTitle("Podio");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
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

        lblPuntajeP1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblPuntajeP1.setForeground(new java.awt.Color(0, 0, 0));
        lblPuntajeP1.setText("0");
        jpnFondo.add(lblPuntajeP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, 30));
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        this.cerrarVentanaPodio();
    }//GEN-LAST:event_formComponentHidden

    public LinkedHashMap<JugadorDTO, Integer> getPodio() {
        return podio;
    }

    public void setPodio(LinkedHashMap<JugadorDTO, Integer> podio) {
        this.podio = podio;
    }

    public int cantidadEnPodio(){
        return this.podio.size();
    }
    
    public void agregarAlPodio(JugadorDTO jugador, Integer puntos) {
        this.podio.put(jugador, puntos);
        this.actualizarPodio();
    }
    
    public void eliminarDelPodio(JugadorDTO jugador){
        this.podio.remove(jugador);
        this.actualizarPodio();
    }
    
    public static FrmPodio getInstance(){
        if(frmPodio == null){
            frmPodio = new FrmPodio();
        }
        return frmPodio;
    }

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
    private javax.swing.JLabel lblPuntajeP1;
    private javax.swing.JLabel lblPuntajeP2;
    private javax.swing.JLabel lblPuntajeP3;
    private javax.swing.JLabel lblPuntajeP4;
    private javax.swing.JLabel lblSegundoLugar;
    private javax.swing.JLabel lblSlots;
    private javax.swing.JLabel lblTercerLugar;
    // End of variables declaration//GEN-END:variables

}
