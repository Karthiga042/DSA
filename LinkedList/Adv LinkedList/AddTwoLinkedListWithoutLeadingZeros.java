//lc-445
// class Solution {
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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode temp1=reverse(l1);
//         ListNode temp2=reverse(l2);
//         ListNode head=null;
//         int carry=0;
//         while(temp1!=null || temp2!=null || carry>0)
//         {
//             int sum=carry;
//             if(temp1!=null)
//             {
//                 sum+=temp1.val;
//                 temp1=temp1.next;
//             }
//             if(temp2!=null)
//             {
//                 sum+=temp2.val;
//                 temp2=temp2.next;
//             }
//             ListNode newNode=new ListNode();
//             newNode.val=sum%10;
//             newNode.next=head;
//             head=newNode;
//             carry=sum/10;
//         }
//         //removing leading zeros condition
//         while(head!=null && head.val==0 && head.next!=null)
//         {
//             head=head.next;
//         }
//         return head;
//     }
// }


import java.util.*;
class Node 
{
    int data;
    Node next;
}
public class AddTwoLinkedListWithoutLeadingZeros
{
    public static Node createNode(int value)
    {
        Node newNode=new Node();
        newNode.data=value;
        newNode.next=null;
        return newNode;
    }
    public static Node reverse(Node head)
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
    public static Node addList(Node head1,Node head2)
    {
        Node temp1=reverse(head1);
        Node temp2=reverse(head2);
        Node head=null;
        int carry=0;
        while(temp1!=null || temp2!=null || carry>0)
        {
            int sum=carry;
            if(temp1!=null)
            {
                sum+=temp1.data;
                temp1=temp1.next;
            }
            if(temp2!=null)
            {
                sum+=temp2.data;
                temp2=temp2.next;
            }
            Node newNode=new Node();
            newNode.data=sum%10;
            newNode.next=head;
            head=newNode;
            carry=sum/10;
        }
        while(head!=null && head.data==0 && head.next!=null)
        {
            head=head.next;
        }
        return head;
    }
    public static void display(Node head)
    {
        if(head==null)
        {
            System.out.print("List empty");
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes for list 1:");
        int n=sc.nextInt();
        Node head1=null;
        Node temp1=null;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value for node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
            if(head1==null)
            {
                head1=newNode;
                temp1=newNode;
            }
            else
            {
                temp1.next=newNode;
                temp1=newNode;
            }
        }
        System.out.println("Enter number of nodes for list 2:");
        int m=sc.nextInt();
        Node head2=null;
        Node temp2=null;
        for(int i=0;i<m;i++)
        {
            System.out.println("Enter value for node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
            if(head2==null)
            {
                head2=newNode;
                temp2=newNode;
            }
            else
            {
                temp2.next=newNode;
                temp2=newNode;
            }
        }
        System.out.println("List 1:");
        display(head1);
        System.out.println();
        System.out.println("List 2:");
        display(head2);
        System.out.println();
        Node result=addList(head1,head2);
        System.out.println("Sum: ");
        display(result);
	}
}