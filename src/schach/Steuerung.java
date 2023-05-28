package schach;

import figuren.Figur;
import static figuren.Figur.HEIGHT;
import static figuren.Figur.WIDTH;
import java.awt.Color;
import java.awt.Graphics;

public class Steuerung {

    private static Figur[][] Brett;
    private GUI dieGUI;
    private FENReader Reader;
    private Figur SelectedFigur;
    private boolean[][] Laufmoeglichkeiten;

    public Steuerung(GUI dieGUI) {
        Brett = new Figur[8][8];
        SelectedFigur = null;
        for (int i = 0; i < Brett[0].length; i++) {
            for (int j = 0; j < Brett.length; j++) {
                Brett[j][i] = null;
            }
        }
        this.dieGUI = dieGUI;
        Reader = new FENReader(Brett);
        Reader.lese("8/r2R3n/5R2/2n3R1/4N3/1N6/4q3/8");
    }

    public void zeichne(Graphics g) {

        for (int i = 0; i < Brett[0].length; i++) {
            for (int j = 0; j < Brett.length; j++) {
                if (Brett[j][i] != null) {
                    Brett[j][i].male(g);
                }
            }
        }

        if (SelectedFigur != null) {
            for (int i = 0; i < Laufmoeglichkeiten[0].length; i++) {
                for (int j = 0; j < Laufmoeglichkeiten.length; j++) {
                    if (Laufmoeglichkeiten[j][i]) {
                        g.setColor(new Color(255,0,0,60));
                        g.fillRect(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
                    }
                }
            }
        }

    }

    public void SelectFigur(int x, int y) {
        if (Brett[x][y] != null) {
            SelectedFigur = Brett[x][y];
            Laufmoeglichkeiten =  SelectedFigur.zeigeLaufmoeglichkeiten();
        }else {
            SelectedFigur = null;
            Laufmoeglichkeiten = null;
        }
    }
    
    
    public void setzeFigur(int x, int y){
        if(Laufmoeglichkeiten[x][y]){
            Brett[x][y] = SelectedFigur;
            Brett[SelectedFigur.getX()][SelectedFigur.getY()] = null;
            SelectedFigur.setzePos(x, y);
            SelectedFigur = null;
            Laufmoeglichkeiten = null;
        }
    }
    
    public boolean isFigurSelected(){
        return SelectedFigur != null;
    }

    public static Figur[][] getBrett() {
        return Brett;
    }

}
