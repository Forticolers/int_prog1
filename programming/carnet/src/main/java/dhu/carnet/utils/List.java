package dhu.carnet.utils;


import dhu.carnet.domain.Contact;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public interface List {

    void add(Contact value);

    void add(int index, Contact value);

    void clear();

    Contact get(int index);

    Contact getFirst();

    Contact getLast();

    boolean isEmpty();

    void remove();

    void remove(int index);

    int size();
    
    
}
