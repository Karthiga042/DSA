//lc-1792
import java.util.PriorityQueue;
public class MaxAveragePassRatio {
    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            //stores gain,pass,total
            //sorts by gain in descending order
            PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
            //pq is sorted so the class with the highest gain is on top
            for(int i=0;i<classes.length;i++)
            {
                double pass=classes[i][0];
                double total=classes[i][1];
                //to store what we get as gain after adding 1 student to current class
                double gain=getGain(pass,total); 
                pq.offer(new double[]{gain,pass,total});
            }
            //assign all extra students(extra students are guarenteed to pass)
            //pq gives us the class where adding one student helps the most(max heap)
            while(extraStudents-->0)
            {
                double top[]=pq.poll();
                double pass=top[1]+1;//add 1 extra student to pass and total 
                double total=top[2]+1;
                double gain=getGain(pass,total);
                pq.offer(new double[]{gain,pass,total});
            }
            //stores sum of their current pass ratio
            double finalAvg=0.0;
            while(!pq.isEmpty())
            {
                double cls[]=pq.poll();
                finalAvg+=cls[1]/cls[2]; // gain/total
            }
            return finalAvg/classes.length; // sum of all avg/n
        }
        private double getGain(double pass,double total)
        {
            //represents the gain in pass ratio if you add one extra passing student to a class
            //new value after adding 1 student minus old value
            return (pass+1)/(total+1)-pass/total;
        }
    }
}
