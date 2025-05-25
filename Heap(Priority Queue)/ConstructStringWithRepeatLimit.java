//lc-2182
import java.util.*;
class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[]=new int[26];
        //count frequency of each character
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }
        //sort in descending
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //if freq>0 add that index to pq
        for(int i=0;i<26;i++)
        {
            if(freq[i]>0)
            {
                pq.offer(i);
            }
        }
        //to store result string
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty())
        {
            //takes larger character
            int curr=pq.poll();
            //get the number of times to repeat
            int useCount=Math.min(freq[curr],repeatLimit);
            // Append the current character up to repeatLimit times
            for(int i=0;i<useCount;i++)
            {
                sb.append((char)(curr+'a'));
            }
            freq[curr]-=useCount;//decrease the no of times we used it
    // If there are still some left, we need to insert a smaller letter to break repetition
            if(freq[curr]>0)
            {
                //there is no next smaller character
                if(pq.isEmpty())
                {
                    break;
                }
                int next=pq.poll();//2nd largest character
                sb.append((char)(next+'a')); // insert once to break the limit
                freq[next]--; //reduce its freq by 1
                //if next has still more occurence put it in pq
                if(freq[next]>0)
                {
                    pq.offer(next);
                }
                //curr also having still more left so add it in pq
                pq.offer(curr);
            }
        }
        return sb.toString();
    }
}