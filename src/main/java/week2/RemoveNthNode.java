package week2;

public class RemoveNthNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode x = head;
        ListNode cur = head;
        while (n > 0) {
            x = x.next;
            n--;
        }

        while (x != null && x.next != null) {
            cur = cur.next;
            x = x.next;
        }

        if (cur == head && x == null) { // if it's a head, move head
            head = cur.next;
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }
}
