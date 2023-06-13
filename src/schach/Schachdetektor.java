package schach;

import figuren.Figur;
import figuren.Koenig;
import java.awt.Point;

public class Schachdetektor {
    // Pruefe auf Schach
    protected Figur angreifer;
    protected Point Kweiss = new Point();
    protected Point Kschwarz = new Point();
    protected boolean  isSchach = false;
    
    public boolean isSchach(Brett brett){
        
        findeKoenig(brett);
        for (int i = 0; i < Brett.BRETT_HEIGHT; i++) {
            for (int j = 0; j < Brett.BRETT_WIDTH; j++) {
                angreifer = brett.gibFigur(j, i);
                if(angreifer != null){
                    angreifer.berechneLaufmoeglichkeiten();
                    if(angreifer.isWeiss() == true){
                        if(angreifer.pruefeFeldMoeglich( Kschwarz.x, Kschwarz.y) == true){
                            isSchach = true;
                            return true;
                        }
                    }else{
                        if(angreifer.pruefeFeldMoeglich( Kweiss.x, Kweiss.y) == true){
                            isSchach = true;
                            return true;
                        }
                    }
                }
            }
        }
        isSchach = false;
        return false;
    }
    
    private void findeKoenig(Brett brett){
        for (int i = 0; i < Brett.BRETT_HEIGHT; i++) {
            for (int j = 0; j < Brett.BRETT_WIDTH; j++) {
                
                if( brett.gibFigur(j, i) != null && brett.gibFigur(j, i).getID() == Figur.ID_KOENIG ){
                    if(brett.gibFigur(j, i).isWeiss() == true ){
                        Kweiss.setLocation(j, i);
                    }
                    if(brett.gibFigur(j, i).isWeiss() == false ){
                        Kschwarz.setLocation(j, i);
                    }
                }
                
            }
            
        }
    }
    
    public void printInfos(){
        System.out.println(" - - - Schachdetektor Infos - - - ");
        System.out.println("Position Koenig Schwarz: " + Kschwarz);
        System.out.println("Position Koenig weiss  : " + Kweiss);
        System.out.println(" Schach = " + isSchach);
    }
    
    public boolean IsKoenigImSchach(boolean weissKoenig, Brett brett){
        findeKoenig(brett);
        for (int i = 0; i < Brett.BRETT_HEIGHT; i++) {
            for (int j = 0; j < Brett.BRETT_WIDTH; j++) {
                angreifer = brett.gibFigur(j, i);
                if(angreifer != null){
                    angreifer.berechneLaufmoeglichkeiten();
                    if(angreifer.isWeiss() == true){
                        if(angreifer.pruefeFeldMoeglich( Kschwarz.x, Kschwarz.y) == true){
                            if(weissKoenig == false){
                                isSchach = true;
                                return true;
                            }
                            
                        }
                    }else{
                        if(angreifer.pruefeFeldMoeglich( Kweiss.x, Kweiss.y) == true){
                            if(weissKoenig == true){
                                isSchach = true;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        isSchach = false;
        return false;
        
    }
}
