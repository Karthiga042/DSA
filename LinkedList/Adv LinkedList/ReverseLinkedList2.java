//lc-92
class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right)
        {
            return head;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        for(int i=1;i<left;i++)
        {
            temp=temp.next;
        }

        ListNode revHead=temp.next;
        ListNode curr=revHead;
        ListNode prev=null;
        for(int i=0;i<=right-left;i++)
        {
            ListNode t=curr.next;
            curr.next=prev;
            prev=curr;
            curr=t;
        }
        //join node before list(temp) to reversed list new head(prev)
        temp.next=prev;
        //join reversed list tail(revHead) to node after sublist(curr)
        revHead.next=curr;
        return dummy.next;
    }
}
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if(head==null || left==right)
//         {
//             return head;
//         }

//         ListNode dummy=new ListNode(0);
//         dummy.next=head;

//         //traverse before left
//         ListNode temp=dummy;
//         for(int i=1;i<left;i++)
//         {
//             temp=temp.next;
//         }
//         ListNode beforeRev=temp; //store that before node for joining afterwards

//         //starts from left
//         ListNode revHead=temp.next;
//         ListNode revTemp=revHead;
//         //pointer to traverse rev sublist
//         for(int i=left;i<right;i++)
//         {
//             revTemp=revTemp.next;
//         }

//         //store node after rev sublist for joining afterwards
//         ListNode afterRev=revTemp.next;
//         revTemp.next=null;//break link

//         //reverse the sublist
//         ListNode reversed=reverse(revHead);
//         //join node before sublist to reversed sublist
//         beforeRev.next=reversed;

//         //iterate reversed sublist and join all nodes
//         ListNode tail=reversed;
//         while(tail.next!=null)
//         {
//             tail=tail.next;
//         }
//         //after joining reversed sublist join the nodes after sublist
//         tail.next=afterRev;
//         return dummy.next;
//     }
//     public ListNode reverse(ListNode head)
//     {
//         ListNode temp=null;
//         ListNode curr=head;
//         ListNode prev=null;
//         while(curr!=null)
//         {
//             temp=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
//         return prev;
//     }
// }