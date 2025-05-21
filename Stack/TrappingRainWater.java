//lc-42
class TrappingRainWater {
    public int trap(int[] height) {
        //optimal
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxLeft=0;//max height seen from left
        int maxRight=0;//max height seen from right
        int water=0;
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(height[left]>=maxLeft)//is higher than max update
                {
                    maxLeft=height[left];
                }
                else //else trap the rainwater
                {
                    water+=maxLeft-height[left];
                }
                left++;
            }
            else
            {
                if(height[right]>=maxRight)
                {
                    maxRight=height[right];
                }
                else
                {
                    water+=maxRight-height[right];
                }
                right--;
            }
        }
        return water;//total water trapped

        // int n=height.length;
        // int left[]=new int[n];
        // left[0]=height[0];
        // for(int i=1;i<n;i++)
        // {
        //     // left[i]=left[i-1]+height[i];
        //     left[i]=Math.max(left[i-1],height[i]);
        // }
        // int right[]=new int[n];
        // right[n-1]=height[n-1];
        // for(int i=n-2;i>=0;i--)
        // {
        //     // right[i]+=right[i+1]+height[i];
        //     right[i]=Math.max(right[i+1],height[i]);
        // }

        // int trap=0;
        // for(int i=0;i<n;i++)
        // {
        //     trap+=Math.min(left[i],right[i])-height[i];
        //     //if height is more than min of left and right max then no water is trapped here
        // }
        // return trap;
    }
}