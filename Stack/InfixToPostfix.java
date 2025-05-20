//coding ninjas
//Infix To Postfix

import java.util.*;
public class InfixToPostfix {
    public static String infixToPostfix(String exp) {
        // Write your code here
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();//sb is more effective than string appending
        // String temp="";
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(ch);
                // temp+=ch;
            }
            else if(ch=='(')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    sb.append(st.pop());
                    // temp+=st.pop();
                }
                if(!st.isEmpty() && st.peek()=='(')
                {
                    st.pop();
                }
            }
            else 
            {
                while(!st.isEmpty() && (precedence(ch)<=precedence(st.peek()) || (precedence(ch)==precedence(st.peek()) && associativity(ch)=='L')))
                {
                    sb.append(st.pop());
                    // temp+=st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
            // temp+=st.pop();
        }
        return sb.toString();
        // return temp;
    }
    static int precedence(char ch)
    {
        if(ch=='^')
            return 3;
        else if(ch=='*' || ch=='/')
            return 2;
        else if(ch=='+' || ch=='-')
            return 1;
        else 
            return -1;
    }
    static char associativity(char ch)
    {
        if(ch=='^')
            return 'R';
        else
            return 'L';
    }
}

// import java.util.*;
// public class InfixToPostfix
// {
//     static int precedence(char ch)
//     {
//         if(ch=='^')
//             return 3;
//         else if(ch=='*' || ch=='/')
//             return 2;
//         else if(ch=='+' || ch=='-')
//             return 1;
//         else 
//             return -1;
//     }
//     static char associativity(char ch)
//     {
//         if(ch=='^')
//             return 'R';
//         else 
//             return 'L';
//     }
//     static void infixToPostfix(String s)
//     {
//         String temp="";//storing postfix
//         Stack<Character> st=new Stack<>();//for operator
//         for(int i=0;i<s.length();i++)
//         {
//             char ch=s.charAt(i);
//             if(Character.isLetterOrDigit(ch))
//             {
//                 temp+=ch;
//             }
//             else if(ch=='(')
//             {
//                 st.push(ch);
//             }
//             else if(ch==')')
//             {
//                 while(!st.isEmpty() && st.peek()!='(')
//                 {
//                     temp+=st.pop();
//                 }
//                 if(!st.isEmpty() && st.peek()=='(')
//                 {
//                     st.pop();
//                 }
//             }
//             else  //for operator
//             {
//                 while(!st.isEmpty() && (precedence(ch)<precedence(st.peek()) || (precedence(ch)==precedence(st.peek()) && associativity(ch)=='L')))
//                 {
//                     temp+=st.pop();
//                 }
//                 st.push(ch);
//             }
//         }
//         while(!st.isEmpty())
//         {
//             temp+=st.pop();
//         }
//         System.out.println(temp);
//     }
// 	public static void main(String[] args) {
// 		Scanner sc=new Scanner(System.in);
// 		String expression=sc.nextLine();
// 		infixToPostfix(expression);
// 	}
// }