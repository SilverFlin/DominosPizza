/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author JIVB
 */
public class Puntero implements MouseInputListener{
    
    GamePanel gp;

    public Puntero() {
    }
    
    public Puntero(GamePanel gp) {
        this.gp=gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        selecionar(e);
        colocar(e);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    private void selecionar(MouseEvent e) {
        var p=(PlayerHandGraphic) gp.dominoGameGraphic.components.get(1);
        for (var f : p.components) 
            if(f.rec.contains(e.getPoint())){
                p.setSelecionada((PlayerTileGraphic) f);
                gp.repaint();
            }
    }

    private void colocar(MouseEvent e) {
        var p=(PlayerHandGraphic) gp.dominoGameGraphic.components.get(1);
        var b=(BoardGraphic) gp.dominoGameGraphic.components.get(0);
        if(p.getSelecionada()!=null)
            if(b.tablero.contains(e.getPoint())) 
                if(b.centro > e.getX()){
                    var s = p.getSelecionada();
                    b.i-=s.rec.getWidth()-10;
                    if(s.leftNum==s.rightNum)
                        s.setP(new Point((int)b.i, (int)gp.getHeight()/2-40));
                    else
                        s.setP(new Point((int)b.i, (int)gp.getHeight()/2-20));
                    b.add(s);
                    p.setSelecionada(null);
                    p.components.remove(s);
                }else if(b.centro < e.getX()){
                    var s = p.getSelecionada();
                    s.setP(s.p);
                    b.d+=s.rec.getWidth();
                    if(s.leftNum==s.rightNum)
                        s.setP(new Point((int) (b.d+s.rec.getWidth()), (int)gp.getHeight()/2-40));
                    else
                        s.setP(new Point((int) b.d, (int)gp.getHeight()/2-20));
                    b.add(s);
                    p.setSelecionada(null);
                    p.components.remove(s);
                }
        gp.repaint();
    }
    
}
