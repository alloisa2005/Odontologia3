/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Consulta;
import IO.Paciente;
import IO.Pago;
import IO.Usuario;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class frmPagos extends javax.swing.JDialog {

    Date fchHoy = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public frmPagos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();   
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        CargarTablaPacientes(); 
        
        txtPago.setText("");
        panelPago.setVisible(false);
        
        lblFecha.setText(df.format(fchHoy));
        
    }
    
        
    public void CargarTablaPacientes(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().listaDePacientes().iterator();
        
        while (it.hasNext()) {
            Object[] fila = new Object[3];            
            
            Paciente pacAux = it.next();
            Conexion.getInstance().Combinar(pacAux);
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;                               
            fila[2] = pacAux.getDeuda();
            
            modeloTabla.addRow(fila);
        }
        
    }
    
    public void CargarTablaPacienteXApellido(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().listaDePacientesXApellido(txtApellidoBuscar.getText()).iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                Paciente pacAux = it.next();

                Object[] fila = new Object[3];

                fila[0] = pacAux.getId();
                fila[1] = pacAux;                   
                fila[2] = pacAux.getDeuda();                               

                modeloTabla.addRow(fila);
            }
        }else{
            VaciarTabla();
            CargarTablaPacientes();
            JOptionPane.showMessageDialog(this, "No existen resutados para la búsqueda", "Buscar Paciente", JOptionPane.INFORMATION_MESSAGE);
        }               
    }
    
    public void CargarTablaPacienteXId(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Paciente pacAux = Conexion.getInstance().getPacientes().unPaciente(txtIdBuscar.getText());
        
        if(pacAux != null){
            Object[] fila = new Object[3];
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;               
            fila[2] = pacAux.getDeuda();            
            
            modeloTabla.addRow(fila);
        }else{
            
            CargarTablaPacientes();
            
            int resp = JOptionPane.showConfirmDialog(null, "Paciente no existe, desea darlo de alta?", "Buscar Paciente", JOptionPane.YES_NO_OPTION);
            if(resp != 1){
                //aqui pones lo que quieras hacer si la respuesta es SI 
                frmAltaPaciente frm = new frmAltaPaciente(new javax.swing.JDialog(), true, txtIdBuscar.getText(), this);
                frm.toFront();
                frm.setVisible(true);
            }else{
                //y aqui va lo contrario si esque la respuesta seria NO
                txtIdBuscar.setText("");
            }
        }                
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtIdBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtApellidoBuscar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnPago = new javax.swing.JButton();
        btnDetallePagos = new javax.swing.JButton();
        panelPago = new javax.swing.JPanel();
        btnPago1 = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu de Pagos");

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pacientes del Sistema");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblPacientes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre y Apellido", "Monto Adeudado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setRowHeight(23);
        tblPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel13.setText("Buscar por Cédula");

        txtIdBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtIdBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtIdBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdBuscarKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel14.setText("Buscar por Apellido");

        txtApellidoBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtApellidoBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtApellidoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoBuscarKeyTyped(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Enter para filtrar pacientes");

        btnPago.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagar32.png"))); // NOI18N
        btnPago.setText("Nuevo Pago ");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        btnDetallePagos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnDetallePagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver32.png"))); // NOI18N
        btnDetallePagos.setText("Detalle Deuda");
        btnDetallePagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallePagosActionPerformed(evt);
            }
        });

        panelPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btnPago1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnPago1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagar32.png"))); // NOI18N
        btnPago1.setText("Confirmar Pago ");
        btnPago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPago1ActionPerformed(evt);
            }
        });

        txtPago.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        txtPago.setForeground(new java.awt.Color(255, 0, 0));
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Monto a pagar ($)");

        lblFecha.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 0, 0));
        lblFecha.setText("lblFecha");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de Pago");

        javax.swing.GroupLayout panelPagoLayout = new javax.swing.GroupLayout(panelPago);
        panelPago.setLayout(panelPagoLayout);
        panelPagoLayout.setHorizontalGroup(
            panelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPago1)
                .addGap(29, 29, 29))
        );
        panelPagoLayout.setVerticalGroup(
            panelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPago1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPago)
                    .addGroup(panelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetallePagos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnDetallePagos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(panelPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1174, 870));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBuscarKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            if(!txtIdBuscar.getText().equals("")){
                txtApellidoBuscar.setText("");

                VaciarTabla();
                CargarTablaPacienteXId();
            }else{
                VaciarTabla();
                CargarTablaPacientes();
            }
        }
    }//GEN-LAST:event_txtIdBuscarKeyPressed

    public void VaciarTabla(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        modeloTabla.setRowCount(0);
    }
    
    private void txtApellidoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoBuscarKeyPressed
        
        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            if(!txtApellidoBuscar.getText().equals("")){
                txtIdBuscar.setText("");
                
                VaciarTabla();
                CargarTablaPacienteXApellido();
            }else{
                VaciarTabla();
                CargarTablaPacientes();
            }
        }
    }//GEN-LAST:event_txtApellidoBuscarKeyPressed

    private void txtApellidoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoBuscarKeyTyped
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
        }

        c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
    }//GEN-LAST:event_txtApellidoBuscarKeyTyped

    private void txtIdBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBuscarKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        } 
    }//GEN-LAST:event_txtIdBuscarKeyTyped

    private void btnDetallePagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallePagosActionPerformed
        if(tblPacientes.getSelectedRowCount() > 0){
            
            int row = tblPacientes.getSelectedRow();                        
            Paciente paciente = (Paciente) tblPacientes.getModel().getValueAt(row, 1);                                     
            frmDetallePagos frm = new frmDetallePagos(this, true, paciente);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDetallePagosActionPerformed

    private void btnPago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPago1ActionPerformed
        
        if(tblPacientes.getSelectedRowCount() > 0){
            
            Double montoAPagar = Double.parseDouble(txtPago.getText());
            
            int row = tblPacientes.getSelectedRow();   
            
            Paciente paciente = (Paciente) tblPacientes.getModel().getValueAt(row, 1);                                     
            
            if(!txtPago.getText().equals("0") && !txtPago.getText().equals("")){
                
                Iterator<Consulta> it = paciente.getConsultasImpagas().iterator();
                while (it.hasNext() && montoAPagar > 0) {
                    
                    Consulta con = it.next();
                    Double montoAdeudadoXConsulta = con.getMontoAdeudado();
                    
                    Pago pago = new Pago();
                    
                    pago.setFchPago(fchHoy);
                    if(montoAPagar >= montoAdeudadoXConsulta){
                        pago.setMonto(montoAdeudadoXConsulta);  
                        con.setPaga(true);
                        montoAPagar -= montoAdeudadoXConsulta;
                    }else{
                        pago.setMonto(montoAPagar);
                        con.setPaga(false);
                        montoAPagar -= montoAdeudadoXConsulta;
                    }
                    Conexion.getInstance().Guardar(pago);
                    
                    if(!con.getPagos().contains(pago)){
                        con.getPagos().add(pago);
                        Conexion.getInstance().Actualizar(con);
                    }
                    
                    Conexion.getInstance().Combinar(pago);
                    if(!pago.getConsultas().contains(con)){
                        pago.getConsultas().add(con);
                        Conexion.getInstance().Actualizar(pago);
                    }
                }
                JOptionPane.showMessageDialog(this, "Pago realizado con exito", "Nuevo Pago", JOptionPane.INFORMATION_MESSAGE);
                panelPago.setVisible(false);
                VaciarTabla();
                CargarTablaPacientes();
                
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese monto a pagar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
//            if(!txtPago.getText().equals("0") && !txtPago.getText().equals("")){
//                
//                Pago pago = new Pago();
//                
//                //pago.setConsulta((List<Consulta>) con);
//                pago.setFchPago(dteFchConsulta.getDate());
//                pago.setMonto(Double.parseDouble(txtPago.getText()));                               
//                Conexion.getInstance().Guardar(pago);
//                
//                if(!con.getPagos().contains(pago)){
//                    con.getPagos().add(pago);
//                    Conexion.getInstance().Actualizar(con);
//                }
//                
//                Conexion.getInstance().Combinar(pago);
//                if(!pago.getConsultas().contains(con)){
//                    pago.getConsultas().add(con);
//                    Conexion.getInstance().Actualizar(pago);
//                }
//            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPago1ActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        
        if(tblPacientes.getSelectedRowCount() > 0){

            int row = tblPacientes.getSelectedRow();
            Paciente paciente = (Paciente) tblPacientes.getModel().getValueAt(row, 1);
            Double deuda = (Double) tblPacientes.getModel().getValueAt(row, 2);

            if(deuda == 0){
                JOptionPane.showMessageDialog(this, "Paciente no tiene monto por pagar", "Pago de Deuda", JOptionPane.INFORMATION_MESSAGE);
            }else{
                txtPago.setText(paciente.getDeuda().toString());
                panelPago.setVisible(true);
            }

        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPagoActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    /*
    private void tblPacientesMouseClilblFechacked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        
        
    }//GEN-LAST:event_tblPacientesMouseClicked
    */
    
    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {                                          
        panelPago.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetallePagos;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnPago1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JPanel panelPago;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidoBuscar;
    private javax.swing.JTextField txtIdBuscar;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
