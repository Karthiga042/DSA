//lc-11
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r)
        {
            int w=(r-l);//distance width between 2 lines
            int h=Math.min(height[l],height[r]);
            int current=w*h;//Area=Width×Height=(j−i)×min(height[i],height[j])
            max=Math.max(current,max);
            //to determine from which line to which line water is more
            //to explore water container in all lines and find max
            if(height[l]<height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return max;
    }
}
