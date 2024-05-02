CC = gcc
CFLAGS = -Wall -Wextra -std=c99
LDFLAGS =
SOURCES = $(wildcard *.c)
OBJECTS = $(SOURCES:.c=.o)
EXECUTABLES = $(OBJECTS:.o=.bin)

.PHONY: all clean

all: $(EXECUTABLES)

%.bin: %.o
	$(CC) $(CFLAGS) $(LDFLAGS) $< -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(EXECUTABLES) $(OBJECTS)

