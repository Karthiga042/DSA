//gfg
//Flattening a Linked List
class FlatteningLinkedList {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null)
        {
            return root;
        }
        //recursion for flattening list on right
        root.next=flatten(root.next);
        //merge list with next one
        root=mergeTwoLists(root,root.next);
        return root;
    }
    Node mergeTwoLists(Node l1,Node l2)
    {
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.data<l2.data)
            {
                temp.bottom=l1;
                l1=l1.bottom;
            }
            else
            {
                temp.bottom=l2;
                l2=l2.bottom;
            }
            temp=temp.bottom;
        }
        if(l1!=null)
        {
            temp.bottom=l1;
        }
        else
        {
            temp.bottom=l2;
        }
        return dummy.bottom;
    }
}