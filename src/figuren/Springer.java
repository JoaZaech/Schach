package figuren;

import schach.Steuerung;

public class Springer extends Figur {

    public Springer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_SPRINGER);
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        if (pruefeFeld(2, 1)) {
            laufMoeglichkeiten[reihe + 2][spalte + 1] = true;
        }

        if (pruefeFeld(1, 2)) {
            laufMoeglichkeiten[reihe + 1][spalte + 2] = true;
        }

        if (pruefeFeld(2, -1)) {
            laufMoeglichkeiten[reihe + 2][spalte - 1] = true;
        }
        if (pruefeFeld(-2, 1)) {
            laufMoeglichkeiten[reihe - 2][spalte + 1] = true;
        }
        if (pruefeFeld(-2, -1)) {
            laufMoeglichkeiten[reihe - 2][spalte - 1] = true;
        }

        if (pruefeFeld(1, -2)) {
            laufMoeglichkeiten[reihe + 1][spalte - 2] = true;
        }
        if (pruefeFeld(-1, 2)) {
            laufMoeglichkeiten[reihe - 1][spalte + 2] = true;
        }
        if (pruefeFeld(-1, -2)) {
            laufMoeglichkeiten[reihe - 1][spalte - 2] = true;
        }
        return laufMoeglichkeiten;
    }

    public boolean aufSchachbrett(int x, int y) {
        boolean aufSchachbrett = true;
        if (x < 0 || x >= 8) {
            aufSchachbrett = false;
        }
        if (y < 0 || y >= 8) {
            aufSchachbrett = false;
        }
        return aufSchachbrett;
    }

    public boolean pruefeFeld(int r, int s) {
        dasBrett = Steuerung.dasBrett;
        if (aufSchachbrett(reihe + r, spalte + s) == true) {
            if (dasBrett.FigurAufBrett(reihe + r, spalte + s)) {
                if (dasBrett.gibFigur(reihe + r, spalte + s).isWeiss() != weiss) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

}
