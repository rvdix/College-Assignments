import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class converts decimal numbers into binary and hexadecimal.
 * @author Alvaro
 * @version 2019/09/06
 */
public class Decimal
{
    private PrintWriter printer;
    private int decimal;

    /**
     * Creates a printwriter to mirror output to a text file.
     * @param pw - printwriter object
     */
    public Decimal(PrintWriter pw)
    {
        printer = pw;
    }

    /**
     * This takes the user input for processing
     */
    private void inputDec()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your decimal number:");
        printer.println("Enter your decimal number:");

        decimal = sc.nextInt();
        printer.println(decimal);
    }

    /**
     * This runs appropriate methods to convert and output to binary.
     */
    public void decToBin()
    {
        StringBuilder binary = new StringBuilder();
        StringBuilder outBinary = new StringBuilder();
        inputDec();
        toBin(binary);
        outBin(binary, outBinary);
    }

    /**
     * This method takes the user input and converts to binary into a StringBuilder named binary.
     * @param binary - used to output converted number
     */
    private void toBin(StringBuilder binary)
    {
        int quotient = decimal;
        int remainder;

        while(quotient != 0)
        {
            remainder = (quotient % 2);
            quotient = (quotient / 2);

            binary.append(remainder);
        }
    }

    /**
     * This takes the binary number and formats the output to outBinary, then prints to screen.
     * @param binary - converted number
     * @param outBinary - converted number formatted with leading zeroes and spaces
     */
    private void outBin(StringBuilder binary, StringBuilder outBinary)
    {
        while(binary.length() % 32 != 0)
        {
            binary.append(0);
        }

        binary.reverse();
        for(int i = 0; i < binary.length(); i++)
        {
            outBinary.append(binary.charAt(i));

            if ((i+1)%4 == 0)
            {
                outBinary.append(" ");
            }
        }
        System.out.println("Your decimal number in binary:");
        printer.println("Your decimal number in binary:");

        System.out.println(outBinary);
        printer.println(outBinary);
    }

    /**
     * This runs the appropriate methods to convert and output to hexadecimal.
     */
    public void decToHex()
    {
        StringBuilder hexadecimal = new StringBuilder();
        inputDec();
        toHex(hexadecimal);
        outHex(hexadecimal);
    }

    /**
     * This method converts the decimal number into hexadecimal and stores it.
     * @param hexadecimal - converted number
     */
    private void toHex(StringBuilder hexadecimal)
    {
        int quotient = decimal;
        int remainder;

        while(quotient != 0)
        {
            remainder = (quotient % 16);
            quotient = (quotient/16);

            if (remainder > 9)
            {
                switch(remainder)
                {
                    case 10: hexadecimal.append("A"); break;
                    case 11: hexadecimal.append("B"); break;
                    case 12: hexadecimal.append("C"); break;
                    case 13: hexadecimal.append("D"); break;
                    case 14: hexadecimal.append("E"); break;
                    case 15: hexadecimal.append("F"); break;
                }
            }
            else
                hexadecimal.append(remainder);
        }
    }

    /**
     * Formats hexadecimal into the appropriate format.
     * @param hexadecimal - output which is then formatted within the method
     */
    private void outHex(StringBuilder hexadecimal)
    {
        while(hexadecimal.length() % 8 != 0)
        {
            hexadecimal.append("0");
        }
        hexadecimal.reverse();
        System.out.println("Your decimal number in hexadecimal:");
        printer.println("Your decimal number in hexadecimal:");
        System.out.println(hexadecimal);
        printer.println(hexadecimal);
    }
}

