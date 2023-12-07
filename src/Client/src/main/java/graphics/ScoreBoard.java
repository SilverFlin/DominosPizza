/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 *
 * @author edemb
 */
public class ScoreBoard extends GraphicComposite {

    public ScoreBoard() {

    }

    @Override
    public void draw(Graphics2D g2) {
        int anchoRectangulo = 500;
        int altoRectangulo = 500;

        g2.setColor(Color.GRAY);
        g2.fillRect((rec.width - anchoRectangulo) / 2, (rec.height - altoRectangulo) / 2, anchoRectangulo, altoRectangulo);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 36));
        g2.drawString("Score Board:", 630, 250);

        int x = 600;
        int y = 350;
        /*
        PlayerScoreTextComponent p1 = new PlayerScoreTextComponent();
        p1.setNombre("Emir");
        p1.setScore(20);
        PlayerScoreTextComponent p2 = new PlayerScoreTextComponent();
        p2.setNombre("Luis");
        p2.setScore(20);
        PlayerScoreTextComponent p3 = new PlayerScoreTextComponent();
        p3.setNombre("Oscar");
        p3.setScore(20);
        PlayerScoreTextComponent p4 = new PlayerScoreTextComponent();
        p4.setNombre("Ramon");
        p4.setScore(20);
        this.components.add(p1);
        this.components.add(p2);
        this.components.add(p3);
        this.components.add(p4);
         */
        for (var component : components) {
            PlayerScoreTextComponent p = (PlayerScoreTextComponent) component;
            System.out.println(p.getScore());
            p.setPoint(new Point2D.Double(x, y));
            p.draw(g2);
            y += 50;
        }
    }

}
