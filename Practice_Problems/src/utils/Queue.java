package utils;

import node.Node;

// DO NOT CHANGE THIS CLASS
public class Queue {

    // DO NOT CHANGE THE VARIABLES OR ACCESS MODIFIERS
    private Node front, rear;
    private int size;

    // DO NOT CHANGE THIS CONSTRUCTOR
    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // DO NOT CHANGE THIS METHOD
    public void enqueue(Object elem) {
        Node newNode = new Node(elem);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        size++; // increment size
    }

    // DO NOT CHANGE THIS METHOD
    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Object removedElem = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--; // decrement size
        return removedElem;
    }

    // DO NOT CHANGE THIS METHOD
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return this.front.data;
    }

    // DO NOT CHANGE THIS METHOD
    public boolean isEmpty() {
        return this.front == null;
    }

    // DO NOT CHANGE THIS METHOD
    public void displayQueue() {
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // ✅ NEW METHOD: Returns the number of elements in the queue
    public int size() {
        return this.size;
    }
}
