import java.io.IOException;
import java.io.InputStream;

class Parser {
    private final InputStream in;
    private int lookahead;

    public Parser(InputStream in) throws IOException {
        this.in = in;
        lookahead = in.read();
    }

    private void consume(int symbol) throws IOException, ParseError {
        if (lookahead == symbol) {
            lookahead = in.read();
        } else {
            throw new ParseError();
        }
    }

    private boolean isDigit(int c) {
        return '0' <= c && c <= '9';
    }

    private int exp() throws  IOException, ParseError
    {
        System.out.println("exp called with lookahead" + (char)lookahead);

        if (isDigit(lookahead) || lookahead == '(' )
        {
            int left_operand = op1();

            return op2(left_operand);
        }
        else if (lookahead == '\n' ||  lookahead ==  '\r' || lookahead == -1)
            return -1;

        System.out.println("tra7");

        throw new ParseError();
    }

    private int op1() throws  IOException, ParseError
    {
        System.out.println("op1 called with lookahead" + (char)lookahead);

        if (isDigit(lookahead) || lookahead == '(')
        {
            int left_operand = term1();

            return term2(left_operand);
        }

        System.out.println("tra5" + (char)lookahead);

        throw new ParseError();
    }

    private int op2(int left_operand) throws  IOException, ParseError
    {
        System.out.println("expr2 called with lookahead" + (char)lookahead);

        switch (lookahead)
        {
            case '+' ->
            {
                consume(lookahead);

                int right_operand = op1();
                int result = left_operand + right_operand;

                return op2(result);
            }

            case '-' ->
            {
                consume(lookahead);

                int right_operand = op1();
                int result = left_operand - right_operand;

                return op2(result);
            }

            case ')', -1 ->
            {
                return left_operand;   
            }

            default ->
            {
                System.out.println("tra6");

                throw new ParseError();
            }
        }
    }
