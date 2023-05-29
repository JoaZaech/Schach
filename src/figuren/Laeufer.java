
package figuren;

import schach.Steuerung;

/**
 *
 * @author Joalu
 */
public class Laeufer extends Figur{

    public Laeufer(int pReihe, int pSpalte, boolean pWeiss) {
        super(pReihe, pSpalte, pWeiss, Figur.ID_LAEUFER);
    }

    @Override
    public void berechneLaufmoeglichkeiten(){
        dasBrett = Steuerung.dasBrett;
         resetLaufmoeglichkeiten();
        
        int[][] arr = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for (int i = 0; i < arr[0].length; i++) {
            for(int[] a : arr){
                
            }
        }
       
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
    
}
