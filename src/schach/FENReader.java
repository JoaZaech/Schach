package schach;

import figuren.Figur;
import figuren.Koenig;
import java.util.HashMap;

public class FENReader {
    
    public static String Grundaufstellung = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private Figur[][] Brett;
    private HashMap<Character, Figur> dieListe;
    
    public FENReader(Figur[][] Brett){
        this.Brett = Brett;
        dieListe = new HashMap();
        
    }
    
    public void lese(String fen){
        
        int file = 0;
        int rank = 0;
        
        for (char symbol : fen.toCharArray()) {
            
            if(symbol == '/'){
                file = 0;
                rank++;
            }else{
                if(Character.isDigit(symbol)){
                    file += symbol;
                }else{
                    
                    // Teste ob schwarz oder weiß 
                    // Teste welche Figurart es ist
                    // Setze die Figur ins Brett ein
                    
                    if((Character.isUpperCase(symbol))){
                        
                        //int figur = dieListe.get(Character.toLowerCase(symbol));
                        
                       // switch(figur){
                            
                        //}
                        
                    }else{
                        
                        // Schwarze Figur
                        
                    }
                    
                    
                    file++;
                }
            }
            
        }
        
    }
    
}
