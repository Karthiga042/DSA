//lc-921
public class MinimumAddToMakeParanthesesValid {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                if(open>0)
                {
                    open--;
                }
                else
                {
                    close++;
                }
            }
        }
        return open+close;//return number of brackets to be added both open and close
        
        // Stack<Character> temp=new Stack<>();
        // int count=0;
        // for(int i=0;i<s.length();i++)
        // {
        //     if(s.charAt(i)=='(')
        //     {
        //         temp.push(s.charAt(i));
        //     }
        //     else  // If the character is a closing parenthesis
        //     {
        //         if(!temp.empty() && temp.peek()=='(')//pop for matching is found
        //         {
        //             temp.pop();
        //         }
        //         else //count the unmatched closing brackets
        //         {
        //             count++;
        //         }
        //     }
        // }
        // // The total number of moves required is the sum of unmatched opening and closing parentheses
        // return temp.size()+count;
        // //temp.size + count bcoz temp.size contains open brackets count and count variables contain closed brackets count

    }
}
