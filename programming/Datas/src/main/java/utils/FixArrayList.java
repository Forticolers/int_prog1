/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import ch.jeanbourquj.cifom.Data;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author JeanbourquJ
 */
public class FixArrayList {

    private int size = -1;
    private Data[] values = null;

    /**
     * Stirng value of empty array.
     */
    public static final String ARRAY_VIDE = "L'array est pleine";

    /**
     * String value of out of bounds index.
     */
    public static final String OUT_OF_BOUNDS = "Index hors limite.";

    /**
     * FixArrayList constructor.
     *
     * @param taille Used for now but will be upgraded to an array with no max
     * size.
     */
    public FixArrayList(final int taille) {
        if (taille < 0) {
            throw new IndexOutOfBoundsException(
                    "Erreur: Mauvaise valeur d'initialisation!");
        }

        this.size = 0;
        this.values = new Data[taille];
    }

    /**
     * Make a standard clone of the FixArrayList passed in parameters.
     *
     * @param list FixArrayList.
     */
    public FixArrayList(final FixArrayList list) {
        if(list == null){
            throw new  RuntimeException("Liste passée en paramètre est nulle");
        }
        this.size = list.size;
        this.values = new Data[list.values.length];
        for(int i = 0; i < this.size; i++){
            this.values[i] = list.values[i];
        }
    }

    /**
     * Add a value to the array.
     *
     * @param value
     */
    public void add(final Data value) {
        if (size == values.length) {
            throw new IndexOutOfBoundsException(
                    "Erreur: Ajout dans une liste plein!");
        }
        values[size] = value;
        size++;
    }

    /**
     * Add value to specifix index to the array.
     *
     * @param index
     * @param value
     */
    public void add(final int index, final Data value) {
        if (size == values.length) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }

        if (!((index >= 0) && (index <= size))) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }

        for (int i = size - 1; i >= index; i--) {
            values[i + 1] = values[i];
        }
        values[index] = value;
        size++;
    }

    /**
     * Remove last entry.
     */
    public void remove() {
        remove(size - 1);
    }

    /**
     * Remove at specific index.
     *
     * @param index
     */
    public void remove(final int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException(ARRAY_VIDE);
        }

        if (!((index >= 0) && (index < size))) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }

        for (int i = index; i < size; i++) {
            values[i] = values[i + 1];
        }
        size--;
    }

    /**
     * Return the size of the array (the number of objects in it).
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Clear the whole array.
     */
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.values[i] = null;
        }
        this.size = 0;
    }

    /**
     * Return first entry.
     *
     * @return Data
     */
    public Data getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ARRAY_VIDE);
        }
        return this.values[0];
    }

    /**
     * Return last entry.
     *
     * @return Data
     */
    public Data getLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ARRAY_VIDE);
        }
        return this.values[this.size - 1];
    }

    /**
     * Get data at specifix index.
     *
     * @param index
     * @return Data
     */
    public Data get(final int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException(ARRAY_VIDE);
        }

        if (!((index >= 0) && (index < size))) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }

        return values[index];
    }

    /**
     * Return true if empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns true if obj is equals.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FixArrayList)) {
            return false;
        }

        FixArrayList list = (FixArrayList) obj;

        boolean sts = false;
        if (this.size() == list.size()) {
            sts = true;
            int index = 0;
            while ((index < this.size()) && sts) {
                sts = this.get(index).equals(list.get(index));
                index++;
            }
        }

        return sts;
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = HASH_HASH;
        hash = HASH_SEL * hash + Objects.hashCode(this.size);
        hash = HASH_SEL * hash + Arrays.deepHashCode(this.values);
        return hash;
    }
    /**
     *
     */
    public static final int HASH_HASH = 5;
    /**
     *
     */
    public static final int HASH_SEL = 83;
}
