##
## EPITECH PROJECT, 2018
## make
## File description:
## make
##

all: package
	rm -rf dist
	mkdir dist
	cp target/*.jar dist/currency-converter-1.0.0.jar

clean:
	mvn clean
	rm -rf dist/*.jar

package:
	mvn package

build:
	mvn compile

test:
	mvn test

deps:
	mvn dependency:resolve
run:
	mvn exec:java -Dexec.mainClass="hello.Window"

fclean:
	rm -f *#
	rm -f *~

re: clean all
