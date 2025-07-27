package problems.Mid_Questions_Solved.Spring24;
import utils.Queue;
import utils.Stack;
public class Question_Three {
    public static void dancePair(Stack stack) {
        Queue queue = new Queue(); // To store spare females
        Object prev = null;

        while (!stack.isEmpty()) {
            Object person = stack.pop();

            if (prev == null) {
                prev = person;
            } else {
                char aGender = prev.toString().charAt(0);
                char bGender = person.toString().charAt(0);

                if ((aGender == 'M' && bGender == 'F') || (aGender == 'F' && bGender == 'M')) {
                    System.out.println(prev.toString().substring(2) + " and " + person.toString().substring(2) + " are paired together");
                    prev = null;
                } else if (aGender == 'F' && bGender == 'F') {
                    queue.enqueue(prev); // save earlier female
                    prev = person;
                } else if (aGender == 'M' && bGender == 'M') {
                    if (!queue.isEmpty()) {
                        Object spareFemale = queue.dequeue();
                        System.out.println(prev.toString().substring(2) + " and " + spareFemale.toString().substring(2) + " are paired together");
                    }
                    // else discard prev male
                    prev = person;
                } else if (aGender == 'F' && bGender == 'M') {
                    System.out.println(prev.toString().substring(2) + " and " + person.toString().substring(2) + " are paired together");
                    prev = null;
                }
            }
        }

        // Handle leftover male
        if (prev != null && prev.toString().charAt(0) == 'M' && !queue.isEmpty()) {
            Object spareFemale = queue.dequeue();
            System.out.println(prev.toString().substring(2) + " and " + spareFemale.toString().substring(2) + " are paired together");
        }

        // Discard extra females (if any)
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        // Push from bottom to top
        st.push("F_18");
        st.push("F_9");
        st.push("M_7");
        st.push("M_1");
        st.push("M_19");
        st.push("M_3");
        st.push("F_5");
        st.push("F_4");
        st.push("F_20");
        st.push("M_10");
        // Call dancePair method
        dancePair(st);
    }
}
