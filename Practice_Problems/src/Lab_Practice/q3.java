package Lab_Practice;

public class q3 {
    public static void updateTree(BTNode tree1, BTNode tree2, int k) {
        if (tree1 == null || tree2 == null)
            return; // Base case: if either node is null, stop recursion

        // Case 1: Values are equal
        if (tree1.elem == tree2.elem) {
            if (tree1.elem % k == 0) {
                tree1.elem = 100; // Replace with 100 if divisible by k
            }
            // Else keep tree1.elem unchanged
        }
        // Case 2: Values are not equal
        else {
            tree1.elem = tree1.elem + tree2.elem; // Replace tree1 value with sum
        }

        // Recur for left and right children
        updateTree(tree1.left, tree2.left, k);
        updateTree(tree1.right, tree2.right, k);
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

        int k = 2;

        System.out.println("Original tree1 (in-order):");
        BTPrinter.printNode(tree1);
        BTPrinter.printNode(tree2);

        updateTree(tree1, tree2, k);

        System.out.println("\nUpdated tree1 (in-order):");
        BTPrinter.printNode(tree1);
    }

}
