import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class converts hexadecimal to binary and decimal.
 * @author Alvaro
 * @version 2018/09/06
 */
public class Hexadecimal
{
    private PrintWriter printer;
    private StringBuilder inHex;
    private int decimal;
    private StringBuilder binary;

    /**
     * This creates a printwriter object to mirror output to text.
     * @param pw - printwriter object
     */
    public Hexadecimal(PrintWriter pw)
    {
        printer = pw;
    }

    /**
     * Takes the users input for processing.
     */
    public void inputHex()
    {
        System.out.println("Enter your hexadecimal number:");
        printer.println("Enter your hexadecimal number:");

        Scanner sc = new Scanner(System.in);
        inHex = new StringBuilder(sc.nextLine());
        printer.println(inHex);

    }

    /**
     * Runs the appropriate methods to convert to decimal.
     */
    public void hexToDec()
    {
        decimal = 0;
        binary = new StringBuilder();
        inputHex();
        toDec();
        outDec();
    }


    /**
     * Converts hexadecimal into binary.
     */
    public void toDec()
    {
        inHex.reverse();

        for(int i = 0; i < inHex.length(); i++)
        {
            switch(inHex.charAt(i))
            {
                case '0':  decimal += (0 * Math.pow(16, i)); break;
                case '1':  decimal += (1 * Math.pow(16, i)); break;
                case '2':  decimal += (2 * Math.pow(16, i)); break;
                case '3':  decimal += (3 * Math.pow(16, i)); break;
                case '4':  decimal += (4 * Math.pow(16, i)); break;
                case '5':  decimal += (5 * Math.pow(16, i)); break;
                case '6':  decimal += (6 * Math.pow(16, i)); break;
                case '7':  decimal += (7 * Math.pow(16, i)); break;
                case '8':  decimal += (8 * Math.pow(16, i)); break;
                case '9':  decimal += (9 * Math.pow(16, i)); break;
                case 'A':  decimal += (10 * Math.pow(16, i)); break;
                case 'B':  decimal += (11 * Math.pow(16, i)); break;
                case 'C':  decimal += (12 * Math.pow(16, i)); break;
                case 'D':  decimal += (13 * Math.pow(16, i)); break;
                case 'E':  decimal += (14 * Math.pow(16, i)); break;
                case 'F':  decimal += (15 * Math.pow(16, i)); break;
            }
        }
    }

    /**
     * Outputs the converted number and prints to screen.
     */
    public void outDec()
    {
        System.out.println("Your hexadecimal number in decimal:");
        printer.println("Your hexadecimal number in decimal:");

        System.out.println(decimal);
        printer.println(decimal);
    }

    /**
     * Runs the appropriate methods to convert to binary.
     */
    public void hexToBin()
    {
        binary = new StringBuilder();
        inputHex();
        toBin();
        outBin();
    }

    /**
     * Converts number to binary
     */
    public void toBin()
    {
        char temp;

        for(int i = 0; i < inHex.length(); i++)
        {
            temp = inHex.charAt(i);

            switch(temp)
            {
                case '0': binary.append("0000"); break;
                case '1': binary.append("0001"); break;
                case '2': binary.append("0010"); break;
                case '3': binary.append("0011"); break;
                case '4': binary.append("0100"); break;
                case '5': binary.append("0101"); break;
                case '6': binary.append("0110"); break;
                case '7': binary.append("0111"); break;
                case '8': binary.append("1000"); break;
                case '9': binary.append("1001"); break;
                case 'A': binary.append("1010"); break;
                case 'B': binary.append("1011"); break;
                case 'C': binary.append("1100"); break;
                case 'D': binary.append("1101"); break;
                case 'E': binary.append("1110"); break;
                case 'F': binary.append("1111"); break;
            }
        }
    }

    /**
     * Outputs the converted number and prints to screen.
     */
    public void outBin()
    {
        StringBuilder outBinary = new StringBuilder();

        System.out.println("Your hexadecimal number in binary:");
        printer.println("Your hexadecimal number in binary:");

        for(int i = 0; i < binary.length(); i++)
        {
            outBinary.append(binary.charAt(i));
            if ((i+1)%4 == 0)

            {
                outBinary.append(" ");
            }
        }

        System.out.println(outBinary);
        printer.println(outBinary);
    }
}
