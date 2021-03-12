package ch.jeanbourquj.cifom.utils;

import ch.jeanbourquj.cifom.domain.Data;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public interface List {
    /**
     *
     * @param value
     */
    void add(Data value);
    /**
     *
     * @param index
     * @param value
     */
    void add(int index, Data value);
    /**
     *
     */
    void clear();
    /**
     *
     * @param index
     * @return Data.
     */
    Data get(int index);
    /**
     *
     * @return Data.
     */
    Data getFirst();
    /**
     *
     * @return Data.
     */
    Data getLast();
    /**
     *
     * @return boolean.
     */
    boolean isEmpty();
    /**
     *
     */
    void remove();
    /**
     *
     * @param index
     */
    void remove(int index);
    /**
     *
     * @return int.
     */
    int size();
}
