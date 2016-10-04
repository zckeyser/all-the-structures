CC = gcc
CFLAGS = -c -Wall -g -Os

SOURCES=$(shell find . -type f -iname '*.c')

OBJECTS=$(foreach x, $(basename $(SOURCES)), $(x).o)

TARGET=Structures

$(TARGET): $(OBJECTS)
	$(CC) $^ -o $@

clean:
	rm -f $(TARGET) $(OBJECTS)
