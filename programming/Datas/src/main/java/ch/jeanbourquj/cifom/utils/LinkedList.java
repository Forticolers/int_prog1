/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom.utils;

import java.util.Objects;

/**
 *
 * @author JeanbourquJ
 */
public class LinkedList implements List {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.first);
        hash = 97 * hash + Objects.hashCode(this.last);
        hash = 97 * hash + this.size;
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
        final LinkedList other = (LinkedList) obj;
        if (this.size != other.size) {
            return false;
        }
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.last, other.last)) {
            return false;
        }
        return true;
    }

    /**
     *
     */
    public static final String ERREUR_LISTE_VIDE = "Erreur: Liste vide!";

    /**
     *
     */
    public static final String ERREUR_INDEX_HORS_LIMITE = "Index est hors limite!";
    private Node first = null;
    private Node last = null;
    private int size = 0;

    public LinkedList() {

    }

    /**
     * Copy constructor.
     *
     * @param l
     */
    public LinkedList(List l) {

    }

    private Node getNode(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException(ERREUR_INDEX_HORS_LIMITE);
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
        first = new Node(value, null, first);
        if (first.next != null) {
            first.next.setPrevious(first);
        }
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
            Node node = new Node(value, last, null);
            last.setNext(node);
            last = node;
            size++;
        }
    }

    @Override
    public void add(int index, Object value) {
        Node newNode = new Node(value, null, null);
        if (this.isEmpty() || (index == 0)) {
            newNode.setNext(first);
            if (first != null) {
                first.getNext().setPrevious(newNode);
            }
            first = newNode;
        } else {
            Node node = this.getNode(index - 1);
            newNode.setNext(node.getNext());
            if (node != null) {
                newNode.setPrevious(node);
            }
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
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }

        return first.getValue();
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
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
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        Node node = this.getNode(index);
        if (index == 0) {
            Node next = node.getNext();
            this.first = next;
            if (this.first != null) {
                this.first.setPrevious(null);
            }
            if (this.first == null || this.first.getNext() == null) {
                this.last = this.first;
            }
        } else {
            Node previous = node.getPrevious();
            Node next = node.getNext();
            previous.setNext(next);
            if (next != null) {
                next.setPrevious(previous);
            }
            if (previous.getNext() == null) {
                this.last = previous;
            }
        }
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {

        private Object value;
        private Node next;
        private Node previous;

        Node(Object value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        Node(Node n) {
            this(n.getValue(), n.getPrevious(), n.getNext());
        }

        Node getPrevious() {
            return this.previous;
        }

        Node getNext() {
            return this.next;
        }

        void setPrevious(Node previous) {
            this.previous = previous;
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
            return "Node{" + "value=" + value + ", previous={" + value.toString() + "}, next={" + next.toString() + "}}";
        }

    }

}
