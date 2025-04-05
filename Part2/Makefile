all: compile execute 

compile:
	jflex scanner.flex
	java -jar ./java-cup-11b.jar -interface -parser Parser parser.cup
	java -jar ./java-cup-11b.jar -interface -parser ParserJava parserJava.cup
	javac -cp ./java-cup-11b-runtime.jar *.java

execute:
	java -cp ./java-cup-11b-runtime.jar:. Main < input1.txt

clean:
	rm -f *.class *~
