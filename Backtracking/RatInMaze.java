import java.util.*;
class RatInMaze 
{
    //function to check if it is a safe cell to move and not blocked
    public static boolean isSafe(int x,int y,int n,int maze[][])
    {
        return x>=0 && x<n && y>=0 && y<n && maze[x][y]==1; 
    }
    public static boolean solnPath(int x,int y,int n,int maze[][],int soln[][])
    {
        //if destination is reached and it's a valid cell
        if(x==n-1 && y==n-1 && maze[x][y]==1)
        {
            soln[x][y]=1;
            return true;
        }
        
        //if current cell is safe
        if(isSafe(x,y,n,maze))
        {
            // If already visited in solution path, avoid cycles
            if(soln[x][y]==1)
            {
                return false;
            }
            
            //mark current cell as part of solution path
            soln[x][y]=1;
            
            //dlru
            if(solnPath(x+1,y,n,maze,soln))
            {
                return true;
            }
            if(solnPath(x,y-1,n,maze,soln))
            {
                return true;
            }
            if(solnPath(x,y+1,n,maze,soln))
            {
                return true;
            }
            if(solnPath(x-1,y,n,maze,soln))
            {
                return true;
            }
            //backtrack
            soln[x][y]=0;
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int maze[][]=new int[n][n];
        int soln[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                maze[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                soln[i][j]=0;
            }
        }
        if(solnPath(0,0,n,maze,soln))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(soln[i][j]+" ");
                }
                System.out.println();
            }
        }
        else 
        {
            System.out.println("Solution does not exists");
        }
    }
}