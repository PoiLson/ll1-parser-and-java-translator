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



# LL(1) Parsing and Translation to Java

## About

This repository contains coursework developed for the *Compilers* course at the Department of Informatics and Telecommunications, National and Kapodistrian University of Athens (NKUA).

The project is divided into two parts:

- **Part 1:** transformation of a grammar into LL(1) form and implementation of a recursive-descent parser for a simple calculator language
- **Part 2:** implementation of a parser and translator for a small string-processing language, producing an intermediate representation and translated Java code

The project focuses on fundamental compiler construction concepts, including grammar transformation, predictive parsing, syntax-directed translation, and code generation.

## Main Idea

The goal of this project is to explore core compiler construction techniques through two hands-on tasks.

In the first part, a grammar for arithmetic expressions is transformed into LL(1) form and used to implement a recursive-descent evaluator supporting operator precedence and parentheses.

In the second part, a small language with string operations, conditionals, and function calls is parsed and translated in two stages: first into an intermediate representation (IR), and then into executable Java code.


## Usage

### Part 1

To compile and run the calculator parser with the default input:

```bash
make run

To compile only:

make compile

Then run manually:

java Main

You can either type the input directly or provide it through input redirection.

Part 2

To generate the IR and translated Java output files:

make all

To check that the generated Translated.java compiles correctly:

make check


If you want to use a different input file, you can modify the corresponding line in the Makefile or run the compiler manually with redirected input.
