//lc-1472
class BrowserHistoryUsingLinkedList {
    private class Node
    {
        Node prev;
        Node next;
        String data;
        Node(String url)
        {
            this.data=url;
            this.prev=null;
            this.next=null;
        }
    }   

    Node temp=null;//points to current page in history

    private BrowserHistory(String homepage) {
        temp=new Node(homepage);//start from homepage
    }
    
    public void visit(String url) {
        Node newNode=new Node(url);
        //clear forward history
//clearing forward history before visiting next node (after back function) ensures linear behaviour in browser history
        temp.next=null;
        //link new page visited to temp
        temp.next=newNode;
        newNode.prev=temp;
        temp=newNode;
    }
    
    public String back(int steps) {
        //move steps back in history
        while(steps>0)
        {
            if(temp.prev!=null)
            {
                temp=temp.prev;
            }
            else
            {
                break;
            }
            steps--;
        }
        return temp.data;//return current url after moving back
    }
    
    public String forward(int steps) {
        //move steps forward in history
        while(steps>0)
        {
            if(temp.next!=null)
            {
                temp=temp.next;
            }
            else
            {
                break;
            }
            steps--;
        }
        return temp.data;//return current url after moving forward
    }
}