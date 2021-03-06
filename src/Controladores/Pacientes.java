
package Controladores;

import IO.Paciente;
import java.util.List;

/**
 *
 * @author User
 */
public class Pacientes {
    
    public Paciente unPaciente(String id) {
        Paciente paciente = null;  
        
        String query = "SELECT * FROM PACIENTE where id='" + id + "' and activo = 't'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            paciente = (Paciente) Conexion.getInstance().getConexion().createNativeQuery(query, Paciente.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return paciente;
    }
    
    public List<Paciente> unPacienteLike(String id) {
        List<Paciente> lista = null; 
        
        String query = "SELECT * FROM PACIENTE where id like '" + id + "%'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Paciente.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Paciente> listaDePacientes() {
        List<Paciente> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM PACIENTE where activo='t' order by id", Paciente.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Paciente> listaDePacientesInactivos() {
        List<Paciente> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM PACIENTE where activo='f' order by id", Paciente.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Paciente> listaDePacientesCumpleanos(String fch) {
        List<Paciente> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM PACIENTE where fchnac='" + fch + "' order by id", Paciente.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Paciente> listaDePacientesXApellido(String apellido) {
        List<Paciente> lista = null;   
        
        String query = "SELECT * FROM PACIENTE where apellido like '" + apellido + "%' order by apellido";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Paciente.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
