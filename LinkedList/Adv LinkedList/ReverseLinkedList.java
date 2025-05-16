//lc-206
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp=null;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}