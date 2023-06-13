package schach;

import figuren.Figur;
import static figuren.Figur.HEIGHT;
import static figuren.Figur.WIDTH;
import java.awt.Color;
import java.awt.Graphics;

public class Steuerung {

    public static Brett dasBrett; 
    private GUI dieGUI;
    private FENReader Reader;
    private Figur SelectedFigur;
    private boolean WeissAnDerReihe;
    private Schachdetektor derSchachdetektor;
    
    public Steuerung(GUI dieGUI) {
        derSchachdetektor = new Schachdetektor();
        dasBrett = new Brett(); 
        WeissAnDerReihe = true;
        SelectedFigur = null;
        this.dieGUI = dieGUI;
        Reader = new FENReader(dasBrett);
        Reader.lese("8/1bq2pp1/4k3/8/1B1KB3/2P2Q2/PP6/8");
    //"3n3B/2R3B1/5B2/R3B1n1/3B4/2B1R3/1B3N2/B1n5"
    }

    public void zeichne(Graphics g) {

        dasBrett.zeichne(g);

        if(isFigurSelected()){
            SelectedFigur.zeichneLaufMoeglichkeiten(g);
        }

    }

    public boolean isFigurSelected() {
        return SelectedFigur != null;
    }

    public void SelectFigur(int x, int y) {
        
        
        // Wenn figur ausgewählt und neue pos ungleich letzter pos und pos möglich dann setze figur
        
        if(isFigurSelected()){
            if((SelectedFigur.getX() != x || SelectedFigur.getY() != y) && SelectedFigur.pruefeFeldMoeglich(x, y)){
                
                int selectedX = SelectedFigur.getX();
                int selectedY = SelectedFigur.getY();
                final Figur alteFigur = dasBrett.gibFigur(x, y); 
                
                dasBrett.resetFigur(SelectedFigur.getX(), SelectedFigur.getY());
                SelectedFigur.setzePos(x, y);
                dasBrett.setzeFigur(x, y, SelectedFigur);
                
                if(derSchachdetektor.IsKoenigImSchach(WeissAnDerReihe, dasBrett)){ 
                        SelectedFigur.setzePos(selectedX, selectedY);
                        dasBrett.setzeFigur(selectedX, selectedY, SelectedFigur);
                        if(alteFigur == null){
                            dasBrett.resetFigur(x, y);
                        }else{
                            dasBrett.setzeFigur(x, y, alteFigur);
                        }
                        
                }else{
                    //gueltiger Zug
                    WeissAnDerReihe = !WeissAnDerReihe;
                    
                    //derSchachdetektor.printInfos();
                }
                
                SelectedFigur = null;
                
            }
        }
        
        if(dasBrett.FigurAufBrett(x, y) && WeissAnDerReihe == dasBrett.gibFigur(x, y).isWeiss()){
            SelectedFigur = dasBrett.gibFigur(x, y);
            SelectedFigur.berechneLaufmoeglichkeiten();
            
        }else{
            SelectedFigur = null;
        }
    }
    
    public boolean pruefeSchach(){
        if( derSchachdetektor.isSchach(dasBrett) ){
            
        }
        derSchachdetektor.printInfos();
        return true;
    }

}
