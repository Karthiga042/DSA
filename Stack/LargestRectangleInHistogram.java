//lc-84
import java.util.Arrays;
import java.util.Stack;
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int prevSmaller[]=new int[n];
        int nextSmaller[]=new int[n];
        Arrays.fill(prevSmaller,0);//default no smaller to leftmost
        Arrays.fill(nextSmaller,n-1);//no smaller to rightmost
        //prev smaller
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                prevSmaller[i]=st.peek()+1;//+1 to exclude prev small element
            }
            st.push(i);//storing index for width count
        }
        st.clear();
        //next smaller
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                nextSmaller[i]=st.peek()-1;//-1 to exclude next small element
            }
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            //right-left+1
            int width=nextSmaller[i]-prevSmaller[i]+1;
            int area=width*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}