#!/bin/bash
index=0
cat file.txt | while read line
do
    index=$index+1
    if [[ index -eq 10 ]]; then
        echo $line
        break
    fi
done
