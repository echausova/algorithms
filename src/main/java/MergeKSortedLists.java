public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int m = (l + r) / 2;
        ListNode leftRes = mergeKLists(lists, l, m);
        ListNode rightRes = mergeKLists(lists, m + 1, r);
        return merge(leftRes, rightRes);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        ListNode f = first;
        ListNode s = second;

        ListNode result = new ListNode();
        ListNode resultHead = result;

        while (f != null && s != null) {
            if (f.val <= s.val) {
                result.next = f;
                result = result.next;
                f = f.next;
            } else {
                result.next = s;
                result = result.next;
                s = s.next;
            }
        }

        while (f != null) {
            result.next = f;
            result = result.next;
            f = f.next;
        }

        while (s != null) {
            result.next = s;
            result = result.next;
            s = s.next;
        }
        return resultHead.next;
    }
}

class ListNode {
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
