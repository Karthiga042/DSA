//lc-24
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //dummy(extra) node to point before head
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prev=dummy;
        while(prev.next!=null && prev.next.next!=null)
        {
            ListNode first=prev.next;
            ListNode second=first.next; //prev.next.next

            first.next=second.next; //1 points to 3
            second.next=first; //2 points to 1
            prev.next=second; //dummy points to 2

            //move prev to end of swapped pair for going to next iteration swap pair
            prev=first; //prev to 1
        }
        return dummy.next; //return new head

        ////for modifying values in a node instead of modifying nodes
        // if(head==null || head.next==null)
        // {
        //     return head;
        // }
        // ListNode temp=head;
        // while(temp!=null && temp.next!=null)
        // {
        //     int data=temp.val;
        //     temp.val=temp.next.val;
        //     temp.next.val=data;
        //     temp=temp.next.next;
        // }
        // return head;
    }
}