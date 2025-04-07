all: compile execute 

compile:
	jflex scanner.flex
	java -jar ./java-cup-11b.jar -interface -parser Parser parser.cup
	java -jar ./java-cup-11b.jar -interface -parser ParserJava parserJava.cup
	javac -cp ./java-cup-11b-runtime.jar *.java

# Different tests for checking, input*.txt are the ones from the website

execute:
#	java -cp ./java-cup-11b-runtime.jar:. Main < test.txt

# test2\test3\test4 about Tralalero Tralala Bombardino Crocodilo
	java -cp ./java-cup-11b-runtime.jar:. Main < test2.txt
#	java -cp ./java-cup-11b-runtime.jar:. Main < test3.txt
#	java -cp ./java-cup-11b-runtime.jar:. Main < test4.txt
#	java -cp ./java-cup-11b-runtime.jar:. Main < input1.txt
#	java -cp ./java-cup-11b-runtime.jar:. Main < input2.txt
#	java -cp ./java-cup-11b-runtime.jar:. Main < input3.txt

# We check our .java code!
check:
	javac Translated.java
	java Translated

clean:
	rm -f *.class *~
	rm -f Translated.java
	rm -f Translated.class
	rm -f Translated.ir