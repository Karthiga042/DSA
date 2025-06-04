import java.util.*;
class Node 
{
    int data;
    Node left;
    Node right;
}
class BurningTheTree 
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
    
    //to find node with given target in BST
    public static Node findTarget(Node root,int target)
    {
        if(root==null)
        {
            return null;
        }
        if(target==root.data)
        {
            return root;
        }
        if(target<root.data)
        {
            return findTarget(root.left,target);
        }
        else 
        {
            return findTarget(root.right,target);
        }
    }
    
    //map each node to its parent for bidirection traversal
    public static void markParents(Node root,Map<Node,Node> parentMap)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            if(curr.left!=null)
            {
                //map left child to its curr node
                parentMap.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null)
            {
                //map right child to its curr node
                parentMap.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    
    //to calculate min time to burn entire tree starting from target
    public static int burnTree(Node root,Node target)
    {
        if(root==null || target==null)
        {
            return 0;
        }
        
        //map to track parents of each node
        Map<Node,Node> parentMap=new HashMap<>();
        markParents(root,parentMap);
        
        //track visited nodes
        Set<Node> visited=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        
        //start BFS from target node
        q.offer(target);
        visited.add(target);
        
        int time=0;
        
        while(!q.isEmpty())
        {
            //captures the number of nodes currently burning at each step
            int size=q.size();
            
            // Flag to track if fire spreads to any new node during this iteration
            boolean burned=false;
            for(int i=0;i<size;i++)
            {
                Node node=q.poll();
                
                //burn left child
                if(node.left!=null && !visited.contains(node.left))
                {
                    visited.add(node.left);
                    q.offer(node.left);
                    burned=true; // Fire spreads to left child, mark burned as true
                }
                
                //burn right child
                if(node.right!=null && !visited.contains(node.right))
                {
                    visited.add(node.right);
                    q.offer(node.right);
                    burned=true;
                }
                
                //burn parent
                Node parent=parentMap.get(node);
                if(parent!=null && !visited.contains(parent))
                {
                    visited.add(parent);
                    q.offer(parent);
                    burned=true;
                }
            }
            
            // Increment time only if fire spread to new nodes in this iteration
            if(burned)
            {
                time++;
            }
        }
        return time;
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
        
        System.out.println("Enter the value to start burning in the tree: ");
        int target=sc.nextInt();
        Node targetNode=findTarget(root,target);
        if(targetNode==null)
        {
            System.out.println(target+" is not found in the tree");
        }
        else
        {
            int burnTime=burnTree(root,targetNode);
            System.out.println("Time to burn entire tree from target is "+burnTime);
        }
    }
}