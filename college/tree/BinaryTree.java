package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nums = { 80, 60, 10, 70, 90, 85, 110 };
        TreeNode root = tree.insertAll(nums);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // System.out.println();
        // tree.PreInPost(root);
        tree.delete(root, root, 80);
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
    class Pair {
        TreeNode node;
        int num;
        Pair (TreeNode node, int num) {
            this.node = node;
            this.num = num;
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

    // delete node in binary search tree
    public void delete(TreeNode root, TreeNode prev, int key) {
        // first search the node to be deleted
        if (root == null) {
            System.out.println("Node with the key: " + key + " does not exist");
            return;
        }
        if (key < root.val) {
            delete(root.left, root, key);
        }
        else if (key > root.val) {
            delete(root.right, root, key);
        }
        else {
            // node found
            // now perform deletion
            deleteNode(root, prev, key);
            return;
        }
    }
    public void deleteNode(TreeNode curr, TreeNode prev, int key) {

        if (curr.left == null && curr.right == null) {
            if (prev.left.val == key) prev.left = null;
            else prev.right = null;
        }
        else if (curr.left != null && curr.right == null) {
            if (prev.left == curr) {

            }
            else {

            }
        
        }
        else if (curr.right != null && curr.left == null) {
            if (prev.left == curr) {
                prev.left = curr.right;
                curr.right = null;
                return;
            }
            else {
                prev.right = curr.right;
                curr.right = null;
                return;
            }
        }
        else {
            // means neither left nor right is null
            // first find the maximum element from left subtree
            TreeNode leftMaxNode = findMaxInLeftSubTree(curr.left);
            if(prev == curr) {
                // means we are going to delete the root node
                root  = root.left;
            }
            else {
                if (prev.left == curr) {
                    prev.left = curr.left;
                }
                else {
                    // prev.right = curr
                    prev.right = curr.left;
                }

            }
            leftMaxNode.right = curr.right;
            curr.left = null;
            curr.right = null;
        }
    }
    public TreeNode findMaxInLeftSubTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode temp = root;
        while (temp != null) {
            prev = temp;
            temp = temp.right;
        }
        return prev;
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

    public  List<Integer> inorderIterative(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            }
            else {
                if (s.isEmpty()) break;
                inorder.add(s.peek().val);
                node = s.pop().right;
            }
        }
        return inorder;
    }
   // Postoder with iteration
    public List<Integer> postorderWithIteration(TreeNode root) {
        List<Integer> postorder = new LinkedList<>();
        if (root == null) return postorder;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            postorder.addFirst(node.val);
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }
        return postorder; 
    }

    // all in one --> Inorder, preorder, and postorder
    public void PreInPost(TreeNode root) {
        if (root == null ) return;
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!s.isEmpty()) {
            Pair currP = s.pop();
            if (currP.num == 1) {
                pre.add(currP.node.val);
                currP.num++;
                s.push(currP);
                if (currP.node.left != null) s.push(new Pair(currP.node.left, 1));
            }
            else if (currP.num == 2) {
                in.add(currP.node.val);
                currP.num++;
                s.push(currP);
                if (currP.node.right != null) s.push(new Pair(currP.node.right, 1));
            }
            else {
                post.add(currP.node.val);
            }
        }

        // Print preorder
        for (int i = 0; i < pre.size(); i++) {
            System.out.print(pre.get(i) + " ");
        }
        System.out.println();
        // print Inorder
        for (int i = 0; i < in.size(); i++) {
            System.out.print(in.get(i) + " ");
        }
        System.out.println();
        // print Postorder
        for (int i = 0; i < in.size(); i++) {
            System.out.print(post.get(i) + " ");
        }
    }
}
