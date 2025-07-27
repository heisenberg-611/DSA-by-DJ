package problems.Mid_Questions_Solved.Fall23;
import node.Node;
import utils.LinkedListUtilsOOP;
public class Question_Two {
    public static boolean pairwiseEqual(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != null && curr2 != null) {
            int a = (int)curr1.data;
            int b = curr1.next != null ? (int)curr1.next.data : -1;
            int c = (int)curr2.data;
            int d = curr2.next != null ? (int)curr2.next.data : -1;

            // Check if (a,b) and (c,d) are the same pair in any order
            if (!((a == c && b == d) || (a == d && b == c))) {
                return false;
            }

            curr1 = curr1.next.next;
            curr2 = curr2.next.next;
        }

        // both should be null (same length assumption given)
        return curr1 == null && curr2 == null;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll1 = new LinkedListUtilsOOP();
        ll1.createList(new Object[] { 10, 15, 34, 41 });
        LinkedListUtilsOOP ll2 = new LinkedListUtilsOOP();
        ll2.createList(new Object[] { 15, 10, 34, 41 });
        System.out.println(pairwiseEqual(ll1.head, ll2.head));
    }
}
