//lc-496
import java.util.*;
class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //optimal
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(!st.isEmpty() && st.peek()<nums2[i])
            {
                map.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        int arr[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            arr[i]=map.getOrDefault(nums1[i],-1);
        }
        return arr;

        // int n=nums2.length;
        // int arr[]=new int[n];//for storing nge
        // Arrays.fill(arr,-1);//initially no next greater element found
        // Stack<Integer> st=new Stack<>();
        // for(int i=n-1;i>=0;i--)//traverse num2 from last
        // {
        //     //if peek<nums2 then it can't be nge so pop
        //     while(!st.isEmpty() && st.peek()<=nums2[i]) 
        //     {
        //         st.pop();
        //     }
        //     //if anything left after pop it is nge
        //     if(!st.isEmpty())
        //     {
        //         arr[i]=st.peek();
        //     }
        //     //when st is empty
        //     st.push(nums2[i]);
        // }
        // int ans[]=new int[nums1.length];
        // //if nums1 and nums2 matches then place nge
        // for(int i=0;i<nums1.length;i++)
        // {
        //     for(int j=0;j<nums2.length;j++)
        //     {
        //         if(nums1[i]==nums2[j])
        //         {
        //             ans[i]=arr[j];
        //             break;
        //         }
        //     }
        // }
        // return ans;
    }
}