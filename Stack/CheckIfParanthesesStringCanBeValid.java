//lc-2116
public class CheckIfParanthesesStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0)//odd length can't form valid paranthesis
        {
            return false;
        }
        int open=0,flexible=0;
        //forward pass for no excess )
        for(int i=0;i<s.length();i++)
        {
            if(locked.charAt(i)=='0')//0 means we can alter flexible characters
            {
                flexible++;
            }
            else if(s.charAt(i)=='(')//count open brackets
            {
                open++;
            }
            else //for closed brackets
            {
                if(open>0) //match each open paranthesis for each closed 
                {
                    open--;
                }
                else if(flexible>0) //if no open use flexible position as ( to match
                {
                    flexible--;
                }
                else //if excess closed there is no match
                {
                    return false;
                }
            }
        }
        int close=0;
        flexible=0;
        //backward pass for no excess (
        for(int i=s.length()-1;i>=0;i--)
        {
            if(locked.charAt(i)=='0')//count flexible position
            {
                flexible++;
            }
            else if(s.charAt(i)==')')//count closed paranthesis
            {
                close++;
            }
            else
            {
                if(close>0)
                {
                    close--;
                }
                else if(flexible>0)
                {
                    flexible--;
                }
                else
                {
                    return false;
                }
            }
        }
        return true; //if no excess ( and ) found
    }
}
