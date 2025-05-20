//lc-907
import java.util.Stack;
class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int prevSmaller[]=new int[n];
        int nextSmaller[]=new int[n];
        //prev smaller
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                prevSmaller[i]=st.peek();
            }
            else
            {
                prevSmaller[i]=-1;
            }
            st.push(i);//storing index for width count
        }
        st.clear();
        //next smaller
        for(int i=n-1;i>=0;i--)
        {
            //include equal values on left so >=
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                nextSmaller[i]=st.peek();
            }
            else
            {
                nextSmaller[i]=n;
            }
            st.push(i);
        }
        long sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++)
        {
            long left=i-prevSmaller[i];//gives how many steps in left it is minimum
            long right=nextSmaller[i]-i;//gives how many steps in right it is minimum
            long contribution=(left*right*arr[i])%mod;
            sum=(sum+contribution)%mod;
        }
        return (int)sum;
    }
}