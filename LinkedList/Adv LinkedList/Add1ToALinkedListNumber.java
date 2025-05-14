//gfg Add 1 to a Linked List Number
class Add1ToALinkedListNumber {
    public Node reverse(Node head)
    {
        Node temp=null;
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head=reverse(head);
        Node temp=head;
        int carry=1;//add 1
        while(temp!=null && carry>0)
        {
            int sum=temp.data+carry;
            temp.data=sum%10;
            carry=sum/10;
            //if there is carry in last and create new node
            if(temp.next==null && carry>0)
            {
                temp.next=new Node(carry);
                carry=0;
            }
            temp=temp.next;
        }
        head=reverse(head);

        // Remove leading zeros condition
        // while(head!=null && head.data==0 && head.next!=null)
        // {
        //     head=head.next;
        // }
        return head;
    }
}
