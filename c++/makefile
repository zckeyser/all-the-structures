CC = g++
CFLAGS = -c -Wall -g -Os

SOURCES=$(shell find . -type f -iname '*.cpp')

OBJECTS=$(patsubst %.cpp, %.o, $(wildcard *.cpp))

TARGET=Structures

all: $(TARGET)

$(TARGET): $(OBJECTS)
		$(CC) -o $@ $^

%.o: %.c
		$(CC) $(CFLAGS) $^ -o $@

clean:
	rm -f $(TARGET) $(OBJECTS)
