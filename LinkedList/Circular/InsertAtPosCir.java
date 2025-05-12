import java.util.*;
class Node 
{
    int data;
    Node next;
}
class InsertAtPosCir 
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
    public static Node insertPos(Node head,int position,int posVal)
    {
        Node newNode=createNode(posVal);
        if(position==0)
        {
            if(head==null)
            {
                head=newNode;
                newNode.next=head;
            }
            else 
            {
                newNode.next=head;
                head=newNode;
                Node temp=head;
                while(temp.next!=head)
                {
                    temp=temp.next;
                }
                temp.next=head;
            }
            return head;
        }
        Node temp=head;
        for(int i=0;i<position-1;i++)
        {
            if(temp==null || temp.next==head)
            {
                System.out.println("Position out of bounds");
                return head;
            }
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
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
        System.out.println("Enter the position to insert:");
        int position=sc.nextInt();
        System.out.println("Enter the value to position:");
        int posVal=sc.nextInt();
        head=insertPos(head,position,posVal);
        System.out.println("Modified list:");
        display(head);
    }
}