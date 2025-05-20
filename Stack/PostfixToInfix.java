import java.util.*;
public class PostfixToInfix
{
    static boolean isOperator(char ch)
    {
        return ch=='^' || ch=='*' || ch=='/' || ch=='+' || ch=='-';
    }
    static void postfixToInfix(String s)
    {
        Stack<String> st=new Stack<>();
       for(int i=0;i<s.length();i++)
       {
           char ch=s.charAt(i);
           if(Character.isLetterOrDigit(ch))
           {
               st.push(Character.toString(ch));
           }
           else if(isOperator(ch))
           {
               String op2=st.pop();//for right side operand
               String op1=st.pop();//for left side operand
               String infix="("+op1+ch+op2+")";
               st.push(infix);
           }
       }
       System.out.println(st.peek());//only one infix string in stack
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String expression=sc.nextLine();
		postfixToInfix(expression);
	}
}