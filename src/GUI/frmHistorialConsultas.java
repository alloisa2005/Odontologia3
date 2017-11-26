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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class frmHistorialConsultas extends javax.swing.JDialog {

    Date hoy = new Date();    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    int edad = 0; 
    
    public frmHistorialConsultas(javax.swing.JDialog parent, boolean modal, Paciente paciente) {
        super(parent, modal);
        initComponents();                
        
        //tblConsultas.setRowSorter(new TableRowSorter<TableModel>(tblConsultas.getModel()));
        
        String FchNac = df.format(paciente.getFchNac());
        String FchHoy = df.format(hoy);
        int anios = Conexion.getInstance().getProcedimientos().CalcularEdad(FchNac, FchHoy);
        lblEdad.setText(String.valueOf(anios));        
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage());  
        
        lblId.setText(paciente.getId());
        lblNomAp.setText(paciente.toString());                                                

        rbtnTodas.setSelected(true);
        CargarTablaConsultas();
        
    }   
    
    public void VaciarTabla(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblConsultas.getModel();
        
        modeloTabla.setRowCount(0);
    }
    
    public void CargarTablaConsultasPagas(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblConsultas.getModel();
        
        Iterator<Consulta> it = Conexion.getInstance().getPacientes().unPaciente(lblId.getText()).getConsultas().iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                
                Object[] fila = new Object[6];
                Consulta conAux = it.next();
                
                if(conAux.isPaga()){
                    
                    Iterator<Pago> pagos = conAux.getPagos().iterator();
                    Double montoPagado = 0.0;

                    while (pagos.hasNext()) {
                        Pago pagosAux = pagos.next();
                        montoPagado += pagosAux.getMonto();
                    }
                    
                    fila[0] = conAux;
                    fila[1] = df.format(conAux.getFecha());
                    fila[2] = conAux.getTitulo();
                    fila[3] = conAux.getMonto();
                    fila[4] = montoPagado.toString();

                    if(conAux.isPaga()){
                        fila[5] = "SI";
                    }else{
                        fila[5] = "NO";
                    }

                    modeloTabla.addRow(fila);
                }
            }
        }
    }
    
    public void CargarTablaConsultasImpagas(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblConsultas.getModel();
        
        Iterator<Consulta> it = Conexion.getInstance().getPacientes().unPaciente(lblId.getText()).getConsultas().iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                
                Object[] fila = new Object[6];
                Consulta conAux = it.next();
                
                if(!conAux.isPaga()){
                    Iterator<Pago> pagos = conAux.getPagos().iterator();
                    Double montoPagado = 0.0;

                    while (pagos.hasNext()) {
                        Pago pagosAux = pagos.next();
                        montoPagado += pagosAux.getMonto();
                    }
                
                    fila[0] = conAux;
                    fila[1] = df.format(conAux.getFecha());
                    fila[2] = conAux.getTitulo();
                    fila[3] = conAux.getMonto();
                    fila[4] = montoPagado.toString();

                    if(conAux.isPaga()){
                        fila[5] = "SI";
                    }else{
                        fila[5] = "NO";
                    }

                    modeloTabla.addRow(fila);
                }
            }
        }
    }
    
    public void CargarTablaConsultas(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblConsultas.getModel();
        
        //Iterator<Consulta> it = Conexion.getInstance().getPacientes().unPaciente(lblId.getText()).getConsultas().iterator();
        String id = lblId.getText();
        Iterator<Consulta> it = Conexion.getInstance().getConsultas().listaDeConsultasOrdenadasXPaciente(id).iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                
                Object[] fila = new Object[6];
                Consulta conAux = it.next();
                
                Iterator<Pago> pagos = conAux.getPagos().iterator();
                Double montoPagado = 0.0;
                
                while (pagos.hasNext()) {
                    Pago pagosAux = pagos.next();
                    montoPagado += pagosAux.getMonto();
                }
               
                fila[0] = conAux;
                fila[1] = df.format(conAux.getFecha());
                fila[2] = conAux.getTitulo();
                fila[3] = conAux.getMonto();
                fila[4] = montoPagado.toString();
                
                if(conAux.isPaga()){
                    fila[5] = "SI";
                }else{
                    fila[5] = "NO";
                }
                
                modeloTabla.addRow(fila);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNomAp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        rbtnTodas = new javax.swing.JRadioButton();
        rbtnPagas = new javax.swing.JRadioButton();
        rbtnPendientes = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Consultas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Paciente");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("C.I.:");

        lblId.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lblId.setForeground(new java.awt.Color(51, 51, 51));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre y Apellido:");

        lblNomAp.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lblNomAp.setForeground(new java.awt.Color(51, 51, 51));
        lblNomAp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Edad:");

        lblEdad.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(51, 51, 51));
        lblEdad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNomAp, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNomAp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblConsultas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Consulta", "Fecha", "Título", "Monto Consulta", "Monto Pagado", "¿Paga?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConsultas.setRowHeight(23);
        tblConsultas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblConsultas.setShowHorizontalLines(false);
        tblConsultas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblConsultas);

        Grupo1.add(rbtnTodas);
        rbtnTodas.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        rbtnTodas.setText("Todas");
        rbtnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodasActionPerformed(evt);
            }
        });

        Grupo1.add(rbtnPagas);
        rbtnPagas.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        rbtnPagas.setText("Pagas");
        rbtnPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPagasActionPerformed(evt);
            }
        });

        Grupo1.add(rbtnPendientes);
        rbtnPendientes.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        rbtnPendientes.setText("Pendientes de Pago");
        rbtnPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPendientesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver32.png"))); // NOI18N
        jButton1.setText("Ver Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(rbtnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(rbtnPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(rbtnPendientes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTodas)
                    .addComponent(rbtnPagas)
                    .addComponent(rbtnPendientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1365, 846));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodasActionPerformed
        
        VaciarTabla();
        CargarTablaConsultas();
    }//GEN-LAST:event_rbtnTodasActionPerformed

    private void rbtnPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPagasActionPerformed
        
        VaciarTabla();
        CargarTablaConsultasPagas();
    }//GEN-LAST:event_rbtnPagasActionPerformed

    private void rbtnPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPendientesActionPerformed
        
        VaciarTabla();
        CargarTablaConsultasImpagas();
    }//GEN-LAST:event_rbtnPendientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tblConsultas.getSelectedRowCount() > 0){
            
            int row = tblConsultas.getSelectedRow();                        
            Consulta consulta = (Consulta) tblConsultas.getModel().getValueAt(row, 0);                         
            
            frmVerConsulta frm = new frmVerConsulta(new javax.swing.JDialog(), true, consulta);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una consulta de la lista", "Selección de Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNomAp;
    private javax.swing.JRadioButton rbtnPagas;
    private javax.swing.JRadioButton rbtnPendientes;
    private javax.swing.JRadioButton rbtnTodas;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
