//lc-160
public class IntersectionPoint {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        if(headA==null || headB==null)
        {
            return null;
        }
        while(tempA!=tempB)//when tempA=tempB intersection point found
        {
            if(tempA!=null)
            {
                tempA=tempA.next;
            }
            else
            {
                tempA=headB; //to traverse equal distance when listA and listB lengths differ
            }
            if(tempB!=null)
            {
                tempB=tempB.next;
            }
            else
            {
                tempB=headA;
            }
        }
        return tempA; //when intersection both tempA tempB same so return any one of them
    }
}