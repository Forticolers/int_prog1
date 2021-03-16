#!/bin/bash
mult=12
for X in $(seq $mult)
do
	((calc=X*$1))
 	echo "$X"*"$1"=$calc;
done
