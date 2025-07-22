package Recursion;

public class MergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeList(ListNode headA, ListNode headB) {
        ListNode dummy  = new ListNode(-1);

        ListNode temp = dummy;

        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                temp.next = headA;
                headA = headA.next;
            }
            else {
                temp.next = headB;
                headB = headB.next;
            }
            temp = temp.next;
        }

        if (headA != null) temp.next = headA;
        if (headB != null) temp.next = headB;

        return dummy.next;
    }
}
