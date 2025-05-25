//lc-1438
import java.util.*;
public class LongestContinuousSubArrayWithAbsDiff {
    class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deque for max elements 
        Deque<Integer> maxDeque=new LinkedList<>();
        // Deque for min elements 
        Deque<Integer> minDeque=new LinkedList<>();
        //left pointer of sliding window or start pointer
        int left=0;
        //to store the length of the longest valid subarray
        int maxLen=0;
        //represents right ie)end pointer of sliding window
        for (int right=0;right<nums.length;right++) 
        {
            // Maintain the max deque (keep max elements at the front)
            while(!maxDeque.isEmpty() && maxDeque.peekLast()<nums[right]) 
            {
                maxDeque.pollLast();//remove that element bcoz it is no longer max
            }
            maxDeque.addLast(nums[right]);//add the new max element to last

            // Maintain the min deque (keep min elements at the front)
            //similar for min
            while (!minDeque.isEmpty() && minDeque.peekLast()>nums[right]) 
            {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);

            // If current window violates the condition max - min > limit, shrink from left
            while(maxDeque.peekFirst()-minDeque.peekFirst()>limit) 
            {
                //when we shrink window if that element is in max or min remove from that too bcoz it is no longer part of window
                if(nums[left]==maxDeque.peekFirst()) 
                {
                    maxDeque.pollFirst();
                }
                if(nums[left]==minDeque.peekFirst()) 
                {
                    minDeque.pollFirst();
                }
                left++;//increment start to shrink the window
            }

            // Calculate the length of the valid subarray r-l+1 and get max valid subarray
            maxLen=Math.max(maxLen,right-left+1);
        }

        return maxLen;
    }
}


// class Solution {
//     public int longestSubarray(int[] nums, int limit) { 
//         int maxLen=0;
//         int n=nums.length;
//         for(int s=0;s<n;s++)
//         {
//             for(int e=s;e<n;e++)
//             {
//                 int min=nums[s];
//                 int max=nums[s];
//                 for(int i=s;i<=e;i++)
//                 {
//                     if(nums[i]<min)
//                     {
//                         min=nums[i];
//                     }
//                     if(nums[i]>max)
//                     {
//                         max=nums[i];
//                     }
//                 }
//                 if(max-min<=limit)
//                 {
//                     maxLen=Math.max(maxLen,e-s+1);//e-s+1 is used to get len of subarray found
//                 }
//             }
//         }
//         return maxLen;
//     }
// }
}
