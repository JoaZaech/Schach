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
    }

    @Override
    public void zeigeLaufmoeglichkeiten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
