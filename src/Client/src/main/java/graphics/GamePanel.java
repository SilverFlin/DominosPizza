/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import domain.PlayerTile;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author JIVB
 */
public class GamePanel extends JPanel {
    
    

    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D)g;
        var pt = new PlayerTile(2,3);
        var p = new PlayerTileGraphic(new Tile(pt,120, 120), g2);
        p.draw();
               
    }
}
