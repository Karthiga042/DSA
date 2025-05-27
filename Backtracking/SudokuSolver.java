import java.util.*;
class SudokuSolver 
{
    static boolean isSafe(int row,int col,int num,int board[][])
    {
        // Check if 'num' is not present in the current row and column
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==num || board[i][col]==num)
            {
                return false;
            }
        }
        // Find the starting index of the 3x3 sub-grid containing (row, col)
        int startRow=row-row%3;
        int startCol=col-col%3;
        
        // Check if 'num' is not present in the 3x3 sub-grid
        for(int i=startRow;i<startRow+3;i++)
        {
            for(int j=startCol;j<startCol+3;j++)
            {
                if(board[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solve(int board[][])
    {
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                // If cell is empty
                if(board[row][col]==0)
                {
                    // Try placing numbers from 1 to 9
                    for(int num=1;num<=9;num++)
                    {
                        if(isSafe(row,col,num,board))
                        {
                            //place num
                            board[row][col]=num;
                            // Recursively proceed to solve the rest of the board
                            if(solve(board))
                            {
                                return true;
                            }
                            else 
                            {
                                //backtrack is placing num does not lead to solution
                                board[row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int board[][]=new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                board[i][j]=sc.nextInt();
            }
        }
        if(solve(board))
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    System.out.print(board[i][j]+" ");
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


