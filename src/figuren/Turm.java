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
public class Turm extends Figur {

    public Turm(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss);
        ID = Figur.ID_TURM;
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
        Figur[][] dasBrett = Steuerung.getBrett();
        
        
        
        //  Links 
        for (int i = reihe-1; i >= 0; i--) {
            if (dasBrett[i][spalte] != null) {
                if (dasBrett[i][spalte].isWeiss() == weiss) {
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
        for (int i = reihe + 1; i < dasBrett.length; i++) {
            if (dasBrett[i][spalte] != null) {
                if (dasBrett[i][spalte].isWeiss() == weiss) {
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
        for (int i = spalte-1; i >= 0; i--) {
            if (dasBrett[reihe][i] != null) {
                if (dasBrett[reihe][i].isWeiss() == weiss) {
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
        for (int i = spalte + 1; i < dasBrett.length; i++) {
            if (dasBrett[reihe][i] != null) {
                if (dasBrett[reihe][i].isWeiss() == weiss) {
                    break;
                } else {
                    laufMoeglichkeiten[reihe][i] = true;
                    break;
                }
            } else {
                laufMoeglichkeiten[reihe][i] = true;
            }
        }


        return laufMoeglichkeiten;
    }

}
