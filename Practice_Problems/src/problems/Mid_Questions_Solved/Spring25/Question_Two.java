package problems.Mid_Questions_Solved.Spring25;
import node.Node;
import utils.HashUtils;
public class Question_Two {
    public static void insert_HashTable(Object key, Object value, HashUtils ht) {
        if(key == null) return;
        int index = ht.hashfunc(key);
        Node newNode = new Node(key, value);
        if((int)value % 2 == 0 && ht.hashTable[index] == null){
            ht.hashTable[index] = newNode;
        } else {
            if((int)value % 2 == 0){
                newNode.next = ht.hashTable[index];
                ht.hashTable[index] = newNode;
            } else {
                Node temp = ht.hashTable[index];
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        ht.size++;
    }
    public static void main(String[] args) {
        //generate tasting for the insert method
        HashUtils ht = new HashUtils(10);
        insert_HashTable("A", 2, ht);
        insert_HashTable("B", 4, ht);
        insert_HashTable("C", 6, ht);
        insert_HashTable("D", 8, ht);
        insert_HashTable("E", 10, ht);
        insert_HashTable("F", 12, ht);
        insert_HashTable("G", 14, ht);
        insert_HashTable("H", 16, ht);
        insert_HashTable("I", 18, ht);
        insert_HashTable("J", 20, ht);
        insert_HashTable("k", 21, ht);
        insert_HashTable("ht", 22, ht);
        ht.print();
    }
}
