//lc-148
class SortList {
    public ListNode sortList(ListNode head) {
        //if no node or only one node already sorted
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        //slow fast pointers to split list
        while(fast!=null && fast.next!=null)
        {
            prev=slow;//keep track of slow to find 2nd list head
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;//break the list into 2 halves
        ListNode l1=sortList(head);//one starts with head
        ListNode l2=sortList(slow);//slow points to 2nd list head
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(0);
        //dummy bcoz modifying head
        //starts with dummy and recursively add nodes in ascending
        ListNode temp=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        //append remaining elements
        if(l1!=null)
        {
            temp.next=l1;
        }
        else
        {
            temp.next=l2;
        }
        return dummy.next;
    }
}