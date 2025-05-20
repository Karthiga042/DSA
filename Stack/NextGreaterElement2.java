//lc-503
import java.util.*;
class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        Arrays.fill(arr,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--)
        {
            int index=i%n;//circular array
            //pop small or equal elements
            while(!st.isEmpty() && st.peek()<=nums[index])
            {
                st.pop();
            }
            // If stack has elements, top is the nge
            if(!st.isEmpty())
            {
                arr[index]=st.peek();
            }
            // Push current element for future comparison
            st.push(nums[index]);
        }
        return arr;
    }
}