import java.util.*;
class RatInMazeDirection 
{
    //function to check if it is a safe cell to move and not blocked
    public static boolean isSafe(int x,int y,int n,int maze[][])
    {
        return x>=0 && x<n && y>=0 && y<n && maze[x][y]==1; 
    }
    public static void solnPath(int x,int y,int n,int maze[][],int soln[][],String path,List<String> allPath)
    {
        //if destination is reached and it's a valid cell
        if(x==n-1 && y==n-1 && maze[x][y]==1)
        {
            allPath.add(path);
            return;
        }
        
        //if current cell is safe
        if(isSafe(x,y,n,maze))
        {
            if(soln[x][y]==1)
            {
                return;
            }
            //mark current cell as part of solution path
            soln[x][y]=1;
            
            //dlru
            solnPath(x+1,y,n,maze,soln,path+"D",allPath);
            solnPath(x,y-1,n,maze,soln,path+"L",allPath);
            solnPath(x,y+1,n,maze,soln,path+"R",allPath);
            solnPath(x-1,y,n,maze,soln,path+"U",allPath);

            //backtrack
            soln[x][y]=0;
        }
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
        List<String> allPath=new ArrayList<>();
        solnPath(0,0,n,maze,soln,"",allPath);
        if(allPath.size()==0)
        {
            System.out.println("No paths found");
        }
        else 
        {
            for(int i=0;i<allPath.size();i++)
            {
                System.out.print(allPath.get(i)+" ");
            }
        }
    }
}