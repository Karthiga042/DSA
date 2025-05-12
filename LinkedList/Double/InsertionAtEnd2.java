import java.util.*;
class Node 
{
    int data;
    Node next;
    Node prev;
}
class InsertionAtEnd2 
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
        //forward traversal
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        
        //backward traversal
        //prints from tail to head
        // Node temp=head;
        // while(temp.next!=null)
        // {
        //     temp=temp.next;
        // }
        // while(temp!=null)
        // {
        //     System.out.print(temp.data+" ");
        //     temp=temp.prev;
        // }
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
        display(head);
    }
}