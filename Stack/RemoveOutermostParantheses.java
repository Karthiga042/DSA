//lc-1021
import java.util.Stack;
class RemoveOutermostParantheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> temp=new Stack<>();
        String str="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(!temp.isEmpty())//means it is still inside primitive decompoistion string
                //so we can add
                //if it is empty we are in the outermost parantheses
                //so no need to add to result
                {
                    str+=s.charAt(i);
                }
                temp.push(s.charAt(i));//push open paranthesis to stack
            }
            else//Current character is a closing parenthesis
            {
                temp.pop();//pop closing bracket for stack with 1 outer open bracket 
                if(!temp.isEmpty())//inside primitive string
                {
                    str+=s.charAt(i);
                }
            }
        }
        return str;
    }
}
//first divide given string into primitive decomposition ie)string can be diviided into valid paranthses string
//after dividing remove outermost paranthesis for each decomposition primitive string