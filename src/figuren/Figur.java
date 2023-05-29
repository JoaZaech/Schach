package figuren;

import java.awt.Graphics;
import schach.Bild;

public abstract class Figur {

    public static final int ID_BAUER = 1;
    public static final int ID_TURM = 2;
    public static final int ID_SPRINGER = 3;
    public static final int ID_LAEUFER = 4;
    public static final int ID_DAME = 5;
    public static final int ID_KOENIG = 6;

    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    protected int ID;
    protected Bild bild;
    protected boolean weiss;
    protected int reihe;
    protected int spalte;
    protected boolean[][] Laufmoeglichkeiten;

    public Figur(int pReihe, int pSpalte, boolean pWeiss, int ID) {
        reihe = pReihe;
        spalte = pSpalte;
        weiss = pWeiss;
        this.ID = ID;
        if (weiss == true) {
            bild = new Bild("img/white/" + ID + ".png");
        } else {
            bild = new Bild("img/black/" + ID + ".png");
        }
    }

    public abstract boolean[][] zeigeLaufmoeglichkeiten();

    public boolean isWeiss() {
        return weiss;
    }

    public void male(Graphics g) {
        bild.zeichne(g, reihe * WIDTH, spalte * HEIGHT, WIDTH, HEIGHT);
    }

    public void setzePos(int x, int y) {
        reihe = x;
        spalte = y;
    }
    
    
    public int getX() {
        return reihe;
    }

    public int getY() {
        return spalte;
    }

}
