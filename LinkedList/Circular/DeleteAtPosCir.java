import java.util.*;
class Node 
{
    int data;
    Node next;
}
class DeleteAtPosCir 
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
    public static Node deletePos(Node head,int position)
    {
        if(head==null)
        {
            return null;
        }
        if(position==0)
        {
            if(head.next==head)
            {
                head=null;
                return null;
            }
            Node temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            temp.next=head.next;
            head=head.next;
            return head;
        }
        Node temp=head;
        for(int i=0;i<position-1;i++)
        {
            if(temp.next==head)
            {
                System.out.println("Position out of bound");
                return head;
            }
            temp=temp.next;
        }
        Node nodeToDelete=temp.next;
        temp.next=nodeToDelete.next;
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
        System.out.print("Original list:");
        display(head);
        System.out.println();
        System.out.println("Enter the position to delete:");
        int position=sc.nextInt();
        head=deletePos(head,position);
        System.out.println("Modified list:");
        if(head==null)
            System.out.print("List is empty");
        else
            display(head);
    }
}