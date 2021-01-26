package Offer;

public class O12 {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(dfs(board, wordArray, 0, i, j, visited)) return true;
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, char[] arr, int index, int x, int y, boolean[][] visited) {
        if(index == arr.length) return true;
        int row = board.length;
        int col = board[0].length;
        if(x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) return false;
        if(board[x][y] != arr[index]) return false;

        visited[x][y] = true;
        boolean find = false;
        find |= dfs(board, arr, index + 1, x + 1, y, visited);
        if(find) return true;
        find |= dfs(board, arr, index + 1, x - 1, y, visited);
        if(find) return true;
        find |= dfs(board, arr, index + 1, x, y + 1, visited);
        if(find) return true;
        find |= dfs(board, arr, index + 1, x, y - 1, visited);
        if(find) return true;
        visited[x][y] = false;
        return false;
    }
}
