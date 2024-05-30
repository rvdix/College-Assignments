/**
 * This class represents the line position of word objects in the text file
 * @author Alvaro Vera
 * @version 1.0
 */
public class LinePosition
{
    private int row;
    private int col;

    /**
     * Constructor for the LinePosition class
     * @param inRow row where word is found
     * @param inCol column where word is found
     */
    public LinePosition(int inRow, int inCol)
    {
        row = inRow;
        col = inCol;
    }

    /**
     * Returns a formatted string of the word's row and column position
     * @return row and column location of word
     */
    public String rowColOutput()
    {
        return String.format(row + "-" + col);
    }
}
