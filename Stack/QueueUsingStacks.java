//lc-232
import java.util.Stack;
class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        int x=-1;
        while(!s1.empty() && s1.size()!=1)
        {
            s2.push(s1.pop());
        }
        if(s1.size()==1)
        {
            x=s1.pop();
        }
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        return x;
    }
    
    public int peek() {
        int x=-1;
        while(!s1.empty() && s1.size()!=1)
        {
            s2.push(s1.pop());
        }
        if(s1.size()==1)
        {
            x=s1.peek();
        }
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
