import java.util.*;
class Node 
{
    int data;
    Node next;
}
class DeleteEndCir 
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
        // while(true)
        // {
        //     System.out.print(temp.data+"->");
        //     temp=temp.next;
        //     if(temp==head)
        //     {
        //         break;
        //     }
        // }
        do
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }while(temp!=head);
        System.out.println("(back to head)");
    }
    public static Node deleteEnd(Node head)
    {
        if(head==null)
        {
            return head;
        }
        if(head.next==head)
        {
            head=null;
            return head;
        }
        Node temp=head;
        while(temp.next.next!=head)
        {
            temp=temp.next;
        }
        temp.next=head;
        return head;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n=sc.nextInt();
        Node head=null;
        Node temp=null;//tail
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the value of node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
             if(head==null)
            {
                head=newNode;
                temp=newNode;
                temp.next=head;
            }
            else 
            {
                temp.next=newNode;
                temp=newNode;
                temp.next=head;
            }
        }
        System.out.println("Original list:");
        display(head);
        System.out.println();
        head=deleteEnd(head);
        System.out.println("Modified list:");
        display(head);
    }
}