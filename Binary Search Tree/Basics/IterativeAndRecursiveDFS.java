import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class IterativeAndRecursiveDFS 
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
    public static void iterativeDfs(Node root)
    {
        if(root==null)
        {
            return;
        }
        Stack<Node> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            Node curr=st.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null)
            {
                st.push(curr.right);
            }
            if(curr.left!=null)
            {
                st.push(curr.left);
            }
        }
        System.out.println();
    }
    public static void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
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
        
        System.out.println("Iterative dfs (using stack): ");
        iterativeDfs(root);
        System.out.println();
        
        System.out.println("Recursive dfs (preorder): ");
        preorder(root);
    }
}