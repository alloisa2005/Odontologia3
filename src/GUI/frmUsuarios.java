/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import Controladores.Usuarios;
import IO.Usuario;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class frmUsuarios extends javax.swing.JDialog {

    
    public frmUsuarios(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        CargarTablaUsuario();
    }
    
    public void CargarTablaUsuario(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();
        
        Iterator<Usuario> it = Conexion.getInstance().getUsuarios().listaDeUsuarios().iterator();
        
        while (it.hasNext()) {
            Object[] fila = new Object[5];
            
            Usuario usuAux = it.next();
            
            fila[0] = usuAux;
            fila[1] = usuAux.getNombre();
            fila[2] = usuAux.getApellido();            
            fila[3] = usuAux.getTelefono();
            fila[4] = usuAux.getCelular();
            
            modeloTabla.addRow(fila);
        }
        
    }
    
    public void CargarTablaUsuarioXApellido(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();
        
        Iterator<Usuario> it = Conexion.getInstance().getUsuarios().listaDeUsuariosXApellido(txtApellidoBuscar.getText()).iterator();
        
        if(it.hasNext()){
            while (it.hasNext()) {
                Usuario usuAux = it.next();

                Object[] fila = new Object[5];

                fila[0] = usuAux;
                fila[1] = usuAux.getNombre();
                fila[2] = usuAux.getApellido();            
                fila[3] = usuAux.getTelefono();
                fila[4] = usuAux.getCelular();

                modeloTabla.addRow(fila);
            }
        }else{
            VaciarTabla();
            CargarTablaUsuario();
            JOptionPane.showMessageDialog(this, "No existen resutados para la búsqueda", "Buscar Usuario", JOptionPane.INFORMATION_MESSAGE);
        }               
    }
    
    public void CargarTablaUsuarioXId(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();
        
        Usuario usuAux = Conexion.getInstance().getUsuarios().unUsuario(txtIdBuscar.getText());
        
        if(usuAux != null){
            Object[] fila = new Object[5];
            
            fila[0] = usuAux;
            fila[1] = usuAux.getNombre();
            fila[2] = usuAux.getApellido();            
            fila[3] = usuAux.getTelefono();
            fila[4] = usuAux.getCelular();
            
            modeloTabla.addRow(fila);
        }else{
            
            CargarTablaUsuario();
            //JOptionPane.showMessageDialog(this, "ID de usuario no existe", "Buscar Usuario", JOptionPane.INFORMATION_MESSAGE);
            int resp = JOptionPane.showConfirmDialog(null, "Usuario no existe, desea darlo de alta?", "Buscar Usuario", JOptionPane.YES_NO_OPTION);
            if(resp != 1){
                //aqui pones lo que quieras hacer si la respuesta es SI 
                frmAltaUsuario frm = new frmAltaUsuario(new javax.swing.JDialog(), true, txtIdBuscar.getText(), this);
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

        btnNuevoUsuario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnModificarUsuario = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtIdBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtApellidoBuscar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios del Sistema");

        btnNuevoUsuario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario32.png"))); // NOI18N
        btnNuevoUsuario.setText("Nuevo Usuario");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios del Sistema");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblUsuarios.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Teléfono", "Celular"
            }
        ));
        tblUsuarios.setRowHeight(23);
        tblUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblUsuarios);

        btnModificarUsuario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario32.png"))); // NOI18N
        btnModificarUsuario.setText("Modificar Usuario");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel13.setText("Buscar Usuario por Id");

        txtIdBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtIdBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtIdBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBuscarKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel14.setText("Buscar Usuario por Apellido");

        txtApellidoBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtApellidoBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtApellidoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoBuscarKeyPressed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Enter para filtrar usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1174, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        
        String cadena="";
        frmAltaUsuario frm = new frmAltaUsuario(new javax.swing.JDialog(), true, cadena, this);
        frm.toFront();
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        
        if(tblUsuarios.getSelectedRowCount() > 0){
            
            int row = tblUsuarios.getSelectedRow();                        
            Usuario usuario = (Usuario) tblUsuarios.getModel().getValueAt(row, 0); 

            frmModifiacionUsuario frm = new frmModifiacionUsuario(new javax.swing.JDialog(), true, usuario, this);
            frm.toFront();
            frm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista", "Selección de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }            
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void txtIdBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBuscarKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            if(!txtIdBuscar.getText().equals("")){
                txtApellidoBuscar.setText("");

                VaciarTabla();
                CargarTablaUsuarioXId();
            }else{
                VaciarTabla();
                CargarTablaUsuario();
            }
        }
    }//GEN-LAST:event_txtIdBuscarKeyPressed

    public void VaciarTabla(){
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();
        
        modeloTabla.setRowCount(0);
    }
    
    private void txtApellidoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoBuscarKeyPressed
        
        if((evt.getKeyCode() == KeyEvent.VK_ENTER)){
            
            if(!txtApellidoBuscar.getText().equals("")){
                txtIdBuscar.setText("");
                
                VaciarTabla();
                CargarTablaUsuarioXApellido();
            }else{
                VaciarTabla();
                CargarTablaUsuario();
            }
        }
    }//GEN-LAST:event_txtApellidoBuscarKeyPressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidoBuscar;
    private javax.swing.JTextField txtIdBuscar;
    // End of variables declaration//GEN-END:variables
}
