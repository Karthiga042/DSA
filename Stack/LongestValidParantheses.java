//lc-32
class LongestValidParantheses {
    public int longestValidParentheses(String s) {
        //optimal
        int maxLen=0;
        int close=0;
        int open=0;
        //left to right for handling more closed brackets
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open==close)
            {
                maxLen=Math.max(maxLen,open*2);
            }
            else if(close>open)
            {
                open=close=0;
            }
        }
        open=close=0; //reset to 0
        //right to left for handling more open brackets
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open==close)
            {
                maxLen=Math.max(maxLen,open*2);
            }
            else if(open>close)
            {
                open=close=0;
            }
        }
        return maxLen;

        // int maxLen=0;
        // Stack<Integer> st=new Stack<>();
        // st.push(-1); //base for valid substring
        // for(int i=0;i<s.length();i++)
        // {
        //     if(s.charAt(i)=='(')
        //     {
        //         st.push(i);
        //     }
        //     else //')'
        //     {
        //         st.pop();
        //         if(st.isEmpty())//if st is empty after popping then push i as base
        //         {
        //             st.push(i);
        //         }
        //         else//if not empty valid substring ends at current i
        //         {
        //             int len=i-st.peek(); //valid substring
        //             maxLen=Math.max(maxLen,len);
        //         }
        //     }
        // }
        // return maxLen;
    }
}
