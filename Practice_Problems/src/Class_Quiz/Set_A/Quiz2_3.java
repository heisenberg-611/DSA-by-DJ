package Class_Quiz.Set_A;

import node.Node;

public class Quiz2_3 {
    public Node[] hashTable;
    public int size = 0;

    public Quiz2_3(int size) {
        this.hashTable = new Node[size];
    }
    public int hashfunc(String key){
        if(key == null) return 0;
        int sum = 0;
        if(key.length()<3){
            key+="X";
        }
        for (int i = 0; i < 3; i++) {
            sum += (int) key.charAt(i);
        }
        return sum % hashTable.length;
    }
    public void insert(String key, String data) {
        if (key == null) {
            return;
        }
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
    public void display() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                System.out.print("Index " + i + ": ");
                Node current = hashTable[i];
                while (current != null) {
                    System.out.print(current.key + " (" + current.data + ") " + "-> ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        Quiz2_3 ht = new Quiz2_3(10);

        ht.insert("PKG123", "In Transit");
        ht.insert("AB", "Delivered");
        ht.insert("PKG456", "Returned");

        System.out.println("\nHash table after insertions:");
        ht.display();

        ht.insert("PKG123", "Delivered"); // Updating PKG123 status

        System.out.println("\nHash table after updates:");
        ht.display();
    }
}