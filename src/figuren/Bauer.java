
package figuren;

import static schach.Brett.BRETT_HEIGHT;
import schach.Steuerung;

public class Bauer extends Figur{

    public Bauer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_BAUER);
    }

    @Override
    public void berechneLaufmoeglichkeiten() {
        dasBrett = Steuerung.dasBrett;
         resetLaufmoeglichkeiten();
        int richtung;
        if(weiss == true){
            richtung = -1;
        }else{ 
            richtung = 1;
        }

        if(!dasBrett.FigurAufBrett(reihe, spalte+richtung)){ // ein Feld vor
            laufMoeglichkeiten[reihe][spalte+richtung] = true;
            if(spalte+richtung*2 >= 0 && spalte+richtung*2 <= BRETT_HEIGHT){ // zwei Felder vor
                if(( spalte == 1 && weiss == false || spalte == 6 && weiss == true ) && !dasBrett.FigurAufBrett(reihe, spalte+richtung*2)){
                    laufMoeglichkeiten[reihe][spalte+richtung*2] = true;
                } 
            }
        }
        if(reihe+1 <= BRETT_HEIGHT){ //schlagen
            if( dasBrett.FigurAufBrett(reihe+1, spalte+richtung)){
                if( dasBrett.gibFigur(reihe+1, spalte+richtung).isWeiss() != weiss){
                    laufMoeglichkeiten[reihe+1][spalte+richtung] = true;
                }
            }
        }
        if(reihe-1 >= 0){
            if(dasBrett.FigurAufBrett(reihe-1, spalte+richtung)){
                if(dasBrett.gibFigur(reihe-1, spalte+richtung).isWeiss() != weiss){
                    laufMoeglichkeiten[reihe-1][spalte+richtung] = true;
                }
            } 
        }
    }
    
}
