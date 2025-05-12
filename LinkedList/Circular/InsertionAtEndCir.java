import java.util.*;
class Node 
{
    int data;
    Node next;
}
class Main 
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
        while(true)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
            if(temp==head)
            {
                break;
            }
        }
        System.out.println("(back to head)");
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
                temp.next=head;//back to head
            }
            else 
            {
                temp.next=newNode;
                temp=newNode;
                temp.next=head;
            }
        }
        // if(temp!=null) //back to head
        // {
        //     temp.next=head;
        // }
        display(head);
    }
}