package schach;

import figuren.Figur;
import java.awt.Graphics;

public class Brett {

    private Figur[][] dasBrett;
    public static int BRETT_WIDTH = 8;
    public static int BRETT_HEIGHT = 8;

    public Brett() {
        dasBrett = new Figur[8][8];
        for (int i = 0; i < dasBrett[0].length; i++) {
            for (int j = 0; j < dasBrett.length; j++) {
                dasBrett[j][i] = null;
            }
        }
    }

    public boolean FigurAufBrett(int x, int y) {
        return dasBrett[x][y] != null;
    }
    
    public void resetFigur(int x, int y){
        dasBrett[x][y] = null;
    }
    
    public void setzeFigur(int x, int y, Figur f){
        dasBrett[x][y] = f;
    }
    
    public void zeichne(Graphics g){
        for (int i = 0; i < dasBrett[0].length; i++) {
            for (int j = 0; j < dasBrett.length; j++) {
                if (dasBrett[j][i] != null) {
                    dasBrett[j][i].male(g);
                }
            }
        }
    }
    
    public Figur gibFigur(int x, int y) {
        return dasBrett[x][y];
    }

}
