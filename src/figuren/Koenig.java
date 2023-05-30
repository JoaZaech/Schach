package figuren;

import schach.Steuerung;

public class Koenig extends Figur {

    public Koenig(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_KOENIG);
    }

    @Override
    public void berechneLaufmoeglichkeiten() {
        dasBrett = Steuerung.dasBrett;
        resetLaufmoeglichkeiten();
        System.out.println("laufen koenig aktiv");
        for (int i = spalte - 1; i < spalte + 2; i++) {
            for (int j = reihe - 1; j < reihe + 2; j++) {
                if (i >= 0 && i < laufMoeglichkeiten[0].length && j >= 0 && j < laufMoeglichkeiten.length) {
                    laufMoeglichkeiten[j][i] = true;
                        if (dasBrett.FigurAufBrett(j, i) == false) {
                            laufMoeglichkeiten[j][i] = true;
                        } else {
                            if (dasBrett.gibFigur(j, i).isWeiss() != weiss) {
                                laufMoeglichkeiten[j][i] = true;
                            }else{
                                 laufMoeglichkeiten[j][i] = false;
                            }
                            
                        }
                }
            }
        }
        laufMoeglichkeiten[reihe][spalte] = false;

    }

}
