package problems.Stack.GeeksForGeeks;

public class String_reverse {
    public static String reverse(String s) {
        utils.Stack stack = new utils.Stack();
        // Push all characters onto the stack
        for (char c : s.toCharArray())
            stack.push(c);
        // Pop characters to form reversed string
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        System.out.println("Original String: " + s);
        String reversed = reverse(s);
        System.out.println("Reversed String: " + reversed);
    }
}
