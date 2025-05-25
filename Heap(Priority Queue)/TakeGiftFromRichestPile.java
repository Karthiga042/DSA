//lc-2558
import java.util.Collections;
import java.util.PriorityQueue;
public class TakeGiftFromRichestPile {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<gifts.length;i++)
            {
                pq.add(gifts[i]);
            }
            while(k>0)
            {
                int n=pq.remove();
                pq.add((int)Math.sqrt(n));
                k--;
            }
            long ans=0;
            while(!pq.isEmpty())
            {
                ans+=pq.remove();
            }
            return ans;
        }
    }
}
