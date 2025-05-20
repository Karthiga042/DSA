//lc-2696
import java.util.Stack;
class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> temp=new Stack<>();
        // String res="";
        for(int i=0;i<s.length();i++)
        {
            if(temp.isEmpty())
            {
                temp.push(s.charAt(i));
            }
            else if((temp.peek()=='A' && s.charAt(i)=='B') ||
                    (temp.peek()=='C' && s.charAt(i)=='D'))
            {
                temp.pop();
            }
            else
            {
                temp.push(s.charAt(i));
            }
        }
        // while(!temp.isEmpty())
        // {
        //     res+=temp.pop();
        // }
        // return res.length();
        return temp.size();
    }
}