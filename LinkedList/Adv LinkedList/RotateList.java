//lc-61
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        //no need to rotate
        if(head==null || head.next==null || k==0)
        {
            return head;
        }
        ListNode temp=head;
        int count=0;
        //count number of nodes
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        //modulo operation to optimize when k>count
        k=k%count;
        if(k==0)//no rotation
        {
            return head;
        }
        //traverse till the node before the node to rotate starts
        temp=head;
        for(int i=1;i<count-k;i++)
        {
            temp=temp.next;
        }
        //takes the nodes where rotation begins
        ListNode newHead=temp.next;
        //break link 
        temp.next=null;
        //traverse to end of list
        //moves forward node by node till last node
        ListNode newTemp=newHead;
        while(newTemp.next!=null)
        {
            newTemp=newTemp.next;
        }
        //after loop newTemp points to last node
        //connect it to the previously pointed head for connecting to remaining nodes
        newTemp.next=head;
        return newHead;
    }
}