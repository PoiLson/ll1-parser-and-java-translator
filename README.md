To begin both parts of the project I added your files as my starting point.

PART 1
-------------------------------------------------------------------------------

For Part1 I did the first part about transforming our grammar into LL1
and put my notes on the folder /Part1/LL1 grammar.
And for the Calculator parser, I added my code into the foldr
/Part1/Evaluator.

In order to run the parser you can check out the Makefile I have made.
If you run the command:

make run

It should compile and execute the calculator parser with a standard 
expression that I have put into it.
If you want to run it with a different input you can go into
line 12 of my Makefile and change the echo string for the input
or you can do these steps:

make compile
java Main
--your_input_here--

or you can give the input with redirection
java Main < --your_input_here--

PART 2
-------------------------------------------------------------------------------

In order to execute the compiler I have made a Makefile and also added
some files in gihub for some tests.

You can run it like this:

make all
make check

The make all command is ebout making the ir and Translated.java files
and the make check is about testing that the Trnaslated.java file compiles
correctly with Java!

If you want to enter a different input run you can change the Makefile,
line 15 and put your input instead of test2.txt that I have there.
Also you can do it like this:

make compile
java -cp ./java-cup-11b-runtime.jar:. Main < --your_input_here--
make check
