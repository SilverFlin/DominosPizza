
package ui.Board;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author José Iván Vázquez Brambila
 */
public class Domino {
    static BufferedImage[] caras=new BufferedImage[7];
    static ArrayList<BufferedImage > fichas= new ArrayList<>(28);
    
    /**
     * @param args the command line arguments
     */
    
    
    public Domino() {
        Domino.hacerCaras();
        Domino.hacerFichas();
        Collections.shuffle(fichas);
    }

    
    public static void hacerFichas(){
        
        int arriba=0,abajo=0;
        
        for(int i=0;i<=28;i++){
            var  ficha = new BufferedImage(40, 80, BufferedImage.TRANSLUCENT);
            var b=ficha.createGraphics();

            b.setColor(Color.white);
            b.fillRoundRect(0,0, 40, 80, 15, 15);
            b.setColor(Color.black);
            b.fillRect(0, 38, 40, 4);
            
            b.drawImage(caras[arriba], null, 0, 0);
            b.drawImage(caras[abajo], null, 0, 40);
            
            b.setPaint(Color.gray);
            b.drawRoundRect(0,0, 39, 79, 15, 15);
            
            fichas.add(ficha);
            if(arriba==6&&abajo==6)return;
            arriba++;
            if(arriba==7){
                abajo++;
                arriba=abajo;
            }
            
        }
    }
    
    public static void hacerCaras(){
        var  cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//0
        var b=cara.createGraphics();
        
        caras[0]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//1
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(16, 16, 8, 8);
        
        caras[1]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//2
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(6, 6, 8, 8);
        b.fillOval(25, 25, 8, 8);
        
        caras[2]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//3
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(16, 16, 8, 8);
        b.fillOval(25, 6, 8, 8);
        b.fillOval(6, 25, 8, 8);
        
        caras[3]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//4
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(6, 6, 8, 8);
        b.fillOval(25, 25, 8, 8);
        b.fillOval(25, 6, 8, 8);
        b.fillOval(6, 25, 8, 8);
        
        caras[4]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//5
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(16, 16, 8, 8);
        b.fillOval(6, 6, 8, 8);
        b.fillOval(25, 25, 8, 8);
        b.fillOval(25, 6, 8, 8);
        b.fillOval(6, 25, 8, 8);
        
        caras[5]=cara;
        
        cara = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//6
        b=cara.createGraphics();
        
        b.setColor(Color.black);
        b.fillOval(6, 16, 8, 8);
        b.fillOval(6, 25, 8, 8);
        b.fillOval(6, 6, 8, 8);
        b.fillOval(25, 16, 8, 8);
        b.fillOval(25, 25, 8, 8);
        b.fillOval(25, 6, 8, 8);
        
        caras[6]=cara;
        
    }
    
    public BufferedImage getUnaFicha(){
        return fichas.remove(fichas.size()-1);
    }
    
}
