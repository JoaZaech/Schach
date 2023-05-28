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
        Reader.lese("8/3r2R1/8/2R2R1r/8/1r2R3/6r1/8");
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
        } else {
            SelectedFigur = null;
        }
    }
    
    public boolean isFigurSelected(){
        return SelectedFigur != null;
    }

    public static Figur[][] getBrett() {
        return Brett;
    }

}
