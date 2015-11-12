/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;

public class gamePanel extends JPanel implements MouseListener {

    private Graphics2D g2d;
    private othelo game;
    public int depth;
    Runtime r ;

    public gamePanel(int x, int y, int w, int h,int response) {
        super();
        setSize(550, 550);
        addMouseListener(this);
        if(response==0) depth=1;
        else if(response==1) depth=3;
        else depth=5;
        game = new othelo(x, y, w, h,depth);
        
      r = Runtime.getRuntime();
      r.gc();
        ////////////////////////////////////////////

    }

    public char getPlayer() {
        return this.game.getPlayer();
    }

    public void setPlayer() {
        game.setPlayer();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        this.setBackground(new Color(0,123,0));
        g2d.setStroke(new BasicStroke(3.0f));

        
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                g2d.setColor(Color.BLACK);
                g2d.draw(new Rectangle2D.Double(game.getSquare(j, i).getX(), game.getSquare(j, i).getY(), game.getSquare(j, i).getW(), game.getSquare(j, i).getH()));
                if (game.getSquare(j, i).getCircle() == 'W') {
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(game.getSquare(j, i).getX() + 5, game.getSquare(j, i).getY() + 5, 30, 30);
                }
                if (game.getSquare(j, i).getCircle() == 'B') {
                    g2d.setColor(Color.BLACK);
                    g2d.fillOval(game.getSquare(j, i).getX() + 5, game.getSquare(j, i).getY() + 5, 30, 30);
                }
                g2d.setColor(Color.BLACK);

            }
        }
        int x=70,y=30;
        int a=1;
        String c=a+" ";
        for(int j=0;j<8;j++)
        {
            c=a+" ";
            g2d.setColor(Color.WHITE);
            g2d.draw(new Rectangle2D.Double(x,y,40,40));
            g2d.drawString(c,40f,20f+x);
            x=x+40;
            a++;
        }
         x=30;y=70;
         a=65;
          c=(char)a+" ";
        for(int j=0;j<8;j++)
        {
            c=(char)a+" ";
            g2d.setColor(Color.WHITE);
            g2d.draw(new Rectangle2D.Double(x,y,40,40));
            g2d.drawString(c,20f+y,50f);
            a++;
            y=y+40;
        }
      g2d.setColor(Color.RED);
      game.setBlackcircles();
      game.setWhitecircles();
      int black=game.getBlackcircles();
      int white=game.getWhitecircles();
      g2d.drawString("Black circles: "+black,70f,15f);
      g2d.drawString("White circles: "+white,300f,15f);
      String player;
      if(game.now=='B') player="Black";
      else player="White";
      g2d.drawString("Player: "+player,190f,15f);
      g2d.setColor(Color.BLACK);
      g2d.fillOval(50,5,13,13);
      g2d.setColor(Color.WHITE);
      g2d.fillOval(280,5,13,13);
      g2d=null;
      r.gc();
    }

    public void mouseClicked(MouseEvent event) {
        if (this.game.getPlayer() == 'B') {
event.translatePoint(-70, -70);
int gety, getx;
getx = event.getX() / 40;
gety = event.getY() / 40;
if(!this.game.getSquare(gety,getx).getAdd_circle()) JOptionPane.showMessageDialog(this,"You can not place a circle here");
if ((getx >= 0) && (gety >= 0) && (getx <= 7) && (gety <= 7) && (this.game.getSquare(gety, getx).getAdd_circle())) {
this.game.makeMove(gety, getx, this.game.getPlayer());
//for(int i=0;i<this.game.getSquare(gety,getx).getChangesSize();i++)System.out.println("allages B: " + (int) this.game.getSquare(gety, getx).getChange(i).getX() + " ," + (int) this.game.getSquare(gety, getx).getChange(i).getY());
this.game.setPlayer();
this.repaint();
}

}
this.repaint();
//this.game.setPlayer();
r.gc();
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseDragged(MouseEvent event) {
    }

    public void mouseMoved(MouseEvent event) {
    }
}
