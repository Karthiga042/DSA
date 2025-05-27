//lc-52
class NQueens2 {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int board[][]=new int[n][n];
        solve(0,n,board,result);
        return result.size();
    }
    public static boolean isSafe(int row,int col,int n,int board[][])
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
            {
                return false;
            }
        }
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
    public static void solve(int row,int n,int board[][],List<List<String>> result)
    {
        if(row==n)
        {
            result.add(possibleSoln(n,board));
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,n,board))
            {
                board[row][col]=1;
                solve(row+1,n,board,result);
                board[row][col]=0;
            }
        }
    }
    public static List<String> possibleSoln(int n,int board[][])
    {
        List<String> path=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                sb.append(board[i][j]==1?'Q':'.');
            }
            path.add(sb.toString());
        }
        return path;
    }
}
