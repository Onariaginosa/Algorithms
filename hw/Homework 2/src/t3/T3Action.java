/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  T3Action.java
 *  Purpose       :  Creates an action object that stores the location and move
 *  @author       :  Andrew Forney
 *  Date written  :  
 *  Notes         :  None right now.  We'll add some as they occur.
 *  Warnings      :  None right now.  We'll add some as they occur.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  -------------  -----------------------------------------------------------
 *  @version 1.0.0              Andrew Forney   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package t3;
import java.util.Objects;

/**
 * T3Actions are agent-specified manipulations on the game
 * board such that they indicate which column, row, (both 0
 * indexed), and number / move they would like to make.
 * T3Actions implement Comparable and are ordered in ascending
 * column, row, then move number.
 */
public class T3Action implements Comparable<T3Action> {
    
    public int col, row, move;
    
    /**
     * Constructs a new T3Action with the given column,
     * row, and move number, though this may be an invalid
     * action in the current state (checked by the T3State class)
     * @param col 0-index column to place a number within
     * @param row 0-index row to place a number within
     * @param move Number to place in the desired coordinates
     */
    T3Action(int col, int row, int move) {
        this.col = col;
        this.row = row;
        this.move = move;
    }
    
    @Override
    public String toString () {
        return "(" + col + "," + row + ") = " + move;
    }
    
    @Override
    public int compareTo(T3Action other) {
        int colDiff = this.col - other.col,
            rowDiff = this.row - other.row,
            movDiff = this.move - other.move;
        if (colDiff != 0) { return colDiff; }
        if (rowDiff != 0) { return rowDiff; }
        else { return movDiff; }
    }
    
    @Override
    public boolean equals (Object other) {
        if (other == this) { return true; }
        if (!(other instanceof T3Action)) { return false; }
        T3Action otherCast = (T3Action) other;
        return this.col == otherCast.col && this.row == otherCast.row && this.move == otherCast.move;
    }
    
    @Override
    public int hashCode () {
        return Objects.hash(this.col, this.row, this.move);
    }
    
}