/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arranque;

/**
 *
 * @author User
 */
public class ConexionBD extends Thread {
    
    public ConexionBD() {
        
    }
    
    @Override
    public void run() {
       
       Controladores.Conexion.getInstance().getConexion();
    }
}
