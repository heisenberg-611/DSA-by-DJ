package utils;

import node.Node;

public class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Pushes an element onto the stack
    public void push(Object elem) {
        Node nn = new Node(elem, top); // Uses Node(Object data, Node next)
        top = nn;
        size++;
    }

    // Removes and returns the top element of the stack
    public Object pop() {
        if (top == null) {
            throw new RuntimeException("Stack Underflow - Cannot pop from empty stack");
        }
        Object e = top.data;
        top = top.next;
        size--;
        return e;
    }

    // Returns the top element without removing it
    public Object peek() {
        if (top == null) {
            throw new RuntimeException("Stack Underflow - Cannot peek from empty stack");
        }
        return top.data;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the number of elements in the stack
    public int size() {
        return size;
    }

    // Returns a string representation of the stack
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Top -> ");
        Node current = top;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
