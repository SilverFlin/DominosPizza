package ui.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class Board extends JPanel {

    int w, h, padding;
    int maxFichas = 6;
    Graphics2D g2;
    Domino domino;
    Point2D.Double p = new Point2D.Double(0, 0);
    ArrayList<Jugador> jugadores;
    Jugador principal;
    Rectangle2D.Double tablero;
    ArrayList<Ficha> usadas;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    public Board() {
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        addMouseMotionListener(new Puntero(this));
        addMouseListener(new Puntero(this));
        w = 508;
        h = 264;
        padding = 10;
        tablero = new Rectangle2D.Double();
        this.domino = new Domino();
        this.jugadores = new ArrayList<>();
        this.usadas = new ArrayList<>();
        jugadoresTemporales();
        asignarfichasRandom();
        principal = jugadores.get(3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setRenderingHints(rh);

        tablero.setRect(this.getWidth() / 2 - w / 2, this.getHeight() / 2 - h / 2, w, h);

        g2.setPaint(new Color(102, 102, 102));
        g2.fillRect(0, 0, this.getWidth(), this.getWidth());

        pintarTablero(g2);
        pintarJugadores(g2);
        lugaresFichas();
        pintarHover(g2);
        pintarSelecionada(g2);
        pintarJugadorPrincipal(g2);
        pintarFichasPool(g2);
        pintarFichasEnTablero(g2);
        pintarSelecionadaPuntero(g2);
        repaint();
    }

    private void pintarTablero(Graphics2D g2) {
        g2.setPaint(Color.white);
        g2.fill(tablero);
    }

    private void pintarJugadores(Graphics2D g2) {

        var img = jugadores.get(0).getPosicion("arriba");
        g2.drawImage(img, null, (this.getWidth() / 2) - img.getWidth() / 2, (this.getHeight() / 2) - padding - h / 2 - img.getHeight());

        img = jugadores.get(1).getPosicion("lateral");
        g2.drawImage(img, null, (this.getWidth() / 2) - w / 2 - padding - img.getWidth(), (this.getHeight() / 2) - img.getHeight() / 2);

        img = jugadores.get(2).getPosicion("lateral");
        g2.drawImage(img, null, (this.getWidth() / 2) + w / 2 + padding, (this.getHeight() / 2) - img.getHeight() / 2);
    }

    private void pintarJugadorPrincipal(Graphics2D g2) {
        ArrayList<Ficha> f = principal.getFichas();
        g2.drawImage(jugadores.get(3).getAvatar(), null, this.getWidth() / 2 - w / 2, this.getHeight() / 2 + h / 2 + padding);

        for (int i = 0; i < jugadores.get(3).getFichas().size(); i++) {
            g2.drawImage(f.get(i).getImagen(), null,
                    (int) f.get(i).getRec().getX(),
                    (int) f.get(i).getRec().getY());
        }
    }

    private void pintarFichasPool(Graphics2D g2) {
        g2.setPaint(new Color(154, 154, 154));
        g2.fillRect(0, this.getHeight() - 70, 70, 70);
        g2.setPaint(Color.black);
        g2.drawString("POOL", 15, this.getHeight() - 70 + padding + 20);
        g2.drawString("X" + domino.fichas.size(), 15, this.getHeight() - 70 + padding + 30);
    }

    private void asignarfichasRandom() {
        for (var jugador : jugadores) {
            for (int i = 0; i < maxFichas; i++) {
                jugador.getFichas().add(new Ficha(domino.getUnaFicha()));
            }
        }
    }

    private void jugadoresTemporales() {
        jugadores.add(new Jugador());
        jugadores.add(new Jugador());
        jugadores.add(new Jugador());
        jugadores.add(new Jugador());
    }

    private void pintarHover(Graphics2D g2) {
        g2.setPaint(Color.BLUE);
        for (var mf : principal.getFichas()) {
            if (mf.getRec().contains(p)) {
                g2.fillRect((int) mf.getRec().getX() - 5, (int) mf.getRec().getY() - 5, 50, 90);
            }
        }
    }

    private void lugaresFichas() {
        for (int i = 0; i < principal.getFichas().size(); i++) {
            principal.getFichas().get(i).setRec(
                    new Rectangle2D.Double(this.getWidth() / 2 - w / 2 + principal.getAvatar().getWidth() + padding - 5 + 50 * i,
                            this.getHeight() / 2 + h / 2 + padding - 5,
                            40, 80));
        }
    }

    private void pintarSelecionada(Graphics2D g2) {
        g2.setPaint(Color.GREEN);
        if (principal.selecionada != null) {
            g2.fillRect((int) principal.selecionada.getRec().getX() - 5, (int) principal.selecionada.getRec().getY() - 5, 50, 90);
        }
    }

    private void pintarFichasEnTablero(Graphics2D g2) {
        for (var u : usadas) {
            g2.drawImage(u.getImagen(), null, (int) u.getRec().getX(), (int) u.getRec().getY());
        }
    }

    private void pintarSelecionadaPuntero(Graphics2D g2) {
        if (principal.selecionada != null) {
            g2.drawImage(principal.selecionada.getImagen(), null, (int) p.getX() - 20, (int) p.getY() - 40);
            g2.setPaint(new Color(200, 200, 200, 90));
            g2.fillRoundRect((int) p.getX() - 20, (int) p.getY() - 40, 40, 80, 15, 15);
        }

    }

}
