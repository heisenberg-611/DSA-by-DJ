package utils;

import node.TreeNode;

public class BinarySearchTree {
    // Binary Search Tree = A tree data structure, where each node is greater than
    // its left child,
    // but less than its right.
    // Benefit: Easy to locate a node when they are in order
    // Time complexity: best case O(log n)
    // worst case O(n)
    // Space complexity: O(n)
    TreeNode root;

    public void insert(TreeNode node) {
        root = insertHelper(root, node);
    }

    private TreeNode insertHelper(TreeNode root, TreeNode node) {
        int data = (int) node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else if (data > root.data) {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(TreeNode root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.print(root.data + " ");
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(TreeNode root, int data) {
        if (root == null)
            return false;
        else if ((int) root.data == data)
            return true;
        else if ((int) root.data > data)
            return searchHelper(root.left, data);
        else
            return searchHelper(root.right, data);
    }

    public void remove(int data) {
        if (search(data))
            root = removeHelper(root, data);
        else
            System.out.println(data + " could not be found");
    }

    private TreeNode removeHelper(TreeNode root, int data) {
        if (root == null)
            return null;
        else if (data < root.data)
            root.left = removeHelper(root.left, data);
        else if (data > root.data)
            root.right = removeHelper(root.right, data);
        else { // node found
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { // find a successor to replace node
                int succ = successor(root);
                root.data = succ;
                root.right = removeHelper(root.right, succ);
            } else { // find a predecessor to replace this node
                int pred = predecessor(root);
                root.data = pred;
                root.left = removeHelper(root.left, pred);
            }
        }
        return root;
    }

    private int successor(TreeNode root) { // find the least value below the right child of this root node
        if (root.right == null)
            throw new IllegalArgumentException("No right subtree to find successor.");
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // A pretty display function
    public void displayVisual() {
        displayVisualHelper(root, 0);
    }

    private void displayVisualHelper(TreeNode root, int level) {
        if (root == null)
            return;

        // First print the right subtree
        displayVisualHelper(root.right, level + 1);

        // Print the current node after spacing
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 spaces per level
        }
        System.out.println(root.data);

        // Then print the left subtree
        displayVisualHelper(root.left, level + 1);
    }

    private int predecessor(TreeNode root) { // find the least value below the left child of this root node
        if (root.left == null)
            throw new IllegalArgumentException("No left subtree to find predecessor.");
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // DFS
    public void preOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public TreeNode getRoot(){
        return root;
    }
}
