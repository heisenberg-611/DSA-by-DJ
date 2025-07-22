package problems.Stack.GeeksForGeeks;
import utils.Stack;
public class Reverse_stack {
    public static Stack reverseStack(Stack stack) {
        Stack reversedStack = new Stack();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }
        return reversedStack;
    }
    public static void main(String[] args) {
        // Example usage of the Stack class
        Stack stack = new utils.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Original Stack: " + stack);
        
        // Reverse the stack
        Stack reversedStack = reverseStack(stack);
        
        System.out.println("Reversed Stack: " + reversedStack);
    }
}
