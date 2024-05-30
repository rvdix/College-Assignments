import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Main class to run the appropriate methods for the program
 * @author Alvaro Vera
 * @version 1.0
 */
public class Xref
{

    public static void main(String args[]) throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new File("csis.txt"));
        Query query = new Query(pw);
        query.hashing();
        query.parseText();
        pw.println();
        System.out.println();
        query.inOrder();
        System.out.println();
        pw.println();
        query.outputHash();
        query.search();
        pw.close();

    }


}
