/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author JIVB
 */
public class GamePanel extends JPanel {
    
    DominoGameGraphic dgg;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    public GamePanel() {
        dgg = new DominoGameGraphic();
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D)g;
        g2.setRenderingHints(rh);
        dgg.draw(g2);
        
    }
}
