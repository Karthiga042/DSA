import java.util.*;
class Node 
{
    int data;
    Node next;
}
public class MultiplyLists
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
    public static long listToInteger(Node head)
    {
        long num=0;
        int mod=1000000007;
        Node temp=head;
        while(temp!=null)
        {
            num=(num*10+temp.data)%mod;
            temp=temp.next;
        }
        return num;
    }
    public static Node integerToList(long num)
    {
        if(num==0)
        {
            return createNode(0);
        }
        Stack<Integer> st=new Stack<>();
        while(num>0)
        {
            int digit=(int)num%10;
            st.push(digit);
            num/=10;
        }
        Node head=null;
        Node temp=null;
        while(!st.isEmpty())
        {
            int digit=st.pop();
            Node newNode=createNode(digit);
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
        return head;
    }
    public static Node multiplyList(Node head1,Node head2)
    {
       long num1=listToInteger(head1);
       long num2=listToInteger(head2);
       int mod=1000000007;
       long result=(num1*num2)%mod;
       return integerToList(result);
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes for list 1:");
        int n=sc.nextInt();
        Node head1=null;
        Node temp1=null;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value for node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
            if(head1==null)
            {
                head1=newNode;
                temp1=newNode;
            }
            else
            {
                temp1.next=newNode;
                temp1=newNode;
            }
        }
        System.out.println("Enter number of nodes for list 2:");
        int m=sc.nextInt();
        Node head2=null;
        Node temp2=null;
        for(int i=0;i<m;i++)
        {
            System.out.println("Enter value for node "+(i+1)+":");
            int value=sc.nextInt();
            Node newNode=createNode(value);
            if(head2==null)
            {
                head2=newNode;
                temp2=newNode;
            }
            else
            {
                temp2.next=newNode;
                temp2=newNode;
            }
        }
        System.out.println("List 1:");
        display(head1);
        System.out.println();
        System.out.println("List 2:");
        display(head2);
        System.out.println();
        Node result=multiplyList(head1,head2);
        System.out.println("Multiply: ");
        display(result);
	}
}