//lc-23
class MergeKSortedLists {
    //optimized approach
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
        {
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();
            temp.next=min;
            temp=min;
        //add nodes after minNode in (1st to n) list for comparing with all nodes
            if(min.next!=null) 
            {
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }

//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null || lists.length==0)
//         {
//             return null;
//         }
//         ListNode head=null;
//         for(int i=0;i<lists.length;i++)
//         {
//             head=mergeTwoLists(head,lists[i]);
//         }
//         return head;
//     }
//     public ListNode mergeTwoLists(ListNode l1,ListNode l2)
//     {
//         ListNode dummy=new ListNode(-1);
//         ListNode temp=dummy;
//         while(l1!=null && l2!=null)
//         {
//             if(l1.val<l2.val)
//             {
//                 temp.next=l1;
//                 l1=l1.next;
//             }
//             else
//             {
//                 temp.next=l2;
//                 l2=l2.next;
//             }
//             temp=temp.next;
//         }
//         if(l1!=null)
//         {
//             temp.next=l1;
//         }
//         else
//         {
//             temp.next=l2;
//         }
//         return dummy.next;

//         // if(l1==null)
//         // {
//         //     return l2;
//         // }
//         // if(l2==null)
//         // {
//         //     return l1;
//         // }
//         // ListNode head=null;
//         // if(l1.val<l2.val)
//         // {
//         //     head=l1;
//         //     l1=l1.next;
//         // }
//         // else
//         // {
//         //     head=l2;
//         //     l2=l2.next;
//         // }
//         // ListNode temp=head;
//         // while(l1!=null && l2!=null)
//         // {
//         //     if(l1.val<l2.val)
//         //     {
//         //         temp.next=l1;
//         //         l1=l1.next;
//         //     }
//         //     else
//         //     {
//         //         temp.next=l2;
//         //         l2=l2.next;
//         //     }
//         //     temp=temp.next;
//         // }
//         // if(l1!=null)
//         // {
//         //     temp.next=l1;
//         // }
//         // else
//         // {
//         //     temp.next=l2;
//         // }
//         // return head;
//     }
}