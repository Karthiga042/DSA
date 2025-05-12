import java.util.*;
class Node 
{
    int data;
    Node next;
}
class InsertAtPosition1 
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
    public static Node insertAtPosition(Node head,int position,int posVal)
    {
        Node newNode=createNode(posVal);
        if(position==0)
        {
            newNode.next=head;
            head=newNode;
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
        if(temp==null)
        {
            System.out.println("Position out of bound");
            return head;
        }
        newNode.next=temp.next;
        temp.next=newNode;
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
        System.out.println("Enter position to be inserted:");
        int position=sc.nextInt();
        System.out.println("Enter value of position:");
        int posVal=sc.nextInt();
        System.out.println("Modified list:");
        head=insertAtPosition(head,position,posVal);
        display(head);
    }
}