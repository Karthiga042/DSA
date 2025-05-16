//lc-86
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess=new ListNode(0);
        ListNode dummyHigh=new ListNode(0);
        ListNode less=dummyLess;
        ListNode high=dummyHigh;

        ListNode temp=head;
        while(temp!=null)
        {
            if(temp.val<x)//if less than x
            {
                less.next=temp;
                less=less.next;
            }
            else//if greater than or equal to x
            {
                high.next=temp;
                high=high.next;
            }
            temp=temp.next;
        }
        high.next=null;//break it
        less.next=dummyHigh.next;//connect less to high
        return dummyLess.next;//print from less
    }
}