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
public class Koenig extends Figur{

    public Koenig(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss);
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
