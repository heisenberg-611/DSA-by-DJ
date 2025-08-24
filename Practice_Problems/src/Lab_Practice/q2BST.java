package Lab_Practice;

public class q2BST {
    // Public function
    public static String mirror_parity(BTNode root, int x) {
        if (root == null) return "No Mirror Found";
        if (root.elem == x) {
            // root mirrors itself
            return (root.elem % 2 == 0) ? "Even" : "Odd";
        }
        return mirrorHelper(root.left, root.right, x);
    }

    // Helper to find mirror node by traversing left and right simultaneously
    private static String mirrorHelper(BTNode left, BTNode right, int x) {
        if (left == null || right == null) {
            return "No Mirror Found";
        }

        if (left.elem == x) {
            return (right.elem % 2 == 0) ? "Even" : "Odd";
        }
        if (right.elem == x) {
            return (left.elem % 2 == 0) ? "Even" : "Odd";
        }

        // Search deeper in mirrored subtrees
        String res = mirrorHelper(left.left, right.right, x);
        if (!res.equals("No Mirror Found")) return res;

        return mirrorHelper(left.right, right.left, x);
    }

    // Example testing
    public static void main(String[] args) {
        /*
                10
               /  \
             7     12
            / \     \
           5  9     15
        */
        BTNode root = new BTNode(10);
        root.left = new BTNode(7);
        root.right = new BTNode(12);
        root.left.left = new BTNode(5);
        root.left.right = new BTNode(9);
        root.right.right = new BTNode(15);

        System.out.println(mirror_parity(root, 5));  // Odd (mirror is 15)
        System.out.println(mirror_parity(root, 7));  // Even (mirror is 12)
        System.out.println(mirror_parity(root, 3));  // No Mirror Found
    }
}
