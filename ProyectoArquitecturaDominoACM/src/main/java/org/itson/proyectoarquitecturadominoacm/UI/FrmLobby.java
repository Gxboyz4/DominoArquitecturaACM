/**
 * FrmLobby.java creado el 19/09/2023.
 */
package org.itson.proyectoarquitecturadominoacm.UI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.itson.libreriatiposdominoacmp.JugadorDTO;
import org.itson.libreriatiposdominoacmp.TipoPaquete;
import org.itson.proyectoarquitecturadominoacm.Jugador.Jugador;
import static org.itson.proyectoarquitecturadominoacm.ProyectoArquitecturaDominoACM.mediador;

/**
 *
 * @author Gabriel Mancinas,Julio Chon,Luis Ayon
 */
public class FrmLobby extends javax.swing.JFrame {

    private String nombreJugador;
    
    /**
     * Creates new form FrmLobby
     */
    public FrmLobby() {
        this.nombreJugador = mediador.getJugador().getNombre();
        initComponents();
        setVisible(true);
        this.setSize(750, 540); //736 x 500
        setIconImage(new ImageIcon(getClass().getResource("/imgFrmPrincipal/iconoGeneral.png")).getImage());
        this.cambirInformacionLider();
    }
    public void cambirInformacionLider(){
        System.out.println("Cambiar informacio lider");
        System.out.println("Jugador lider"+mediador.getPartida().getJugadores().get(0));
        System.out.println("Jugador Local" + mediador.getJugador());
        if(mediador.getPartida().getJugadores().get(0).getId()!=mediador.getJugador().getId())
        {
            cbxFichasPorJugador.setEnabled(false);
            
        }else{
            System.out.println("Entro al else");
             cbxFichasPorJugador.setEnabled(true);
        }
    }
    public void mostrarMensaje(){
        JOptionPane.showMessageDialog(null,"Ya hay una partida creada.", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    public void mostrarInformacion() {
        asignarInformacionJugadores();
        System.out.println("se muestra info");
        
            System.out.println("config"+mediador.getPartida().getNumFichas());
            cbxFichasPorJugador.setSelectedItem(mediador.getPartida().getNumFichas()+"");
          
    }

    public void asignarInformacionJugadores() {
        limpiarInformacion();
        int numJugadores = mediador.getPartida().getJugadores().size();
        if (numJugadores == 1) {
            asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
        } else if (numJugadores == 2) {
            asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
            asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
        } else if (numJugadores == 3) {
            asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
            asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
            asignarInformacionJugador3(mediador.getPartida().getJugadores().get(2));
        } else {
            asignarInformacionJugador1(mediador.getPartida().getJugadores().get(0));
            asignarInformacionJugador2(mediador.getPartida().getJugadores().get(1));
            asignarInformacionJugador3(mediador.getPartida().getJugadores().get(2));
            asignarInformacionJugador4(mediador.getPartida().getJugadores().get(3));
        }
    }
    public void abrirPantallaPartida()
    {
        this.dispose();
        mediador.cerrarPantallaLobby();
        mediador.abrirPantallaPartida();
    }
    public void limpiarInformacion() {
        lblAvatarP1.setIcon(null);
        lblNombreJugadorP1.setText("");
        lblAvatarP2.setIcon(null);
        lblNombreJugadorP2.setText("");
        lblAvatarP3.setIcon(null);
        lblNombreJugadorP3.setText("");
        lblAvatarP4.setIcon(null);
        lblNombreJugadorP4.setText("");
    }

    public void asignarInformacionJugador1(Jugador jugador) {
        Icon icon;
        icon = new ImageIcon(jugador.getAvatar().getImage().getScaledInstance(lblAvatarP1.getWidth(), lblAvatarP1.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP1.setIcon(icon);
        lblNombreJugadorP1.setText(jugador.getNombre());
        lblNombreJugadorP1.setHorizontalAlignment(SwingConstants.CENTER);
        System.out.println(jugador.getListo());
        if(jugador.getListo())
        {
            lblNombreJugadorP1.setForeground(Color.green);
        }else
        {
            lblNombreJugadorP1.setForeground(Color.black);
        }
    }

    public void asignarInformacionJugador2(Jugador jugador) {
        Icon icon;
        icon = new ImageIcon(jugador.getAvatar().getImage().getScaledInstance(lblAvatarP2.getWidth(), lblAvatarP2.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP2.setIcon(icon);
        lblNombreJugadorP2.setText(jugador.getNombre());
        lblNombreJugadorP2.setHorizontalAlignment(SwingConstants.CENTER);
        if(jugador.getListo())
        {
            lblNombreJugadorP2.setForeground(Color.green);
        }else
        {
            lblNombreJugadorP2.setForeground(Color.black);
        }
    }

    public void asignarInformacionJugador3(Jugador jugador) {
        Icon icon;
        icon = new ImageIcon(jugador.getAvatar().getImage().getScaledInstance(lblAvatarP3.getWidth(), lblAvatarP3.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP3.setIcon(icon);
        lblNombreJugadorP3.setText(jugador.getNombre());
        lblNombreJugadorP3.setHorizontalAlignment(SwingConstants.CENTER);
        if(jugador.getListo())
        {
            lblNombreJugadorP3.setForeground(Color.green);
        }else
        {
            lblNombreJugadorP3.setForeground(Color.black);
        }
    }

    public void asignarInformacionJugador4(Jugador jugador) {
        Icon icon;
        icon = new ImageIcon(jugador.getAvatar().getImage().getScaledInstance(lblAvatarP4.getWidth(), lblAvatarP4.getHeight(), Image.SCALE_DEFAULT));
        lblAvatarP4.setIcon(icon);
        lblNombreJugadorP4.setText(jugador.getNombre());
        lblNombreJugadorP4.setHorizontalAlignment(SwingConstants.CENTER);
        if(jugador.getListo())
        {
            lblNombreJugadorP4.setForeground(Color.green);
        }else
        {
            lblNombreJugadorP4.setForeground(Color.black);
        }
    }

    public int obtenerNumFichas() {
        String numFichas = cbxFichasPorJugador.getSelectedItem().toString();
        return Integer.parseInt(numFichas);
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
        cbxFichasPorJugador = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnListo = new javax.swing.JButton();
        lblNombreJugadorP1 = new javax.swing.JLabel();
        lblNombreJugadorP2 = new javax.swing.JLabel();
        lblNombreJugadorP3 = new javax.swing.JLabel();
        lblNombreJugadorP4 = new javax.swing.JLabel();
        lblAvatarP1 = new javax.swing.JLabel();
        lblAvatarP2 = new javax.swing.JLabel();
        lblAvatarP3 = new javax.swing.JLabel();
        lblAvatarP4 = new javax.swing.JLabel();
        lblSlots = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dominó " + this.nombreJugador);
        setMinimumSize(new java.awt.Dimension(755, 540));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpnFondo.setBackground(new java.awt.Color(255, 0, 0));
        jpnFondo.setMinimumSize(new java.awt.Dimension(736, 500));
        jpnFondo.setOpaque(false);
        jpnFondo.setPreferredSize(new java.awt.Dimension(736, 500));
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxFichasPorJugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7" }));
        cbxFichasPorJugador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFichasPorJugadorItemStateChanged(evt);
            }
        });
        jpnFondo.add(cbxFichasPorJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, -1));

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

        btnListo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmLobby/iconoListo.png"))); // NOI18N
        btnListo.setBorderPainted(false);
        btnListo.setContentAreaFilled(false);
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoActionPerformed(evt);
            }
        });
        jpnFondo.add(btnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 190, 70));

        lblNombreJugadorP1.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        lblNombreJugadorP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreJugadorP1.setText("Creador");
        jpnFondo.add(lblNombreJugadorP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, 30));

        lblNombreJugadorP2.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        lblNombreJugadorP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreJugadorP2.setText("Esperando...");
        jpnFondo.add(lblNombreJugadorP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 130, 30));

        lblNombreJugadorP3.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        lblNombreJugadorP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreJugadorP3.setText("Esperando...");
        jpnFondo.add(lblNombreJugadorP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 130, 30));

        lblNombreJugadorP4.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        lblNombreJugadorP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreJugadorP4.setText("Esperando...");
        jpnFondo.add(lblNombreJugadorP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 130, 30));
        jpnFondo.add(lblAvatarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 130, 110));
        jpnFondo.add(lblAvatarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 130, 110));
        jpnFondo.add(lblAvatarP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 130, 110));
        jpnFondo.add(lblAvatarP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 130, 110));

        lblSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmLobby/iconoSlots.png"))); // NOI18N
        lblSlots.setMaximumSize(new java.awt.Dimension(700, 500));
        lblSlots.setMinimumSize(new java.awt.Dimension(700, 500));
        jpnFondo.add(lblSlots, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 690, 240));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgFrmLobby/imgFondoLobby.png"))); // NOI18N
        lblFondo.setMaximumSize(new java.awt.Dimension(700, 500));
        lblFondo.setMinimumSize(new java.awt.Dimension(755, 540));
        lblFondo.setOpaque(true);
        lblFondo.setPreferredSize(new java.awt.Dimension(755, 540));
        jpnFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 500));

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

    private void btnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoActionPerformed
        if(!mediador.getJugador().getListo())
        {
            mediador.getJugador().setListo(true);
            btnListo.setIcon(new ImageIcon(getClass().getResource("/imgFrmLobby/iconoNoListo.png")));
        }else
        {
            mediador.getJugador().setListo(false);
            btnListo.setIcon(new ImageIcon(getClass().getResource("/imgFrmLobby/iconoListo.png")));
        }
        
        mediador.jugadorListo();
//        this.setVisible(false);
//        mediador.getJugador().setFichas(null);
//        //mediador.crearPartida(mediador.getJugador(),obtenerNumFichas());
//        mediador.getPartida().setNumFichas(obtenerNumFichas());
//        mediador.abrirPantallaPartida();
    }//GEN-LAST:event_btnListoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        mediador.cerrarPantallaLobby();
        mediador.getJugador().setListo(false);
        JugadorDTO jugador = new JugadorDTO(mediador.getJugador().getNombre(), mediador.getJugador().getAvatar(),mediador.getJugador().getId());
        mediador.getProxyCliente().eliminarJugador(jugador);
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cbxFichasPorJugadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFichasPorJugadorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
                    // Obtiene el objeto seleccionado
                    String itemSeleccionado = (String) cbxFichasPorJugador.getSelectedItem();
                    int numero = Integer.parseInt(itemSeleccionado);
                    mediador.getPartida().setNumFichas(numero);
                    mediador.configuracionPartida();
                }
    }//GEN-LAST:event_cbxFichasPorJugadorItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        mediador.cerrarPantallaLobby();
        mediador.getJugador().setListo(false);
        JugadorDTO jugador = new JugadorDTO(mediador.getJugador().getNombre(), mediador.getJugador().getAvatar(),mediador.getJugador().getId());
        mediador.getProxyCliente().eliminarJugador(jugador);
        mediador.abrirPantallaMenu();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxFichasPorJugador;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JLabel lblAvatarP1;
    private javax.swing.JLabel lblAvatarP2;
    private javax.swing.JLabel lblAvatarP3;
    private javax.swing.JLabel lblAvatarP4;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombreJugadorP1;
    private javax.swing.JLabel lblNombreJugadorP2;
    private javax.swing.JLabel lblNombreJugadorP3;
    private javax.swing.JLabel lblNombreJugadorP4;
    private javax.swing.JLabel lblSlots;
    // End of variables declaration//GEN-END:variables
}
