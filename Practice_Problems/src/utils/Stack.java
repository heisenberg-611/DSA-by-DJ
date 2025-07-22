package utils;

public class Stack {
    private Node top;
    private int size;

    // Inner private Node class
    private static class Node {
        int elem;
        Node next;

        Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int elem) {
        Node nn = new Node(elem, top);
        top = nn;
        size++;
    }

    public Integer pop() {
        if (top == null) {
            throw new RuntimeException("Stack Underflow - Cannot pop from empty stack");
        }
        int e = top.elem;
        top = top.next;
        size--;
        return e;
    }

    public Integer peek() {
        if (top == null) {
            throw new RuntimeException("Stack Underflow - Cannot peek from empty stack");
        }
        return top.elem;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Top -> ");
        Node current = top;
        while (current != null) {
            sb.append(current.elem).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
