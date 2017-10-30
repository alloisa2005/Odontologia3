/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Color;
import java.awt.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TablaRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        super.getTableCellRendererComponent(tabla, value, isSelected, hasFocus, row, column);
        
        String ok = tabla.getValueAt(row, 8).toString();
        
        if(isSelected){
            this.setBackground(tabla.getSelectionBackground());
        }else{
            if(ok.equals("NO")){
                this.setBackground(Color.red);
            }else{
                this.setBackground(Color.WHITE);
            }
        }
        
        return this;
    }
    
    
    
}
