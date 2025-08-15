package utils;

import node.BTNode;

public class BinarySearchTree { 
    // Binary Search Tree = A tree elem structure, where each node is greater than
    // its left child,
    // but less than its right.
    // Benefit: Easy to locate a node when they are in order
    // Time complexity: best case O(log n)
    // worst case O(n)
    // Space complexity: O(n)
    BTNode root;

    public void insert(BTNode node) {
        root = insertHelper(root, node);
    }

    private BTNode insertHelper(BTNode root, BTNode node) {
        int elem = (int) node.elem;
        if (root == null) {
            root = node;
            return root;
        } else if (elem < root.elem) {
            root.left = insertHelper(root.left, node);
        } else if (elem > root.elem) {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(BTNode root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.print(root.elem + " ");
            displayHelper(root.right);
        }
    }

    public boolean search(int elem) {
        return searchHelper(root, elem);
    }

    private boolean searchHelper(BTNode root, int elem) {
        if (root == null)
            return false;
        else if ((int) root.elem == elem)
            return true;
        else if ((int) root.elem > elem)
            return searchHelper(root.left, elem);
        else
            return searchHelper(root.right, elem);
    }

    public void remove(int elem) {
        if (search(elem))
            root = removeHelper(root, elem);
        else
            System.out.println(elem + " could not be found");
    }

    private BTNode removeHelper(BTNode root, int elem) {
        if (root == null)
            return null;
        else if (elem < root.elem)
            root.left = removeHelper(root.left, elem);
        else if (elem > root.elem)
            root.right = removeHelper(root.right, elem);
        else { // node found
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { // find a successor to replace node
                int succ = successor(root);
                root.elem = succ;
                root.right = removeHelper(root.right, succ);
            } else { // find a predecessor to replace this node
                int pred = predecessor(root);
                root.elem = pred;
                root.left = removeHelper(root.left, pred);
            }
        }
        return root;
    }

    private int successor(BTNode root) { // find the least value below the right child of this root node
        if (root.right == null)
            throw new IllegalArgumentException("No right subtree to find successor.");
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.elem;
    }

    private int predecessor(BTNode root) { // find the least value below the left child of this root node
        if (root.left == null)
            throw new IllegalArgumentException("No left subtree to find predecessor.");
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.elem;
    }

    // DFS
    public void preOrderTraversal(BTNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.elem+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(BTNode root) {
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.elem+" ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BTNode root) {
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.elem+" ");
    }

    

    public BTNode getRoot(){
        return root;
    }
}
