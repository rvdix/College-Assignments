import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class runs the required methods to read input, send for conversion, and print out values
 * @author  Alvaro Vera - 010787761
 * @version 1.0
 */
public class Driver {

    public static void main(String args[]) throws FileNotFoundException {

        File file = new File("input.txt");
        PrintWriter pw = new PrintWriter("csis.txt");
        StringBuilder sb;
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            sb = new StringBuilder(sc.nextLine());
            InfixToPostfix infxToPstx = new InfixToPostfix(pw);
            infxToPstx.convert(sb);
        }
        pw.close();
    }
}
