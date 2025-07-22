package problems.Stack;
import utils.Stack;

public class Sorting_stack {
    public static Stack sortStack(Stack stack) {
        Stack tempStack = new Stack();
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }
            
            tempStack.push(current);
        }
        
        return tempStack;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        
        System.out.println("Original Stack: " + stack);
        
        Stack sortedStack = sortStack(stack);
        
        System.out.println("Sorted Stack: " + sortedStack);
    }
}