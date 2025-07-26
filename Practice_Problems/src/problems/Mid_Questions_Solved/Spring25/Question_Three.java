package problems.Mid_Questions_Solved.Spring25;
import utils.Stack;
public class Question_Three {
    public static Stack Rearrage_Odd_even(Stack stack) {
        Stack odd = new Stack();
        Stack even = new Stack();
        while(!stack.isEmpty()){
            if((int)stack.peek() % 2 == 0){
                even.push(stack.pop());
            }
            else{
                odd.push(stack.pop());
            }
        }
        while(!even.isEmpty()){
            stack.push(even.pop());
        }
        while(!odd.isEmpty()){
            stack.push(odd.pop());
        }
        return null;
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(14);
        stack.push(11);
        stack.push(8);
        stack.push(5);
        stack.push(7);
        stack.push(12);
        System.out.println("Original Stack: " + stack);
        Rearrage_Odd_even(stack);
        System.out.println("Modified Stack: " + stack);
    }
}
