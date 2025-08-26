package Class_Quiz.Set_B;
import node.Node;
public class Quiz2_1 {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node s_Half = reverse(slow);
        Node f_Half = head;
        Node temp = s_Half;
        while(temp!=null){
            if(f_Half.data !=temp.data)return false;
            f_Half=f_Half.next;
            temp = temp.next;
        }
        return true;
    }

    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(2);
        x.next.next.next.next = new Node(1);
        x.next.next.next.next.next = new Node(1);
        Quiz2_1 obj = new Quiz2_1();
        System.out.println("Is the linked list a palindrome? " + obj.isPalindrome(x));
    }
}
