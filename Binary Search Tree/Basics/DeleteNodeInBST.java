import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class DeleteNodeInBST 
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
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    private static int minValue(Node root)
    {
        //to find min node in left of right subtree to replace deleted node
        int min=root.data;
        while(root.left!=null)
        {
            root=root.left;
            min=root.data;
        }
        return min;
    }
    public static Node delete(Node root,int delVal)
    {
        if(root==null)
        {
            return null;
        }
        //go to left if value is smaller
        if(delVal<root.data)
        {
            root.left=delete(root.left,delVal);
        }
        //go to right if value is larger
        else if(delVal>root.data)
        {
            root.right=delete(root.right,delVal);
        }
        //node found
        else 
        {
            //if that node has only right child replace that with deleted node
            if(root.left==null)
            {
                return root.right;
            }
            //if that node has only left child replace that with deleted node
            else if(root.right==null)
            {
                return root.left;
            }
            //if it has 2 children
            //find min node in left of right subtree and replace that with deleted node
            root.data=minValue(root.right);
            root.right=delete(root.right,root.data);
        }
        return root;
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
        
        System.out.println("Inorder traversal before deletion: ");
        inorder(root);
        System.out.println();
        
        System.out.println("Enter the value to delete from the tree: ");
        int delVal=sc.nextInt();
        root=delete(root,delVal);
        
        System.out.println("Inorder traversal after deletion: ");
        inorder(root);
    }
}