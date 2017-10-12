/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Factura;

/**
 *
 * @author User
 */
public class Facturas {
    
    public Factura maxFactura() {
        
        Factura factura = null;
        
        String query = "select * from factura order by numero desc limit 1;" ;
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            factura =  (Factura) Conexion.getInstance().getConexion().createNativeQuery(query, Factura.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        
        return factura;
    }
}
