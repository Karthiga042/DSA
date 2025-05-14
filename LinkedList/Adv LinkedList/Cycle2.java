//lc-142
public class Cycle2 {
    public ListNode detectCycle(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null)
       {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)//cycle found
            {
                slow=head;// Reset the slow pointer to the head to find start node of cycle
                //if slow meets fast the node where they meet is start of cycle
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;   
                }
                return slow;
            }
       }
       return null;
    }
}