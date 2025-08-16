package problems.Tree.BinarySearchTree;
import utils.BTPrinter;
import utils.BinarySearchTree;
import node.BTNode;
public class Implementation_tester {
    public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();  

        bst.insert(new BTNode(10));
        bst.insert(new BTNode(5));
        bst.insert(new BTNode(15));
        bst.insert(new BTNode(2));
        bst.insert(new BTNode(7));
        bst.insert(new BTNode(12));
        bst.insert(new BTNode(17));
        
        // bst.display();
        // System.out.println();
        // bst.remove(1);
        BTPrinter.inOrderPrint(bst.getRoot());
        BTPrinter.printNode(bst.getRoot());
        System.out.print(bst.isBalanced());
    }
}
