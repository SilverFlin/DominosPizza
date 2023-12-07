/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author JIVB
 */
public class Tile {
    BufferedImage imagen;
    Rectangle2D.Double recTile= new Rectangle2D.Double(0,0,40,80);
    
    public Tile() {
    }
    
    public Tile(int l,int r,int x,int y){
        recTile.setRect(x, y, 0, 0);
        if(l==r){
            crearFichaVertical(l, r);
            recTile.setRect(x, y, getImagen().getWidth(), getImagen().getHeight());
        }
        else{
            crearFichaHorizontal(l, r);
            recTile.setRect(x, y, getImagen().getWidth(), getImagen().getHeight());
        }
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public Rectangle2D.Double getRec() {
        return recTile;
    }

    public void setRec(Rectangle2D.Double rec) {
        this.recTile = rec;
    }
    
    public void crearFichaHorizontal(int l,int r){
        imagen=new BufferedImage(80, 40, BufferedImage.TRANSLUCENT);
        var b = imagen.createGraphics();
        
        b.setColor(Color.white);
        b.fillRoundRect(0,0, 80, 40, 15, 15);
        b.setColor(Color.black);
        b.fillRect(38, 0, 2,38);
        
        b.drawImage(cara(l), null, 0, 0);
        b.drawImage(cara(r), null, 40, 0);
        
        b.setPaint(Color.gray);
        b.drawRoundRect(0,0, 79, 39, 15, 15);
        
        setImagen(escalar(1.0, 1.0));
    }
    
    public void crearFichaVertical(int ar,int ab){
        
        imagen=new BufferedImage(40, 80, BufferedImage.TRANSLUCENT);
        var b = imagen.createGraphics();
        
        b.setColor(Color.white);
        b.fillRoundRect(0,0, 40, 80, 15, 15);
        b.setColor(Color.black);
        b.fillRect(0, 38,38, 2);
        
        b.drawImage(cara(ar), null, 0, 0);
        b.drawImage(cara(ab), null, 0, 40);
        
        b.setPaint(Color.gray);
        b.drawRoundRect(0,0, 39, 79, 15, 15);
        
        setImagen(escalar(1.0, 1.0));
    }
    
    public BufferedImage cara(int n){
        var  img = new BufferedImage(40, 40, BufferedImage.TRANSLUCENT);//0
        var b=img.createGraphics();
        b.setColor(Color.black);
        
        switch (n){
            case 0 ->{return img;} 
            case 1 ->{b.fillOval(16, 16, 8, 8);}
            case 2 ->{b.fillOval(6, 6, 8, 8);
                        b.fillOval(25, 25, 8, 8);}
            case 3 ->{b.fillOval(16, 16, 8, 8);
                        b.fillOval(25, 6, 8, 8);
                        b.fillOval(6, 25, 8, 8);}
            case 4 ->{b.fillOval(6, 6, 8, 8);
                        b.fillOval(25, 25, 8, 8);
                        b.fillOval(25, 6, 8, 8);
                        b.fillOval(6, 25, 8, 8);}
            case 5 ->{b.fillOval(16, 16, 8, 8);
                        b.fillOval(6, 6, 8, 8);
                        b.fillOval(25, 25, 8, 8);
                        b.fillOval(25, 6, 8, 8);
                        b.fillOval(6, 25, 8, 8);}
            case 6 ->{b.fillOval(6, 16, 8, 8);
                        b.fillOval(6, 25, 8, 8);
                        b.fillOval(6, 6, 8, 8);
                        b.fillOval(25, 16, 8, 8);
                        b.fillOval(25, 25, 8, 8);
                        b.fillOval(25, 6, 8, 8);}
            default ->{throw new AssertionError();}
        }
        return img;
    }
    
    public BufferedImage escalar(double escalaX, double escalaY){
        
        var at = new AffineTransform();
        at.scale(escalaX, escalaY);
        var op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        var fichita = op.filter(getImagen(), null);
        return fichita;
    }
    
}
