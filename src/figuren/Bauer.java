
package figuren;

import schach.Steuerung;

public class Bauer extends Figur{

    public Bauer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_BAUER);
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        boolean[][] laufMoeglichkeiten = new boolean[8][8];
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
        Figur[][] dasBrett = Steuerung.getBrett();
        int richtung;
        if(weiss == true){
            richtung = -1;
        }else{ 
            richtung = 1;
        }
        
        if(dasBrett[reihe][spalte+richtung] == null){ // ein Feld vor
            laufMoeglichkeiten[reihe][spalte+richtung] = true;
        }
        if(spalte+richtung*2 >= 0 && spalte+richtung*2 <= Steuerung.getBrett()[0].length ){ // zwei Felder vor
            if((spalte == 1 || spalte == 6) && dasBrett[reihe][spalte+richtung*2] == null){
                laufMoeglichkeiten[reihe][spalte+richtung*2] = true;
            } 
        }
        if(reihe-1 >= 0 && reihe+1 <= Steuerung.getBrett()[0].length){ //schlagen
            if(dasBrett[reihe+1][spalte+richtung] != null ){
                if(dasBrett[reihe+1][spalte+richtung].isWeiss() != weiss){
                    laufMoeglichkeiten[reihe+1][spalte+richtung] = true;
                }
            }
            if(dasBrett[reihe-1][spalte+richtung] != null ){
                if(dasBrett[reihe-1][spalte+richtung].isWeiss() != weiss){
                    laufMoeglichkeiten[reihe-1][spalte+richtung] = true;
                }
            } 
        }
        
       
        return laufMoeglichkeiten;
    }
    
}
