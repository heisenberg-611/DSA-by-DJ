package Lab_Practice;

public class q5 {
    // Node class with elem, left and right

    public static void OddSwap(BTNode root) {
        oddSwapHelper(root, 1);  // Start at level 1 (root level)
    }

    // Recursive helper with level tracking
    private static void oddSwapHelper(BTNode node, int level) {
        if (node == null) return;

        // Swap siblings at odd levels if right child's elem is greater than left child's
        if (level % 2 == 1 && node.left != null && node.right != null) {
            if (node.right.elem > node.left.elem) {
                BTNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }

        // Recurse on children with incremented level
        oddSwapHelper(node.left, level + 1);
        oddSwapHelper(node.right, level + 1);
    }

    // In-order traversal to print the tree elements
    public static void printInOrder(BTNode node) { 
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.elem + " ");
        printInOrder(node.right);
    }

    // Main tester function
    public static void main(String[] args) {
        /*
                 10
                /  \
               3    8
              / \  / \
             1  4 7   9
        */
        BTNode root = new BTNode(10);
        root.left = new BTNode(3);
        root.right = new BTNode(8);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(4);
        root.right.left = new BTNode(7);
        root.right.right = new BTNode(9);

        System.out.println("Original tree in-order:");
        BTPrinter.printNode(root);
        System.out.println();

        OddSwap(root);

        System.out.println("Tree after OddSwap in-order:");
        BTPrinter.printNode(root);
        System.out.println();
    }
    
}
