/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import IO.Paciente;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author User
 */
public class frmAltaPaciente extends javax.swing.JDialog {

    Date hoy = new Date();
    DefaultComboBoxModel modeloRoles = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloMedicos = new DefaultComboBoxModel();
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    int edad = 0; 
    private byte[] fotoPerfil;
    private final JDialog padre;

    
    public frmAltaPaciente(javax.swing.JDialog parent, boolean modal, String idPaciente, JDialog padre) {
        super(parent, modal);
        initComponents();        
        dteFchNacimiento.setDate(hoy);
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        txtEdad.setEditable(false);
        
        txtId.setText(idPaciente);                       
        
        txtId.requestFocus();   
        
        Image aux = new ImageIcon(getClass().getResource("/Imagenes/camara.png")).getImage();                
        ImageIcon perfil = new ImageIcon(aux.getScaledInstance(228, 235, Image.SCALE_DEFAULT));
        this.padre = padre;
        lblFoto.setIcon(perfil);
    }
    
    public void LimpiarCampos(){
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        dteFchNacimiento.setDate(hoy);
        txtDireccion.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");  
        txtMail.setText("");
        Image aux = new ImageIcon(getClass().getResource("/Imagenes/camara.png")).getImage();                
        ImageIcon perfil = new ImageIcon(aux.getScaledInstance(228, 235, Image.SCALE_DEFAULT));
        lblFoto.setIcon(perfil);
    }                
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dteFchNacimiento = new com.toedter.calendar.JDateChooser();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Paciente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel2.setText("Cédula");

        txtId.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel5.setText("Nombre");

        dteFchNacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        dteFchNacimiento.setDateFormatString("dd/MM/yyyy");
        dteFchNacimiento.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dteFchNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteFchNacimientoPropertyChange(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel7.setText("Edad");

        txtTelefono.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel8.setText("Mail");

        txtCelular.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel9.setText("Celular");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel10.setText("Foto");

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios32.png"))); // NOI18N
        btnLimpiar.setText("Resetear");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel12.setText("Teléfono");

        txtEdad.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 0, 0));
        txtEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel13.setText("Apellido");

        txtMail.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtMail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel11.setText("Dirección");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(dteFchNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(52, 52, 52)))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtMail)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(152, 152, 152))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dteFchNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(txtEdad)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(11, 11, 11)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMail)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(998, 724));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String sigo = "S";
        String cedula = txtId.getText();
        
        Paciente pacAux = Conexion.getInstance().getPacientes().unPaciente(cedula);
        if(pacAux != null){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Paciente ya existe, valide nro. de cédula ingresado", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtId.requestFocus();
        }
        
        if(txtId.getText().equals("")){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Nro. de cédula requerido", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtId.requestFocus();
        }                
        
        if(txtId.getText().length() != 8){   // Si el largo de la cedula ingresada no es de 8 caracteres, lo considero error
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Nro. de cédula debe ser de 8 digitos", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtId.requestFocus();
        }
        
        boolean validoCedula = Conexion.getInstance().getProcedimientos().validarCedula(cedula);
        if(!validoCedula){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Nro. de cédula incorrecto, verifique por favor", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtId.requestFocus();
        }
        
        if(sigo.equals("S") && txtNombre.getText().equals("")){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Nombre de paciente requerido", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
        }
        
        if(sigo.equals("S") && txtApellido.getText().equals("")){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Apellido de paciente requerido", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtApellido.requestFocus();
        }                
        
        if(sigo.equals("S") && dteFchNacimiento.getDate().after(hoy)){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no puede ser mayor al día de hoy", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            dteFchNacimiento.requestFocus();
        }
        
        if(sigo.equals("S") && txtDireccion.getText().equals("")){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Dirección de paciente requerida", "Validación de datos", JOptionPane.ERROR_MESSAGE);
            txtDireccion.requestFocus();
        }        
        
        if(sigo.equals("S") && !txtMail.getText().equals("") && !Conexion.getInstance().getProcedimientos().ValidarMail(txtMail.getText())){
            sigo = "N";
            JOptionPane.showMessageDialog(this, "Formato de mail incorrecto, por favor corrija.", "Validación de datos", JOptionPane.ERROR_MESSAGE);
        }
        
        if(sigo == "S"){
            
            Paciente pac = new Paciente();
            
            pac.setId(txtId.getText());            
            pac.setNombre(txtNombre.getText());
            pac.setApellido(txtApellido.getText());
            pac.setCelular(txtCelular.getText());
            pac.setTelefono(txtTelefono.getText());
            pac.setDireccion(txtDireccion.getText());
            pac.setFchNac(dteFchNacimiento.getDate());            
            pac.setFoto(fotoPerfil);
            pac.setMail(txtMail.getText());
            
            Conexion.getInstance().Guardar(pac);
            
            JOptionPane.showMessageDialog(this, "Paciente dado de alta exitosamente", "Nuevo Médico", JOptionPane.INFORMATION_MESSAGE);
            
            LimpiarCampos();
            
            try {
                frmPacientes frm = (frmPacientes) padre;
                frm.VaciarTabla();
                frm.CargarTablaPacientes();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        dteFchNacimiento.setDate(hoy);
        txtDireccion.setText("");        
        txtTelefono.setText("");
        txtCelular.setText("");
        
        txtId.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
        }

        c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
        }

        c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }        
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }        
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadKeyTyped

    private void dteFchNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteFchNacimientoPropertyChange
        
        String FchNac = df.format(dteFchNacimiento.getDate());
        String FchHoy = df.format(hoy);
        
        if(evt.getPropertyName().equals("date")){
            int anios = Conexion.getInstance().getProcedimientos().CalcularEdad(FchNac, FchHoy);
            
            txtEdad.setText(String.valueOf(anios));
        }
    }//GEN-LAST:event_dteFchNacimientoPropertyChange

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "gif", "png");
        JFileChooser jFileChooser1 = new JFileChooser();
        
        jFileChooser1.setFileFilter(filter);
        
        int returnVal = jFileChooser1.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        try {
            Image aux = new ImageIcon(jFileChooser1.getSelectedFile().getPath()).getImage();
            ImageIcon perfil = new ImageIcon(aux.getScaledInstance(228, 235, Image.SCALE_DEFAULT));
            lblFoto.setIcon(perfil);
            fotoPerfil = Conexion.getInstance().getProcedimientos().convertirImagen(jFileChooser1.getSelectedFile().getPath());
        } catch (IOException ex) {
        }
    }

    }//GEN-LAST:event_lblFotoMouseClicked

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
       
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        } 
    }//GEN-LAST:event_txtIdKeyTyped

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser dteFchNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
