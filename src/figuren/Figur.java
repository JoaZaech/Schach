/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuren;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import schach.Bild;

/**
 *
 * @author Joalu
 */
public abstract class Figur {
    
    public static final int ID_BAUER = 1;
    public static final int ID_TURM = 2; 
    public static final int ID_SPRINGER = 3;
    public static final int ID_LAEUFER = 4;
    public static final int ID_DAME = 5;
    public static final int ID_KOENIG = 6;
    
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    
    protected int ID;
    protected Bild bild;
    protected boolean weiss;
    protected int reihe;
    protected int spalte;
    
    public Figur(int pReihe, int pSpalte, boolean pWeiss){
        reihe = pReihe;
        spalte = pSpalte;
        weiss = pWeiss;
    }
    
    public abstract boolean[][] zeigeLaufmoeglichkeiten();
    
    public boolean isWeiss(){
        return weiss;
    }
    
    public void male(Graphics g){
        g.drawImage(bild.gibBild(), reihe*WIDTH, spalte*HEIGHT, WIDTH, HEIGHT, null);
    }
    
    protected void setzeBild(){
        if(weiss == true){
            bild.setzeBild("img/white/"+ID+".png");
        }else{
            bild.setzeBild("img/black/"+ID+".png");
        }
    }
    
}
