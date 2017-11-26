/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Consulta;
import IO.Medico;
import IO.Paciente;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.mapping.Collection;
import javax.help.HelpBroker;
import javax.help.HelpSet;

/**
 *
 * @author User
 */
public class frmReportes extends javax.swing.JDialog implements Printable {

    DefaultComboBoxModel modeloMedicos = new DefaultComboBoxModel();    
    Paciente pacImprimir = null;
    Date fchHoy = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public frmReportes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        panel1.setVisible(false);
        panel2.setVisible(false);
        rbtnConsultasXMedico.setSelected(false);
        
        CargarComboMedicos();
    }
    
//    private void cargarAyuda(){
//        try {
//                // Carga el fichero de ayuda
//                File fichero = new File("src/help/help.hs");
//                URL hsURL = fichero.toURI().toURL();
//
//                // Crea el HelpSet y el HelpBroker
//                HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
//                HelpBroker hb = helpset.createHelpBroker();                
//                
////                // Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem
//                hb.enableHelpOnButton(jButton1, "pacientes", helpset);
//                hb.enableHelpKey(this, "ventana_principal", helpset);
//
//        } catch (Exception e) {
////                logger.error("Error al cargar la ayuda: " + e);
//        }
//    }
    
    public void VaciarTabla(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        modeloTabla.setRowCount(0);
    }
    
    public void CargarTablaPacientes(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().listaDePacientes().iterator();
        
        while (it.hasNext()) {
            Object[] fila = new Object[5];
            
            Paciente pacAux = it.next();
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;   
            fila[2] = pacAux.getDireccion(); 
            fila[3] = pacAux.getTelefono();
            fila[4] = pacAux.getDeuda();            
            
            modeloTabla.addRow(fila);
        }
        
    }
    
    public void CargarComboMedicos() {
        Iterator<Medico> it = Conexion.getInstance().getMedicos().listaDeMedicos().iterator();

        modeloMedicos.addElement("SELECCIONE MÉDICO");

        while (it.hasNext()) {
            Medico med = it.next();
            
            if(med.isActivo()){
                modeloMedicos.addElement(med);
            }
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
        panel1 = new javax.swing.JPanel();
        cmbMedicos = new javax.swing.JComboBox<>();
        btnVerConsultasXMedico = new javax.swing.JButton();
        rbtnDeudaXPaciente = new javax.swing.JRadioButton();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCedulaBuscar = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        txtApellidoBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setResizable(false);

        Grupo1.add(rbtnConsultasXMedico);
        rbtnConsultasXMedico.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        rbtnConsultasXMedico.setText("Consultas por Médico");
        rbtnConsultasXMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultasXMedicoActionPerformed(evt);
            }
        });

        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

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
                .addContainerGap()
                .addComponent(cmbMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnVerConsultasXMedico)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnVerConsultasXMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cmbMedicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Grupo1.add(rbtnDeudaXPaciente);
        rbtnDeudaXPaciente.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        rbtnDeudaXPaciente.setText(" Deuda por paciente");
        rbtnDeudaXPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDeudaXPacienteActionPerformed(evt);
            }
        });

        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel2.setText("Cédula");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Enter para filtrar pacientes");

        txtCedulaBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCedulaBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtCedulaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaBuscarKeyTyped(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText(" Impimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        tblPacientes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre y Apellido", "Dirección", "Teléfono", "Deuda ($)"
            }
        ));
        tblPacientes.setRowHeight(23);
        tblPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPacientes);

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

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel3.setText("Apellido");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedulaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)))
                .addGap(20, 347, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedulaBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(txtApellidoBuscar)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnDeudaXPaciente)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(181, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnConsultasXMedico)
                        .addGap(307, 1001, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(rbtnConsultasXMedico)
                .addGap(4, 4, 4)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(rbtnDeudaXPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1256, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnConsultasXMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultasXMedicoActionPerformed
        
        panel1.setVisible(true);
        panel2.setVisible(false);
    }//GEN-LAST:event_rbtnConsultasXMedicoActionPerformed

    private void cmbMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedicosActionPerformed

    public void Imprimo(){           
           
           PrinterJob job = PrinterJob.getPrinterJob();
           Paper hoja = new Paper();
           hoja.setImageableArea(0, 0, 595, 841);
           hoja.setSize(595, 841);
           try {
              // Diálogo para elegir el formato de impresión
              PageFormat pageFormat = new PageFormat();
              pageFormat.setPaper(hoja);
              
             // job.setPrintable(new ImpFact(listaConsultas,paciete), pageFormat);
              job.setPrintable(this, pageFormat);
              //pageFormat = job.pageDialog(pageFormat);
              if (job.printDialog()) {
                  job.print();
              }
           } catch (Exception e) {
           }    
    }       
    
    private void btnVerConsultasXMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerConsultasXMedicoActionPerformed

        if(cmbMedicos.getSelectedIndex() != 0){
            Medico medico = (Medico) cmbMedicos.getSelectedItem();
            Conexion.getInstance().Combinar(medico);
            Iterator<Consulta> it = medico.getConsultas().iterator();
            
            int cantidadConsultas = 0;
            while (it.hasNext()) {
                Consulta next = it.next();
                cantidadConsultas += 1;
            }
            if(cantidadConsultas == 0){
                JOptionPane.showMessageDialog(this, "Médico no tiene consultas", "Consultas por Médico", JOptionPane.WARNING_MESSAGE);
            }else{
                frmConsultasXMedico frm = new frmConsultasXMedico(new javax.swing.JDialog(), true, medico);
                frm.toFront();
                frm.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione médico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerConsultasXMedicoActionPerformed

    private void rbtnDeudaXPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDeudaXPacienteActionPerformed
        
        panel1.setVisible(false);
        panel2.setVisible(true);        
        
        txtCedulaBuscar.setText("");
        txtApellidoBuscar.setText("");
        VaciarTabla();
        CargarTablaPacientes();
        
        txtCedulaBuscar.requestFocus();
    }//GEN-LAST:event_rbtnDeudaXPacienteActionPerformed

    public void CargarTablaPacienteXIdLike(String id){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().unPacienteLike(id).iterator();
        
        while (it.hasNext()) {
            Paciente pacAux = it.next();
            Object[] fila = new Object[5];
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;   
            fila[2] = pacAux.getDireccion(); 
            fila[3] = pacAux.getTelefono();
            fila[4] = pacAux.getDeuda();
            
            modeloTabla.addRow(fila);
        }               
    }
    
    public void CargarTablaPacienteXId(String id){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Paciente pacAux = Conexion.getInstance().getPacientes().unPaciente(id);
        
        if(pacAux != null){
            Object[] fila = new Object[5];
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;   
            fila[2] = pacAux.getDireccion(); 
            fila[3] = pacAux.getTelefono();
            fila[4] = pacAux.getDeuda();
            
            modeloTabla.addRow(fila);
        }else{
            
            CargarTablaPacientes();                        
        }                
    }
    
    private void txtCedulaBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaBuscarKeyPressed

        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            VaciarTabla();
                           
            if(!txtCedulaBuscar.getText().equals("")){
                txtApellidoBuscar.setText("");

                VaciarTabla();
                CargarTablaPacienteXId(txtCedulaBuscar.getText());
            }else{
                VaciarTabla();
                CargarTablaPacientes();
            }
        }
    }//GEN-LAST:event_txtCedulaBuscarKeyPressed

    private void txtCedulaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaBuscarKeyTyped

        if(txtCedulaBuscar.getText().length() == 8){
            evt.consume();
        }

        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaBuscarKeyTyped

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        if(tblPacientes.getSelectedRowCount() > 0){
            
            int row = tblPacientes.getSelectedRow();                        
            pacImprimir = (Paciente) tblPacientes.getModel().getValueAt(row, 1); 
            Imprimo();
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }                       
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtApellidoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoBuscarKeyPressed
        
        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            if(!txtApellidoBuscar.getText().equals("")){                
                
                VaciarTabla();
                CargarTablaPacienteXApellido();
            }else{
                VaciarTabla();
                CargarTablaPacientes();
            }
        }
    }//GEN-LAST:event_txtApellidoBuscarKeyPressed

    public void CargarTablaPacienteXApellido(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();                
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().listaDePacientesXApellido(txtApellidoBuscar.getText()).iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                Paciente pacAux = it.next();

                Object[] fila = new Object[5];

                fila[0] = pacAux.getId();
                fila[1] = pacAux;   
                fila[2] = pacAux.getDireccion(); 
                fila[3] = pacAux.getTelefono();
                fila[4] = pacAux.getDeuda();

                modeloTabla.addRow(fila);
            }
        }else{
//            VaciarTabla();
//            CargarTablaPacientes();
//            JOptionPane.showMessageDialog(this, "No existen resutados para la búsqueda", "Buscar Paciente", JOptionPane.INFORMATION_MESSAGE);
        }               
    }
    
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

    public String DevuelvoMes(int nroMes){
        String mes = "";
        
        switch(nroMes){
            case 0:  mes = "Enero"; break;
            case 1:  mes = "Febrero";  break;
            case 2:  mes = "Marzo";  break;
            case 3:  mes = "Abril";  break;
            case 4:  mes = "Mayo";  break;
            case 5:  mes = "Junio";  break;
            case 6:  mes = "Julio";  break;
            case 7:  mes = "Agosto";  break;
            case 8:  mes = "Setiembre";  break;
            case 9:  mes = "Octubre";  break;
            case 10: mes = "Noviembre";  break;
            case 11: mes = "Diciembre";  break;
        }
        
        return mes;
    }
    
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVerConsultasXMedico;
    private javax.swing.JComboBox<String> cmbMedicos;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JRadioButton rbtnConsultasXMedico;
    private javax.swing.JRadioButton rbtnDeudaXPaciente;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidoBuscar;
    private javax.swing.JTextField txtCedulaBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
//        throw new UnsupportedOperationException("Not supported yet."); 
        
        int x;
        String s;
        
        if(pageIndex == 0){
            
            try {
               Image img = ImageIO.read(new File("src/Imagenes/listadoDeuda.png").toURI().toURL());
                g.drawImage(img, 5, 5, 590, 410, null);
            } catch (Exception ex) {
            }
            
            // Fecha (Dia)
            g.setFont(new Font("Calibri", Font.BOLD, 11));            
            s = String.valueOf(fchHoy.getDate());
            g.drawString(s, 418, 20);
            
            // Fecha (Mes)
            g.setFont(new Font("Calibri", Font.BOLD, 11));   
            int mes = fchHoy.getMonth();
            s = DevuelvoMes(mes);
            //s = String.valueOf();
            g.drawString(s, 465, 20);
            
            // Fecha (Anio)
            g.setFont(new Font("Calibri", Font.BOLD, 11));               
            s = String.valueOf(fchHoy.getYear()+ 1900);    // el getYear me devuelve en int el año atual menos 1900, por eso le sumo 1900
            //s = String.valueOf();
            g.drawString(s, 544, 20); 
            
            // Nombre y Apellido de paciente
            g.setFont(new Font("Calibri", Font.BOLD, 11)); 
            g.setColor(Color.red);
            s = pacImprimir.toString();
            //s = String.valueOf();
            g.drawString(s, 150, 74);
            
            // Cédula del paciente
            g.setFont(new Font("Calibri", Font.BOLD, 11));  
            g.setColor(Color.red);
            s = pacImprimir.getId();
            //s = String.valueOf();
            g.drawString(s, 400, 74); 
            
            int cantidad = 0;
            double montoTotal = 0.0;
            
            //List<Consulta> listaAux = pacImprimir.getConsultasImpagas();
            //Collections.sort(listaAux);
            
            Iterator<Consulta> it = pacImprimir.getConsultasImpagas().iterator();
            while (it.hasNext()) {
                Consulta consulta = it.next();
                cantidad += 1;
                
                double montoAdeudado = consulta.getMontoAdeudado();
                montoTotal += montoAdeudado;
                
                g.setFont(new Font("Calibri", Font.BOLD, 11));  
                g.setColor(Color.black);
                s = df.format(consulta.getFecha()) + " - " + consulta.getTitulo();
                //s = String.valueOf();
                g.drawString(s, 48, 116+(cantidad*19));
                
                // Monto Consulta
                g.setFont(new Font("Calibri", Font.BOLD, 11));  
                g.setColor(Color.black);
                s = String.valueOf(consulta.getMonto());
                //s = String.valueOf();
                g.drawString(s, 432, 116+(cantidad*19));
                
                // Monto Adeudado por Consulta
                g.setFont(new Font("Calibri", Font.BOLD, 11));  
                g.setColor(Color.black);
                s = String.valueOf(montoAdeudado);
                //s = String.valueOf();
                g.drawString(s, 503, 116+(cantidad*19));
            }
            
            // Monto Adeudado por Consulta
            g.setFont(new Font("Calibri", Font.BOLD, 11));  
            g.setColor(Color.black);
            s = String.valueOf(montoTotal);
            //s = String.valueOf();
            g.drawString(s, 503, 384);
                
            return PAGE_EXISTS;
        }else{
            return NO_SUCH_PAGE;
        }
    }
}
