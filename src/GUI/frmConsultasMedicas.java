/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Opcion;
import IO.Paciente;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class frmConsultasMedicas extends javax.swing.JDialog {

    
    public frmConsultasMedicas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();   
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        CargarTablaPacientes();
    }
    
    public void CargarTablaPacientes(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblPacientes.getModel();
        
        Iterator<Paciente> it = Conexion.getInstance().getPacientes().listaDePacientes().iterator();
        
        while (it.hasNext()) {
            Object[] fila = new Object[5];
            
            Paciente pacAux = it.next();
            
            Conexion.getInstance().Combinar(pacAux);
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;   
            fila[2] = pacAux.getDireccion(); 
            fila[3] = pacAux.getTelefono();
            fila[4] = pacAux.getCelular();            

            
            modeloTabla.addRow(fila);
        }
        
    }
    
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
                fila[4] = pacAux.getCelular();                

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
            Object[] fila = new Object[5];
            
            fila[0] = pacAux.getId();
            fila[1] = pacAux;   
            fila[2] = pacAux.getDireccion(); 
            fila[3] = pacAux.getTelefono();
            fila[4] = pacAux.getCelular(); 
            
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevaConsulta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnHistorial = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtIdBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtApellidoBuscar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu de Pacientes");
        setResizable(false);

        btnNuevaConsulta.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnNuevaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultaMedica32.png"))); // NOI18N
        btnNuevaConsulta.setText("Nueva Consulta");
        btnNuevaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaConsultaActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblPacientes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre y Apellido", "Dirección", "Teléfono", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setRowHeight(23);
        tblPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPacientes);

        btnHistorial.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial32.png"))); // NOI18N
        btnHistorial.setText("Historial de Consultas");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel13.setText("Buscar por Cédula");

        txtIdBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtIdBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtIdBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBuscarKeyPressed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(410, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        setSize(new java.awt.Dimension(1174, 786));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaConsultaActionPerformed
        
        if(tblPacientes.getSelectedRowCount() > 0){
            
            int row = tblPacientes.getSelectedRow();                        
            Paciente paciente = (Paciente) tblPacientes.getModel().getValueAt(row, 1);                         
            
            frmAltaConsulta frm = new frmAltaConsulta(new javax.swing.JDialog(), true, paciente);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnNuevaConsultaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        
        if(tblPacientes.getSelectedRowCount() > 0){
            
            int row = tblPacientes.getSelectedRow();                        
            Paciente paciente = (Paciente) tblPacientes.getModel().getValueAt(row, 1); 

            frmHistorialConsultas frm = new frmHistorialConsultas(new javax.swing.JDialog(), true, paciente);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la lista", "Selección de Paciente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHistorialActionPerformed

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

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed

        cargarAyuda();
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void cargarAyuda(){
        try {
                // Carga el fichero de ayuda
                String id = "5";
                Opcion op = Conexion.getInstance().getOpciones().unaOpcion(id);
                String rutaImagen = op.getValor();
                
                File fichero = new File(rutaImagen);
                //File fichero = new File("src/help/help.hs");
                URL hsURL = fichero.toURI().toURL();

                // Crea el HelpSet y el HelpBroker
                HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
                HelpBroker hb = helpset.createHelpBroker();                
                
//                // Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem
                hb.enableHelpOnButton(btnAyuda, "consultas", helpset);
                hb.enableHelpKey(this, "ventana_principal", helpset);

        } catch (Exception e) {
//                logger.error("Error al cargar la ayuda: " + e);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnNuevaConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidoBuscar;
    private javax.swing.JTextField txtIdBuscar;
    // End of variables declaration//GEN-END:variables
}
