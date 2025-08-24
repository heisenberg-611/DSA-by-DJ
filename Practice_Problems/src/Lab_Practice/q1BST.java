package Lab_Practice;

public class q1BST {
    public static long calculate_energy(BTNode root, int destination) {
        if (root == null) return -1;

        if (root.elem == destination) {
            return root.elem;
        } else if (destination < root.elem) {
            long leftProduct = calculate_energy(root.left, destination);
            if (leftProduct != -1) {
                return root.elem * leftProduct;
            }
        } else {
            long rightProduct = calculate_energy(root.right, destination);
            if (rightProduct != -1) {
                return root.elem * rightProduct;
            }
        }
        return -1;
    }

    // Main tester
    public static void main(String[] args) {
        // Build sample BST externally; here assuming root is given
        // Example tree:
        /*
                30
               /  \
             20    40
                   /
                 35
        */

        BTNode root = new BTNode(30);
        root.left = new BTNode(15);
        root.left.left = new BTNode(9);
        root.left.left.left = new BTNode(7);
        root.left.right = new BTNode(20);
        root.right = new BTNode(40);
        root.right.left = new BTNode(35);
        root.right.right = new BTNode(45);
        root.right.left.left = new BTNode(32);

        System.out.println("Original tree:");
        BTPrinter.printNode(root);

        int destination = 35;
        System.out.println("\nCalculating energy to destination " + destination + ":");
        long output = calculate_energy(root, destination);
        System.out.println(output);
    }
}
