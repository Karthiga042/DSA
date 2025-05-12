import java.util.*;
class Node 
{
    int data;
    Node next;
    Node prev;
}
class DeleteAtPos2 
{
    public static Node createNode(int value)
    {
        Node newNode=new Node();
        newNode.data=value;
        newNode.next=null;
        newNode.prev=null;
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
            if(head.next!=null)
            {
                head=head.next;
                head.prev=null;
            }
            else 
            {
                head=null;
            }
            return head;
        }
        Node temp=head;
        for(int i=0;i<position;i++)
        {
            if (temp == null) 
            {
                System.out.println("Position out of bound");
                return head;
            }
            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.println("Position out of bound");
            return head;
        }
        if(temp.next!=null)
        {
            temp.next.prev=temp.prev;
        }
        if(temp.prev!=null)
        {
            temp.prev.next=temp.next;
        }
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
                newNode.prev=temp;
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