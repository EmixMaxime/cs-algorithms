.PHONY: compile tests run cleantmp

# The compilator
CC      = gcc
# flags for the compilator
CFLAGS  = -g

RM_FOLDER  = rm -fR

# Folders config
DIST    = ./dist
SRC     = ./src
HEADERS = ./src
TESTS   = ./tests
TESTS_DIST = ./tests/dist

$(SRC)/%.o: $(SRC)/%.c
	$(CC) $(CFLAGS) -c $< -o $@ -I $(HEADERS)

cleantmp:
	@echo "Cleaning .o files"
	rm -rf $(SRC)/*.o

compile: $(SRC)/hanoi.o $(SRC)/main.o
	gcc -o $(DIST)/Binary $?
	# $(MAKE) cleantmp

# $(TESTS)/%.o: $(TESTS)/%.c
# 	$(CC) $(CFLAGS) -c $< -o $@ -I $(HEADERS)

# tests: $(TESTS)/linkedlistTest.o $(SRC)/linkedlist.o
# 	gcc -o $(TESTS_DIST)/Binary $?

# run: tests
# 	./tests/dist/Binary