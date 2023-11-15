/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import domain.PlayerTile;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author JIVB
 */
public class Tile {
    PlayerTile playerTile;
    BufferedImage imagen;
    Rectangle2D.Double rec= new Rectangle2D.Double(0,0,40,80);
    
    public Tile() {
    }

    public Tile(PlayerTile playerTile,int x, int y) {
        this.playerTile=playerTile;
        rec=new Rectangle2D.Double(x,y,40,80);
        crearFicha();
    }
    
    
    
    

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public Rectangle2D.Double getRec() {
        return rec;
    }

    public void setRec(Rectangle2D.Double rec) {
        this.rec = rec;
    }

    public PlayerTile getPlayerTile() {
        return playerTile;
    }

    public void setPlayerTile(PlayerTile playerTile) {
        this.playerTile = playerTile;
    }
    
    public  void crearFicha(){
        imagen=new BufferedImage(80, 40, BufferedImage.TRANSLUCENT);
        var b = imagen.createGraphics();
        
        b.setColor(Color.white);
        b.fillRoundRect(0,0, 80, 40, 15, 15);
        b.setColor(Color.black);
        b.fillRect(38, 2, 4,38);
        
        b.drawImage(cara(playerTile.getLeftValue()), null, 0, 0);
        b.drawImage(cara(playerTile.getRightValue()), null, 40, 0);
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
    
}
