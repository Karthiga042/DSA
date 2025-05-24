//lc-3264
import java.util.PriorityQueue;
public class FinalArrayAfterKMultiplication1 {
    class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //optimal
        //stores value and index 
        //it sorts based on value is equal values then based on index
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<nums.length;i++)
        {
            pq.add(new int[]{nums[i],i});
        }
        while(k-->0)
        {
            int x[]=pq.poll();
            int val=x[0];
            int index=x[1];

            nums[index]=val*multiplier;//after multiplication set new value in that index
            pq.add(new int[]{nums[index],index});
        }
        return nums;

        // while(k!=0)
        // {
        //     int min=Integer.MAX_VALUE;
        //     int index=-1;
        //     for(int i=0;i<nums.length;i++)
        //     {
        //         if(min>nums[i])
        //         {
        //             min=nums[i];
        //             index=i;
        //         }
        //     }
        //     nums[index]*=multiplier;
        //     k--;
        // }
        // return nums;
    }
}
}
