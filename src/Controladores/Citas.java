/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Cita;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Citas {
    
    public List<Cita> listaDeCitasXFecha(String fecha, String medicoCedula) {
        List<Cita> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        String query = "SELECT * FROM CITA where fecha='" + fecha + "' and medico_id='" + medicoCedula + "' order by hora,minuto";
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Cita.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public Cita unaCita(String fecha, String hora, String minuto, String medicoCedula) {
        Cita cita = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        String query = "SELECT * FROM CITA where fecha='" + fecha + "' and hora='" + hora + "' and minuto='" + minuto+ "' and medico_id='" + medicoCedula + "'";
        
        try {
            cita =  (Cita) Conexion.getInstance().getConexion().createNativeQuery(query, Cita.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return cita;
    }
    
    public void eliminarCita(String id){
        
        String query = "delete from cita where id='" + id +"'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            Conexion.getInstance().getConexion().createNativeQuery(query).executeUpdate();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
    }
}
