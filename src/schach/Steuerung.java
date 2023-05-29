package schach;

import figuren.Figur;
import static figuren.Figur.HEIGHT;
import static figuren.Figur.WIDTH;
import java.awt.Color;
import java.awt.Graphics;

public class Steuerung {

    public static Brett dasBrett;
    private GUI dieGUI;
    private FENReader Reader;
    private Figur SelectedFigur;
    private boolean[][] Laufmoeglichkeiten;

    public Steuerung(GUI dieGUI) {
        dasBrett = new Brett();
        SelectedFigur = null;
        this.dieGUI = dieGUI;
        Reader = new FENReader(dasBrett);
        Reader.lese("8/r2R3n/5R2/2n3R1/4N3/1N6/4q3/8");
    }

    public void zeichne(Graphics g) {

        dasBrett.zeichne(g);

        if(isFigurSelected()){
            SelectedFigur.zeichneLaufMoeglichkeiten(g);
        }

    }

    public boolean isFigurSelected() {
        return SelectedFigur != null;
    }

    public void SelectFigur(int x, int y) {
        System.out.println(x + " " + y);
        if(dasBrett.FigurAufBrett(x, y)){
            SelectedFigur = dasBrett.gibFigur(x, y);
            SelectedFigur.berechneLaufmoeglichkeiten();
        }else{
            SelectedFigur = null;
        }
    }

}
