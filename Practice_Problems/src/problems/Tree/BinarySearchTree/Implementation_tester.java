package problems.Tree.BinarySearchTree;
import utils.BinarySearchTree;
import node.TreeNode;
public class Implementation_tester {
    public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();  

        bst.insert(new  TreeNode(10));
        bst.insert(new  TreeNode(8));
        bst.insert(new  TreeNode(9));
        bst.insert(new  TreeNode(11));
        bst.insert(new  TreeNode(12));
        bst.insert(new  TreeNode(12));
        bst.insert(new  TreeNode(13));
        bst.insert(new  TreeNode(4));
        bst.insert(new  TreeNode(3));
        bst.insert(new  TreeNode(2));
        bst.insert(new  TreeNode(1));


        // bst.display();
        // System.out.println();
        // bst.remove(1);
        bst.displayVisual();
        bst.preOrderTraversal(bst.getRoot());
    }
}
