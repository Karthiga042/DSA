//lc-1475
import java.util.Stack;
class FinalPriceWithSpecialDiscount {
    //optimal
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length]; // Array to store the final prices
        Stack<Integer> stack=new Stack<>(); // Stack to keep track of indices

        // Initialize arr with original prices
        for(int i=0;i<prices.length;i++) 
        {
            arr[i]=prices[i];
        }

        // Iterate over each price
        for(int i=0;i<prices.length;i++) 
        {
            // While there are indices in the stack and the current price is less than or equal to the price at that index
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]) 
            {
                // Get the index of the price that can have a discount applied
                int index=stack.pop();
                // Calculate the final price by applying the discount
                arr[index]=prices[index]-prices[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        return arr; // Return the final prices array
    }
}
// class Solution {
//     public int[] finalPrices(int[] prices) {
//         int arr[]=new int[prices.length];
//         for(int i=0;i<prices.length;i++)
//         {
//             arr[i]=prices[i];
//         }
//         for(int i=0;i<prices.length;i++)
//         {
//             for(int j=i+1;j<prices.length;j++)
//             {
//                 if(prices[j]<=prices[i])
//                 {
//                     arr[i]=prices[i]-prices[j];//get prices[j] equivalent discount
//                     break;
//                 }
//             }
//         }
//         return arr;
//     }
// }
