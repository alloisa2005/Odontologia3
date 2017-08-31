/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.postgresql.util.Base64;

/**
 *
 * @author User
 */
public class Procedimientos {
    
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
}
