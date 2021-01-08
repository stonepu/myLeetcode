package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class T200 {
    private int count = 0;
    public int numIslands(char[][] grid) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for(int i = 0; i < grid.length; i++) {
            map.put(i, new HashSet<Integer>());
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !map.get(i).contains(j)){
                    count++;
                    check(map, grid, i + 1, j);
                    check(map, grid, i, j + 1);
                }
            }
        }
        return count;
    }

    public void check(HashMap<Integer, HashSet<Integer>> map, char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if(grid[x][y] == '0' || map.get(x).contains(y)) return;
        map.get(x).add(y);
        check(map, grid, x + 1, y);
        check(map, grid, x, y + 1);
        check(map, grid, x - 1, y);
        check(map, grid, x, y - 1);
    }
}
