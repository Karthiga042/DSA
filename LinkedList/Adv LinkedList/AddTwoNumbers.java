//lc-2
//already reversed list
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode temp=null;
        int carry=0;
        while(l1!=null || l2!=null || carry>0)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode newNode=new ListNode();
            newNode.val=sum%10;
            carry=sum/10;
            if(head==null)
            {
                head=newNode;
                temp=newNode;
            }
            else
            {
                temp.next=newNode;
                temp=newNode;
            }
        }
        return head;
    }
}