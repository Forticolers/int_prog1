/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom.utils;

import java.util.Objects;

/**
 * A rather unsignificative change.
 * @author JeanbourquJ
 */
public class SingleDoubleEntryLinkedList implements List {

    /**
     *
     */
    public static final String ERREUR_LISTE_VIDE = "Erreur: Liste vide!";

    /**
     *
     */
    public static final String INDEX_HORS_LIMITE = "Index est hors limite!";
    /**
     *
     */
    private Node first = null;
    /**
     *
     */
    private Node last = null;

    /**
     *
     */
    public SingleDoubleEntryLinkedList() {

    }

    /**
     *
     * @param l
     */
    public SingleDoubleEntryLinkedList(final List l) {
        if (l == null) {
            throw new RuntimeException("Liste passée en paramètre est nulle");
        }
        for (int i = 0; i < l.size(); i++) {
            this.add(l.get(i));
        }
    }

    /**
     *
     * @param value
     */
    @Override
    public void add(final Object value) {
        this.add(this.size(), value);
    }

    private Node getLastNode() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        return this.last;
    }

    private Node getNode(final int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        Node node = first;
        if (node != null) {
            int pos = 0;
            if(index == this.size()-1){
                return this.last;
            }
            while ((node.getNext() != null) && (pos < index)) {
                node = node.getNext();
                pos++;
            }
            
            if (pos != index) {
                throw new IndexOutOfBoundsException(INDEX_HORS_LIMITE);
            }
        }
        return node;
    }

    /**
     *
     * @param index
     * @param value
     */
    @Override
    public void add(final int index, final Object value) {
        Node newNode = new Node(value, null);
        if (this.isEmpty() || (index == 0)) {
            newNode.setNext(first);
            first = newNode;
            last = newNode;
        } else if (index == this.size()) {
            Node node = this.getLastNode();
            newNode.setNext(node.getNext());
            node.setNext(newNode);
            this.last = newNode;
        } else {
            Node node = this.getNode(index - 1);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
    }

    /**
     *
     */
    @Override
    public void clear() {
        if (!isEmpty()) {
            while (this.first != null) {
                if (this.first.next != null) {
                    Node tmp = first.next;
                    this.first = null;
                    this.first = tmp;
                } else {
                    this.first = null;
                    this.last = null;
                }
            }
        }
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public Object get(final int index) {
        return this.getNode(index).getValue();
    }

    /**
     *
     * @return
     */
    @Override
    public Object getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        return this.first.getValue();
    }

    /**
     *
     * @return
     */
    @Override
    public Object getLast() {
        return this.getLastNode().getValue();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.remove(this.size() - 1);
    }

    /**
     *
     * @param index
     */
    @Override
    public void remove(final int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException(INDEX_HORS_LIMITE);
        }
        if (this.first.next != null) {
            Node next = this.getNode(index).getNext();
            Node previous;
            if (index != 0) {
                previous = this.getNode(index - 1);

                previous.next = next;
                if (index == this.size()) {
                    this.last = previous;
                }
            } else if (index == this.size()) {
                previous = this.getNode(index - 1);

                previous.next = next;
                this.last = previous;
            } else {
                this.first = next;
                if (index == this.size()) {
                    this.last = next;
                }
            }
        } else {
            this.first = null;
            this.last = null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        int size = 0;

        Node node = first;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "SingleLinkedList{" + "first=" + first + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = MAGIC_NUM7;
        hash = MAGIC_NUM79 * hash + Objects.hashCode(this.first);
        return hash;
    }

    /**
     *
     */
    public static final int MAGIC_NUM7 = 7;

    /**
     *
     */
    public static final int MAGIC_NUM79 = 79;

    /**
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
        if (!(obj instanceof List)) {
            return false;
        }
        final List list = (List) obj;

        boolean sts = false;
        if (this.size() == list.size()) {
            sts = true;
            int index = 0;
            while ((index < this.size()) && (sts)) {
                sts = this.get(index).equals(list.get(index));
                index++;
            }
        }

        return sts;
    }

    private static class Node {

        /**
         *
         */
        private Object value;
        /**
         *
         */
        private Node next;

        /**
         *
         * @param nValue
         * @param nNext
         */
        Node(final Object nValue, final Node nNext) {
            this.value = nValue;
            this.next = nNext;
        }

        /**
         *
         * @param n
         */
        Node(final Node n) {
            this(n.getValue(), n.getNext());
        }

        /**
         *
         * @return Node.
         */
        Node getNext() {
            return this.next;
        }

        /**
         *
         * @param nNext
         */
        void setNext(final Node nNext) {
            this.next = nNext;
        }

        /**
         *
         * @return Object.
         */
        Object getValue() {
            return this.value;
        }

        /**
         *
         * @param nValue
         */
        void setValue(final Object nValue) {
            this.value = nValue;
        }

        /**
         *
         * @return
         */
        @Override
        public int hashCode() {
            int hash = MAGIC_NUM7;
            hash = MAGIC_NUM79 * hash + Objects.hashCode(this.value);
            return hash;
        }

        /**
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
            final SingleDoubleEntryLinkedList.Node other
                    = (SingleDoubleEntryLinkedList.Node) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }

        /**
         *
         * @return
         */
        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }
    }

}
