#!/bin/bash
input="./file.txt"
while IFS= read -r line
  if [[ "$input" -eq "Line10" ]]
    then 
      echo "$line"
  fi
done line =  "$input"
