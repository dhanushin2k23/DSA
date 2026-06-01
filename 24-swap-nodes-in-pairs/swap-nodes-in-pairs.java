class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next  = head;
        ListNode p = dummy;

        while(head !=null && head.next != null){
            ListNode f = head;
            ListNode s = head.next;

            f.next = s.next;
            s.next = f;
            p.next = s;

            p=f;
            head = f.next;
        }
        return dummy.next;
    }
}