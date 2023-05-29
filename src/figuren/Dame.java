
package figuren;

public class Dame extends Figur{

    public Dame(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_DAME);
    }

    @Override
    public boolean[][] zeigeLaufmoeglichkeiten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
