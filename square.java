/*
 * Square class anaparista ena tetragono tou tamplo tou othelo
 *
 */

/**
 *
 * @author
 */
import java.util.*;
import java.awt.*;

public class square {

    private boolean add_circle;
    private char circle; //W for white,B for Black,N fon None
    private int x, y, w, h;
    private int i;
    private int j;
    private Vector<Point> changes;
    private char label;

    public square(int x, int y, int w, int h, int i, int j) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        if ((j == 3) && (i == 3) || ((j == 4) && (i == 4))) {
            circle = 'W';
        } //WHITE
        else if (((j == 4) && (i == 3)) || ((j == 3) && (i == 4))) {
            circle = 'B';
        } //BLACK
        else {
            circle = 'N';
        } //NONE
        changes = new Vector<Point>();
        if (((j == 0) && (i == 0)) || ((j == 7) && (i == 7)) || ((j == 0) && (i == 7)) || ((j == 7) && (i == 0))) {
            label = 'S';
        }
        if (((j == 0) && (i == 1)) || ((j == 1) && (i == 0)) || ((j == 6) && (i == 0)) || ((j == 7) && (i == 1)) || ((j == 0) && (i == 6)) || ((j == 1) && (i == 7)) || ((j == 6) && (i == 7)) || ((j == 7) && (i == 6))) {
            label = 'C';
        }
        if (((j == 0) && (i == 2)) || ((j == 0) && (i == 5)) || ((j == 2) && (i == 0)) || ((j == 2) && (i == 7)) || ((j == 5) && (i == 0)) || ((j == 5) && (i == 7)) || ((j == 7) && (i == 2)) || ((j == 7) && (i == 5))) {
            label = 'A';
        }
        if (((j == 0) && (i == 3)) || ((j == 0) && (i == 4)) || ((j == 3) && (i == 0)) || ((j == 4) && (i == 0)) || ((j == 3) && (i == 7)) || ((j == 4) && (i == 7)) || ((j == 7) && (i == 3)) || ((j == 7) && (i == 4))) {
            label = 'B';
        }
        if (((j == 1) && (i == 1)) || ((j == 6) && (i == 6)) || ((j == 1) && (i == 6)) || ((j == 6) && (i == 1))) {
            label = 'X';
        }
    }

    public boolean getAdd_circle() {
        return this.add_circle;
    }

    public void setAdd_circle(boolean add) {
        this.add_circle = add;
    }

    public char getCircle() {
        return this.circle;
    }

    public Point getPoint() {
        return new Point(i, j);
    }

    public void setCircle(char circle) {
        this.circle = circle;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }

    public void addChange(Vector v) {
        this.changes.addAll(v);
    }

    public Point getChange(int i) {
        return this.changes.get(i);
    }

    public Vector<Point> getChanges() {
        return this.changes;
    }

    public int getChangesSize() {
        return this.changes.size();
    }

    public char getLabel() {
        return this.label;
    }
    public void setLabel(char label) {
        this.label=label;
    }
}
