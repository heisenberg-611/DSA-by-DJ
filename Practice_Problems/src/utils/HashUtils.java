package utils;

import node.Node;

public class HashUtils{
    public Node[] hashTable;
    public int size = 0;
    private static final double LOAD_FACTOR = 0.75;

    public HashUtils(int size) {
        this.hashTable = new Node[size];
    }

    public int hashfunc(Object key){
        if(key == null) return 0;
        int sum = 0;    
        for (int i = 0; i < key.toString().length(); i++) {
            sum += (int) key.toString().charAt(i);
        }
        return sum % hashTable.length;
    }

    private void resizeIfNeeded() {
        double currentLoad = (double) size / hashTable.length;
        if (currentLoad >= LOAD_FACTOR) {
            int newSize = hashTable.length * 2; // Double the size
            Node[] newTable = new Node[newSize];
            
            // Rehash all elements into the new table
            for (Node node : hashTable) {
                Node current = node;
                while (current != null) {
                    Node next = current.next;
                    int newIndex = current.key.hashCode() % newSize;
                    current.next = newTable[newIndex];
                    newTable[newIndex] = current;
                    current = next;
                }
            }
            hashTable = newTable; // Replace the old table
        }
    }

    public void insert(Object key, Object data) {
        if (key == null) {
            return;
        }
        if (size >= hashTable.length * 0.75) {
            System.out.println("Warning: Hash table is getting full. Consider resizing.");
        }
        resizeIfNeeded();
        int index = hashfunc(key);
        Node newNode = new Node(key, data);
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            newNode.next = hashTable[index];
            hashTable[index] = newNode;
        }
        size++;
    }

    public Node search(Object key) {
        if (key == null) {
            return null;
        }
        int index = this.hashfunc(key);
        if (hashTable[index] == null) {
            return null;
        } else {
            Node temp = hashTable[index];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public void delete(Object key) {
        if (key == null) {
            return;
        }
        int index = this.hashfunc(key);
        if(hashTable[index] != null){
            Node temp = hashTable[index];
            if(temp.key.equals(key)){
                hashTable[index] = temp.next;
            } else {
                Node prev = temp;
                temp = temp.next;
                while(temp != null){
                    if(temp.key.equals(key)){
                        prev.next = temp.next;
                        size--;
                        break;
                    }
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
    }

    public void print() {
        System.out.println("\nHash Table Contents (Size: " + size + "/" + hashTable.length + "):");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                System.out.print("[" + i + "]: ");
                Node temp = hashTable[i];
                while (temp != null) {
                    System.out.print(temp.key + "=" + temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }
        }
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}