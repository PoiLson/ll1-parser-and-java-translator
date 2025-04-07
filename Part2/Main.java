import java_cup.runtime.*;
import java.io.*;

class Main
{
    public static void main(String[] argv) throws Exception
    {
        // Implementing the first stage of our compiler
        // input -> IR language!
       
        PrintStream outputTxt = new PrintStream(new FileOutputStream("Translated.ir"));
        System.setOut(outputTxt);

        Parser pIR = new Parser(new Scanner(new InputStreamReader(System.in)));
        pIR.parse();

        
        // Implementing the second stage of our compiler
        // IR -> Java code!
        outputTxt = new PrintStream(new FileOutputStream("Translated.java"));
        System.setOut(outputTxt);

        ParserJava pJava = new ParserJava(new Scanner(new FileReader("Translated.ir")));
        pJava.parse();
    }
}
