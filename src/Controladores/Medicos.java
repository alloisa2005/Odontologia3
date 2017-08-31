/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Medico;
import java.util.List;

/**
 *
 * @author User
 */
public class Medicos {
    
    public Medico unMedico(String id) {
        Medico medico = null;                
        String query = "SELECT * FROM MEDICO where id='" + id + "'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            medico = (Medico) Conexion.getInstance().getConexion().createNativeQuery(query, Medico.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return medico;
    }
    
    public List<Medico> listaDeMedicos() {
        List<Medico> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM MEDICO order by id", Medico.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    
    public List<Medico> listaDeMedicosActivos() {
        List<Medico> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM MEDICO where activo='t' order by id", Medico.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Medico> listaDeMedicosXApellido(String apellido) {
        List<Medico> lista = null;   
        
        String query = "SELECT * FROM MEDICO where apellido like '" + apellido + "%' order by apellido";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Medico.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
