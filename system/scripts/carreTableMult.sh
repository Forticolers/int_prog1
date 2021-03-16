#!/bin/bash
carre=$1
if [ -z "$1" ];
then
	carre=12
fi
printf "\t"
for Z in $(seq $carre)
do
	printf "%5s" "$Z"
done

printf "\n\t"

for D in $(seq $carre)
do
	printf -- "-------";
done

printf "\n"

for X in $(seq $carre)
do
	printf "%5s\t" "$X:"
	for Y in $(seq $carre)
	do
		((calc=X*Y))
		printf "%5s" "$calc";
	done
	printf "\n"
done
