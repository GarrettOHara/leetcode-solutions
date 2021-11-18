#!/bin/bash


# Build
if [ "$#" -ne 1 ]
then
  echo "Illegal number of parameters"
else
# Clean
  if [ "$clean" ]
    then
      echo "Cleaning build files"
	    rm -rf *.class
    else
      echo "Nothing to remove"
  fi
fi
