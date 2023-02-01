package com.example.lists.singlylinkedlist;


import java.util.AbstractList;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public void pushFront(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public Node<T> popFront() {

        if (isEmpty()) {
            return null;
        }
        Node<T> current = head;
        head = current.getNext();
        current.setNext(null);
        size--;
        return current;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
