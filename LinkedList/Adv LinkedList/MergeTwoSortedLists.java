//lc-21
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
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
        if(l1!=null)
        {
            temp.next=l1;
        }
        else
        {
            temp.next=l2;
        }
        return dummy.next;

        // if(list1==null)
        // {
        //     return list2;
        // }
        // if(list2==null)
        // {
        //     return list1;
        // }
        // //for deciding head
        // ListNode head=null;
        // if(list1.val<list2.val)
        // {
        //     head=list1;
        //     list1=list1.next;
        // }
        // else
        // {
        //     head=list2;
        //     list2=list2.next;
        // }
        // //traverse and append after head
        // ListNode temp=head;
        // while(list1!=null && list2!=null)
        // {
        //     if(list1.val<list2.val)
        //     {
        //         temp.next=list1;
        //         list1=list1.next;
        //     }
        //     else
        //     {
        //         temp.next=list2;
        //         list2=list2.next;
        //     }
        //     temp=temp.next;
        // }
        // //if there is node left in list1 and list2
        // if(list1!=null)
        // {
        //     temp.next=list1;
        // }
        // else
        // {
        //     temp.next=list2;
        // }
        // return head;
    }
}