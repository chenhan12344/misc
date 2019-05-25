package leetcode.medium;

/**
 * Created by 44399 on 2019/2/25
 *
 * @author 44399
 */
public class LC200 {

    public static void main(String[] args) {
        System.out.println(new LC200().numIslands(new char[][]{
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '0'},
                {'0', '0', '1', '1', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] vistited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                vistited[i][j] = false;
            }
        }
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                islands += search(grid, vistited, i, j) > 0 ? 1 : 0;
            }
        }
        return islands;
    }

    private int search(char[][] grid, boolean[][] visited, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        if (grid[i][j] == '0') {
            return 0;
        }
        return 1 + search(grid, visited, i + 1, j) + search(grid, visited, i, j + 1) + search(grid, visited, i - 1, j) + search(grid, visited, i, j - 1);
    }
}