/*----------------------------------------------------------------
 *  Author:   Louis Fiacco
 *  Email:    lwfiac22@g.holycross.edu
 *  Written:  12/3/2018
 *  
 *  Each Cell object manages information about and draws a
 *  single "cell" of the game grid. 
 *----------------------------------------------------------------*/

import GUI.*;
import java.awt.Color;

/**
 * A <i>Cell</i> object holds all information about the state of a single cell
 * of the minesweeper game board. This includes:
 *   - whether a mine is hidden in this cell or not
 *   - how many of its neighboring cells contain mines
 *   - whether it has been revealed yet or is still hidden
 * Each Cell object knows how to draw itself in a graphical window, and it will
 * draw itself in different styles depending on all the above state information.
 */
public class Cell extends Widget {

    /**
     * Size of one cell when it is drawn on the screen, in pixels.
     */
    public static final int SIZE = 20;

    /**
     * Whether a mine is hidden in this cell or not.
     */
    protected boolean isMine;

    /**
     * Whether this cell is "revealed" or not.
     */
    protected boolean isRevealed;

    /**
     * Count of how many neighboring cells have mines.
     */
    protected int neighborMineCount;

    /**
     * Constructor: Initialize a cell to be drawn at the given x, y coordinates
     * on the screen. The cell will be blank. That is, it will not be a mine,
     * and it will have no neighboring mines so a neighbor mine count of zero.
     */
    public Cell(int x, int y) {
        super(x, y, SIZE, SIZE);
        this.isMine = false;
        this.isRevealed = false;
        this.neighborMineCount = 0;
    }

    /**
     * Hide a mine in this cell by changing the isMine variable to true.
     */
    public void plantMine() {
        isMine = true;
    }

    /**
     * Returns true if a mine is hidden in this cell, otherwise returns false.
     */
    public boolean isMine() {
        return isMine;
    }

    /**
     * Increment the neighbor mine count variable by one. 
     */
    public void incrementNeighborMineCount() {
        neighborMineCount++;
    }

    /**
     * Set the neighbor mine count variable to a given value.
     */
    public void setNeighborMineCount(int count) {
        neighborMineCount = count;
    }

    /**
     * Returns the value of the neighbor mine count variable.
     */
    public int getNeighborMineCount() {
        return neighborMineCount;
    }

    /**
     * Change this cell so that it is "revealed" by setting isRevealed to true.
     */
    public void reveal() {
        isRevealed = true;
    }

    /**
     * Returns true if this cell is "revealed", otherwise returns false.
     */
    public boolean isRevealed() {
        return isRevealed;
    }

    /**
     * Hide a mine in this cell by changing the isMine variable to true.
     */
    public void makeMine() {
        isMine = true;
    }

    /**
     * Change this cell so that it shows the mine that is hiding in it.
     */
    public void showMine() {
        if (isMine)
            isRevealed = true;
    }

    /**
     * Check whether there are neighboring mines.
     */
    public boolean coastIsClear() {
        return (neighborMineCount == 0);
    }

    /**
     * Paint this cell on the canvas. Don't call this directly, it is called by
     * the GUI system automatically. This function should draw something on the
     * canvas. Usually the drawing should stay within the bounds (x, y, width,
     * height) which are protected member variables of GUI.Widget, which this
     * class extends.
     * @param canvas the canvas on which to draw.
     */
    public void repaint(GUI.Canvas canvas) {
        // Add code here to draw this cell. The look of the cell should
        // depend on its current state, e.g. if it has been revealed or not, how
        // many neighbors it has, and so on.
        String s = "" + this.neighborMineCount;
        if (!isRevealed){
            canvas.setPenColor(Canvas.GRAY);
            canvas.raisedBevelRectangle(x, y, 20, 20, 3.0);
        } else if (isRevealed) {
            canvas.setPenColor(Canvas.WHITE);
            canvas.raisedBevelRectangle(x, y, width, height, 3.0);
        
            if (this.neighborMineCount == 1) {
                canvas.setPenColor(Color.GREEN);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 2) {
                canvas.setPenColor(Color.BLUE);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 3) {
                canvas.setPenColor(Color.RED);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 4) {
                canvas.setPenColor(Color.MAGENTA);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 5) {
                canvas.setPenColor(Color.GREEN);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 6) {
                canvas.setPenColor(Color.BLUE);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 7) {
                canvas.setPenColor(Color.RED);
                canvas.text(x + (width / 2), y + (height / 2), s);
            } else if (this.neighborMineCount == 8) {
                canvas.setPenColor(Color.MAGENTA);
                canvas.text(x + (width / 2), y + (height / 2), s);
            }
            
            if (isMine){
                canvas.setPenColor(Canvas.RED);
                canvas.raisedBevelRectangle(x, y, width, height, 3.0);
            }
        }
         
    }
    

}
