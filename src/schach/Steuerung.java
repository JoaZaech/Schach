package schach;

import figuren.Figur;
import java.awt.Graphics;

public class Steuerung {
    
    private Figur[][] Brett;
    private GUI dieGUI;
    private FENReader Reader;
    
    public Steuerung(GUI dieGUI){
        Brett = new Figur[8][8];
        this.dieGUI = dieGUI;
        Reader = new FENReader(Brett);
    }
    
    
    
    public void zeichne(Graphics g){
        
        
        
    }
    
}
