package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class T79 {

    public boolean exist(char[][] board, String word) {
        HashMap<Integer, HashSet<Integer>> find = new HashMap<>();
        for (int i = 0; i < board.length ; i++) {
            find.put(i, new HashSet<>());
        }
        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == chars[0]) {
                    clear(find, board.length);
                    if(check(board, i, j, chars, 0, find)) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {  {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        T79 t79 = new T79();
        System.out.println(t79.exist(board, "ABCCED"));
        System.out.println(t79.exist(board, "SEE"));
        System.out.println(t79.exist(board, "ABCB"));
        char[][] b = {{'a', 'a'}};

        System.out.println(t79.exist(b, "aa"));

        char[][] arr = {{'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        System.out.println(t79.exist(arr, "ABCESEEEFS"));
    }

    public boolean check(char[][] board, int x, int y, char[] word, int index, HashMap<Integer, HashSet<Integer>> find) {
        if(index >= word.length) return true;
        if(x >= board.length || y >= board[0].length || x < 0 || y < 0) return false;
        if(board[x][y] != word[index]) return false;
        if(index >= word.length - 1) return true;
        find.get(x).add(y);
        boolean findNext = false;
        if(y < board[0].length - 1){
            System.out.println("a");
            if(!find.get(x).contains(y + 1)) {
                findNext = check(board, x, y + 1, word, index + 1, find);
            }
            if(findNext) return true;

        }

        if(y > 0) {
            System.out.println("b");
            if(!find.get(x).contains(y - 1)) {
                findNext = check(board, x, y - 1, word, index + 1, find);
            }
            if(findNext) return true;
        }

        if(x < board.length - 1) {
            System.out.println("c");
            if(!find.get(x + 1).contains(y)) {
                findNext = check(board, x + 1, y, word, index + 1, find);
            }
            if(findNext) return true;
        }

        if(x > 0) {
            System.out.println("d");
            if(!find.get(x - 1).contains(y)) {
                findNext = check(board, x - 1, y, word, index + 1, find);
            }
        }
        find.get(x).remove(y);
        return findNext;
    }

    public void clear(HashMap<Integer, HashSet<Integer>> find, int len){
        for (int i = 0; i < len; i++) {
            find.get(i).clear();
        }
    }
}
