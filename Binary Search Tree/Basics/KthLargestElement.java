import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class KthLargestElement
{
    public static Node insert(Node root,int value)
    {
        Node newNode=new Node();
        newNode.data=value;
        newNode.left=null;
        newNode.right=null;
        if(root==null)
        {
            return newNode;
        }
        if(value==root.data)
        {
            System.out.println("Duplicate value found: "+value);
            return root;
        }
        if(value<root.data)
        {
            root.left=insert(root.left,value);
        }
        else 
        {
            root.right=insert(root.right,value);
        }
        return root;
    }
    private static int count=0;
    private static int result=-1; //to store the kth largest element
    public static int kthLargest(Node root,int k)
    {
        //reset count and result for next process
        count=0;
        result=-1;
        reverseInorder(root,k);
        return result;
    }
    //reverse inorder gives in descending order
    public static void reverseInorder(Node root,int k) 
    {
        if(root==null || count>=k)
        {
            return;
        }
        //greater elements are always right so process that 1st
        reverseInorder(root.right,k);
        count++;
        if(count==k)
        {
            result=root.data;
            return;
        }
        //then process left which contains smaller elements
        reverseInorder(root.left,k);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n=sc.nextInt();
        Node root=null;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the value for node "+(i+1)+": ");
            int value=sc.nextInt();
            root=insert(root,value);
        }
        
        System.out.println("Enter the value of k: ");
        int k=sc.nextInt();
        
        int ans=kthLargest(root,k);
        if(ans!=-1)
        {
            System.out.println(k+" largest value is: "+ans);
        }
        else
        {
            System.out.println("Tree does not have "+k+" elements");
        }
    }
}