/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Acceso;
import IO.Usuario;
import java.awt.Image;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class frmPrincipal extends javax.swing.JFrame {

    private Usuario usu;
    private byte[] fotoPerfil;
    
    public frmPrincipal(Usuario usuAux) {
        initComponents();
        
        //this.setExtendedState(MAXIMIZED_BOTH); 
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage());                 
        usu = usuAux;
        
        Image aux = new ImageIcon(getClass().getResource("/Imagenes/camara.png")).getImage();                
        ImageIcon perfil = new ImageIcon(aux.getScaledInstance(228, 235, Image.SCALE_DEFAULT));
        lblFoto.setIcon(perfil);
        
        if(usu.getFoto() != null){
           lblFoto.setIcon(usu.getFotoImage());    
           fotoPerfil = usu.getFoto();
        }
        
        lblNombreUsu.setText(usu.getNombre() + " " + usu.getApellido());
        
        inhabilitoBotones();  // Cuando carga el panel deshabilito todos los botones y habilito de acuerdo a los accesos del usuario
        
        accesoUsuarios();        
        
    }
    
    private void inhabilitoBotones(){
        
        btnAgenda.setEnabled(false);
        btnConsultasMedicas.setEnabled(false);
        btnEstadisticas.setEnabled(false);
        btnEstadisticas.setEnabled(false);
        btnOpciones.setEnabled(false);
        btnPersonas.setEnabled(false);
        btnPagos.setEnabled(false);
        btnReportes.setEnabled(false);
    }
    
    private void accesoUsuarios(){
        
        Acceso acceso = usu.getAcceso();
        
        if(acceso != null){
            if(acceso.isAgenda()){
                btnAgenda.setEnabled(true);
            }

            if(acceso.isConsultas()){
                btnConsultasMedicas.setEnabled(true);
            }

            if(acceso.isEstadisticas()){
                btnEstadisticas.setEnabled(true);
            }

            if(acceso.isOpciones()){
                btnOpciones.setEnabled(true);
            }

            if(acceso.isPacientes()){
                btnPersonas.setEnabled(true);
            }

            if(acceso.isPagos()){
                btnPagos.setEnabled(true);
            }

            if(acceso.isReportes()){
                btnReportes.setEnabled(true);
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

        btnPersonas = new javax.swing.JButton();
        btnOpciones = new javax.swing.JButton();
        btnConsultasMedicas = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        btnAgenda = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        lblNombreUsu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software de Gestión de Pacientes");
        setResizable(false);

        btnPersonas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personas32.png"))); // NOI18N
        btnPersonas.setText("Pacientes");
        btnPersonas.setToolTipText("Menu de Personas");
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        btnOpciones.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tools32.png"))); // NOI18N
        btnOpciones.setText("Opciones");
        btnOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionesActionPerformed(evt);
            }
        });

        btnConsultasMedicas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnConsultasMedicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultaMedica32.png"))); // NOI18N
        btnConsultasMedicas.setText("Consultas Médicas");
        btnConsultasMedicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasMedicasActionPerformed(evt);
            }
        });

        btnEstadisticas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/finanzas32.png"))); // NOI18N
        btnEstadisticas.setText("Estadísticas");
        btnEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasActionPerformed(evt);
            }
        });

        btnAgenda.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agenda32.png"))); // NOI18N
        btnAgenda.setText("Agenda");
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportes32.png"))); // NOI18N
        btnReportes.setText("Reportes");

        btnPagos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pago32.png"))); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir32.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        lblNombreUsu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblNombreUsu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConsultasMedicas)
                                .addGap(71, 71, 71)
                                .addComponent(btnEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreUsu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultasMedicas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        setSize(new java.awt.Dimension(1181, 701));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
    
        frmOpciones frm = new frmOpciones();
        frm.toFront();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnOpcionesActionPerformed

    private void btnPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasActionPerformed
        frmPacientes frm = new frmPacientes(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnPersonasActionPerformed

    private void btnConsultasMedicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasMedicasActionPerformed
        frmConsultasMedicas frm = new frmConsultasMedicas(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnConsultasMedicasActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        
        frmPagos frm = new frmPagos(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        
        frmEstadisticas frm = null;
        try {
            frm = new frmEstadisticas(new javax.swing.JDialog(), true);
        } catch (ParseException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnEstadisticasActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        
        frmAgenda frm = new frmAgenda(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgendaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
        this.dispose();
        
        frmLogin frm = new frmLogin(this, true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

        
    }//GEN-LAST:event_lblFotoMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultasMedicas;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnOpciones;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombreUsu;
    // End of variables declaration//GEN-END:variables
}
