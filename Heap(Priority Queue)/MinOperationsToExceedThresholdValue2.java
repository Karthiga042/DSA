//lc-3066
import java.util.PriorityQueue;
public class MinOperationsToExceedThresholdValue2 {
    class Solution {
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> pq=new PriorityQueue<>();
            for(int i=0;i<nums.length;i++)
            {
                pq.add((long)nums[i]);
            }
            int count=0;
            while(pq.peek()<k)
            {
                long x=pq.poll();
                if(!pq.isEmpty())
                {
                    long y=pq.poll();
                    long ans=x*2+y;
                    pq.add(ans);
                    count++;
                }
                else
                {
                    break;
                }
            }
            return count;
        }
    }
}
