package problems.Stack.GeeksForGeeks;
import utils.Stack;

public class Sorting_stack {
    public static Stack sortStack(Stack stack) {
        Stack tmpStack = new Stack();
        
        while(!stack.isEmpty())
        {
            // pop out the first element
            int tmp = (int)stack.pop();
        
            // while temporary stack is not empty and
            // top of stack is lesser than temp
            while(!tmpStack.isEmpty() && (int)tmpStack.peek() < tmp)
            {
                // pop from temporary stack and 
                // push it to the input stack
                stack.push(tmpStack.pop());
            }
            
            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        while(!tmpStack.isEmpty()){
            stack.push(tmpStack.pop());
        }
        return stack;
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