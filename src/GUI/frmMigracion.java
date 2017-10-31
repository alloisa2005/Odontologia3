/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import Controladores.TablaRender;
import IO.Paciente;
import IO.Usuario;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public class frmMigracion extends javax.swing.JDialog {

    int cantFilas = 0;
    int registroError = 0;
    int registrosOK = 0;
    Double porcentaje = 0.0;
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decf = new DecimalFormat("#.00");
    
    public frmMigracion(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();                
         
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage()); 
        
        jTablaGenerica.setDefaultRenderer(Object.class, new TablaRender());
        
        rbtnPacientes.setSelected(true);
        ArmoTablaPacientes();
        
    }

    public void ArmoTablaPacientes(){
        
        //Array de ‘String’ con los titulos de las columnas 
        String[] columnNames = {"Cédula", "Nombre", "Apellido", "Fch Nacimiento", "Dirección", "Mail", "Teléfono", "Celular", "OK"};        
        DefaultTableModel dm = new DefaultTableModel(columnNames, 0);
        jTablaGenerica.setModel(dm);
         
    }
    
    public void ArmoTablaMedicos(){
        
        //Array de ‘String’ con los titulos de las columnas 
        String[] columnNames = {"Cédula", "Nombre", "Apellido", "Teléfono", "Dirección", "Celular", "Fch Ingreso", "Activo (S/N)", "OK"};        
        DefaultTableModel dm = new DefaultTableModel(columnNames, 0);
        jTablaGenerica.setModel(dm);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaGenerica = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbtnPacientes = new javax.swing.JRadioButton();
        rbtnMedicos = new javax.swing.JRadioButton();
        btnCargar = new javax.swing.JButton();
        txtCantFilas = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantFilasErr = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Migración de Datos");

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Migración De Datos ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTablaGenerica.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTablaGenerica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablaGenerica.setRowHeight(23);
        jTablaGenerica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTablaGenerica);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setText("Migrar:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        Grupo1.add(rbtnPacientes);
        rbtnPacientes.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        rbtnPacientes.setText("Pacientes");
        rbtnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPacientesActionPerformed(evt);
            }
        });

        Grupo1.add(rbtnMedicos);
        rbtnMedicos.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        rbtnMedicos.setText("Médicos");
        rbtnMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMedicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnPacientes)
                .addGap(18, 18, 18)
                .addComponent(rbtnMedicos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPacientes)
                    .addComponent(rbtnMedicos))
                .addContainerGap())
        );

        btnCargar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel32.png"))); // NOI18N
        btnCargar.setText("  Cargar Excel");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        txtCantFilas.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCantFilas.setForeground(new java.awt.Color(255, 0, 0));
        txtCantFilas.setText("0");

        btnValidar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/validar32.png"))); // NOI18N
        btnValidar.setText("  Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Cantidad de Registros:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Cantidad de Registros Erroneos:");

        txtCantFilasErr.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCantFilasErr.setForeground(new java.awt.Color(255, 0, 0));
        txtCantFilasErr.setText("0");

        txtPorcentaje.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtPorcentaje.setText("0");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("% Correctos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantFilasErr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantFilasErr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1251, 774));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMedicosActionPerformed
        
        ArmoTablaMedicos();
    }//GEN-LAST:event_rbtnMedicosActionPerformed

    private void rbtnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPacientesActionPerformed
        jTablaGenerica.setDefaultRenderer(Object.class, new TablaRender());      
        ArmoTablaPacientes();
    }//GEN-LAST:event_rbtnPacientesActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
                       
        cantFilas = 0;
        registroError = 0;
        porcentaje = 0.0;
        
        txtCantFilas.setText(String.valueOf(cantFilas));
        txtCantFilasErr.setText(String.valueOf(registroError));
        txtPorcentaje.setText(String.valueOf(porcentaje));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xls", "xlsx");
        jFileChooser1.setFileFilter(filter);
        
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                this.leer(jFileChooser1.getSelectedFile().getPath());
            } catch (IOException ex) {
                Logger.getLogger(frmMigracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        int cant = jTablaGenerica.getRowCount();
        DefaultTableModel modelo = (DefaultTableModel) jTablaGenerica.getModel();
        ArrayList<Object[]> lista = new ArrayList<Object[]>();
        
        for (int i = 0; i < cant; i++) {
            Paciente pac = new Paciente();            
            
            Object[] fila = new Object[9];
            
            String fchStr    = jTablaGenerica.getModel().getValueAt(i, 3).toString();
            
            pac.setId(jTablaGenerica.getModel().getValueAt(i, 0).toString());
            pac.setNombre(jTablaGenerica.getModel().getValueAt(i, 1).toString());
            pac.setApellido(jTablaGenerica.getModel().getValueAt(i, 2).toString());
            try {
                 pac.setFchNac(df.parse(fchStr));
            } catch (ParseException ex) {
                 Logger.getLogger(frmMigracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            pac.setDireccion(jTablaGenerica.getModel().getValueAt(i, 4).toString());
            pac.setMail(jTablaGenerica.getModel().getValueAt(i, 5).toString());
            pac.setTelefono(jTablaGenerica.getModel().getValueAt(i, 6).toString());
            pac.setCelular(jTablaGenerica.getModel().getValueAt(i, 7).toString());            
            
            fila[0] = pac.getId();
            fila[1] = pac.getNombre();
            fila[2] = pac.getApellido();       fila[3] = df.format(pac.getFchNac());
            fila[4] = pac.getDireccion();      fila[5] = pac.getMail();
            fila[6] = pac.getTelefono();       fila[7] = pac.getCelular();
            fila[8] = "";
            
            if(ValidarPaciente(pac)){
                Conexion.getInstance().Guardar(pac);
                registrosOK +=1 ;
            }else{               
                lista.add(fila);
                //jTablaGenerica.getModel().setValueAt("NO", i-registroError, 8);
                registroError += 1;
//                FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "Excel", "xls", "xlsx");
//                jFileChooser1.setFileFilter(filter);
//                int returnVal = jFileChooser1.showSaveDialog(this);
//                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                    this.escribir(jFileChooser1.getSelectedFile().getPath());
//                }
            }                                     
        }
        
        modelo.setRowCount(0);
        for (int j = 0; j < lista.size(); j++) {
                
            modelo.addRow(lista.get(j));
        }
            
//        DefaultTableModel modeloTabla = (DefaultTableModel) jTablaGenerica.getModel();        
//        modeloTabla.setRowCount(0);
//        jTablaGenerica.setModel(modelo);
      
        JOptionPane.showMessageDialog(this, "Se dieron de alta " + registrosOK + " pacientes", "Alta de Datos", JOptionPane.INFORMATION_MESSAGE);
        
        Double porcentaje = 100 - (((double)registroError/(double)cant)*100);
        if(porcentaje <= 35.0){
            txtPorcentaje.setForeground(Color.red);
        }
        txtCantFilasErr.setText(String.valueOf(registroError));
        txtPorcentaje.setText(String.valueOf(decf.format(porcentaje)));
    }//GEN-LAST:event_btnValidarActionPerformed
    
    private void escribir(String path) {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet("Agenda");
        //cabecera de la hoja de excel
        String[] header = new String[]{"Nombre", "Apellido", "Dirección", "Teléfono"};

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        //Armo cabecera
        XSSFRow rowH = hoja1.createRow(0);
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = rowH.createCell(i);//se crea las celdas para la cabecera, junto con la posición
            cell.setCellStyle(style); // se añade el style crea anteriormente 
            cell.setCellValue(header[i]);
        }

        //generar los datos para el documento
        for (int i = 0; i < jTablaGenerica.getRowCount(); i++) {
            XSSFRow row = hoja1.createRow(i + 1);//se crea las filas
            for (int j = 0; j < jTablaGenerica.getColumnCount(); j++) {
                XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                cell.setCellValue(jTablaGenerica.getValueAt(i, j).toString()); //se añade el contenido       
            }
        }

        //Guardar archivo
        File file;
        file = new File(path);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
//            if (file.exists()) {// si el archivo existe se elimina
//                file.delete();
//                System.out.println("Archivo eliminado");
//            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private boolean ValidarPaciente(Paciente pac){
        boolean ok = true;
        
        if(pac != null){
            if(pac.getId().equals("")){
                ok = false;
            }
            
            Paciente pacAux = Conexion.getInstance().getPacientes().unPaciente(pac.getId());
            if(pacAux != null){  // El nro de cedula del paciente ya existe en la base de datos
                ok = false;
            }
            
            if(ok && pac.getId().length() != 8){
                ok = false;
            }else{
                if(ok && !Conexion.getInstance().getProcedimientos().validarCedula(pac.getId())){
                    ok = false;
                }
            }                        
            
            if(pac.getNombre().equals("") && ok){
                ok = false;
            }
            
            if(ok && pac.getApellido().equals("")){
                ok = false;
            }
        }else{
            ok = false;
        }
        return ok;
    }
    
    private void leer(String path) throws FileNotFoundException, IOException {
        DefaultTableModel mdl = (DefaultTableModel) jTablaGenerica.getModel();
        mdl.setRowCount(0);
        
        FileInputStream file = null;
        XSSFWorkbook worbook = null;
        XSSFSheet sheet = null;
        Row row;
        
        try  {
            file = new FileInputStream(new File(path));
            // leer archivo excel
            worbook = new XSSFWorkbook(file);
            //HSSFWorkbook worbook = new HSSFWorkbook(file);
            //obtener la hoja que se va leer
            sheet = worbook.getSheetAt(0);
            //HSSFSheet  sheet = worbook.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.rowIterator();//iterator();

//            Row row;
            // se recorre cada fila hasta el final
            //me salteo la cabecera
            rowIterator.next();
            while (rowIterator.hasNext()) {
                
                cantFilas += 1;
                
                row = rowIterator.next();
                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                //Para cargar la tabla
                Object[] fila = new Object[9];
                int columna = 0;
                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en específico y se la imprime
                    cell = cellIterator.next();
                    fila[columna] = cell.getStringCellValue();
                    columna++;
                }
                

                if(!"".equals(String.valueOf(fila[0]))){  // Si la 1er columna es vacía de la fila no la cargo en el excel
                   fila[8] = "";
                    mdl.addRow(fila);
                }
            }
            txtCantFilas.setText(String.valueOf(cantFilas));  // Resto uno para no incluir en la cantidad la 1er fila ya que son los titulos de las columnas
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
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
//            java.util.logging.Logger.getLogger(frmMigracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmMigracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmMigracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmMigracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                frmMigracion dialog = new frmMigracion(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaGenerica;
    private javax.swing.JRadioButton rbtnMedicos;
    private javax.swing.JRadioButton rbtnPacientes;
    private javax.swing.JLabel txtCantFilas;
    private javax.swing.JLabel txtCantFilasErr;
    private javax.swing.JLabel txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
