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
    void add(Object value);
    /**
     *
     * @param index
     * @param value
     */
    void add(int index, Object value);
    /**
     *
     */
    void clear();
    /**
     *
     * @param index
     * @return Data.
     */
    Object get(int index);
    /**
     *
     * @return Data.
     */
    Object getFirst();
    /**
     *
     * @return Data.
     */
    Object getLast();
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
