package problems.Stack.GeeksForGeeks;
import utils.Stack;
public class Delete_middle_element {
    public static void deleteMiddle(Stack stack) {
        int n = stack.size();
        Stack tmpStack = new Stack();
        for (int i = 0; i < n / 2; i++) {
            tmpStack.push(stack.pop());
        }
        stack.pop();
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Original Stack: " + stack);
        deleteMiddle(stack);
        System.out.println("Modified Stack: " + stack);
    }
}
