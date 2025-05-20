//coding ninjas
// Next Smaller Element
import java.util.*;
public class NextSmallerElement{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        int size=arr.size();
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(size,-1));
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()>=arr.get(i))
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                list.set(i,st.peek());
            }
            st.push(arr.get(i));
        }
        return list;
    }
}

// import java.util.Arrays;
// import java.util.Stack;
// class NextSmallerElement {
//     public int[] nextSmaller(int arr[]) {
//         // code here
//         int n=arr.length;
//         int ans[]=new int[n];
//         Arrays.fill(ans,-1);
//         Stack<Integer> st=new Stack<>();
//         for(int i=n-1;i>=0;i--)
//         {
//             while(!st.isEmpty() && st.peek()>=arr[i])
//             {
//                 st.pop();
//             }
//             if(!st.isEmpty())
//             {
//                 ans[i]=st.peek();
//             }
//             st.push(arr[i]);
//         }
//         return ans;
//     }
// }