package utils;

import node.Node;

public class LinkedListUtilsOOP {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void createList(Object[] arr) {// Time complexity O(n)
        if (arr == null || arr.length == 0) {
            head = null;
            return;
        }
        head = new Node(arr[0]);
        Node n = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            n.next = newNode;
            n = n.next;
        }
    }

    public Node reverseNodeOutplace() {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.data);
            n.next = prev;
            prev = n;
            temp = temp.next;
        }
        return prev;
    }

    public void reverseNodeInplace() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    public void insertAtEnd(int data) { // Time complexity O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void insertAtHead(int data) { // Time complexity O(1)
        Node newNode = new Node(data);
        // if (head == null) { //empty list
        // head = newNode;
        // tail = newNode;
        if (head == null) { // same works
            insertAtEnd(data);
        } else { // non-empty list
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayinStyle() {
        Node n = head;
        while (n != null) {
            if (n.next != null)
                System.out.print(n.data + " -> ");
            else
                System.out.println(n.data);
            n = n.next;
        }
    }

    public int size() { // Time complexity O(n)
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void insertAt(int index, int data) { // Time complexity O(n) Space Complexity O(1)
        Node x = new Node(data);
        Node temp = head;
        if (index == 0) {
            insertAtHead(data);
            return;
        } else if (index == size()) {
            insertAtEnd(data);
            return;
        } else if (index < 0 || index > size()) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        x.next = temp.next;
        temp.next = x;
        size++;
    }

    public Object getElementAt(int index) { // Time complexity O(n)
        Node temp = head;
        if (index < 0) {
            System.out.println("Index out of bounds");
            return -1;
        } else if (index > size()) {
            System.out.println("Index out of bounds");
            return -1;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void deleteAt(int index) {
        Node temp = head;
        if (index < 0) {
            System.out.println("Index out of bounds");
        } else if (index == 0) {
            head = head.next;
            size--;
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            tail = temp;
            size--;
        }
    }
    // public Node nodeAt(int index) {
    // int count = 0;
    // Node temp = head;
    // while (temp != null) {
    // if (count == index) {
    // return temp;
    // }
    // count++;
    // temp = temp.next;
    // }
    // return temp;
    // }

    public Node nodeAt(int index) {
        int count = 0;
        Node temp = head;
        while (true) {
            if (count == index) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return temp;
    }

    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}