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
public class Laeufer extends Figur{

    public Laeufer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss);
        ID = Figur.ID_LAEUFER;
        setzeBild();
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        boolean[][] laufMoeglichkeiten = new boolean[8][8];
        Figur[][] dasBrett = Steuerung.getBrett();
        
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
        
        return laufMoeglichkeiten;
    }
    
}
