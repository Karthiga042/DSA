//lc-2503
import java.util.*;
public class MaxNoOfPointsFromGridQueries {
    class Solution {
        public int[] maxPoints(int[][] grid, int[] queries) {
            int r=grid.length;
            int c=grid[0].length;
            int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};//rdlu
            int n=queries.length;
            int result[]=new int[n];//to store result of each query
            int visited[][]=new int[r][c];
            //stores value,index
            //process cells in increasing order of their values
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
            //pair each query and its index
            List<int[]> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                list.add(new int[]{queries[i],i});
            }
            //sort based on values
            Collections.sort(list,Comparator.comparingInt(a->a[0]));
            //start from 0,0
            pq.offer(new int[]{grid[0][0],0,0});
            visited[0][0]=1;
            //stores total reachable cells for each query
            int count=0;
            for(int query[]:list)
            {
                int val=query[0];//query value
                int index=query[1];//query index
                while(!pq.isEmpty() && pq.peek()[0]<val)//cells with less than query value
                {
                    int curr[]=pq.poll();
                    int cellvalue=curr[0];
                    int row=curr[1];
                    int col=curr[2];
                    count++; //earn point for the cell
                    for(int i=0;i<dir.length;i++)
                    {
                        //explore neighbours
                        int nr=row+dir[i][0];
                        int nc=col+dir[i][1];
                        if(nr>=0 && nr<r && nc>=0 && nc<c && visited[nr][nc]==0)
                        {
                            visited[nr][nc]=1;
                            pq.offer(new int[]{grid[nr][nc],nr,nc});
                        }
                    }
                }
                result[index]=count;//store number of reachable cells for that query
            }
            return result;
        }
    }
}
