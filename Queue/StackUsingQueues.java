//lc-225
import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQueues {
    class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int x=-1;
        while(!q1.isEmpty() && q1.size()!=1)
        {
            q2.add(q1.remove());
        }
        if(q1.size()==1)
        {
            x=q1.remove();
        }

        //instead of again removing and moving everything we can make it optimal by just changing reference of queue
        while(!q2.isEmpty()) 
        {
            q1.add(q2.remove());
        }
        // Queue<Integer> temp=q1;
        // q1=q2;
        // q2=temp;
        return x;
    }
    
    public int top() {
        int x=-1;
        while(!q1.isEmpty() && q1.size()!=1)
        {
            q2.add(q1.remove());
        }
        if(q1.size()==1)
        {
            x=q1.peek();
            q2.add(q1.remove());
        }
        while(!q2.isEmpty())
        {
            q1.add(q2.remove());
        }
        // Queue<Integer> temp=q1;
        // q1=q2;
        // q2=temp;
        return x;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
