/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Cita;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class Conexion {
    
    private int correlativoGraf = 0; 
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();                
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Odontologia3PU");
        private static final EntityManager em = emf.createEntityManager();        
        
        private static final Medicos medicos = new Medicos();
        private static final Usuarios usuarios = new Usuarios();
        private static final Pacientes pac = new Pacientes();
        private static final Procedimientos pro = new Procedimientos();
        private static final Consultas con = new Consultas();
        private static final Pagos pagos = new Pagos();
        private static final Citas citas = new Citas();
        private static final Facturas facturas = new Facturas();
        private static final Graficas graficas = new Graficas();
        private static final Opciones opciones = new Opciones();
        
    }

    public int getCorrelativoGraf() {
        return correlativoGraf;
    }

    public void setCorrelativoGraf(int correlativoGraf) {
        this.correlativoGraf = correlativoGraf;
    }
    
    public EntityManager getConexion(){
        return ConexionHolder.em;
    }
    
    public Citas getCitas(){
        return ConexionHolder.citas;
    }        
    
    public Consultas getConsultas(){
        return ConexionHolder.con;
    }
    
    public Facturas getFacturas(){
        return ConexionHolder.facturas;
    }
    
    public Opciones getOpciones(){
        return ConexionHolder.opciones;
    }
    
    public Graficas getGraficas(){
        return ConexionHolder.graficas;
    }
    
    public Pagos getPagos(){
        return ConexionHolder.pagos;
    }
    
    public Pacientes getPacientes(){
        return ConexionHolder.pac;
    }
    
    public Procedimientos getProcedimientos(){
        return ConexionHolder.pro;
    }
    
    public Medicos getMedicos(){
        return ConexionHolder.medicos;
    }
    
    public Usuarios getUsuarios(){
        return ConexionHolder.usuarios;
    }
    
    public void Guardar(Object object) {
        
        getConexion().getTransaction().begin();
        
        try {
            getConexion().persist(object);
            getConexion().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();            
            getConexion().getTransaction().rollback();
        } 
    }
    
    public void Eliminar(Object object) {
        
        getConexion().getTransaction().begin();
        
        //getConexion().refresh(object);
        
        try {
//            if(getConexion().contains(object)){
//                getConexion().remove(object);
//            }
            
            getConexion().remove(object);
            getConexion().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();            
            getConexion().getTransaction().rollback();
        } 
    }
    
    public void Actualizar(Object object) {
        
        getConexion().getTransaction().begin();
        
        try {
            getConexion().merge(object);
            getConexion().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();            
            getConexion().getTransaction().rollback();
        } 
    }
    
    public void Combinar(Object object) {
        
        getConexion().getTransaction().begin();
        
        try {
            getConexion().refresh(object);
            getConexion().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();            
            getConexion().getTransaction().rollback();
        } 
    }
}
