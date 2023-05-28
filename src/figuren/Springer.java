/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuren;

import schach.Steuerung;

/**
 *
 * @author Joalu
 */
public class Springer extends Figur{

    public Springer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss);
        ID = Figur.ID_SPRINGER;
        setzeBild();
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        boolean[][] laufMoeglichkeiten = new boolean[8][8];
        
        
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
        
        if(pruefeFeld( 2, 1) == true ){ laufMoeglichkeiten[reihe+2][spalte+1] = true; }
        if(pruefeFeld( 2,-1) == true ){ laufMoeglichkeiten[reihe+2][spalte-1] = true; }
        if(pruefeFeld(-2, 1) == true ){ laufMoeglichkeiten[reihe-2][spalte+1] = true; }
        if(pruefeFeld(-2,-1) == true ){ laufMoeglichkeiten[reihe-2][spalte-1] = true; }
        if(pruefeFeld( 1, 2) == true ){ laufMoeglichkeiten[reihe+1][spalte+2] = true; }
        if(pruefeFeld( 1,-2) == true ){ laufMoeglichkeiten[reihe+1][spalte-2] = true; }
        if(pruefeFeld(-1, 2) == true ){ laufMoeglichkeiten[reihe-1][spalte+2] = true; }
        if(pruefeFeld(-1,-2) == true ){ laufMoeglichkeiten[reihe-1][spalte-2] = true; }
         return laufMoeglichkeiten;
    }
    
    public boolean aufSchachbrett(int x, int y){
        boolean aufSchachbrett = true;
        if(x < 0 || x >= 8){
            aufSchachbrett = false;
        }
        if(y < 0 || y >= 8){
            aufSchachbrett = false;
        }
        return aufSchachbrett;
    }
    
    public boolean pruefeFeld(int r, int s){
        Figur[][] dasBrett = Steuerung.getBrett(); 
        if( aufSchachbrett(reihe+r,spalte+s) == true ){
            if(dasBrett[reihe+r][spalte+s] != null){
                if(dasBrett[reihe+r][spalte+s].isWeiss() != weiss){
                    return true;
                }
            }else{
                return true;
            }
        }
        return false;
    }
    
    
}
