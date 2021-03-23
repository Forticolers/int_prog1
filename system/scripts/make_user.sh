#!/bin/bash
MAX_USER=100
USERNAME="user"
INT_COUNTER=1

function add_user {
    INT_COUNTER=1
    for user in $(seq $MAX_USER)
    do
        
        curr_username="$USERNAME$INT_COUNTER"
        printf "Création de user ${curr_username}\n"
        PASS=$(mkpasswd "${curr_username}")
        useradd -m "${curr_username}" -p "${PASS}" -s /bin/bash
        INT_COUNTER=$(($INT_COUNTER+1))
    done;
}

function del_user {
   INT_COUNTER=1
    for user in $(seq $MAX_USER)
    do
        curr_username="$USERNAME$INT_COUNTER"
        printf "Suppression de user ${curr_username}\n"
        userdel -r -f "$curr_username"
        INT_COUNTER=$(($INT_COUNTER+1))
    done;
}
if [ -z "$2" ]; then
    if [ "$2" == '-max']; then
        MAX_USER= $(echo $2 | grep -oP "(?i)$TYPE_PARAM"'=\K(.*)')
    fi
fi
if [ "$1" != '-del' ]; then
add_user
fi
if [ "$1"  == '-del' ]; then
del_user
fi