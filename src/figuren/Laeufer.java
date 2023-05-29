/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public boolean[][] zeigeLaufmoeglichkeiten() {
        boolean[][] laufMoeglichkeiten = new boolean[8][8];
        Figur[][] dasBrett = Steuerung.getBrett();
        
        for (int i = 0; i < laufMoeglichkeiten[0].length; i++) {
            for (int j = 0; j < laufMoeglichkeiten.length; j++) {
                laufMoeglichkeiten[j][i] = false;
            }
        }
        
        int[][] arr = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for (int i = 0; i < arr[0].length; i++) {
            for(int[] a : arr){
                
            }
        }
        
        return laufMoeglichkeiten;
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
