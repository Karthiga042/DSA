//lc-1721
class SwappingNodes {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null)
        {
            return head;
        }
        //move fast k node from beginning
        ListNode fast=head;
        for(int i=1;i<k;i++)
        {
            fast=fast.next;
        }
        ListNode first=fast;// k-th node from the beginning

        //start slow from head and fast from kth node at beginning
        // When fast reaches the end, slow is at the k-th node from the end
        ListNode slow=head;
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        ListNode second=slow;// k-th node from the end

        int temp=first.val;
        first.val=second.val;
        second.val=temp;

        return head;

        // if(head==null || head.next==null)
        // {
        //     return head;
        // }
        // ListNode temp=head;
        // int count=0; //total count of list
        // while(temp!=null)
        // {
        //     count++;
        //     temp=temp.next;
        // }
        // int c1=0;//kth node pointer
        // ListNode temp1=head;
        // while(temp1!=null)
        // {
        //     c1++;
        //     if(c1==k)
        //     {
        //         break;
        //     }
        //     temp1=temp1.next;
        // }
        // int c2=0; //last kth node pointer
        // int ek=(count-c1)+1;//last kth node
        // ListNode temp2=head;
        // while(temp2!=null)
        // {
        //     c2++;
        //     if(c2==ek)
        //     {
        //         break;
        //     }
        //     temp2=temp2.next;
        // }
        // int swap=temp1.val;
        // temp1.val=temp2.val;
        // temp2.val=swap;

        // return head;
    }
}