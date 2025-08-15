package problems.Tree.BinarySearchTree;
import utils.BTPrinter;
import utils.BinarySearchTree;
import node.BTNode;
public class Implementation_tester {
    public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();  

        bst.insert(new  BTNode(10));
        bst.insert(new  BTNode(8));
        bst.insert(new  BTNode(9));
        bst.insert(new  BTNode(11));
        bst.insert(new  BTNode(12));
        bst.insert(new  BTNode(12));
        bst.insert(new  BTNode(13));
        bst.insert(new  BTNode(4));
        bst.insert(new  BTNode(3));
        bst.insert(new  BTNode(2));
        bst.insert(new  BTNode(1));


        // bst.display();
        // System.out.println();
        // bst.remove(1);
        BTPrinter.inOrderPrint(bst.getRoot());
        BTPrinter.printNode(bst.getRoot());
    }
}
