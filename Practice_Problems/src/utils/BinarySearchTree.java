package utils;

import node.TreeNode;

public class BinarySearchTree {
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
            System.out.print(root.data+" ");
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(TreeNode root, int data) {
        if (root == null)return false;
        else if((int)root.data == data)return true;
        else if((int)root.data > data)return searchHelper(root.left, data);
        else return searchHelper(root.right, data);
    }

    public void remove(int data) {
        if(search(data)) root = removeHelper(root, data);
        else System.out.println(data+" could not be found");
    }

    private TreeNode removeHelper(TreeNode root, int data) {
        if (root == null) return null;
        else if(data < root.data) root.left = removeHelper(root.left, data);
        else if(data > root.data) root.right = removeHelper(root.right, data);
        else{ //node found
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.right != null) { //find a successor to replace node
                int succ = successor(root);
                root.data = succ;
                root.right = removeHelper(root.right, succ);
            }
            else{ //find a predecessor to replace this node
                int pred = predecessor(root);
                root.data = pred;
                root.left = removeHelper(root.left, pred); 
            }
        }
        return root;
    }

    private int successor(TreeNode root) { //find the least value below the right child of this root node
        if (root.right == null)
            throw new IllegalArgumentException("No right subtree to find successor.");
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(TreeNode root) { //find the least value below the left child of this root node
        if (root.left == null)
            throw new IllegalArgumentException("No left subtree to find predecessor.");
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
}
