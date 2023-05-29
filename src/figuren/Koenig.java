
package figuren;


public class Koenig extends Figur{

    public Koenig(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_KOENIG);
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
