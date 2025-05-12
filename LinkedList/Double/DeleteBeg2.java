import java.util.*;
class Node 
{
    int data;
    Node next;
    Node prev;
}
class DeleteBeg2 
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
    public static Node deleteBeg(Node head)
    {
        if(head==null)
        {
            return null;
        }
        Node temp=head;
        head=head.next;
        if(head!=null)
        {
            head.prev=null;
        }
        temp=null; //not necessary
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
        System.out.println("Modified list:");
        head=deleteBeg(head);
        display(head);
    }
}