import java.util.PriorityQueue;

public class TrappingRainWater2 {
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            if(heightMap==null || heightMap.length==0 || heightMap[0].length==0)
            {
                return 0;
            }
            int m=heightMap.length;
            int n=heightMap[0].length;
            boolean visited[][]=new boolean[m][n];
            //stores x,y,height
            //sorts by short height
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
            //Add all boundary cells to the priority queue and mark them visited
            //bcoz water can't trapped in boundary so to avoid processing them
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==0 || i==m-1 || j==0 || j==n-1)
                    {
                        pq.offer(new int[]{i,j,heightMap[i][j]});
                        visited[i][j]=true;
                    }
                }
            }
            int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
            int trappedWater=0; //total water trapped
            while(!pq.isEmpty())
            {
                int cell[]=pq.poll();// Pop the cell with the smallest height
                int x=cell[0];
                int y=cell[1];
                int height=cell[2];
                for(int i=0;i<dir.length;i++)
                {
                    int nx=x+dir[i][0];
                    int ny=y+dir[i][1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && visited[nx][ny]==false)
                    {
                        visited[nx][ny]=true;
                        int neighborHeight=heightMap[nx][ny];
                        //water trapped between current height & neighbor=height-neighborHeight
                        //but if the neighbor height is higher water trapped is negative so comparing with 0 similary comparing all neighbors and getting max water trapped 
                        int water=Math.max(0,height-neighborHeight);
                        trappedWater+=water;
                        //takes max height to avoid water overflow
                        pq.offer(new int[]{nx,ny,Math.max(height,neighborHeight)});
                    }
                }
            }
            return trappedWater;
        }
    }
}
