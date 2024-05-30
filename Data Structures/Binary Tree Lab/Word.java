import java.io.PrintWriter;

/**
 * This class is used to represent word objects, keep track of usage, and line position of word
 * @author Alvaro Vera
 * @version 1.0
 */
public class Word implements TreeComparable
{
    private String word;
    private int count;
    private ObjectList ref = new ObjectList();
    private PrintWriter pw;
    private ObjectListNode p;
    private LinePosition lp;

    /**
     * Constrcutor for the word class
     * @param inWord String to be set as the word
     * @param pw PrintWriter object used to mirror output
     */
    public Word(String inWord, PrintWriter pw)
    {
        word = inWord;
        count = 1;
        this.pw = pw;
    }

    /**
     * Set the LinePosition object in the class
     * @param inLP LinePosition object to be added
     */
    public void setRef(LinePosition inLP)
    {
        setLinePosition(inLP);
        ref.addLast(inLP);
    }

    /**
     * Returns the string containing the word
     * @return word
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Used to operate on the Word class when used in the Binary Tree
     * @param o object to be operated on
     */
    public void operate(Object o)
    {
       count++;
       Word w = (Word)o;
       ref.addLast(w.getLinePosition());
    }

    /**
     * Used to compare objects of the Word class
     * @param o object to be compared with
     * @return int depending on whether the word is of greater or lesser value
     */
    public int compareTo(Object o)
    {
        Word w = (Word) o;

        return this.word.compareTo(w.getWord());
    }

    /**
     * Used when a word is taken from the Object Binary Tree and outputs all information of the word object
     */
    public void visit()
    {
        p = ref.getFirstNode();
        LinePosition temp;
        StringBuilder sb = new StringBuilder();


        while(p != null)
        {
              temp = (LinePosition)p.getInfo();
              sb.append(temp.rowColOutput() + " ");
              p = p.getNext();
        }

        System.out.printf("%-15s %-5d %-10s", word, count, sb);
        System.out.println();

        pw.printf("%-15s %-5d %-10s", word, count, sb);
        pw.println();
    }

    /**
     * Returns the line position object that word is set to
     * @return LinePosition
     */
    public LinePosition getLinePosition()
    {
        return this.lp;
    }

    /**
     * Sets the LinePosition object of the Word object
     * @param inLinePosition lineposition object to be used
     */
    public void setLinePosition(LinePosition inLinePosition)
    {
        this.lp = inLinePosition;
    }

}
