//lc-1368
import java.util.PriorityQueue;
public class MinCostToMakeLeastOneValidPath {
    class Solution {
        public int minCost(int[][] grid) {
            int rows=grid.length;
            int columns=grid[0].length;
            int targetRow=grid.length-1;
            int targetCol=grid[0].length-1;
            boolean traversed[][]=new boolean[rows][columns];
            //stores row,col,cost
            //sort elements by smallest cost
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> (a[2]-b[2]));
            // Start from (0, 0) with cost 0
            pq.add(new int[] {0,0,0});
            int[][] directions={{0, 1},{0, -1},{1, 0},{-1, 0}}; // Right, Left, Down, Up
            int[] directionCosts={1,2,3,4};// Corresponding grid values for each direction
            while(!pq.isEmpty())
            {
                int top[]=pq.poll(); //return smallest cost element
                int row=top[0];//current row index
                int col=top[1];//current col index
                int cost=top[2];//current cost

                // If already traversed, skip
                if(traversed[row][col])
                {
                    continue;
                }

                // Mark the cell as traversed
                traversed[row][col]=true;

                // If we reach the target cell, return the cost
                if(row==targetRow && col==targetCol)
                {
                    return cost;
                }

                for(int i=0;i<4;i++)
                {
                    //to explore neighboring cells for adding valid neighbors to pq
                    int newRow=row+directions[i][0];
                    int newCol=col+directions[i][1];

                    // Check if the new cell is within grid bound
                    if(newRow>=0 && newRow<rows && newCol>=0 && newCol<columns && !traversed[newRow][newCol]) 
                    {
                    // checks if the direction we're trying to move matches the direction specified by the grid's value at the current cell.
                    //if matches no addition cost so 0 else cost 1
                        int newCost=cost+(grid[row][col]==directionCosts[i] ? 0 : 1);
                        pq.add(new int[] {newRow,newCol,newCost}); // add new cell to pq
                    }
                }
            }
            return 0; //if no path found
        }
    }
}
