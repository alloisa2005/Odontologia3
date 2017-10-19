/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Conexion;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author User
 */
public class frmVerGraficas extends javax.swing.JDialog {

    Date fchHoy = new Date();
    
    public frmVerGraficas(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/molar.png")).getImage());
        
        int anio = fchHoy.getYear() + 1900;
        CrearGrafica(anio);
    }

    public void CrearGrafica(int anio) throws IOException{
        
         JFreeChart grafica = null;         
         
         Iterator<Object[]> it = Conexion.getInstance().getGraficas().ConsultasXMes(anio).iterator();
         
         DefaultCategoryDataset resultado = new DefaultCategoryDataset();
         
         while (it.hasNext()) {
             
            Object[] obj = it.next();  
            
            resultado.setValue(Integer.parseInt(obj[0].toString()), obj[1].toString(), " ");
            //resultado.setValue(Integer.parseInt(), obj[0].toString(), " ");
        }
         
        grafica = ChartFactory.createBarChart3D("Estadísticas de Consultas Por Mes En El Año " + String.valueOf(anio), "Meses", "Consultas", resultado, PlotOrientation.VERTICAL, true, true, false);        
        
        File archivo = new File(System.getProperty("java.io.tmpdir") + "grafica.png");
        archivo.delete();
        
        //File archivo = new File("C:/pepe/grafica.png");
        String path = archivo.getPath();  //"C:/pepe/grafica.png";  //System.getProperty("java.io.tmpdir") + "grafica.png";
        //ChartUtilities.saveChartAsPNG(archivo, grafica, 300, 300);
        ChartUtilities.saveChartAsPNG(archivo, grafica, 1058, 776);
        
        lblUno.setIcon(new ImageIcon(path));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gáficas estadísticas");

        lblUno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblUno, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUno, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1207, 849));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblUno;
    // End of variables declaration//GEN-END:variables
}
