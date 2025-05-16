import java.util.*;
class Node 
{
    int data;
    Node next;
}
public class RemoveDuplicatesFromUnsortedList
{
    public static Node createNode(int value)
    {
        Node nn=new Node();
        nn.data=value;
        nn.next=null;
        return nn;
    }
    public static void display(Node head)
    {
        if(head==null)
        {
            System.out.println("List empty");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static Node removeDuplicates(Node head)
    {
        if(head==null)
        {
            return null;
        }
        HashSet<Integer> set=new HashSet<>();
        Node temp=head;
        set.add(temp.data);
        while(temp.next!=null)
        {
            if(set.contains(temp.next.data))
            {
                temp.next=temp.next.next;
            }
            else 
            {
                set.add(temp.next.data);
                temp=temp.next;
            }
        }
        return head;
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes:");
		int n=sc.nextInt();
		Node head=null;
		Node temp=null;
		for(int i=0;i<n;i++)
		{
		    System.out.println("Enter the value for node "+(i+1)+":");
		    int value=sc.nextInt();
		    Node nn=createNode(value);
		    if(head==null)
		    {
		        head=nn;
		        temp=nn;
		    }
		    else 
		    {
		        temp.next=nn;
		        temp=nn;
		    }
		}
		System.out.println("Original list");
		display(head);
		System.out.println();
		System.out.println("Modified list:");
		head=removeDuplicates(head);
		display(head);
	}
}