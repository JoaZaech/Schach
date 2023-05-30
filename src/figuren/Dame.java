
package figuren;

import static schach.Brett.BRETT_HEIGHT;
import static schach.Brett.BRETT_WIDTH;
import schach.Steuerung;

public class Dame extends Figur{

    public Dame(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_DAME);
    }

    @Override
    public void berechneLaufmoeglichkeiten() {
        dasBrett = Steuerung.dasBrett;
         resetLaufmoeglichkeiten();
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
