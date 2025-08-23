package Lab_Practice;

public class q4 {
    // Function to calculate max root-to-leaf path sum
    public static int max_path_sum(BTNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.elem;
        }
        int leftSum = max_path_sum(root.left);
        int rightSum = max_path_sum(root.right);
        return root.elem + Math.max(leftSum, rightSum);
    }

    // Main tester method
    public static void main(String[] args) {
        // Constructing the input tree:
        //       1
        //      / \
        //     7   9
        //    /     \
        //   6       9
        //  / \       \
        // 5  11       5

        BTNode root = new BTNode(1);
        root.left = new BTNode(7);
        root.right = new BTNode(9);
        root.left.left = new BTNode(6);
        root.left.left.left = new BTNode(5);
        root.left.left.right = new BTNode(11);
        root.right.right = new BTNode(9);
        root.right.right.right = new BTNode(5);

        int maxSum = max_path_sum(root);
        System.out.println("Maximum path sum is: " + maxSum);  // Expected output: 25
    }

}
