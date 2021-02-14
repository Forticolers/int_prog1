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
    public static final String ARRAY_VIDE = "L'array est pleine";

    public FixArrayList(final Integer pmaxSize) {
        this.maxSize = pmaxSize;
        this.size = 0;
        this.values = new Data[this.maxSize];
    }

    public FixArrayList(final FixArrayList list) {
        throw new UnsupportedOperationException();
    }

    public void add(final Data value) {
        if (this.size - 1 < this.maxSize) {
            this.values[this.size] = value;
            this.size += 1;
        }
    }

    public void add(final int index, final Data value) {
        throw new UnsupportedOperationException();
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        for (int i = 1; i < this.size; i++) {
            this.values[i - 1] = this.values[i];
        }
        this.size -= 1;
    }

    public void remove(final int index) {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        if (index > this.size()) {
            throw new RuntimeException("Index hors limite.");
        }
        for (int i = index; i < this.size - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        this.size -= 1;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.values[i] = null;
        }
        this.size = 0;
    }


    public Data getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        return this.values[0];
    }

    public Data getLast() {
        if (this.isEmpty()) {
            throw new RuntimeException(ARRAY_VIDE);
        }
        return this.values[this.size-1];
    }

    public Data get(final int index) {
        if (index > this.size()) {
            throw new RuntimeException("Index hors limite.");
        }
        return this.values[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean equals(Object obj) {
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

    
}
