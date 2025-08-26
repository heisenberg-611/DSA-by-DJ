package Class_Quiz.Set_B;
import utils.Queue;
import utils.Stack;
public class Quiz2_2 {
    public static void reverseFirstN(Queue original, int n) {
    Stack temp1 = new Stack();

    int size = original.size();

    for (int i = 0; i < n; i++) {
        temp1.push(original.dequeue());
    }
    while (!temp1.isEmpty()) {
        original.enqueue(temp1.pop());
    }
    for (int i = 0; i < size - n; i++) {
        original.enqueue(original.dequeue());
    }
}

    
    public static void main(String[] args) {
        Queue x = new Queue();
        x.enqueue(5);
        x.enqueue(4);
        x.enqueue(3);
        x.enqueue(2);
        x.enqueue(1);
        System.out.println("Original queue (top to bottom):");
        printQueue(x);
        int n = 3;
        reverseFirstN(x, n);
        System.out.println("Queue after reversing first " + n + " elements:");
        printQueue(x);
    }


    private static void printQueue(Queue x) {
    int size = x.size();
    Queue temp = new Queue();
    for (int i = 0; i < size; i++) {
        int val = (int) x.dequeue();
        System.out.print(val + " ");
        temp.enqueue(val);
    }
    System.out.println();
    for (int i = 0; i < size; i++) {
        x.enqueue(temp.dequeue());
    }
}

}
