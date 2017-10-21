/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.List;

/**
 *
 * @author User
 */
public class Graficas {
 
    public List<Object[]> ConsultasXMes(int anio) {
        
        List<Object[]> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        //String query = "select mes, count(*) from (select extract(month from fecha) as mes from consulta where extract(year from fecha) =" + anio + " ) as p group by  mes";
        
        String query = "select cantidad, case when mes = 12 then '12-Diciembre' when mes = 11 then '11-Noviembre' when mes = 10 then '10-Octubre' ";
        query += " when mes = 9 then  '09-Setiembre' when mes = 8 then '08-Agosto' when mes = 7  then '07-Julio' when mes = 6 then '06Junio'";
        query += " when mes = 5 then '05-Mayo' when mes = 4 then '04-Abril' when mes = 3 then '03-Marzo' when mes = 2 then '02-Febrero'";
        query += " else '01-Enero'  end as mesletra  from (select mes as mes, count(*) as cantidad from (" ;
        query += "select extract(month from fecha) as mes from consulta where extract(year from fecha) = " + anio + ") as p group by  mes) as w order by mesletra";
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query).getResultList();
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
    
    public List<Object[]> MontoXMes(int anio) {
        
        List<Object[]> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();        
        
        String query = "select monto, case when mes = 12 then '12-Diciembre' when mes = 11 then 'Noviembre' when mes = 10 then '10-Octubre' ";
        query += " when mes = 9 then  'Setiembre' when mes = 8 then 'Agosto' when mes = 7  then 'Julio' when mes = 6 then 'Junio'";
        query += " when mes = 5 then 'Mayo' when mes = 4 then 'Abril' when mes = 3 then 'Marzo' when mes = 2 then 'Febrero'";
        query += " else 'Enero'  end as mesletra  from (select mes as mes, sum(monto) as monto from (" ;
        query += "select extract(month from fchpago) as mes , monto from pago where extract(year from fchpago) = " + anio + ") as p group by  mes) as w order by mesletra";
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query).getResultList();
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
