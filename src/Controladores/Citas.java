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
    
    public List<Cita> listaDeCitasXFecha(Date fecha, String medicoCedula) {
        List<Cita> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        String query = "SELECT * FROM CITA where fecha='" + fecha + "' and medico_id='" + medicoCedula + "' order by fecha,hora,minuto";
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query, Cita.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
