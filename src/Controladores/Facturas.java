/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Factura;
import java.util.List;

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
    
    public List<Factura> facturasEntreFechas(String fchIni, String fchFin) {
        List<Factura> lista = null;
        
        String query = "select * from factura where fecha between '" + fchIni + "' and '" + fchFin + "'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Factura.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public Factura unaFactura(Long numero) {
        Factura factura = null;
        
        String query = "select * from factura where numero = " + numero;
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            factura = (Factura) Conexion.getInstance().getConexion().createNativeQuery(query, Factura.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return factura;
    }
}
