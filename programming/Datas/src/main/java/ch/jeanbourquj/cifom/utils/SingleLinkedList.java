/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom.utils;

import ch.jeanbourquj.cifom.domain.Data;
import java.util.Objects;

/**
 *
 * @author JeanbourquJ
 */
public class SingleLinkedList implements List {

    public static final String ERREUR_LISTE_VIDE = "Erreur: Liste vide!";
    public static final String INDEX_HORS_LIMITE = "Index est hors limite!";
    private Node first = null;

    public SingleLinkedList() {

    }

    public SingleLinkedList(List l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Data value) {
        this.add(this.size(), value);
    }

    private Node getLastNode() {
        return this.getNode(this.size() - 1);
    }

    private Node getNode(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        Node node = first;
        if (node != null) {
            int pos = 0;
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

    @Override
    public void add(int index, Data value) {
        Node newNode = new Node(value, null);
        if (this.isEmpty() || (index == 0)) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node node = this.getNode(index - 1);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
    }

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
                }
            }
        }
    }

    @Override
    public Data get(int index) {
        return this.getNode(index).getValue();
    }

    @Override
    public Data getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        return this.first.getValue();
    }

    @Override
    public Data getLast() {
        return this.getLastNode().getValue();
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
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(ERREUR_LISTE_VIDE);
        }
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException(INDEX_HORS_LIMITE);
        }
        if (this.first.next != null) {

            Node current = this.getNode(index);
            Node next = current.getNext();
            if (index != 0) {
                Node previous = this.getNode(index - 1);

                previous.next = next;
            } else {
                this.first = next;
            }
        } else {
            this.first = null;
        }
    }

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

    @Override
    public String toString() {
        return "SingleLinkedList{" + "first=" + first + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.first);
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
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

    private static class Node {

        private Data value;
        private Node next;

        public Node(Data value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node n) {
            this(n.getValue(), n.getNext());
        }

        Node getNext() {
            return this.next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Data getValue() {
            return this.value;
        }

        void setValue(Data value) {
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
            final SingleLinkedList.Node other = (SingleLinkedList.Node) obj;
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
