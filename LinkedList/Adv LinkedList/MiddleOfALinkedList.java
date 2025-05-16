//lc-876
class MiddleOfALinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

        // ListNode temp=head;
        // int count=0;
        // while(temp!=null)
        // {
        //     count++;
        //     temp=temp.next;
        // }
        // int mid=count/2;
        // temp=head;
        // for(int i=0;i<mid;i++)
        // {
        //     temp=temp.next;
        // }
        // return temp;
    }
}