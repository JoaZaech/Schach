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
        /*
        // AbstandRe
        int rowRe = Brett.BRETT_WIDTH - reihe + 1;

        int rowLi = Brett.BRETT_WIDTH - rowRe + 1;

        int columnRe = Brett.BRETT_HEIGHT - spalte + 1;

        int columnLi = Brett.BRETT_HEIGHT - columnRe + 1;

        // Rechts unten
        for (int spaltezaehler = 1; spaltezaehler < rowRe; spaltezaehler++) {
            for (int reihezaehler = 1; reihezaehler < columnRe; reihezaehler++) {
                if (reihezaehler == spaltezaehler && aufSchachbrett(reihe + reihezaehler, spalte + spaltezaehler)) {

                    laufMoeglichkeiten[reihe + reihezaehler][spalte + spaltezaehler] = true;
                }
            }
        }

        // Links unten
        for (int spaltezaehler = 1; spaltezaehler < rowLi + 1; spaltezaehler++) {
            for (int reihezaehler = 1; reihezaehler < columnLi + 1; reihezaehler++) {
                if (reihezaehler == spaltezaehler && aufSchachbrett(reihe - reihezaehler, spalte - spaltezaehler)) {
                    laufMoeglichkeiten[reihe - reihezaehler][spalte - spaltezaehler] = true;
                }
            }
        }
        */
        int spaltezaehler = spalte;
        int reihezaehler = reihe;
        dasBrett = Steuerung.dasBrett;
        for (int a = 0; a < 8; a++) { // rechts unten
            spaltezaehler++;
            reihezaehler++;
            if(pruefeAlles(reihezaehler,spaltezaehler) == false){
                break;
            }
        }
        spaltezaehler = spalte;
        reihezaehler = reihe;
        for (int a = 0; a < 8; a++) { // rechts oben
            spaltezaehler--;
            reihezaehler++;
            if(pruefeAlles(reihezaehler,spaltezaehler) == false){
                break;
            }
        }
        spaltezaehler = spalte;
        reihezaehler = reihe;
        for (int a = 0; a < 8; a++) { // links oben
            spaltezaehler--;
            reihezaehler--;
            if(pruefeAlles(reihezaehler,spaltezaehler) == false){
                break;
            }
        }
        spaltezaehler = spalte;
        reihezaehler = reihe;
        for (int a = 0; a < 8; a++) { // links unten
            spaltezaehler++;
            reihezaehler--;
            if(pruefeAlles(reihezaehler,spaltezaehler) == false){
                break;
            }
        }
    }
    
    public boolean pruefeAlles(int x, int y){
        if(aufSchachbrett(x,y)){
            if( dasBrett.FigurAufBrett(x,y) == false ){
                laufMoeglichkeiten[x][y] = true;
            }else{
                if( dasBrett.gibFigur(x, y).isWeiss() != weiss ){
                    laufMoeglichkeiten[x][y] = true;
                }
                return false;
            }
        }else{
            return false;
        }
        return true;
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
