//lc-20
import java.util.Stack;
class ValidParantheses {
    public boolean isValid(String s) 
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else if((st.peek()=='{' && ch=='}') || 
                    (st.peek()=='[' && ch==']') ||
                    (st.peek()=='(' && ch==')'))
            {
                st.pop();
            }
            else
            {
                st.push(ch);
            }
        }
        return (st.isEmpty())?true:false;
    }
}
