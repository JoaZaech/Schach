package figuren;

import java.awt.Color;
import java.awt.Graphics;
import schach.Bild;
import schach.Brett;
import static schach.Brett.BRETT_HEIGHT;
import static schach.Brett.BRETT_WIDTH;

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

    protected Brett dasBrett;
    protected boolean[][] laufMoeglichkeiten;

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
        laufMoeglichkeiten = new boolean[BRETT_WIDTH][BRETT_HEIGHT];
        resetLaufmoeglichkeiten();
    }

    public abstract void berechneLaufmoeglichkeiten();
    
    protected void resetLaufmoeglichkeiten(){
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
    }
    
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
    
    public void zeichneLaufMoeglichkeiten(Graphics g){
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                if(laufMoeglichkeiten[j][i]){
                    g.setColor(new Color(255, 0, 0, 60));
                    g.fillRect(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
                }
            }
        }
    }
    
    public boolean pruefeFeldMoeglich(int x, int y){
        return laufMoeglichkeiten[x][y];
    }

}
