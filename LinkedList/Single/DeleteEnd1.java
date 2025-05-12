import java.util.*;
class Node 
{
    int data;
    Node next;
}
class DeleteEnd1
{
    public static Node createNode(int value)
    {
        Node newNode=new Node();
        newNode.data=value;
        newNode.next=null;
        return newNode;
    }
    public static void display(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.print("null");
        }
    }
    public static Node deleteEnd(Node head)
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            head=null;
            return null;
        }
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n=sc.nextInt();
        Node head=null;
        Node temp=null;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value for node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
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
        System.out.println("Original list:");
        display(head);
        System.out.println();
        System.out.println("Modified list:");
        head=deleteEnd(head);
        display(head);
    }
}