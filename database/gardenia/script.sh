#!/bin/bash
# 
# auteur: Dominique Huguenin (dominique.huguenin AT rpn.ch)
HOST=localhost
PORT=5432
USER=gardenia
PASSWORD=gardeniapass
DATABASE=gardeniaDB
PSQL_SCRIPT=script.psql

PGPASSWORD=$PASSWORD psql -h $HOST -p $PORT -U $USER $DATABASE  -f $PSQL_SCRIPT
