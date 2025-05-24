//lc-295
import java.util.Collections;
import java.util.PriorityQueue;
class FindMedianFromDataStream {
    
    class MedianFinder {
    //optimal
    PriorityQueue<Integer>left;
    PriorityQueue<Integer>right;
    
    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());//max heap stores smaller half
        right=new PriorityQueue<>();//min heap stores larger half
    }
    //median is top of max heap if odd count 
    //average of top of max and min if even count
    public void addNum(int num) {
        left.add(num);
        //we want size difference atmost 1 so greater than that move to right
        if (left.size() > right.size() + 1)
        {
            right.add(left.poll());  // Move the root of left to right
        }
        // Ensure the right does not have smaller values than left
        if (!right.isEmpty() && left.peek() > right.peek()) 
        {
            int temp = left.poll();
            left.add(right.poll());
            right.add(temp);
        }
    }
    
    public double findMedian() {
        //if left has one more element than right it is odd
        if (left.size() > right.size()) 
        {
            return left.peek();  // the median is the root of the max heap
        } 
        else 
        {
            return (left.peek() + right.peek()) / 2.0; // If both heaps have the same number of elements, the median is the average of the roots of both heaps
        }
    }
}

// class MedianFinder {
//     PriorityQueue<Integer>pq;
    
//     public MedianFinder() {
//         pq=new PriorityQueue<>();
//     }
    
//     public void addNum(int num) {
//         pq.add(num);
//     }
    
//     public double findMedian() {
//         int n=pq.size();
//         double ans=0.0;
//         if(n%2!=0)
//         {
//             for(int i=0;i<n/2;i++)
//             {
//                 pq.remove();
//             }
//             ans=pq.peek();
//         }
//         else
//         {
//             for(int i=0;i<n/2-1;i++)
//             {
//                 pq.remove();
//             }
//             int first=pq.peek();
//             pq.remove();
//             int second=pq.peek();
//             ans=(first+second)/2.0;
//         }
//         return ans;
//     }
// }
}