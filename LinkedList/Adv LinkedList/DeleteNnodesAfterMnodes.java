//gfg 
//Delete N nodes after M nodes of a linked list
class DeleteNnodesAfterMnodes {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        if(head==null)
        {
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            //traverse m nodes(skip)
            int mCount=1;
            while(mCount<m && temp!=null)
            {
                temp=temp.next;
                mCount++;
            }
            if(temp==null)
            {
                break;
            }
            
            //skip(delete) n nodes
            Node tempA=temp.next;
            int nCount=1;
            while(nCount<=n && tempA!=null)
            {
                tempA=tempA.next;
                nCount++;
            }
            
            //now connect the traversed(skip) nodes after deleted nodes
            temp.next=tempA;
            temp=tempA; //for next iteration move temp to nodes after delete
        }
    }
}
