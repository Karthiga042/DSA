import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class DiameterOfTree 
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
    static int diameter=0;
    public static int findHeightAndDiameter(Node root)
    {
        if(root==null)
        {
            return -1;
        }
        int leftHeight=findHeightAndDiameter(root.left);
        int rightHeight=findHeightAndDiameter(root.right);
        
        //diameter is sum of leftHeight+rightHeight+2 edges(left and right for 1 current node)
        diameter=Math.max(diameter,leftHeight+rightHeight+2);
        
        //finding height 
        return Math.max(leftHeight,rightHeight)+1;
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
        int height=findHeightAndDiameter(root);
        System.out.println("Height of BST is: "+height);
        System.out.println("Diameter of BST is: "+diameter);
    }
}