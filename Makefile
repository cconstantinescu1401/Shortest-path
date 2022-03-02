build:
	javac Tema1/*.java

run: build
	java Tema1.Main > map.out

clean:
	rm Tema1/*.class

all:
	make run
	make clean
