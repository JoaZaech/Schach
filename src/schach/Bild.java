package schach;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Bild {
    
    private BufferedImage bim;
    private File f;
 
    public Bild(String Pfad){
        try {
            f = new File(Pfad);
            bim = ImageIO.read(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void setzeBild(String Pfad){
        try {
            f = new File(Pfad);
            bim = ImageIO.read(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void zeichne(Graphics g, int x, int y){
        try {
            g.drawImage(bim,x,y,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public BufferedImage gibBild(){
        return bim;
    }
    
    public void zeichne(Graphics g, int x, int y, int width,int height){
        try {
             g.drawImage(bim,x,y,width,height,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getHeight(){
        return bim.getHeight();
    }
    
    public int getWidth(){
        return bim.getWidth();
    }
}