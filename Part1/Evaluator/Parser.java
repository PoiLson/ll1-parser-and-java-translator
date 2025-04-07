import java.io.IOException;
import java.io.InputStream;

class Parser
{
    private final InputStream in;
    private int lookahead;

    public Parser(InputStream in) throws IOException
    {
        this.in = in;
        lookahead = in.read();
    }

    private void consume(int symbol) throws IOException, ParseError
    {
        if (lookahead == symbol)
            lookahead = in.read();
        else
            throw new ParseError();
    }

    private boolean isDigit(int c)
    {
        return '0' <= c && c <= '9';
    }


/* Visualizing the grammar */

    public int exp() throws  IOException, ParseError
    {

        if (isDigit(lookahead) || lookahead == '(' )
        {
            int leftOperand = op1();

            return op2(leftOperand);
        }
        else if (lookahead == '\n' ||  lookahead ==  '\r' || lookahead == -1)
            return -1;

        throw new ParseError();

    }


    private int op1() throws  IOException, ParseError
    {

        if (isDigit(lookahead) || lookahead == '(')
        {
            int leftOperand = term1();

            return term2(leftOperand);
        }

        throw new ParseError();

    }

    private int op2(int leftOperand) throws  IOException, ParseError
    {

        if(lookahead == '+')
        {
            consume(lookahead);

            int rightOperand = op1();
            int result = leftOperand + rightOperand;

            return op2(result);
        }
        else if(lookahead == '-')
        {
            consume(lookahead);

            int rightOperand = op1();
            int result = leftOperand - rightOperand;

            return op2(result);
        }
        else if(lookahead == '\n' || lookahead ==  '\r' || lookahead == ')' || lookahead == -1)
            return leftOperand;

            
        throw new ParseError();

    }


    private int term1() throws  IOException, ParseError
    {

        if (isDigit(lookahead))
            return Integer.parseInt(num());
        else if (lookahead == '(')
        {
            consume(lookahead);

            int result = exp();

            if (lookahead != ')' )
                throw new ParseError();

            consume(lookahead);

            return result;
        }

        throw new ParseError();

    }

    private int term2(int leftOperand) throws  IOException, ParseError
    {

        if (lookahead == '*')
        {
            consume(lookahead);

            if (lookahead == '*')
            {
                consume(lookahead);

                int power = term1();

                return term2((int)Math.pow(leftOperand, power));
            }
        }
        else if (lookahead == '+' || lookahead == '-' || lookahead == '\n' || lookahead == ')'  || lookahead ==  '\r' || lookahead == -1)
            return leftOperand;

        throw new ParseError();

    }


    private String num() throws  IOException, ParseError
    {

        if (isDigit(lookahead))
        {
            String digit = "";

            digit += (char) lookahead;

            consume(lookahead);
            String nextOperand = rest();

            if ("-1".equals(nextOperand))
                return digit;
            else
                return (digit + nextOperand);

        }

        throw new ParseError();

    }

    private String rest() throws  IOException, ParseError
    {

        if (isDigit(lookahead))
        {
            String digit = "";
            digit += (char) lookahead;

            consume(lookahead);
            String nextOperand = rest();

            if ("-1".equals(nextOperand))
                return digit;
            else
                return (digit + nextOperand);
        }

        else if (lookahead == '*' || lookahead == '+' || lookahead == '-' || lookahead == '\n' || lookahead ==  '\r' || lookahead == ')' || lookahead == -1)
            return "-1";


        throw new ParseError();

    }

}