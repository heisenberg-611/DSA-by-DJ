package problems.Stack.GeeksForGeeks;

public class Reverse_individual_Words {
    public static String reverse(String s) {
        utils.Stack stack = new utils.Stack();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            }
            else{
                while(!stack.isEmpty()){
                    res.append(stack.pop());
                }
                res.append(' ');
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "Geeks for Geeks";
        System.out.println("Original String: " + s);
        String reversed = reverse(s);
        System.out.println("Reversed String: " + reversed);
    }
}
