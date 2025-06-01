package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nums = { 80, 60, 10, 70, 90, 85, 110 };
        TreeNode root = tree.insertAll(nums);
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.levelOrder(root);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    TreeNode root;

    BinaryTree() {
        root = null;
    }

    public TreeNode insertAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;

    }

    public boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target)
            return true;
        else if (target < root.val) {
            return search(root.left, target);
        } else
            return search(root.right, target);
    }

    public void delete(TreeNode root, int key) {

    }

    // level order traversal
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levels = queue.size();
            for (int i = 0; i < levels; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                System.out.print(node.val + " ");

            }
            System.out.println();

        }
    }

    // inorder
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public int height(TreeNode root) {
        return 0;
    }

}
