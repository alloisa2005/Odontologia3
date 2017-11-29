/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import IO.Factura;
import IO.LineaFactura;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class frmVerFactura extends javax.swing.JDialog implements Printable{

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Factura facAux = new Factura();
    List<LineaFactura> lineas = null;
    
    public frmVerFactura(javax.swing.JDialog parent, boolean modal, Factura factura) {
        super(parent, modal);
        initComponents();        
        
        facAux = factura;   // La guardo en facAux para dsp poder imprimir                
        
        lineas = facAux.getLineaFacturas();
        
        this.setTitle("Factura Nro.: " + factura.getNumero());

        DibujoFactura(factura);
        
    }

    public void DibujoFactura(Factura factura){
        
        lblNroFactura.setText(factura.getNumero());
        lblPaciente.setText(factura.getPaciente().toString());        
        lblCedula.setText(factura.getPaciente().getId());
        lblMontoTotal.setText(String.valueOf(factura.getMonto()));
        
        Date fchFactura = factura.getFecha();
        int nroMes = fchFactura.getMonth();
        String mes = DevuelvoMes(nroMes);
        lblMes.setText(mes);
        
        lblDia.setText(String.valueOf(factura.getFecha().getDate()));
        lblAnio.setText(String.valueOf(String.valueOf(factura.getFecha().getYear()+ 1900)));   
        
        Iterator<LineaFactura> it = factura.getLineaFacturas().iterator();
        
        int i = 0;
        while (it.hasNext()) {
            i += 1;
            LineaFactura next = it.next();
            
            String fchLinea = df.format(next.getConsulta().getFecha());
            
            if(i == 1){
                lblLinea1.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                lblMonto1.setText(String.valueOf(next.getMonto()));
            }else{
                if(i == 2){
                    lblLinea2.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                    lblMonto2.setText(String.valueOf(next.getMonto()));
                }else{
                    if(i == 3){
                        lblLinea3.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                        lblMonto3.setText(String.valueOf(next.getMonto()));
                    }else{
                        if(i == 4){
                            lblLinea4.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                            lblMonto4.setText(String.valueOf(next.getMonto()));
                        }else{
                            if(i == 5){
                                lblLinea5.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                                lblMonto5.setText(String.valueOf(next.getMonto()));
                            }else{
                                if(i == 6){
                                    lblLinea6.setText(next.getConsulta().getTitulo() + "  -  " + fchLinea);
                                    lblMonto6.setText(String.valueOf(next.getMonto()));
                                }
                            }
                        }
                    }
                }
            }
            
        }
        
    }
    
    @Override
    public int print(Graphics g, PageFormat f, int pageIndex) throws PrinterException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        int x;
        String s;                
        
        Date fchFactura = facAux.getFecha();
        if(pageIndex == 0){            
//            
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.translate(x, 40);
//            g2d.scale(0.65, 0.65); //Reducción de la impresión al 75%
//            tblPacientes.printAll(g);
            
            try {
               Image img = ImageIO.read(new File("src/Imagenes/factura.png").toURI().toURL());
                g.drawImage(img, 5, 5, 590, 410, null);
            } catch (Exception ex) {
            }
            
            // Fecha (Dia)
            g.setFont(new Font("Calibri", Font.BOLD, 11));            
            s = String.valueOf(fchFactura.getDate());
            g.drawString(s, 418, 76);
            
            // Fecha (Mes)
            g.setFont(new Font("Calibri", Font.BOLD, 11));   
            int mes = fchFactura.getMonth();
            s = DevuelvoMes(mes);
            //s = String.valueOf();
            g.drawString(s, 465, 76);
            
            // Fecha (Anio)
            g.setFont(new Font("Calibri", Font.BOLD, 11));               
            s = String.valueOf(fchFactura.getYear()+ 1900);    // el getYear me devuelve en int el año atual menos 1900, por eso le sumo 1900
            //s = String.valueOf();
            g.drawString(s, 544, 76);                                    
            
            // Nro Factura
            g.setFont(new Font("Calibri", Font.BOLD, 11)); 
            g.setColor(Color.red);
            s = facAux.getNumero();
            g.drawString(s, 500, 30);
            
            // Nombre y Apellido de paciente
            g.setFont(new Font("Calibri", Font.BOLD, 11)); 
            g.setColor(Color.red);
            s = facAux.getPaciente().toString();  
            //s = String.valueOf();
            g.drawString(s, 150, 128); 
            
            // Cédula del paciente
            g.setFont(new Font("Calibri", Font.BOLD, 11));  
            g.setColor(Color.red);
            s = facAux.getPaciente().getId();  
            //s = String.valueOf();
            g.drawString(s, 400, 128); 
            
            //double monto = 0.0;
            
            for (int i = 0; i < lineas.size(); i++) {
                LineaFactura linea = lineas.get(i);
                
                g.setColor(Color.black);
                s = linea.getConsulta().getTitulo() + " - " + df.format(linea.getConsulta().getFecha());
                x = 210 + (i*25);
                g.drawString(s, 50, x); 
                
                s = String.valueOf(linea.getMonto()); //linea.getConsulta().getPagos().get(linea.getConsulta().getPagos().size()-1).getMonto().toString();
                g.drawString(s, 508, x);
                //monto += linea.getConsulta().getPagos().get(linea.getConsulta().getPagos().size()-1).getMonto();
            }
            
            s = String.valueOf(facAux.getMonto());  //txtPago.getText();
            g.drawString(s, 508, 380);
            
            return PAGE_EXISTS;
        }else{            
            return NO_SUCH_PAGE;
        }
    }
    
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNroFactura = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        brnImprimir = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblLinea1 = new javax.swing.JLabel();
        lblMonto1 = new javax.swing.JLabel();
        lblLinea2 = new javax.swing.JLabel();
        lblMonto2 = new javax.swing.JLabel();
        lblLinea3 = new javax.swing.JLabel();
        lblMonto3 = new javax.swing.JLabel();
        lblLinea4 = new javax.swing.JLabel();
        lblMonto4 = new javax.swing.JLabel();
        lblLinea5 = new javax.swing.JLabel();
        lblMonto5 = new javax.swing.JLabel();
        lblLinea6 = new javax.swing.JLabel();
        lblMonto6 = new javax.swing.JLabel();
        lblFactura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura Nro.: ");
        setResizable(false);
        getContentPane().setLayout(null);

        lblNroFactura.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblNroFactura.setForeground(new java.awt.Color(255, 0, 0));
        lblNroFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroFactura.setText("jLabel1");
        lblNroFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblNroFactura);
        lblNroFactura.setBounds(870, 30, 140, 30);

        lblPaciente.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(255, 0, 0));
        lblPaciente.setText("jLabel1");
        lblPaciente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblPaciente);
        lblPaciente.setBounds(260, 170, 340, 40);

        brnImprimir.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        brnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        brnImprimir.setText("Re Imprimir");
        brnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(brnImprimir);
        brnImprimir.setBounds(440, 650, 180, 60);

        lblCedula.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 0, 0));
        lblCedula.setText("jLabel1");
        lblCedula.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblCedula);
        lblCedula.setBounds(710, 170, 110, 40);

        lblMontoTotal.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoTotal.setText("jLabel1");
        lblMontoTotal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMontoTotal);
        lblMontoTotal.setBounds(850, 550, 130, 40);

        lblMes.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMes.setText("jLabel1");
        lblMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMes);
        lblMes.setBounds(800, 90, 130, 40);

        lblDia.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDia.setText("jLabel1");
        lblDia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblDia);
        lblDia.setBounds(720, 90, 60, 40);

        lblAnio.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblAnio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnio.setText("jLabel1");
        lblAnio.setVerifyInputWhenFocusTarget(false);
        lblAnio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblAnio);
        lblAnio.setBounds(950, 90, 50, 40);

        lblLinea1.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLinea1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea1);
        lblLinea1.setBounds(90, 290, 750, 40);

        lblMonto1.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto1);
        lblMonto1.setBounds(850, 290, 130, 40);

        lblLinea2.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea2);
        lblLinea2.setBounds(90, 330, 750, 40);

        lblMonto2.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto2);
        lblMonto2.setBounds(850, 330, 130, 40);

        lblLinea3.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea3);
        lblLinea3.setBounds(90, 370, 750, 40);

        lblMonto3.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto3.setToolTipText("");
        lblMonto3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto3);
        lblMonto3.setBounds(850, 370, 130, 40);

        lblLinea4.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea4);
        lblLinea4.setBounds(90, 410, 750, 40);

        lblMonto4.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto4);
        lblMonto4.setBounds(850, 410, 130, 40);

        lblLinea5.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea5);
        lblLinea5.setBounds(90, 450, 750, 40);

        lblMonto5.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto5);
        lblMonto5.setBounds(850, 450, 130, 40);

        lblLinea6.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblLinea6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLinea6);
        lblLinea6.setBounds(90, 490, 750, 40);

        lblMonto6.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        lblMonto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonto6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblMonto6);
        lblMonto6.setBounds(850, 490, 130, 40);

        lblFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.PNG"))); // NOI18N
        lblFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        getContentPane().add(lblFactura);
        lblFactura.setBounds(12, 13, 1035, 616);

        setSize(new java.awt.Dimension(1077, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnImprimirActionPerformed
        Imprimo();
    }//GEN-LAST:event_brnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnImprimir;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JLabel lblLinea1;
    private javax.swing.JLabel lblLinea2;
    private javax.swing.JLabel lblLinea3;
    private javax.swing.JLabel lblLinea4;
    private javax.swing.JLabel lblLinea5;
    private javax.swing.JLabel lblLinea6;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMonto1;
    private javax.swing.JLabel lblMonto2;
    private javax.swing.JLabel lblMonto3;
    private javax.swing.JLabel lblMonto4;
    private javax.swing.JLabel lblMonto5;
    private javax.swing.JLabel lblMonto6;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNroFactura;
    private javax.swing.JLabel lblPaciente;
    // End of variables declaration//GEN-END:variables
}
