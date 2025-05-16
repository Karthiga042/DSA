//lc-82
class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        while(temp.next!=null && temp.next.next!=null)//bcoz starts from dummy
        {
            if(temp.next.val==temp.next.next.val)
            {
                int duplicate=temp.next.val;
                //skip all duplicate nodes 
                while(temp.next!=null && temp.next.val==duplicate)
                {
                    temp.next=temp.next.next;
                }
            }
            else
            {
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}