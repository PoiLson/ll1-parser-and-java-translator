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

## Part 1

### Structure

For Part 1, I transformed the grammar into LL(1) form and added my notes in the [`Part1/LL1 grammar`](Part1/LL1%20grammar) folder. The calculator parser implementation is located in [`Part1/Evaluator`](Part1/Evaluator).

### Usage

To compile and run the calculator parser with the default input provided in the [`Part1/Evaluator/Makefile`](Part1/Evaluator/Makefile), use:

```make run```

This command compiles and executes the parser using a sample arithmetic expression.

If you want to use a different input, you can either modify the corresponding input string in the [`Part1/Evaluator/Makefile`](Part1/Evaluator/Makefile) (line 12) or run the program manually:

```
make compile
java Main
```
Then type your input expression directly.

You can also provide the input using redirection:

```java Main < input.txt```

## Part 2

### Usage

To generate the intermediate representation and the translated Java file, run:

```make all```

To verify that the generated Translated.java compiles correctly:

```make check```

The ```make all``` command generates the IR and ```Translated.java```, while ```make check``` verifies that the produced Java code compiles correctly.

If you want to use a different input file, you can modify the corresponding line in the [`Part2/Makefile`](Part2/Makefile) or run the compiler manually:

```
make compile
java -cp ./java-cup-11b-runtime.jar:. Main < input.txt
make check
```
