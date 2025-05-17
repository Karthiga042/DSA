//lc-2807
class InsertGCDBetweenNodes {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode temp1=head;
        ListNode temp2=head.next;
        while(temp1!=null && temp2!=null)
        {
            int gcdVal=gcd(temp1.val,temp2.val);
            ListNode gcdNode=new ListNode(gcdVal);
            temp1.next=gcdNode;
            gcdNode.next=temp2;

            temp1=temp2;//move to next node 1 to 2
            temp2=temp2.next;//2 to 3
        }
        return head;
    }
    public static int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}