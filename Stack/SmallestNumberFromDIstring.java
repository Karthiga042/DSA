//lc-2375
import java.util.Stack;
class SmallestNumberFromDIstring {
    public String smallestNumber(String pattern) {
        StringBuilder res=new StringBuilder();
        Stack<Integer> st=new Stack<>();//to store reverse groups of 'D'
        //res length is pattern+1 so <=
        for(int i=0;i<=pattern.length();i++)
        {
            st.push(i+1);//push from 1 to n+1
            //if reaqches end or
            //if encounters I means D sequence over popping them satisfy D requirement
            if(i==pattern.length() || pattern.charAt(i)=='I')
            {
                while(!st.isEmpty())
                {
                    res.append(st.pop());
                }
            }
        }
        return res.toString();
    }
}
//eg
//stack  //res
//1     //1
//2     //12
//3     //123
//4     //123
//45    //12354
//6     //12354
//67    //12354
//678   //12354
//6789  //123549876
