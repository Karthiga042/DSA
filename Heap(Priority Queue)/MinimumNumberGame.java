//lc-2974
import java.util.Arrays;
public class MinimumNumberGame {
    class Solution {
        public int[] numberGame(int[] nums) {
            //optimal
            //sort array then swap as pairs(min1,min2 and min3,min4 etc) gives same result
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i+=2) 
            {
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
            return nums;

            // PriorityQueue<Integer> pq=new PriorityQueue<>();
            // for(int i=0;i<nums.length;i++)
            // {
            //     pq.add(nums[i]);
            // }
            // List<Integer> list=new ArrayList<>();
            // while(!pq.isEmpty())
            // {
            //     int alice=pq.poll();
            //     int bob=pq.poll();
            //     list.add(bob);
            //     list.add(alice);
            // }
            // int res[]=new int[list.size()];
            // for(int i=0;i<list.size();i++)
            // {
            //     res[i]=list.get(i);
            // }
            // return res;
        }
    }
}
