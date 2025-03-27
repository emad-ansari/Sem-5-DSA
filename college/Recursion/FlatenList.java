package Recursion;
//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1  [SOLVED]

public class FlatenList {
    public class Node {
        int data;
        Node next, bottom;
        
        Node(int data) {
            this.data = data;
        }
    }
    Node flatten(Node root) {
        // code here
        Node temp = root;
        return helper(temp);
    }
    Node helper(Node node) {
        if (node.next == null) {
            return node;
        }
        
        
        Node n = helper(node.next);
        
        return merge(node, n);
    }
    
    
    Node merge(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.data <= list2.data) {
            list1.bottom = merge(list1.bottom, list2);
            return list1;
        }
        else {
            list2.bottom = merge(list1, list2.bottom);
            return list2;
        }
    }
}
