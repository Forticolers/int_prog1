/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
package carnet.utils;


import carnet.domain.Contact;
import java.util.Arrays;

public class ArrayList implements List {

    private Contact[] values = null;

    public ArrayList() {
        values = new Contact[0];
    }
    
    public ArrayList(List list) {
        values = new Contact[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
    }
    

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void add(Contact value) {
        add(values.length, value);
    }

    @Override
    public void add(int index, Contact value) {
        if (!((index >= 0) && (index <= values.length))) {
            throw new IndexOutOfBoundsException("Erreur: index hors champs!");
        }

        Contact[] tmp = new Contact[values.length + 1];

        for (int i = values.length - 1; i >= index; i--) {
            tmp[i + 1] = values[i];
        }

        tmp[index] = value;

        for (int i = index - 1; i >= 0; i--) {
            tmp[i] = values[i];
        }

        values = tmp;
    }

    @Override
    public void remove() {
        remove(this.size() - 1);
    }

    @Override
    public void remove(int index) {
        if (values.length == 0) {
            throw new IndexOutOfBoundsException("Erreur: la liste est vide!");
        }

        if (!((index >= 0) && (index < values.length))) {
            throw new IndexOutOfBoundsException("Erreur: index hors champs!");
        }

        Contact[] tmp = new Contact[values.length - 1];
        for (int i = values.length - 1; i > index; i--) {
            tmp[i - 1] = values[i];
        }

        for (int i = index - 1; i >= 0; i--) {
            tmp[i] = values[i];
        }

        values = tmp;
    }

    @Override
    public Contact getFirst() {
        if (this.size() == 0) {
            throw new IndexOutOfBoundsException("Erreur: la liste est vide!");
        }
        return values[0];
    }

    @Override
    public Contact getLast() {
        if (this.size() == 0) {
            throw new IndexOutOfBoundsException("Erreur: la liste est vide!");
        }
        return values[this.size() - 1];
    }

    @Override
    public Contact get(int index) {
        if (this.size() == 0) {
            throw new IndexOutOfBoundsException("Erreur: la liste est vide!");
        }

        if (!((index >= 0) && (index < this.size()))) {
            throw new IndexOutOfBoundsException("Erreur: index hors champs!");
        }

        return values[index];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            str.append(values[i]);
            str.append(" ");
        }

        return str.toString();
    }

    @Override
    public void clear() {
        values = new Contact[0];
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Arrays.deepHashCode(this.values);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        
        List list = (List) obj;
        
        boolean sts = false;
        if (this.size() == list.size()) {
            sts = true;
            int index = 0;
            while ((index < this.size()) && (sts == true)) {
                sts = this.get(index).equals(list.get(index));
                index++;
            }
        }
        
        return sts;
    }
    
    

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

}
