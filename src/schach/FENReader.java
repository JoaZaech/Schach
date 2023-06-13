package schach;

import figuren.Bauer;
import figuren.Dame;
import figuren.Figur;
import figuren.Koenig;
import figuren.Laeufer;
import figuren.Springer;
import figuren.Turm;
import java.util.HashMap;

public class FENReader {

    public final static String Grundaufstellung = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private Brett dasBrett;
    private HashMap<Character, Integer> dieListe;

    public FENReader(Brett dasBrett) {
        this.dasBrett = dasBrett;
        dieListe = new HashMap();
        dieListe.put('k', Figur.ID_KOENIG);
        dieListe.put('p', Figur.ID_BAUER);
        dieListe.put('r', Figur.ID_TURM);
        dieListe.put('b', Figur.ID_LAEUFER);
        dieListe.put('q', Figur.ID_DAME);
        dieListe.put('n', Figur.ID_SPRINGER);
    }

    public void lese(String fen) {

        int file = 0;
        int rank = 0;

        for (char symbol : fen.toCharArray()) {

            if (symbol == '/') {
                file = 0;
                rank++;
            } else {
                if (Character.isDigit(symbol)) {
                    file += Character.getNumericValue(symbol);
                } else {
                    boolean weiss;

                    if ((Character.isUpperCase(symbol))) {
                        weiss = true;
                    } else {
                        weiss = false;
                    }
                    setFigur(dieListe.get(Character.toLowerCase(symbol)), weiss, file, rank);
                    file++;
                }
            }

        }

    }

    private void setFigur(int figur, boolean weiss, int file, int rank) {
        switch (figur) {
            case Figur.ID_KOENIG:
                dasBrett.setzeFigur(file, rank, new Koenig(file, rank, weiss));
                break;
            case Figur.ID_BAUER:
                dasBrett.setzeFigur(file, rank, new Bauer(file, rank, weiss));
                break;
            case Figur.ID_TURM:
                dasBrett.setzeFigur(file, rank, new Turm(file, rank, weiss));
                break;
            case Figur.ID_SPRINGER:
                dasBrett.setzeFigur(file, rank, new Springer(file, rank, weiss));
                break;
            case Figur.ID_LAEUFER:
                dasBrett.setzeFigur(file, rank, new Laeufer(file, rank, weiss));
                break;
            case Figur.ID_DAME:
                dasBrett.setzeFigur(file, rank, new Dame(file, rank, weiss));
                break;
        }

        /*
                dieListe.put('k', Figur.ID_KOENIG);
        dieListe.put('p', Figur.ID_BAUER);
        dieListe.put('r', Figur.ID_TURM);
        dieListe.put('b', Figur.ID_LAEUFER);
        dieListe.put('q', Figur.ID_DAME);
        dieListe.put('n', Figur.ID_SPRINGER);*/
    }

}
