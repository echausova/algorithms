package week2;

public class ReverseLL {

    private ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        newHead = reverseIterative(head);
        return newHead;

    }

    // recursive solution
    private ListNode reverse(ListNode cur) {
        if (cur == null || cur.next == null) {
            newHead = cur;
            return cur;
        }
        ListNode t = reverse(cur.next);

        t.next = cur;
        cur.next = null;
        return cur;
    }

    //iterative solution
    private ListNode reverseIterative(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
