package problems.Stack.GeeksForGeeks;

public class Balance_equation {
    public static boolean isBalanced(String s) {
        // Write your code here
        utils.Stack st = new utils.Stack();
        // for (int i = 0; i < s.length(); i++) {

        // // Check if the character is an opening bracket
        // if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        // st.push(s.charAt(i));
        // }
        // else {

        // // If it's a closing bracket, check if the stack is non-empty
        // // and if the top of the stack is a matching opening bracket
        // if (!st.isEmpty() &&
        // ((st.peek() == '(' && s.charAt(i) == ')') ||
        // (st.peek() == '{' && s.charAt(i) == '}') ||
        // (st.peek() == '[' && s.charAt(i) == ']'))) {
        // st.pop();
        // }
        // else {

        // // Unmatched closing bracket
        // return false;
        // }
        // }
        // }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Process only brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (!st.isEmpty()) {
                    char top = (char) st.peek(); // safely cast Object to char
                    if ((top == '(' && ch == ')') ||
                            (top == '{' && ch == '}') ||
                            (top == '[' && ch == ']')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }

            }
            // Else: ignore the character
        }

        // If stack is empty, return true (balanced),
        // otherwise false
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{([5+6]*7)-3}";
        if (isBalanced(s))
            System.out.println("true");
        else
            System.out.println("false");
    }
}