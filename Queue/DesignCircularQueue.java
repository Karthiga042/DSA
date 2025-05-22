//lc-622
public class DesignCircularQueue {
    class MyCircularQueue {
    private int queue[];//to store queue elements
    private int front;//store index of front element
    private int rear;//store index of rear element
    private int size;//gives current size of queue
    private int capacity;//maximum size ie) capacity of queue given as k
    public MyCircularQueue(int k){
        capacity=k;
        queue=new int[capacity];//create queue with given capatity size
        front=0;//starts from 0th index
        rear=-1;//inititallyt no inserted so -1
        size=0;//to get size of queue ie)position till we inserted now
    }
    
    public boolean enQueue(int value) {
        if(isFull())
        {
            return false;
        }
        rear=(rear+1)%capacity;//when the index goes out of bound it wraps that index back to 0th index ie)makes it circular queue
        //eg when ur rear is in 2 and queue size is 3 then rear+1=3 that goes out of bound so (2+1)%3=0 so backs to 0th index
        queue[rear]=value;//insert the given value at rear
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
        {
            return false;
        }
        front=(front+1)%capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
        {
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
        {
            return -1;
        }
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}
}
