import java.util.Arrays;
import java.util.Stack;
class NextGreaterOnLeft {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n=arr.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}