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
 
    public List<Object[]> Valores(int anio) {
        
        List<Object[]> lista = null;                
        
        Conexion.getInstance().getConexion().getTransaction().begin();
        //String query = "select mes, count(*) from (select extract(month from fecha) as mes from consulta where extract(year from fecha) =" + anio + " ) as p group by  mes";
        
        String query = "select cantidad, case when mes = 12 then 'Diciembre' when mes = 11 then 'Noviembre' when mes = 10 then 'Octubre' ";
        query += " when mes = 9 then  'Setiembre' when mes = 8 then 'Agosto' when mes = 7  then 'Julio' when mes = 6 then 'Junio'";
        query += " when mes = 5 then 'Mayo' when mes = 4 then 'Abril' when mes = 3 then 'Marzo' when mes = 2 then 'Febrero'";
        query += " else 'Enero'  end as mesletra  from (select mes as mes, count(*) as cantidad from (" ;
        query += "select extract(month from fecha) as mes from consulta where extract(year from fecha) = " + anio + ") as p group by  mes) as w order by mesletra";
        
        try {
            lista = Conexion.getInstance().getConexion().createNativeQuery(query).getResultList();
            
            Conexion.getInstance().getConexion().getTransaction().commit(); 
        } catch (Exception e) {
            Conexion.getInstance().getConexion().getTransaction().rollback();       
        
        }
        return lista;
    }
}
/*
select cantidad, case when mes = 12 then 'Diciembre' when mes = 11 then 'Noviembre' when mes = 10 then 'Octubre'
when mes = 9 then  'Setiembre' when mes = 8 then 'Agosto' when mes = 7  then 'Julio' when mes = 6 then 'Junio'
when mes = 5 then 'Mayo' when mes = 4 then 'Abril' when mes = 3 then 'Marzo' when mes = 2 then 'Febrero'
else 'Enero'  end as mesletra  from (select mes as mes, count(*) as cantidad from (
select extract(month from fecha) as mes from consulta where extract(year from fecha) = 2017) as p
group by  mes) as w;
*/