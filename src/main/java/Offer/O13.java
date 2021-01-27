package Offer;

public class O13 {
    private int count;
    public int movingCount(int m, int n, int k) {
        if(k == 0) return 1;
        boolean[][] visited = new boolean[m][n];
        dfs(visited, 0, 0, k);
        return count;
    }

    private void dfs(boolean[][] visited, int x, int y, int k) {
        int row = visited.length;
        int col = visited[0].length;
        if(x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || !check(x, y, k)) return;
        ++count;
        visited[x][y] = true;
        dfs(visited, x + 1, y, k);
        //dfs(visited, x - 1, y, k);
        dfs(visited, x, y + 1, k);
        //dfs(visited, x, y - 1, k);
    }

    private boolean check(int m, int n, int k){
        int rst = m / 100 + (m % 100) / 10 + m % 10 + n / 100 + (n % 100) / 10 + n % 10;
        return rst <= k;
    }
}
