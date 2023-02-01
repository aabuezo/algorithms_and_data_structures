package com.example.lists.singlylinkedlist;

import com.example.lists.entity.Person;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        Person p1 = new Person("Juan", "Perez");
        Person p2 = new Person("Juana", "Perez");
        Person p3 = new Person("John", "Doe");
        Person p4 = new Person("Jane", "Doe");

        SinglyLinkedList<Person> pList = new SinglyLinkedList<>();
        pList.pushFront(p1);
        pList.pushFront(p2);
        pList.pushFront(p3);
        pList.pushFront(p4);

        System.out.println("size(): " + pList.size());
        pList.printList();

        System.out.println(pList.popFront());
        System.out.println(pList.popFront());

        System.out.println("isEmpty? " + pList.isEmpty());
        System.out.println("size(): " + pList.size());
        pList.printList();

        System.out.println(pList.popFront());
        System.out.println(pList.popFront());
        System.out.println(pList.popFront());

        System.out.println("isEmpty? " + pList.isEmpty());
        System.out.println("size(): " + pList.size());
        pList.printList();
    }
}
