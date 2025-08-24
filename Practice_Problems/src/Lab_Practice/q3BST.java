package Lab_Practice;

public class q3BST {
    // Helper class to keep multiplication and count state during recursion
    static class MulCount {
        long product = 1;
        int count = 0;
    }

    // Public API method
    public static long smallest_mul(BTNode root, int k) {
        MulCount state = new MulCount();
        inorderMul(root, k, state);
        return state.product;
    }

    // In-order traversal to multiply the k smallest nodes recursively
    private static void inorderMul(BTNode node, int k, MulCount state) {
        if (node == null || state.count >= k) return;

        inorderMul(node.left, k, state);

        if (state.count < k) {
            // multiply current node element
            state.product *= node.elem;
            state.count++;
        }

        inorderMul(node.right, k, state);
    }

    // Example usage and testing
    public static void main(String[] args) {
        /*
                  6
                 / \
                3   8
               / \   \
              1   4   7
        */
        BTNode root = new BTNode(6);
        root.left = new BTNode(3);
        root.right = new BTNode(8);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(4);
        root.right.left = new BTNode(7);

        System.out.println(smallest_mul(root, 3)); // Output: 12 (1*3*4)
        System.out.println(smallest_mul(root, 4)); // Output: 72 (1*3*4*6)
        System.out.println(smallest_mul(root, 6)); // Output: 4032 (1*3*4*6*7*8)
    }
}
