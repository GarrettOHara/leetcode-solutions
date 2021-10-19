JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: program

program: $(classes)

clean:
    rm -f *.class

%.class: %.java
    $(JAVAC) $<

jar: $(classes)
    jar cvf program.jar $(classes)

.PHONY: all program clean jar
