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
