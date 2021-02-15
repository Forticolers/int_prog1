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

    private Integer maxSize;
    private Integer size;
    private Data[] values;

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
     * @param pmaxSize Used for now but will be upgraded to an array with no max
     * size.
     */
    public FixArrayList(final Integer pmaxSize) {
        this.maxSize = pmaxSize;
        this.size = 0;
        this.values = new Data[this.maxSize];
    }

    /**
     * FixArrayList clone constructor. Will be implemented in the future.
     *
     * @param list
     */
    public FixArrayList(final FixArrayList list) {
        throw new UnsupportedOperationException();
    }

    /**
     * Add a value to the array.
     *
     * @param value
     */
    public void add(final Data value) {
        if (this.size - 1 < this.maxSize) {
            this.values[this.size] = value;
            this.size += 1;
        }
    }

    /**
     * Add value to specifix index to the array.
     *
     * @param index
     * @param value
     */
    public void add(final int index, final Data value) {
        if (this.size - 1 < this.maxSize) {
            Data tmp;
            for (int i = this.size() - 1; i >= index; i--) {
                this.values[i + 1] = this.values[i];
            }
            this.values[index] = value;
            this.size += 1;
        }
    }

    /**
     * Remove last entry.
     */
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        for (int i = 1; i < this.size; i++) {
            this.values[i - 1] = this.values[i];
        }
        this.size -= 1;
    }

    /**
     * Remove at specific index.
     *
     * @param index
     */
    public void remove(final int index) {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        if (index > this.size()) {
            throw new RuntimeException(OUT_OF_BOUNDS);
        }
        for (int i = index; i < this.size - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        this.size -= 1;
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
            throw new RuntimeException(ARRAY_VIDE);
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
            throw new RuntimeException(ARRAY_VIDE);
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
        if (index > this.size()) {
            throw new RuntimeException("Index hors limite.");
        }
        return this.values[index];
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FixArrayList other = (FixArrayList) obj;
        if (!Objects.equals(this.maxSize, other.maxSize)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Arrays.deepEquals(this.values, other.values)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = HASH_HASH;
        hash = HASH_SEL * hash + Objects.hashCode(this.maxSize);
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
