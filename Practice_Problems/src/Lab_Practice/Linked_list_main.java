package Lab_Practice;
import utils.LinkedListUtilsOOP;
public class Linked_list_main {
    public static void main(String[] args) {
        LinkedListUtilsOOP A = new LinkedListUtilsOOP();
        A.createList(new Object[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
        System.out.println(A.nodeAt(1).data);
        A.reverseList();
        A.displayinStyle();
    }
}
