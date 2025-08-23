package Lab_Practice;

public class q5 {
    // Node class with elem, left and right
    static class BSTNode {
        int elem;
        BSTNode left, right;

        BSTNode(int elem) {
            this.elem = elem;
            this.left = this.right = null;
        }
    }
    public static void OddSwap(BSTNode root) {
        oddSwapHelper(root, 1);  // Start at level 1 (root level)
    }

    // Recursive helper with level tracking
    private static void oddSwapHelper(BSTNode node, int level) {
        if (node == null) return;

        // Swap siblings at odd levels if right child's elem is greater than left child's
        if (level % 2 == 1 && node.left != null && node.right != null) {
            if (node.right.elem > node.left.elem) {
                BSTNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }

        // Recurse on children with incremented level
        oddSwapHelper(node.left, level + 1);
        oddSwapHelper(node.right, level + 1);
    }

    // In-order traversal to print the tree elements
    public static void printInOrder(BSTNode node) {
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
        BSTNode root = new BSTNode(10);
        root.left = new BSTNode(3);
        root.right = new BSTNode(8);
        root.left.left = new BSTNode(1);
        root.left.right = new BSTNode(4);
        root.right.left = new BSTNode(7);
        root.right.right = new BSTNode(9);

        System.out.println("Original tree in-order:");
        printInOrder(root);
        System.out.println();

        OddSwap(root);

        System.out.println("Tree after OddSwap in-order:");
        printInOrder(root);
        System.out.println();
    }
}
