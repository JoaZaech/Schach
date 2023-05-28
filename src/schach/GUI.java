package schach;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

public class GUI extends javax.swing.JPanel {

    private static final int T_WIDTH = 100;
    private static final int T_HEIGHT = 100;
    private static final char[] files = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final char[] rows = {'1', '2', '3', '4', '5', '6', '7', '8'};
    private Color black, white;
    private Font Arial;
    private int FigurSelected;

    public GUI() {
        this.setFocusable(true);
        this.requestFocus();
        initComponents();
        black = new Color(78, 44, 30);
        white = new Color(255, 255, 255);
        Arial = new Font("Arial", Font.BOLD, 13);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(Arial);

        zeichneSchachbrett(g);
    }

    private void zeichneSchachbrett(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                whiteLine(g, i);
            } else {
                blackLine(g, i);
            }
        }
        zeichneKoordinaten(g);
    }

    private void zeichneKoordinaten(Graphics g) {

        alphabet(g);
        numbers(g);
    }

    private void alphabet(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                g.setColor(white);
            } else {
                g.setColor(black);
            }
            Rectangle2D r = g.getFontMetrics().getStringBounds(String.valueOf(files[i]), g);
            g.drawString(String.valueOf(files[i]), (i * T_WIDTH) + (T_WIDTH - ((int) r.getWidth() + 3)), (8 * T_HEIGHT) - ((int) (r.getHeight() / 4)));
        }
    }

    private void numbers(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                g.setColor(white);
            } else {
                g.setColor(black);
            }
            Rectangle2D r = g.getFontMetrics().getStringBounds(String.valueOf(files[7 - i]), g);
            g.drawString(String.valueOf(rows[7 - i]), (8 * T_WIDTH) - ((int) (r.getWidth()) + 3), (i * T_HEIGHT) + (int) r.getHeight());
        }
    }

    private void whiteLine(Graphics g, int y) {
        int T_WIDTH = 100;
        int T_HEIGHT = 100;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                g.setColor(white);
                g.fillRect(i * T_WIDTH, y * T_HEIGHT, T_WIDTH, T_HEIGHT);
            } else {
                g.setColor(black);
                g.fillRect(i * T_WIDTH, y * T_HEIGHT, T_WIDTH, T_HEIGHT);
            }
        }
    }

    private void blackLine(Graphics g, int y) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                g.setColor(black);
                g.fillRect(i * T_WIDTH, y * T_HEIGHT, T_WIDTH, T_HEIGHT);
            } else {
                g.setColor(white);
                g.fillRect(i * T_WIDTH, y * T_HEIGHT, T_WIDTH, T_HEIGHT);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
