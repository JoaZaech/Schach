package figuren;

import static schach.Brett.BRETT_HEIGHT;
import static schach.Brett.BRETT_WIDTH;
import schach.Steuerung;

public class Turm extends Figur {

    public Turm(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_TURM);
    }

    @Override
    public void berechneLaufmoeglichkeiten() {
        dasBrett = Steuerung.dasBrett;
         resetLaufmoeglichkeiten();
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
        //  Links 
        for (int i = reihe - 1; i >= 0; i--) {
            if (dasBrett.FigurAufBrett(i, spalte)) {
                if (dasBrett.gibFigur(i, spalte).isWeiss() == weiss) {
                    break;
                } else {
                    laufMoeglichkeiten[i][spalte] = true;
                    break;
                }
            } else {
                laufMoeglichkeiten[i][spalte] = true;
            }
        }

        // Rechts
        for (int i = reihe + 1; i < BRETT_WIDTH; i++) {
            if (dasBrett.FigurAufBrett(i, spalte)) {
                if (dasBrett.gibFigur(i, spalte).isWeiss() == weiss) {
                    break;
                } else {
                    laufMoeglichkeiten[i][spalte] = true;
                    break;
                }
            } else {
                laufMoeglichkeiten[i][spalte] = true;
            }
        }

        //  Oben 
        for (int i = spalte - 1; i >= 0; i--) {
            if (dasBrett.FigurAufBrett(reihe, i)) {
                if (dasBrett.gibFigur(reihe, i).isWeiss() == weiss) {
                    break;
                } else {
                    laufMoeglichkeiten[reihe][i] = true;
                    break;
                }
            } else {
                laufMoeglichkeiten[reihe][i] = true;
            }
        }

        // Unten
        for (int i = spalte + 1; i < BRETT_HEIGHT; i++) {
            if (dasBrett.FigurAufBrett(reihe, i)) {
                if (dasBrett.gibFigur(reihe, i).isWeiss() == weiss) {
                    break;
                } else {
                    laufMoeglichkeiten[reihe][i] = true;
                    break;
                }
            } else {
                laufMoeglichkeiten[reihe][i] = true;
            }
        }
    }

}
