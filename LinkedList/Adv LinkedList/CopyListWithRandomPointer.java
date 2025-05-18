//lc-138
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        //to map every original node to its copied node
        Map<Node,Node> map=new HashMap<>();

        //traverse original list
        Node temp=head;
        while(temp!=null)
        {
            //create a node with same value of original list
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        //assign next and random pointers by traversing original list again
        temp=head;
        while(temp!=null)
        {
            Node copyNode=map.get(temp);//each original node get its copy node
            copyNode.next=map.get(temp.next);//set copied version of next
            copyNode.random=map.get(temp.random);//set copied version of random
            temp=temp.next;
        }
        //return copied head node corresponds to original head
        return map.get(head);
    }
}