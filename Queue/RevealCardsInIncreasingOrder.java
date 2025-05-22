//lc-950
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);//to reveal cards in increasing order
        Queue<Integer> queue=new LinkedList<>();//to hold index of cards
        for(int i=0;i<deck.length;i++)
        {
            //queue.offer(i);
            queue.add(i);//add index values of deck to queue
        }
        int reorder[]=new int[deck.length];
        for(int i=0;i<deck.length;i++)
        {
            int index=queue.poll();
            reorder[index]=deck[i];//takes 1st card as it is and reveal
            if(!queue.isEmpty())//if still more cards 
            {
                queue.add(queue.poll());//put cards at bottom of deck
                // queue.offer(queue.poll());
            }
        }
        return reorder;
    }
}
