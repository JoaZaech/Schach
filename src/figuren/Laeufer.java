package figuren;

import schach.Brett;
import schach.Steuerung;

public class Laeufer extends Figur {

    public Laeufer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_LAEUFER);
    }

    @Override
    public void berechneLaufmoeglichkeiten() {
        dasBrett = Steuerung.dasBrett;
        resetLaufmoeglichkeiten();

        // AbstandRe
        int rowRe = Brett.BRETT_WIDTH - reihe + 1;

        int rowLi = Brett.BRETT_WIDTH - rowRe + 1;

        int columnRe = Brett.BRETT_HEIGHT - spalte + 1;

        int columnLi = Brett.BRETT_HEIGHT - columnRe + 1;

        // Rechts unten
        for (int i = 1; i < rowRe; i++) {
            for (int j = 1; j < columnRe; j++) {
                if (j == i && aufSchachbrett(reihe + j, spalte + i)) {

                    laufMoeglichkeiten[reihe + j][spalte + i] = true;
                }
            }
        }

        // Links unten
        for (int i = 1; i < rowLi + 1; i++) {
            for (int j = 1; j < columnLi + 1; j++) {
                if (j == i && aufSchachbrett(reihe - j, spalte - i)) {
                    laufMoeglichkeiten[reihe - j][spalte - i] = true;
                }
            }
        }

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

}
