package utils;

import node.Node;

public class DHDCLUtils {
    public Node dh; // Dummy head
    public Node tail; // Last node

    // Constructor: initializes empty list
    public DHDCLUtils() {
        Node n = new Node(null); // Dummy node
        dh = n;
        dh.next = dh;
        dh.prev = dh;
        tail = n;
    }

    // Create list from array
    public void createList(Object[] arr) {
        for (Object o : arr) {
            addNode(o);
        }
    }

    // Add node at end
    public void addNode(Object data) {
        Node n = new Node(data);
        n.next = dh;
        n.prev = tail;
        tail.next = n;
        dh.prev = n;
        tail = n;
    }

    // Insert node at specified index (0-based)
    public void insertAtIndex(Object data, int index) {
        int size = countNodes();
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }
        if (index == size) {
            // Append at end
            addNode(data);
            return;
        }

        Node n = new Node(data);

        // Traverse to node currently at 'index'
        Node current = dh.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Insert n before 'current'
        n.next = current;
        n.prev = current.prev;
        current.prev.next = n;
        current.prev = n;

        // If inserted at position 0, update tail if list was empty
        if (size == 0) {
            tail = n;
        }
    }

    // Delete node by value (deletes first occurrence)
    public void deleteByValue(Object data) {
        Node current = dh.next;
        while (current != dh) {
            if (current.data.equals(data)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                // If deleting tail, update tail
                if (current == tail) {
                    tail = current.prev != dh ? current.prev : dh;
                }
                System.out.println("Deleted node with value: " + data);
                return;
            }
            current = current.next;
        }
        System.out.println("Value not found: " + data);
    }

    // Delete node by index (0-based)
    public void deleteAtIndex(int index) {
        int size = countNodes();
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        Node current = dh.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        if (current == tail) {
            tail = current.prev != dh ? current.prev : dh;
        }

        System.out.println("Deleted node at index: " + index);
    }

    // Count the number of nodes
    public int countNodes() {
        int count = 0;
        Node current = dh.next;
        while (current != dh) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Convert list to array
    public Object[] toArray() {
        int size = countNodes();
        Object[] arr = new Object[size];
        Node current = dh.next;
        int i = 0;
        while (current != dh) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    // Traverse forward
    public void traverseForward() {
        Node current = dh.next;
        while (current != dh) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Traverse backward
    public void traverseBackward() {
        Node current = dh.prev;
        while (current != dh) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public Node getDummy() {
        return dh;
    }

    public Node getHead() {
        return dh.next;
    }
}