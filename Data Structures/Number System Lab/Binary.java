import java.io.PrintWriter;
import java.lang.Math;
import java.util.Scanner;

/**
 * This class takes a binary number then converts to decimal or hexadecimal.
 * @author Alvaro
 * @version 2018/09/06
 */
public class Binary
{
    private PrintWriter printer;
    private StringBuilder inBin;
    private int decimal;

    /**
     * Used to mirror output to a text file.
     * @param pw - printwriter object
     */
    public Binary(PrintWriter pw)
    {
        printer = pw;
    }

    /**
     * This takes the user input for processing.
     */
    public void inputBin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your binary number:");
        printer.println("Enter your binary number:");
        inBin = new StringBuilder(sc.next());
        printer.println(inBin);
    }

    /**
     * Runs the appropriate methods to convert and output to decimal.
     */
    public void binToDec()
    {
        decimal = 0;
        inputBin();
        toDec();
        outDec();
    }

    /**
     * This method converts the decimal into hexadecimal then stores it in decimal.
     */
    public void toDec()
    {
        inBin.reverse();

        for(int i = 0; i < inBin.length(); i++)
        {
            if (inBin.charAt(i) == '1')
            {
                decimal += ((Math.pow(2, i)));
            }
        }
    }

    /**
     * This method outputs the converted number and prints to screen.
     */
    public void outDec()
    {
        System.out.println("Your binary number in decimal:");
        printer.println("Your binary number in decimal:");

        System.out.println(decimal);
        printer.println(decimal);
    }

    /**
     * This runs the appropriate methods to convert to hexadecimal
     */
    public void binToHex()
    {
        StringBuilder outHex = new StringBuilder(32);
        inputBin();
        toHex(outHex);
        outHex(outHex);
    }

    /**
     * This takes the user input and converts to hexadecimal.
     * @param outHex - converted number
     */
    public void toHex(StringBuilder outHex)
    {
        String split;
        int i = 0;

        for(int n = 0; n < (inBin.length()/4); n++)
        {
            split = inBin.substring(i,i+4);
            if(split.equals("0000"))
                outHex.append("0");
            if(split.equals("0001"))
                outHex.append("1");
            if(split.equals("0010"))
                outHex.append("2");
            if(split.equals("0011"))
                outHex.append("3");
            if(split.equals("0100"))
                outHex.append("4");
            if(split.equals("0101"))
                outHex.append("5");
            if(split.equals("0110"))
                outHex.append("6");
            if(split.equals("0111"))
                outHex.append("7");
            if(split.equals("1000"))
                outHex.append("8");
            if(split.equals("1001"))
                outHex.append("9");
            if(split.equals("1010"))
                outHex.append("A");
            if(split.equals("1011"))
                outHex.append("B");
            if(split.equals("1100"))
                outHex.append("C");
            if(split.equals("1101"))
                outHex.append("D");
            if(split.equals("1110"))
                outHex.append("E");
            if(split.equals("1111"))
                outHex.append("F");

            i += 4;
        }

    }

    /**
     * This method outputs converted number and prints to screen.
     * @param outHex - converted number
     */
    public void outHex(StringBuilder outHex)
    {
        System.out.println("Your binary number in hexadecimal:");
        printer.println("Your binary number in hexadecimal:");

        System.out.println(outHex);
        printer.println(outHex);
    }
}

