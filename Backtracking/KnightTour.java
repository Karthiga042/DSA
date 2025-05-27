import java.util.*;
class KnightTour 
{
    static int n;
    //possible knight moves
    static int dx[]={2,1,-1,-2,-2,-1,1,2};
    static int dy[]={1,2,2,1,-1,-2,-2,-1};
    
    //inside board and not visisted
    static boolean isSafe(int x,int y,int board[][])
    {
        return x>=0 && x<n && y>=0 && y<n && board[x][y]==-1;
    }
    static boolean solve(int x,int y,int moveCount,int board[][])
    {
        //if all squares are visisted
        if(moveCount==n*n)
        {
            return true;
        }
        //try all 8 possible moves 
        for(int i=0;i<8;i++)
        {
            int nextX=x+dx[i];
            int nextY=y+dy[i];
            if(isSafe(nextX,nextY,board))
            {
                //mark move number on board
                board[nextX][nextY]=moveCount;
                //moveCount+1 for next step
                if(solve(nextX,nextY,moveCount+1,board))
                {
                    return true;
                }
                //backtrack if it does not leads to solution
                board[nextX][nextY]=-1;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of board:");
        n=sc.nextInt();
        int board[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=-1;
            }
        }
        //starts from(0,0)
        board[0][0]=0;
        //already placed knight in 0,0 so moveCount is passed as 1 instead of 0
        if(solve(0,0,1,board))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.printf("%2d ",board[i][j]);
                }
                System.out.println();
            }
        }
        else 
        {
            System.out.println("No solution found");
        }
    }
}

//rules of knight tour problem
// You must cover all N × N = N² squares.
// No square should be visited more than once.
// No square should be skipped.
// A knight moves in an L-shape:
// 2 steps in one direction (horizontal or vertical), then 1 step in a perpendicular direction.