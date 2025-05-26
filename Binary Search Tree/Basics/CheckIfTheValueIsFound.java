import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class CheckIfTheValueIsFound 
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
    public static boolean search(Node root,int searchVal)
    {
        if(root==null)
        {
            return false;
        }
        if(searchVal==root.data)
        {
            return true;
        }
        if(searchVal<root.data)
        {
            return search(root.left,searchVal);
        }
        else 
        {
            return search(root.right,searchVal);
        }
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
        
        System.out.println("Enter the value to search in the tree: ");
        int searchVal=sc.nextInt();
        
        if(search(root,searchVal))
        {
            System.out.println(searchVal+" is found in the tree");
        }
        else
        {
            System.out.println(searchVal+" is not found in the tree");
        }
    }
}