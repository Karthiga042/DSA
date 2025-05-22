//lc-1823
public class WinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        //optimal
        //Josephus Problem Recursive Formula
        //f(n, k) = (f(n - 1, k) + k) % n
        int winner=0;
        //starts from 2 bcoz f(1, k) is already known = 0
        for(int i=2;i<=n;i++)
        {
            winner=(winner+k)%i;
        }
        return winner+1;//0 based index

        // Queue<Integer> queue=new LinkedList<>();
        // for(int i=1;i<=n;i++)//for 1 based index
        // {
        //     queue.add(i);
        // }
        // while(queue.size()>1)
        // {
        //     for(int i=0;i<k-1;i++)//to remove kth position element
        //     {
        //         queue.add(queue.poll());//add to back of queue
        //     }
        //     queue.poll();//remove it
        // }
        // return queue.peek();//return the leftover value
    }
}
