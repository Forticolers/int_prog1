package ch.jeanbourquj.cifom.utils;


import ch.jeanbourquj.cifom.domain.Data;
import java.util.Objects;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class SingleDoubleEntryLinkedList_prof implements List {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public SingleDoubleEntryLinkedList_prof() {
    }

    public SingleDoubleEntryLinkedList_prof(List l) {
        this();
        if (!l.isEmpty()) {
            Node node = new Node(l.getFirst(), null);
            this.first = node;
            size += 1;
            for (int i = 1; i < l.size(); i += 1) {
                Node next = new Node(l.get(i), null);
                node.setNext(next);
                node = next;
                size += 1;
            }
            last = node;
        }
    }

    private Node getNode(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Erreur: Liste vide!");
        }
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("Index est host limite!");
        }

        if (index == 0) {
            return first;
        }

        if (index == size - 1) {
            return last;
        }

        Node node = first;
        int pos = 0;
        while ((node.getNext() != null) && (pos < index)) {
            node = node.getNext();
            pos++;
        }
        return node;
    }

    private void addFirst(Object value) {
        first = new Node(value, first);
        size++;
        if (this.size() == 1) {
            last = first;
        }
    }

    @Override
    public void add(Object value) {
        if (isEmpty()) {
            this.addFirst(value);
        } else {
            Node node = new Node(value, null);
            last.setNext(node);
            last = node;
            size++;
        }
    }

    @Override
    public void add(int index, Object value) {
        Node newNode = new Node(value, null);
        if (this.isEmpty() || (index == 0)) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node node = this.getNode(index - 1);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return this.getNode(index).getValue();

    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Erreur: Liste vide!");
        }

        return first.getValue();
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Erreur: Liste vide!");
        }

        return last.getValue();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void remove() {
        this.remove(this.size() - 1);
    }

    @Override
    public void remove(int index) {
        Node node = this.getNode(index);
        if (index == 0) {
            this.first = node.getNext();
            if (this.first == null
                    || this.first.getNext() == null) {
                this.last = this.first;
            }
        } else {
            Node precedent = this.getNode(index - 1);
            precedent.setNext(node.getNext());

            if (precedent.getNext() == null) {
                this.last = precedent;
            }
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "SingleDoubleEntryLinkedList{" + "first=" + first
                + ", size=" + size + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.first);
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
        final List list = (List) obj;

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

    private class Node {

        private Object value;
        private Node next;

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(Node n) {
            this(n.getValue(), n.getNext());
        }

        Node getNext() {
            return this.next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Object getValue() {
            return value;
        }

        void setValue(Object value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.value);
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
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }

    }

}
