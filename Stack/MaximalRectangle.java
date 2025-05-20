//lc-85
import java.util.Arrays;
import java.util.Stack;
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
        {
            return 0;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int heights[]=new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')//calculate height for each column
                {
                    //When you hit a '1', you increase the column height, because it's a continuous vertical bar of '1'
                    heights[j]++;
                }
                else
                {
                    //When you hit a '0', the column height is reset to 0,because you can’t form a rectangle including that cell.
                    heights[j]=0;
                }
            }
            //recursively calculate max area like 
            //1st row alone then 1 and 2 alone then 1 2 3 alone then 1 2 3 4 etc
            maxArea=Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
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