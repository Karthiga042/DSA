//lc-1047
import java.util.Stack;
class RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> temp=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(temp.isEmpty())
            {
                temp.push(s.charAt(i));
            }
            else if(temp.peek()==s.charAt(i))
            {
                temp.pop();
            }
            else
            {
                temp.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!temp.isEmpty())
        {
            sb.append(temp.pop());
        }
        return sb.reverse().toString();
    }
}