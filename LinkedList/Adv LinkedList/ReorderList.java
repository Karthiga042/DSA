//lc-143
class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            return;
        }
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        //divide into 2 halves
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=head;//head of 1st half
        ListNode l2=reverse(slow);//reverse from head of 2nd half
        merge(l1,l2);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=null;
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public void merge(ListNode l1,ListNode l2)
    {
        while(l1!=null && l2!=null)
        {
            ListNode temp1=l1.next;//store for next ieration
            ListNode temp2=l2.next;
            l1.next=l2;
            //if odd no of nodes
            if(temp1==null)
            {
                break;
            }
            l2.next=temp1;
            //move forward l1 l2
            l1=temp1;
            l2=temp2;
        }
    }
}