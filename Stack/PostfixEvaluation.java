//gfg
//Postfix Evaluation
import java.util.*;
class PostfixEvaluation {
    private static boolean isNumber(String s)
	{
		return s.matches("-?\\d+"); //allows negative and numerous digits
	}
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
		for(int i=0;i<arr.length;i++)
		{
			String s=arr[i];
			if(isNumber(s))
			{
				st.push(Integer.parseInt(s));
			}
			else 
			{
				int b=st.pop();
				int a=st.pop();
				switch(s)
				{
					case "+":
					st.push(a+b);
					break;
					case "-":
					st.push(a-b);
					break;
					case "*":
					st.push(a*b);
					break;
					case "/":
					st.push(a/b);
					break;
				}
			}
		}
		return st.pop();
    }
}