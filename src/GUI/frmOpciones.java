/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class frmOpciones extends javax.swing.JFrame {

    /**
     * Creates new form frmOpciones
     */
    public frmOpciones() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage());                 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUsuarios = new javax.swing.JButton();
        btnMedicos = new javax.swing.JButton();
        btnBaseDeDatos = new javax.swing.JButton();
        btnOpGenerales = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opciones de Programa");
        setResizable(false);

        btnUsuarios.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios32.png"))); // NOI18N
        btnUsuarios.setText(" Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnMedicos.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medico32.png"))); // NOI18N
        btnMedicos.setText(" Médicos");
        btnMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicosActionPerformed(evt);
            }
        });

        btnBaseDeDatos.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnBaseDeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bd32.png"))); // NOI18N
        btnBaseDeDatos.setText(" Base de Datos");
        btnBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaseDeDatosActionPerformed(evt);
            }
        });

        btnOpGenerales.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnOpGenerales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opGenerales32.png"))); // NOI18N
        btnOpGenerales.setText(" Op. Generales");
        btnOpGenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpGeneralesActionPerformed(evt);
            }
        });

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda64.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(254, 254, 254)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaseDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBaseDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnOpGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1111, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        frmUsuarios frm = new frmUsuarios(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicosActionPerformed
        
        frmMedicos frm = new frmMedicos(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnMedicosActionPerformed

    private void btnBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaseDeDatosActionPerformed
        
        frmBaseDeDatos frm = null;
        try {
            frm = new frmBaseDeDatos(new javax.swing.JDialog(), true);
        } catch (IOException ex) {
            Logger.getLogger(frmOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnBaseDeDatosActionPerformed

    private void btnOpGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpGeneralesActionPerformed
        
        frmOpGenerales frm = new frmOpGenerales(new javax.swing.JDialog(), true);
        frm.toFront();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnOpGeneralesActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed

        cargarAyuda();
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void cargarAyuda(){
        try {
                // Carga el fichero de ayuda
                File fichero = new File("src/help/help.hs");
                URL hsURL = fichero.toURI().toURL();

                // Crea el HelpSet y el HelpBroker
                HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
                HelpBroker hb = helpset.createHelpBroker();                
                
//                // Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem
                hb.enableHelpOnButton(btnAyuda, "opciones", helpset);
                hb.enableHelpKey(this, "ventana_principal", helpset);

        } catch (Exception e) {
//                logger.error("Error al cargar la ayuda: " + e);
        }
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBaseDeDatos;
    private javax.swing.JButton btnMedicos;
    private javax.swing.JButton btnOpGenerales;
    private javax.swing.JButton btnUsuarios;
    // End of variables declaration//GEN-END:variables
}
