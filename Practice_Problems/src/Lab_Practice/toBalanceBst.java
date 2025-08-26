package Lab_Practice;

public class toBalanceBst {

    public static int toArray(BTNode root, int[] arr, int idx) {
        if (root == null) {
            return idx;
        }
        idx = toArray(root.left, arr, idx);
        arr[idx++] = root.elem;
        idx = toArray(root.right, arr, idx);
        return idx;
    }

    public static BTNode buildBST(int[] arr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        BTNode root = new BTNode(arr[mid]);
        root.left = buildBST(arr, st, mid - 1);
        root.right = buildBST(arr, mid + 1, end);
        return root;
    }

    public static int countNode(BTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static BTNode Balanced(BTNode root) {
        int n = countNode(root);
        int[] arr = new int[n];
        toArray(root, arr, 0);
        return buildBST(arr, 0, n - 1);
    }

    // Utility method to print inorder traversal
    public static void inorderPrint(BTNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.elem + " ");
            inorderPrint(root.right);
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        /*
         Construct an unbalanced tree:
                   10
                     \
                      20
                        \
                         30
                           \
                            40
        */
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.right.right = new BTNode(30);
        root.right.right.right = new BTNode(40);

        System.out.print("Original tree inorder traversal: ");
        inorderPrint(root);
        System.out.println();
        BTPrinter.printNode(root);
        System.out.println();

        BTNode balancedRoot = Balanced(root);

        System.out.print("Balanced tree inorder traversal: ");
        inorderPrint(balancedRoot);
        System.out.println();
        BTPrinter.printNode(balancedRoot);
        System.out.println();
    }
}
