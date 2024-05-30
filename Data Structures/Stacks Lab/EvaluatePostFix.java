/**
 * This class takes a postfix expression and evaluates it for the answer
 * @author Alvaro Vera
 * @version 1.0
 */
public class EvaluatePostFix {

    private ObjectStack calculate = new ObjectStack();
    private int value;
    private int left;
    private int right;

    /**
     * Constructor for class EvaluatePostFix
     */
    public EvaluatePostFix()
    {
    }

    /**
     * This takes a postfix expression and calculates the value of the expression
     * @param postfix a mathematical expression in postfix form
     * @return integer value of evaluated expression
     */
    public int evaluation(StringBuilder postfix)
    {
        for(int i = 0; i < postfix.length(); i++)
        {
            if(Character.isDigit(postfix.charAt(i)))
            {
                calculate.push(Character.getNumericValue(postfix.charAt(i)));
            }

            else
            {
                switch(postfix.charAt(i))
                {
                    case '+' :
                        right = (int)calculate.pop();
                        left = (int)calculate.pop();
                        value = left+right;
                        calculate.push(value);
                        break;
                    case '-' :
                        right = (int)calculate.pop();
                        left = (int)calculate.pop();
                        value = left-right;
                        calculate.push(value);
                        break;
                    case '*' :
                        right = (int)calculate.pop();
                        left = (int)calculate.pop();
                        value = left*right;
                        calculate.push(value);
                        break;
                    case '/' :
                        right = (int)calculate.pop();
                        left = (int)calculate.pop();
                        value = left/right;
                        calculate.push(value);
                        break;
                    case '^' :
                        right = (int)calculate.pop();
                        left = (int)calculate.pop();
                        value = (int)Math.pow(left,right);
                        calculate.push(value);
                        break;
                }
            }
        }
        return (int)calculate.top();
    }

}
