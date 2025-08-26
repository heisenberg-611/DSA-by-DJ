package Lab_Practice;

public class Newq3 {
    public static void updateTree(BTNode tree1, int k) {
        if (tree1 == null)
            return; 

        if (tree1.left != null && tree1.right != null) {
            if (tree1.elem % k == 0) {
                tree1.elem = Math.abs(tree1.left.elem - tree1.right.elem);
            }
            else {
                tree1.elem = 2*tree1.elem;
            }
        }
        updateTree(tree1.left, k);
        updateTree(tree1.right, k);
    }

    public static void main(String[] args) {
        // Build sample trees with same structure but different values
        BTNode tree1 = new BTNode(4);
        tree1.left = new BTNode(6);
        tree1.right = new BTNode(8);
        tree1.left.left = new BTNode(10);
        tree1.left.right = new BTNode(12);

        BTNode tree2 = new BTNode(4);
        tree2.left = new BTNode(7);
        tree2.right = new BTNode(8);
        tree2.left.left = new BTNode(10);
        tree2.left.right = new BTNode(15);

        int k = 3;

        System.out.println("Original tree1 (in-order):");
        BTPrinter.printNode(tree1);

        updateTree(tree1, k);

        System.out.println("\nUpdated tree1 (in-order):");
        BTPrinter.printNode(tree1);
    }

}
