#!/bin/bash
# 
# auteur: Jeanbourquin Julien
HOST=localhost
PORT=5432
USER=genealogie
PASSWORD=genealogiepass
DATABASE=genealogieDB
PSQL_SCRIPT=script.psql

PGPASSWORD=$PASSWORD psql -h $HOST -p $PORT -U $USER $DATABASE -f $PSQL_SCRIPT
