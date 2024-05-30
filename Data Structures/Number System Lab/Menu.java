import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This outputs a menu for the user to select their conversion
 * @author Alvaro
 * @version 2018/09/06
 */
public class Menu
{
    private PrintWriter printer;

    /**
     * Uses a printwriter object to mirror output to text file
     * @param pw - printwriter object
     */
    public Menu(PrintWriter pw)
    {
       printer = pw;
    }

    /**
     * Prompts user to choose their option with a number.
     */
    public void display()
    {
        System.out.println("Please select an option using the corresponding number: ");
        printer.println("Please select an option using the corresponding number: ");

        System.out.println("1. Decimal to Binary");
        printer.println("1. Decimal to Binary");

        System.out.println("2. Decimal to Hexadecimal");
        printer.println("2. Decimal to Hexadecimal");

        System.out.println("3. Binary to Decimal");
        printer.println("3. Binary to Decimal");

        System.out.println("4. Binary to Hexadecimal");
        printer.println("4. Binary to Hexadecimal");

        System.out.println("5. Hexadecimal to Decimal");
        printer.println("5. Hexadecimal to Decimal");

        System.out.println("6. Hexadecimal to Binary");
        printer.println("6. Hexadecimal to Binary");

        System.out.println("7. Exit");
        printer.println("7. Exit");
    }

    /**
     * Gets number from user for their selection.
     * @return - the value of their choice
     */
    public int getSelection()
    {
        int choice;
        Scanner sc = new Scanner(System.in);

        choice =  sc.nextInt();
        printer.print(choice);

        return choice;
    }
}
