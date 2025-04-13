package linkedlist;

// 
public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        // node.next = new ListNode(2);
        ListNode ans = swapPairs(node);
        ListNode temp = ans;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        ListNode temp2 = node;
        System.out.println();
        while (temp2 != null) {
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = first.next;

        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    };

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}