/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Cita;
import IO.Medico;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class frmAgenda extends javax.swing.JDialog {

    DefaultComboBoxModel modeloMedicos = new DefaultComboBoxModel();
    DefaultListModel modeloCitas = new DefaultListModel();
    Date fchHoy = new Date(); 
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public frmAgenda(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        CargarComboMedicos();
        
        dteFechaCita.setDate(fchHoy);
        
    }

    public void CargarComboMedicos(){
        Iterator<Medico> it = Conexion.getInstance().getMedicos().listaDeMedicosActivos().iterator();        
        
        modeloMedicos.addElement("SELECCIONE MÉDICO");
        
        while (it.hasNext()) {
            modeloMedicos.addElement(it.next());            
        }
        cmbMedicos.setModel(modeloMedicos);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbMedicos = new javax.swing.JComboBox<>();
        jCalendario = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCitas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        dteFechaCita = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        cmbMinuto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnMover = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda de Médico");

        cmbMedicos.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        cmbMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicosActionPerformed(evt);
            }
        });

        jCalendario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCalendario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendarioMouseClicked(evt);
            }
        });
        jCalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarioPropertyChange(evt);
            }
        });

        lstCitas.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        lstCitas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCitasMouseClicked(evt);
            }
        });
        lstCitas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCitasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCitas);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel3.setText("Fecha");

        dteFechaCita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        dteFechaCita.setDateFormatString("dd/MM/yyyy");
        dteFechaCita.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dteFechaCita.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteFechaCitaPropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel7.setText("Hora");

        cmbHora.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        cmbMinuto.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        cmbMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "30" }));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel6.setText("Minuto");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel4.setText("Descripción");

        txtDescripcion.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnMover.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMover.setText("Mover");
        btnMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Citas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                        .addComponent(cmbMedicos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dteFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)
                            .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMedicos)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dteFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1287, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarioMouseClicked

    }//GEN-LAST:event_jCalendarioMouseClicked

    private void jCalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarioPropertyChange

        //System.out.println(evt.getPropertyName());
        if(evt.getPropertyName().equals("calendar")){
            modeloCitas.clear();
            Medico medico = (Medico) cmbMedicos.getSelectedItem();

            String fchStr = df.format(jCalendario.getDate());
            Iterator<Cita> listaCitas = Conexion.getInstance().getCitas().listaDeCitasXFecha(jCalendario.getDate(), medico.getId()).iterator();
            while (listaCitas.hasNext()) {
                modeloCitas.addElement(listaCitas.next());
            }
            lstCitas.setModel(modeloCitas);
            dteFechaCita.setDate(jCalendario.getDate());
        }
    }//GEN-LAST:event_jCalendarioPropertyChange

    private void lstCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCitasMouseClicked

    }//GEN-LAST:event_lstCitasMouseClicked

    private void lstCitasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCitasValueChanged

//        if(lstCitas.getSelectedIndex() != -1){
//
//            Cita cita = (Cita) modeloCitas.getElementAt(lstCitas.getSelectedIndex());
//            txtDescripcion.setText(cita.getDescripcion());
//
//            String fchStr = cita.getfecha();
//            try {
//                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fchStr);
//                dteFechaCita.setDate(date);
//            } catch (ParseException ex) {
//                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            cmbHora.setSelectedItem(cita.getHora());
//            cmbMinuto.setSelectedItem(cita.getMinuto());
//        }
    }//GEN-LAST:event_lstCitasValueChanged

    private void dteFechaCitaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteFechaCitaPropertyChange

        //        if(evt.getPropertyName().equals("date") && ((dteFechaCita.getDate().before(fchHoy)) || ())){
            //            JOptionPane.showMessageDialog(this, "Fecha de cita es anterior al dia de hoy", "Fecha de Cita", JOptionPane.ERROR_MESSAGE);
            //            dteFechaCita.setDate(fchHoy);
            //        }

    }//GEN-LAST:event_dteFechaCitaPropertyChange

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped

        char c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if(cmbMedicos.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Seleccione Médico", "Nueva Cita", JOptionPane.ERROR_MESSAGE);
        }else{
            if(txtDescripcion.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingrese descripción", "Nueva Cita", JOptionPane.ERROR_MESSAGE);
            }else{
                Cita c = new Cita();
                Medico medico = (Medico) cmbMedicos.getSelectedItem();

                c.setDescripcion(txtDescripcion.getText());
                c.setFecha(dteFechaCita.getDate());
                c.setMedico(medico);
                c.setHora(cmbHora.getSelectedItem().toString());
                c.setMinuto(cmbMinuto.getSelectedItem().toString());

                Conexion.getInstance().Guardar(c);        

                CitasXFecha(medico, dteFechaCita.getDate());
                
                txtDescripcion.setText("");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicosActionPerformed
        
        Medico medico = (Medico) cmbMedicos.getSelectedItem();
        Conexion.getInstance().Combinar(medico);
        
        CitasXFecha(medico, fchHoy);
        dteFechaCita.setDate(fchHoy);
        
    }//GEN-LAST:event_cmbMedicosActionPerformed

    public void CitasXFecha(Medico medico, Date fch){               
                
        modeloCitas.clear();

        Iterator<Cita> it = medico.getCitas().iterator();                

        while (it.hasNext()) {
            Cita next = it.next();            

            if(next.getFecha().equals(fch)){
                modeloCitas.addElement(next);
            }
        }

        lstCitas.setModel(modeloCitas);
        
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMover;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMedicos;
    private javax.swing.JComboBox<String> cmbMinuto;
    private com.toedter.calendar.JDateChooser dteFechaCita;
    private com.toedter.calendar.JCalendar jCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstCitas;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
