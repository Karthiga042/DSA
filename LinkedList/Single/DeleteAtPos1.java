import java.util.*;
class Node 
{
    int data;
    Node next;
}
class DeleteAtPos1
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
    public static Node deleteAtPosition(Node head,int position)
    {
        if(head==null)
        {
            return null;
        }
        if(position==0)
        {
            Node temp=head;
            head=head.next;
            temp=null;
            return head;
        }
        Node temp=head;
        for(int i=0;i<position-1;i++)
        {
            if(temp!=null)
            {
                temp=temp.next;
            }
        }
        if(temp==null || temp.next==null)
        {
            System.out.println("Position out of bound");
            return head;
        }
        Node nodeToDelete=temp.next;
        temp.next=temp.next.next;
        nodeToDelete=null;
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
        System.out.println("Enter the position to delete:");
        int position=sc.nextInt();
        System.out.println("Modified list:");
        head=deleteAtPosition(head,position);
        display(head);
    }
}