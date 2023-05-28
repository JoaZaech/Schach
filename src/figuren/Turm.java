/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuren;

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
        for (int i = 0; i < laufMoeglichkeiten.length; i++) {
            
            
        }
        return laufMoeglichkeiten;
    }

    
    
}
