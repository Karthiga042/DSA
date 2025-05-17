//gfg
//Queue using Linked List
class QueueUsingLinkedList {
    QueueNode front, rear;

    // Function to push an element into the queue.
    void push(int a) {
        // Your code here
        QueueNode newNode=new QueueNode(a);
        if(front==null && rear==null)
        {
            front=newNode;
            rear=newNode;
        }
        else
        {
            rear.next=newNode;
            rear=newNode;
        }
    }

    // Function to pop front element from the queue.
    int pop() {
        
        // Your code here
        int popElement=-1;
        if(front==null || rear==null)
        {
            return popElement;
        }
        if(front==rear)
        {
            popElement=front.data;
            front=null;
            rear=null;
            return popElement;
        }
        popElement=front.data;
        front=front.next;
        return popElement;
    }
}
