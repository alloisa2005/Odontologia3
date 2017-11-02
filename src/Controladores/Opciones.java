/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Consulta;
import IO.Opcion;
import IO.Pago;
import java.util.List;

/**
 *
 * @author User
 */
public class Opciones {
    
    public Opcion unaOpcion(String id) {
        
        Opcion opcion = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            opcion = (Opcion) Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM OPCION where id='" + id + "'", Opcion.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return opcion;
    }
    
    public void eliminarOpcion(String id){
        
        String query = "delete from opcion where id='" + id +"'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            Conexion.getInstance().getConexion().createNativeQuery(query).executeUpdate();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
    }
    
    public List<Opcion> ListaOpciones() {
        
        List<Opcion> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM OPCION order by id", Opcion.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
