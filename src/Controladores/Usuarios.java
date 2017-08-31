/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Usuario;
import java.util.List;

/**
 *
 * @author User
 */
public class Usuarios {
    
    public Usuario unUsuario(String id) {
        Usuario usu = null;                
        String query = "SELECT * FROM USUARIO where id='" + id + "'";
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            usu = (Usuario) Conexion.getInstance().getConexion().createNativeQuery(query, Usuario.class).getSingleResult();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return usu;
    }
    
    public List<Usuario> listaDeUsuarios() {
        List<Usuario> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM USUARIO order by id", Usuario.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Usuario> listaDeUsuariosXApellido(String apellido) {
        List<Usuario> lista = null;                
        String query = "SELECT * FROM USUARIO where apellido like '" + apellido + "%' order by apellido";
                
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Usuario.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
