/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Opcion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;

/**
 *
 * @author User
 */
public class Procedimientos {
    
    public boolean validarCedula(String cedula){        
        
        //  3.113.736-1
        int valorFinal = 0;
        int[] valores = {2, 9, 8, 7, 6, 3, 4};  
        int largo = cedula.length();  
        int limite = 0; 
        
//        cedula = cedula.trim();
//        
//        for (int i = 0; i < cedula.length() ; i++) {
//            String car = cedula.substring(i, i+1);
//        }
        
        int digitoVer = Integer.parseInt(cedula.substring(7, 8)) ;  // Saco el digito verificador para comparar al final.
        
        //System.out.println("Digito verificador: " + digitoVer);   // 3*2 + 1*9 + 1*8 + 3*7 + 7*6 + 3*3 + 6*4 
        
        for(int i=1; i<largo ; i++){  // Multiplico cada digito de la cedula (menos el dig verificador) por cada elemento del vector "valores"
            
            int digito = Integer.parseInt(cedula.substring(i-1, i));
            valorFinal += digito*valores[i-1];
        }
        //System.out.println("Valor Final: " + valorFinal); 
        
        // Calculo el siguiente numero divisible por 10 a partir del valorFinal
        
        for(int i=0; i <= 10; i++){     //  Al valor final obtengo el numero mayor siguiente que sea divisble entre 10
            if((valorFinal+i)%10==0){
                limite = valorFinal + i;
            }
        }
        
        int digCalculado = limite - valorFinal;
        
        return digitoVer == digCalculado; // Comparo si el digito calculado es igual al ingresado
        //System.out.println("Digito verificador " + digitoVer + " es correcto");
        //System.out.println("Digito verificador " + digitoVer + " NO es correcto");
    }
    
    public boolean ValidarMail(String mail){                
        
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");         
 
        Matcher mather = pattern.matcher(mail);
        return mather.find();        
        
    }
    
    public int CalcularEdad(String fechaNac, String fechaActual) {

        //String fechaInicio = "22/04/1988";
        //String fechaActual = "09/04/2015";
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        fechaActual = df.format(date);
        String[] aFechaIng = fechaNac.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha = fechaActual.split("/");
        Integer diaActual = Integer.parseInt(aFecha[0]);
        Integer mesActual = Integer.parseInt(aFecha[1]);
        Integer anioActual = Integer.parseInt(aFecha[2]);

        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
            
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    dias = b - (diaInicio - diaActual);
                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                //System.out.println(anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }
        
        return anios;        

    }
    
    //Transforma la foto en un array de bytes para poder guardarlo en la BD
    public byte[] convertirImagen(String path) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedImage img = ImageIO.read(new File(path));
            ImageIO.write(img, "png", baos);
            baos.flush();

            String base64String = Base64.encodeBytes(baos.toByteArray());
            baos.close();

            return Base64.decode(base64String);
    }   
    
    public void realizaBackup(String dir) {      
        final List<String> comandos = new ArrayList<String>(); 
        
//        Opcion op = Conexion.getInstance().getOpciones().unaOpcion("2");
//        String dir = op.getValor();  //"C:/DentistaBD";  
                 
        comandos.add("C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe");  
                         
        comandos.add("-h");      
        comandos.add("localhost");        
        comandos.add("-p");      
        comandos.add("5432");      
        comandos.add("-U");      
        comandos.add("postgres");      
        comandos.add("-F");      
        comandos.add("c");      
        comandos.add("-b");      
        comandos.add("-v");      
        comandos.add("-f"); 

        //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+JOptionPane.showInputDialog(null,"Digite o nome do Backup")+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+(Character.getNumericValue(recebe)+1)+" "+getDateTime()+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        //comandos.add("C:\\DentistaBD\\" + JOptionPane.showInputDialog(null,"Escriba nombre de archivo") + ".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        
        File directorio = new File(dir); 
        directorio.mkdir(); 

        comandos.add(dir + JOptionPane.showInputDialog(null,"Escriba nombre de archivo") + ".backup"); 
        comandos.add("Odontologia3");      
        ProcessBuilder pb = new ProcessBuilder(comandos);      

        pb.environment().put("PGPASSWORD", "1234");              

        try {      
            final Process process = pb.start();      

            final BufferedReader r = new BufferedReader(      
                new InputStreamReader(process.getErrorStream()));      
            String line = r.readLine();      
            while (line != null) {      
            System.err.println(line);      
            line = r.readLine();      
            }      
            r.close();      

            process.waitFor();    
            process.destroy(); 
            JOptionPane.showMessageDialog(null,"BackUp realizado con exito en " + dir);  

        } catch (IOException e) {      
            e.printStackTrace();      
        } catch (InterruptedException ie) {      
            ie.printStackTrace();      
        }                                               
    }
    
    public void RestaurarBD(){
        JFileChooser open = new JFileChooser(new File("C:/DentistaBD")); 
        int op = open.showOpenDialog(null); 
        
        if(op == JFileChooser.APPROVE_OPTION){
           File arq = open.getSelectedFile(); 
           String nomeDoArquivo = open.getName(arq);
           
           final List<String> comandos = new ArrayList<String>();      
           comandos.add("C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_restore.exe");
                 
           comandos.add("-h");      
           comandos.add("localhost");      
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");
           comandos.add("-c");
           comandos.add("-d");
           comandos.add("Odontologia3");     
           comandos.add("-v");      
             
           //comandos.add("C:\\BOHib3.6.4\\Backups do Banco de Dados\\bkpBolOcor04102012.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           comandos.add("C:\\DentistaBD\\" + nomeDoArquivo);
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", "1234");        
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();    
               
               }      
               r.close();      
               
               process.waitFor();    
               process.destroy();                
               JOptionPane.showMessageDialog(null,"Restauración realizada con éxito");
               
            } catch (IOException e) {      
               e.printStackTrace();      
            } catch (InterruptedException ie) {      
               ie.printStackTrace();      
            }         
        }    
    }
    
}
