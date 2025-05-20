//lc-155
import java.util.Stack;
class MinStack {
    Stack<Integer> s1 =new Stack<>();//main stack
    Stack<Integer> s2 =new Stack<>();//min stack
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s1.isEmpty())
        {
            s1.push(val);
            s2.push(val); // If it's the first element, it is also the minimum
        }
        else
        {
            s1.push(val);
            int min=Math.min(val,s2.peek());// Compare `val` with the current minimum
            s2.push(min);//push new minimum to stack
        }
    }
    
    public void pop() {
        s1.pop();//pop main stack top element
        s2.pop();//pop min stack corresponding top element
    }
    
    public int top() {
        return s1.peek();//retun top of main stack
    }
    
    public int getMin() {
        return s2.peek();//returns current min value
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */