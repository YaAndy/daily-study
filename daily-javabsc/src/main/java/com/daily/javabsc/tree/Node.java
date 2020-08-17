package com.daily.javabsc.tree;

/**
 * @author Rocia
 * @description :
 * @CreateTime 2018-08-17-9:39
 */
public class Node {

    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

}
