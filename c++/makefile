CC = g++
CFLAGS = -c -Wall -g -Os

SOURCES=$(shell find . -type f -iname '*.cpp')

OBJECTS=$(foreach x, $(basename $(SOURCES)), $(x).o)

TARGET=Structures

$(TARGET): $(OBJECTS)
	$(CC) $^ -o $@

clean:
	rm -f $(TARGET) $(OBJECTS)
