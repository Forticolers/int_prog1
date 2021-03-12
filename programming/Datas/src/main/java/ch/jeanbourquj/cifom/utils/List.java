package ch.jeanbourquj.cifom.utils;

import ch.jeanbourquj.cifom.domain.Data;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public interface List {

    void add(Data value);

    void add(int index, Data value);

    void clear();

    Data get(int index);

    Data getFirst();

    Data getLast();

    boolean isEmpty();

    void remove();

    void remove(int index);

    int size();
    
}
