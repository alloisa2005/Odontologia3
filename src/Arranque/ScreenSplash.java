/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arranque;

import GUI.frmLogin;
import java.awt.*;
import java.awt.SplashScreen;

/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public final class ScreenSplash extends Thread {

    final SplashScreen splash;
    //texto que se muestra a medida que se va cargando el screensplah
    final String[] texto = {"Criollas", "Jinetes", "Tropillas",
        "Rondas", "Resultados", "Informes", "Interfaces gráficas",
        ""};
    private Object GUI;

    public ScreenSplash() {
        splash = SplashScreen.getSplashScreen();
    }

    @Override
    public void run() {
        Image img = null;
//        try {
//           img = ImageIO.read(new File(getClass().getResource("/imagenes/splash1.png").toURI()));
//            //img = new ImageIcon("imagenes/caballo.png").getImage();
//        } catch (Exception e) {
//
//        }

        if (splash != null) {
            Graphics2D g = splash.createGraphics();
//            Graphics2D g2d = (Graphics2D) g;
//    Toolkit toolkit = Toolkit.getDefaultToolkit();
//    Image image = toolkit.getImage("imagenes/cargando.gif");
//    g2d.drawImage(image, 100, 150, null);
            //se pinta texto del array
//            g.drawImage(img, 50, 50, null);
            g.setColor(new Color(219, 200, 135));//color de fondo
            g.fillRect(253, 253, 280, 12);//para tapar texto anterior
            g.setColor(Color.black);//color de texto 
            g.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
            g.drawString("Conectando con la base de datos...", 253, 263);
//            g.setColor(Color.green);//color de barra de progeso
//            g.fillRect(204, 308, (307 / texto.length), 12);//la barra de progreso
//            //se pinta una linea segmentada encima de la barra verde
//            float dash1[] = {2.0f};
//            BasicStroke dashed = new BasicStroke(9.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
//            g.setStroke(dashed);
//            g.setColor(Color.GREEN);//color de barra de progeso
//            g.setColor(new Color(4, 52, 101));
//            g.drawLine(205, 314, 510, 314);
            //se actualiza todo
            splash.update();
            try {
                Thread.sleep(630);
            } catch (InterruptedException e) {
            }
            for (int i = 2; i < texto.length; i++) {
                //se pinta texto del array
                g.setColor(new Color(219, 200, 135));//color de fondo
                g.fillRect(253, 253, 280, 12);//para tapar texto anterior
                g.setColor(Color.black);//color de texto 
                g.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
                g.drawString("Cargando " + texto[i - 1] + "...", 253, 263);
//                g.setColor(Color.green);//color de barra de progeso
//                g.fillRect(204, 308, (i * 307 / texto.length), 12);//la barra de progreso
//                //se pinta una linea segmentada encima de la barra verde
//
//                dashed = new BasicStroke(9.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
//                g.setStroke(dashed);
//                g.setColor(Color.GREEN);//color de barra de progeso
//                g.setColor(new Color(4, 52, 101));
//                g.drawLine(205, 314, 510, 314);
                //se actualiza todo
                splash.update();
                try {
                    Thread.sleep(630);
                } catch (InterruptedException e) {
                }
            }
            splash.close();
        }
        //una vez terminada la animación se muestra la aplicación principal
        try {
            frmLogin frm = new frmLogin(new javax.swing.JFrame(), true);
            frm.setVisible(true);
            frm.toFront();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
