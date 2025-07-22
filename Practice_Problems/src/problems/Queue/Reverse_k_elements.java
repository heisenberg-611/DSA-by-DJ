package problems.Queue;

import utils.Queue;
import utils.Stack;

public class Reverse_k_elements {

    // Function to reverse first k elements of a queue.
    public static Queue reverseFirstK(Queue q, int k) {
        Stack stack = new Stack();
        int size = q.size();

        // Step 1: Push first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.dequeue());
        }

        // Step 2: Pop from stack and enqueue back to queue (reverses first k)
        while (!stack.isEmpty()) {
            q.enqueue(stack.pop());
        }

        // Step 3: Move the remaining (size - k) elements to the back to preserve their order
        for (int i = 0; i < size - k; i++) {
            q.enqueue(q.dequeue());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i <= 5; i++) {
            q.enqueue(i);  // Queue: 1 2 3 4 5
        }

        System.out.print("Original Queue: ");
        q.displayQueue(); // Expected: 1 2 3 4 5

        q = reverseFirstK(q, 3); // Should reverse to: 3 2 1 4 5

        System.out.print("After Reversing first 3 elements: ");
        q.displayQueue(); // Expected: 3 2 1 4 5
    }
}
