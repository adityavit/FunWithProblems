package noOfIslands;

/**
 * Created by adib on 7/14/15.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        return doDFS(grid);
    }

    private int doDFS(char[][] grid){
        int gridHeight = grid.length;
        int gridWidth = grid[0].length;
        int[][] visited = new int[gridHeight][gridWidth];
        int islandCount = 0;
        for(int i = 0; i< gridHeight; i++) {
            for(int j = 0; j < gridWidth; j++) {
                //Check if the grid element is not '0' and is not already visited
                if(grid[i][j] != '0' && visited[i][j] != 1) {
                    //Do the DFS for '1' grid Element represented by i,j
                    doDFSHelper(grid, i, j, visited);
                    //Increase island count for this one.
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void doDFSHelper(char[][] grid, int heightIndex, int widthIndex, int[][] visited) {
        //Base cases for handling recursive cases.
        //heightIndex should within the grid
        if(heightIndex < 0 || heightIndex >= grid.length)
            return;
        //widthIndex should be within grid
        if(widthIndex < 0 || widthIndex >= grid[0].length)
            return;
        //Check if '0' return
        if(grid[heightIndex][widthIndex] == '0')
            return;
        // Check if already visited then return
        if(visited[heightIndex][widthIndex] == 1)
            return;
        //make the node visited.
        visited[heightIndex][widthIndex] = 1;
        //Call recursively for all the four children for the node.
        //heightIndex-1, widthIndex
        doDFSHelper(grid, heightIndex - 1, widthIndex, visited);
        //heightIndex + 1, widthIndex
        doDFSHelper(grid, heightIndex + 1, widthIndex, visited);
        //heightIndex, widthIndex - 1
        doDFSHelper(grid, heightIndex, widthIndex - 1, visited);
        //heightIndex, widthIndex + 1
        doDFSHelper(grid, heightIndex, widthIndex + 1, visited);
    }
}
