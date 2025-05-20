//lc-1963
public class MinSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
            {
                open++;
            }
            else//s.charAt(i)==']'
            {
                if(open>0)//for each open close the pair[] is found
                {
                    open--;//pair with close bracket and decrement count
                }
                else
                {
                    close++;//unmatched close bracket count increases
                }
            }
        }
        // Each swap can fix two unmatched brackets so divided by 2
        return (close+1)/2;//unmatched counts 

        // Stack<Character> temp=new Stack<>();
        // for(int i=0;i<s.length();i++)
        // {
        //     if(temp.isEmpty() && s.charAt(i)==']')
        //     // If the current character is a closing bracket ']' and the stack is empty,
        //     // it means there is no matching opening bracket for this closing bracket.
        //     // We continue to the next character without doing anything.
        //     {
        //         continue;
        //     }
        //     else if(!temp.isEmpty() && temp.peek()=='[' && s.charAt(i)==']')
        //      // If the current character is a closing bracket ']' and the top of the stack
        //     // is an opening bracket '[', we pop the top bracket from the stack
        //     // because we found a matching pair
        //     {
        //         temp.pop();
        //     }
        //     else
        //     // If the current character is an opening bracket '[' or there is no matching
        //     // closing bracket for the top of the stack, we push the opening bracket onto the stack.
        //     {
        //         temp.push(s.charAt(i));
        //     }
        // }
        // // After processing all characters, the stack will contain unmatched brackets.
        // // Each swap can fix two unmatched brackets, so we calculate the number of swaps needed.
        // // The formula (st.size() + 1) / 2 ensures that we account for any odd number of unmatched brackets.
        // return (temp.size()+1)/2;
    }
}
