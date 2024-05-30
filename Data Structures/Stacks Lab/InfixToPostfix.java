import java.io.PrintWriter;
/**
 * This class runs methods to take an infix expression and convert it to a postfix expression
 * @author Alvaro Vera
 * @version 1.0
 */
public class InfixToPostfix
{

    private StringBuilder input;
    private StringBuilder postfix = new StringBuilder();
    private ObjectStack operator = new ObjectStack();
    private PrintWriter pw;
    private int output;

    /**
     * Constructor for the infixToPostfix class
     * @param pw printwriter object to mirror output to text
     */
    public InfixToPostfix(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * This takes in the infix expression and runs methods for its conversion and evaluation as well as output
     * @param convert this is the infix expression to be converted
     */
    public void convert(StringBuilder convert)
    {
        EvaluatePostFix eval = new EvaluatePostFix();
        input = convert;
        convertTo();
        output = eval.evaluation(postfix);
        convertOutput();

    }

    /**
     * The method that converts a stringbuilder of an infix expression to postfix
     */
    public void convertTo()
    {
        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i)))
            {
               postfix.append((input.charAt(i)));
            }
            else
                operatorOrder(input.charAt(i));
        }
        while(!operator.isEmpty())
        {
            postfix.append((char)operator.pop());
        }
    }

    /**
     * This method takes a character from the infix expression if it's an operator and determines it's order on the stack
     * @param x the operator from the infix expression
     */
    private void operatorOrder(char x)
    {
        if(x == ' ')
            return;

        if(x == ')')
        {
            while(!operatorEmpty())
            {
                postfix.append(operator.pop());
            }
            operator.pop();
        }

        else if(operator.isEmpty() || operatorEmpty())
            operator.push(x);

        else if(x == '(')
        {
            operator.push(x);
        }

        else if(priority(x) > priority((char)operator.top()))
            operator.push(x);

        else if(priority(x) <= priority((char)operator.top()))
        {
            while(!operator.isEmpty() && priority((char)(operator.top())) >= priority(x))
            {
                postfix.append(operator.pop());
            }
            operator.push(x);
        }
    }

    /**
     * This method determines the value of the operators in terms of preference
     * @param x the operator brought in for evaluation
     * @return int - priority of operator
     */
    private int priority(char x)
    {
        switch (x) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default : return 0;
        }
    }

    /**
     * This method outputs the text to the console and mirrors to text file
     */
    public void convertOutput()
    {
        System.out.println("Infix:");
        System.out.println(input + "\n");
        pw.println("Infix:");
        pw.println(input + "\n");

        System.out.println("Postfix:");
        System.out.println(postfix + "\n");
        pw.println("Postfix:");
        pw.println(postfix + "\n");

        System.out.println("Evaluated value:");
        System.out.println(output + "\n");
        pw.println("Evaluated value:");
        pw.println(output + "\n");
    }

    /**
     * checks if the top of the stack is a left parenthesis which is considered empty
     * @return true if stack is empty
     */
    private boolean operatorEmpty()
    {
       return ((char)operator.top() == '(');
    }
}
