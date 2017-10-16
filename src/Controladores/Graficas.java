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
public class Graficas {
 
    public Object[] Valores(int anio) {
        Object[] lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        String query = "select mes, count(*) from (select extract(month from fecha) as mes from consulta where extract(year from fecha) =" + anio + " ) as p group by  mes";
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query).getResultList().toArray(lista);
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
