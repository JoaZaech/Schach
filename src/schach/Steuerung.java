package schach;

import figuren.Figur;
import static figuren.Figur.HEIGHT;
import static figuren.Figur.WIDTH;
import java.awt.Graphics;

public class Steuerung {

    private static Figur[][] Brett;
    private GUI dieGUI;
    private FENReader Reader;

    public Steuerung(GUI dieGUI) {
        Brett = new Figur[8][8];
        for (int i = 0; i < Brett[0].length; i++) {
            for (int j = 0; j < Brett.length; j++) {
                Brett[j][i] = null;
            }
        }
        this.dieGUI = dieGUI;
        Reader = new FENReader(Brett);
        Reader.lese(FENReader.Grundaufstellung);
    }

    public void zeichne(Graphics g) {

        for (int i = 0; i < Brett[0].length; i++) {
            for (int j = 0; j < Brett.length; j++) {
                if(Brett[j][i] != null){
                    Brett[j][i].male(g);
                }
            }
        }

    }

    public static Figur[][] getBrett() {
        return Brett;
    }

}
