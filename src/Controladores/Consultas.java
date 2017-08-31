/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Consulta;
import IO.Medico;
import java.util.Date;
import java.util.List;


public class Consultas {
    
    public Consulta unaConsulta(Long id) {
        Consulta consulta = null;                
        String query = "SELECT * FROM CONSULTA where id = " + id ;
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            consulta = (Consulta) Conexion.getInstance().getConexion().createNativeQuery(query, Consulta.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return consulta;
    }
    
    public List<Consulta> listaDeConsultas() {
        List<Consulta> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM CONSULTA order by id", Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Consulta> listaDeConsultasPagas() {
        List<Consulta> lista = null;                
        String query = "SELECT * FROM CONSULTA where paga='t' order by id ";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Consulta> listaDeConsultasImPagas() {
        List<Consulta> lista = null;                
        String query = "SELECT * FROM CONSULTA where paga='f' order by id ";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Consulta> listaDeConsultasXPaciente(String id) {
        List<Consulta> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM CONSULTA where paciente_id='" + id + "'", Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public Consulta consultaFchMinima() {
        Consulta consulta = null;
        
        String query = "select * from consulta order by fecha asc limit 1";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            
            consulta = (Consulta) Conexion.getInstance().getConexion().createNativeQuery(query, Consulta.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return consulta;
    }
    
    public List<Consulta> consultasEntreFechas(String fchIni, String fchFin) {
        List<Consulta> lista = null;
        
        String query = "select * from consulta where fecha between '" + fchIni + "' and '" + fchFin + "'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
