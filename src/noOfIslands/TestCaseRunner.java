package noOfIslands;

/**
 * Created by adib on 7/14/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {{'1','1'}};
        System.out.println("grid.length = " + grid.length);
        System.out.println("grid[0].length = " + grid[0].length);
        int islands = sol.numIslands(grid);
        System.out.println("islands = " + islands);
    }
}
