package problems.Tree.BinarySearchTree;
import utils.BinarySearchTree;
import node.TreeNode;
public class Implementation_tester {
    public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();  

        bst.insert(new  TreeNode(10));
        bst.insert(new  TreeNode(5));
        bst.insert(new  TreeNode(15));
        bst.insert(new  TreeNode(3));
        bst.insert(new  TreeNode(7));
        bst.insert(new  TreeNode(12));
        bst.insert(new  TreeNode(17));
        bst.insert(new  TreeNode(99));
        bst.insert(new  TreeNode(20));
        bst.insert(new  TreeNode(25));

        bst.display();
        System.out.println();
        bst.remove(1);
        bst.display();
    }
}
