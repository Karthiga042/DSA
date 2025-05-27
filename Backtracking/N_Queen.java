import java.util.*;
class N_Queen
{
    static boolean isSafe(int row,int col,int n,int board[][])
    {
        //check vertical column (above current row)
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
            {
                return false;
            }
        }
        //check upper left diagonal
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0)
        {
            if(board[i][j]==1)
            {
                return false;
            }
            i--;
            j--;
        }
        //upper right diagonal
        i=row-1;
        j=col+1;
        while(i>=0 && j<n)
        {
            if(board[i][j]==1)
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    static boolean solve(int row,int n,int board[][])
    {
        //all queens are placed 
        if(row==n)
        {
            return true;
        }
        //try placing queen in every col of current row
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,n,board))
            {
                //place queen
                board[row][col]=1;
                //recursion for next row
                if(solve(row+1,n,board))
                {
                    return true;
                }
                //backtrack
                board[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of queens:");
        int n=sc.nextInt();
        int board[][]=new int[n][n];
        if(solve(0,n,board))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(board[i][j]==1?"Q":".");
                }
                System.out.println();
            }
        }
        else 
        {
            System.out.println("No solution exists");
        }
    }
}

//n-queen problem rules
// A queen can move any number of squares vertically, horizontally, or diagonally.
// So, no two queens can be:
// In the same row
// In the same column
// On the same diagonal

// Constraints:
// Only one queen per row (common approach to simplify)
// One queen per column
// No two queens share a diagonal (both major and minor diagonals)

