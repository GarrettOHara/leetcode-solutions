CXX = g++
CXXFLAGS = -std=c++20
LDLIBS = -lstdc++

# Get all .cpp files in the current directory
SRCS := $(wildcard *.cpp)

# Generate corresponding object file names
OBJS := $(SRCS:.cpp=.o)

# Generate corresponding executable file names with .bin extension
EXECUTABLES := $(SRCS:.cpp=.bin)

# Rule to compile .cpp files to object files
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Rule to link object files into executables with .bin extension
%.bin: %.o
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDLIBS)

# Phony target to compile all executables
all: $(EXECUTABLES)

# Phony target to clean generated files
.PHONY: clean
clean:
	rm -f $(OBJS) $(EXECUTABLES)

