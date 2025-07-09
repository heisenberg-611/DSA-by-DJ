package problems.DJSpecial;
//Construct a method which takes the head of a 
//singly linked list as input and returns the 
//sum of all node elements located at even indices (0-based).
import node.Node;
import utils.LinkedListUtilsOOP;
public class special2 {
    public static int sumEvenIndices(Node head){
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return -1;
        }
        int sum = 0;
        int count = 0;
        Node temp = head;
        while(temp != null){
            if (count % 2 == 0) {
                sum += (int) temp.data;
            }
            count++;
            temp = temp.next;
        }
        return sum;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        System.out.println(sumEvenIndices(ll.head));
    }
}
