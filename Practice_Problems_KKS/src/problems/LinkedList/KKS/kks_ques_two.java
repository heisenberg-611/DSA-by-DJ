package problems.LinkedList.KKS;
import node.Node;
import utils.LinkedListUtilsOOP;
public class kks_ques_two {

    public static Node intersecTion(Node head1, Node head2){
        Node temp;
        Node temp2;
        temp = head1;
        Node finaNode = null;
        Node lasNode = null;
        while(temp != null){
            temp2 = head2;
            while(temp2 != null){
                if(temp.data == temp2.data){
                    Node newNode = new Node(temp2.data);
                    if(finaNode == null){
                        finaNode = newNode;
                        lasNode = newNode;
                    } else {
                        if(lasNode != null){
                            lasNode.next = newNode;
                            lasNode = newNode;
                        } else {
                            lasNode = newNode;
                            lasNode.next = null;
                        }
                    }
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return finaNode;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1,2,3,4,5});
        LinkedListUtilsOOP ll2 = new LinkedListUtilsOOP();
        ll2.createList(new Object[] { 2,3,4});
        LinkedListUtilsOOP ll3 = new LinkedListUtilsOOP();
        ll3.head = intersecTion(ll.head, ll2.head);
        ll3.displayinStyle();
    }
}
