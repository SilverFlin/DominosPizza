/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 *
 * @author edemb
 */
public class PlayerScoreTextComponent extends GraphicComponent {

    String nombre;
    int score;
    Point2D point;

    public PlayerScoreTextComponent() {
    }

    public PlayerScoreTextComponent(String nombre, int score) {
        this.nombre = nombre;
        this.score = score;
    }

    @Override
    public void draw(Graphics2D g2) {

        g2.setFont(new Font("Arial", Font.BOLD, 24));
        g2.drawString(nombre + ": " + score, (int) this.point.getX(), (int) this.point.getY());

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

}
