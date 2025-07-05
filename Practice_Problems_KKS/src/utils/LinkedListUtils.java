package utils;
import node.Node;
public class LinkedListUtils {
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printListinStyle(Node head){
        Node n = head;
        while (n!=null){
            if (n.next !=null)
                System.out.print(n.data+" -> ");
            else
                System.out.println(n.data);
            n = n.next;
        }
    }

    public static Node createList( Object[] arr ){
        Node head = new Node( arr[0] );
        Node n = head;
        for ( int i=1; i<arr.length; i++ ){
            Node newN = new Node( arr[i] );
            n.next = newN;
            n = n.next;
        }
        return head;
    }
    public static int size(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static Node nodeAt(Node head, int index) {
        int count = 0;
        while (head != null) {
            if (count == index) {
                return head;
            }
            count++;
            head = head.next;
        }
        return head;
    }
    
    public static Node insertAtHead(Node head, int data) { // Time complexity O(1) Space Complexity O(1)
        if (head == null) {
            return insertAtEnd(head, data);
        } else {
            Node newHead = new Node(data);
            newHead.next = head;
            return newHead;
        }
    }

    public static Node insertAtEnd(Node head, int data) { // Time complexity O(n) Space Complexity O(1)
        Node newNode = new Node(data);
        if(head == null) {
            return newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return head;
        }
    }

    public static void insertAt(Node head, int index, int data) { //Time complexity O(n) Space Complexity O(1)
        if (index == 0) {
            insertAtHead(head,data);
        } else {
            Node prev = nodeAt(head, index-1);
            if (prev == null) {
                throw new IndexOutOfBoundsException("Index out of bounds" + index);
            }
            Node next = prev.next;
            Node newNode = new Node(data);
            prev.next = newNode;
            newNode.next = next;
        }
    }

    public static Node remove(Node head, int index) { // Time complexity O(n) Space Complexity O(1)
        if (index == 0) {
            return head.next;
        } else {
            Node prev = nodeAt(head, index-1);
            Node next = prev.next.next;
            prev.next = next;
            return head;
        }
    }
}