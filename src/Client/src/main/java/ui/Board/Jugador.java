    
package ui.Board;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class Jugador {
    
    BufferedImage avatar;
    ArrayList<Ficha> fichas;
    Ficha selecionada=null;
    
    public Jugador(){
        this.avatar=new BufferedImage(54, 54, BufferedImage.TYPE_INT_RGB);
        this.fichas=new ArrayList<>();
    }

    public BufferedImage getAvatar() {
        return avatar;
    }

    public void setAvatar(BufferedImage avatar) {
        this.avatar = avatar;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList fichas) {
        this.fichas = fichas;
    }
    
    public BufferedImage getPosicion(String lugar){
        var img=new BufferedImage(54, 54, BufferedImage.TYPE_INT_RGB);
        switch (lugar) {
            case "arriba" -> { img=new BufferedImage(54+20, 54, BufferedImage.TRANSLUCENT);
                                        img.createGraphics().drawImage(this.getAvatar(), null, 0, 0);
                                        img.createGraphics().setPaint(Color.WHITE);
                                        img.createGraphics().drawString("X"+this.getFichas().size(), 59, 30);}
            case "lateral"->{img=new BufferedImage(54, 54+20, BufferedImage.TRANSLUCENT);
                                            img.createGraphics().drawImage(this.getAvatar(), null, 0, 0);
                                            img.createGraphics().setPaint(Color.WHITE);
                                            img.createGraphics().drawString("X"+this.getFichas().size(), 21, 70);}
            default -> throw new AssertionError();
        }
        return img;
    }
    
    
}
