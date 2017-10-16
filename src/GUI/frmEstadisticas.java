/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Consulta;
import IO.Medico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class frmEstadisticas extends javax.swing.JDialog {

    DefaultComboBoxModel modeloMedicos = new DefaultComboBoxModel();
    Date fchHoy = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date fchMinimaConsulta = new Date();

    public frmEstadisticas(javax.swing.JDialog parent, boolean modal) throws ParseException {
        super(parent, modal);
        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage());

        panel1.setVisible(false);
        panel2.setVisible(false);

        CargarComboMedicos();

        dteFchHasta.setDate(fchHoy);
        Consulta con = Conexion.getInstance().getConsultas().consultaFchMinima();
        dteFchDesde.setDate(con.getFecha());
        
        CalcularMontoCobrado();
        
        fchMinimaConsulta = dteFchDesde.getDate();  // Le asigno el valor del día minimo para asignarselo de nuevo si hay error        
        
    }

    public void CargarComboMedicos() {
        Iterator<Medico> it = Conexion.getInstance().getMedicos().listaDeMedicosActivos().iterator();

        modeloMedicos.addElement("SELECCIONE MÉDICO");

        while (it.hasNext()) {
            modeloMedicos.addElement(it.next());
        }
        cmbMedicos.setModel(modeloMedicos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        rbtnConsultasXMedico = new javax.swing.JRadioButton();
        rbtnMontoRecaudado = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        cmbMedicos = new javax.swing.JComboBox<>();
        btnVerConsultasXMedico = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dteFchDesde = new com.toedter.calendar.JDateChooser();
        dteFchHasta = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        lblMontoRecaudado = new javax.swing.JLabel();
        btnVerMontoRecaudado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu de Estadísticas");
        setResizable(false);

        Grupo1.add(rbtnConsultasXMedico);
        rbtnConsultasXMedico.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        rbtnConsultasXMedico.setText("Consultas por Médico");
        rbtnConsultasXMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultasXMedicoActionPerformed(evt);
            }
        });

        Grupo1.add(rbtnMontoRecaudado);
        rbtnMontoRecaudado.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        rbtnMontoRecaudado.setText("Monto recaudado entre fechas");
        rbtnMontoRecaudado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMontoRecaudadoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estadísticas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        cmbMedicos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cmbMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicosActionPerformed(evt);
            }
        });

        btnVerConsultasXMedico.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnVerConsultasXMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver32.png"))); // NOI18N
        btnVerConsultasXMedico.setText("Ver");
        btnVerConsultasXMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerConsultasXMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(cmbMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnVerConsultasXMedico)
                .addGap(25, 25, 25))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerConsultasXMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        jLabel1.setText("Hasta");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        jLabel3.setText("Desde");

        dteFchDesde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        dteFchDesde.setDateFormatString("dd/MM/yyyy");
        dteFchDesde.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dteFchDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteFchDesdePropertyChange(evt);
            }
        });

        dteFchHasta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        dteFchHasta.setDateFormatString("dd/MM/yyyy");
        dteFchHasta.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dteFchHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteFchHastaPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        jLabel4.setText("Monto ($)");

        lblMontoRecaudado.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblMontoRecaudado.setForeground(new java.awt.Color(255, 0, 0));
        lblMontoRecaudado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoRecaudado.setText("0.0");

        btnVerMontoRecaudado.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnVerMontoRecaudado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver32.png"))); // NOI18N
        btnVerMontoRecaudado.setText("Detalle");
        btnVerMontoRecaudado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMontoRecaudadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(dteFchDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dteFchHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMontoRecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerMontoRecaudado)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dteFchHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dteFchDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerMontoRecaudado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMontoRecaudado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnConsultasXMedico)
                            .addComponent(rbtnMontoRecaudado)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(rbtnConsultasXMedico)
                .addGap(4, 4, 4)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(rbtnMontoRecaudado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1162, 784));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedicosActionPerformed

    private void rbtnConsultasXMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultasXMedicoActionPerformed

        panel1.setVisible(true);
        panel2.setVisible(false);
    }//GEN-LAST:event_rbtnConsultasXMedicoActionPerformed

    private void rbtnMontoRecaudadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMontoRecaudadoActionPerformed

        panel1.setVisible(false);
        panel2.setVisible(true);
        
    }//GEN-LAST:event_rbtnMontoRecaudadoActionPerformed

    private void dteFchDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteFchDesdePropertyChange

        if (evt.getPropertyName().equals("date")) {

            if (dteFchDesde.getDate().after(dteFchHasta.getDate())) {
                JOptionPane.showMessageDialog(this, "Fecha Desde debe ser menor a Fecha Hasta", "Error", JOptionPane.ERROR_MESSAGE);
                dteFchDesde.setDate(fchMinimaConsulta);
            } else {
                CalcularMontoCobrado();
            }
        }
    }//GEN-LAST:event_dteFchDesdePropertyChange

    private void CalcularMontoCobrado() {
        String fchIni = df.format(dteFchDesde.getDate());
        String fchFin = df.format(dteFchHasta.getDate());
        double montoRecaudado = 0.0;

        Iterator<Consulta> it = Conexion.getInstance().getConsultas().consultasEntreFechas(fchIni, fchFin).iterator();
        while (it.hasNext()) {
            Consulta consulta = it.next();

            montoRecaudado += consulta.getMonto() - consulta.getMontoAdeudado();
        }

        lblMontoRecaudado.setText(String.valueOf(montoRecaudado));
        lblMontoRecaudado.repaint();
    }

    private void dteFchHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteFchHastaPropertyChange

        if (evt.getPropertyName().equals("date")) {
            if(dteFchDesde.getDate() != null){
                if (dteFchHasta.getDate().before(dteFchDesde.getDate())) {
                    JOptionPane.showMessageDialog(this, "Fecha Hasta debe ser mayor a Fecha Desde", "Error", JOptionPane.ERROR_MESSAGE);
                    dteFchHasta.setDate(fchHoy);
                } else {
                    CalcularMontoCobrado();
                }
            }
        }
    }//GEN-LAST:event_dteFchHastaPropertyChange

    private void btnVerConsultasXMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerConsultasXMedicoActionPerformed
        
        if(cmbMedicos.getSelectedIndex() != 0){
            Medico medico = (Medico) cmbMedicos.getSelectedItem();
            Conexion.getInstance().Combinar(medico);
            
            frmConsultasXMedico frm = new frmConsultasXMedico(new javax.swing.JDialog(), true, medico);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione médico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerConsultasXMedicoActionPerformed

    private void btnVerMontoRecaudadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMontoRecaudadoActionPerformed
        
        String fchIni = df.format(dteFchDesde.getDate());
        String fchFin = df.format(dteFchHasta.getDate());
        
        frmMontoRecaudado frm = new frmMontoRecaudado(new javax.swing.JDialog(), true, fchIni, fchFin, this);
        frm.toFront();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnVerMontoRecaudadoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton btnVerConsultasXMedico;
    private javax.swing.JButton btnVerMontoRecaudado;
    private javax.swing.JComboBox<String> cmbMedicos;
    private com.toedter.calendar.JDateChooser dteFchDesde;
    private com.toedter.calendar.JDateChooser dteFchHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMontoRecaudado;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JRadioButton rbtnConsultasXMedico;
    private javax.swing.JRadioButton rbtnMontoRecaudado;
    // End of variables declaration//GEN-END:variables
}
