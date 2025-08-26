package Class_Quiz.Set_A;

import utils.Stack;

public class Quiz2_2 {
    public static void reverseFirstN(Stack original, int n) {
    Stack temp1 = new Stack();
    Stack temp2 = new Stack();
    if(original.size() < n){System.out.println("n is not valid");}
    for(int i = 0; i<n;i++){
        temp1.push(original.pop());
    }
    while(!temp1.isEmpty()){
        temp2.push(temp1.pop());
    }
    while(!temp2.isEmpty()){
        original.push(temp2.pop());
    }
}

    public static void main(String[] args) {
        Stack x = new Stack();
        // Push some elements (leftmost is top)
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(4);
        x.push(5);
        x.push(6);

        System.out.println("Original stack (top to bottom):");
        printStack(x);

        int n = 4;
        reverseFirstN(x, n);

        System.out.println("Stack after reversing first " + n + " elements:");
        printStack(x);
    }

    // Helper for printing stack contents (top to bottom)
    static void printStack(Stack s) {
        Stack temp = new Stack();
        while (!s.isEmpty()) {
            int val = (int)s.pop();
            System.out.print(val + " ");
            temp.push(val);
        }
        System.out.println();

        // Restore original stack
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}