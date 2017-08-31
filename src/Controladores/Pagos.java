/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Consulta;
import IO.Pago;
import java.util.List;

/**
 *
 * @author User
 */
public class Pagos {
    
    public List<Pago> listaDePagosXConsulta(String id) {
        List<Pago> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery("SELECT * FROM PAGO where paciente_id='" + id + "'", Consulta.class).getResultList();            
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
