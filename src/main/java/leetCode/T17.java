package leetCode;

import java.util.LinkedList;
import java.util.List;

public class T17 {

    final String[] strArray = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //广度优先搜索
    public List<String> letterCombinations(String digits) {
        List<String> tmp = new LinkedList<>();
        if(digits.length() <= 0) return tmp;
        tmp.add("");
        char[] chars = digits.toCharArray();
        return addString(tmp, strArray, chars, 0);

    }

    public List<String> addString(List<String> tmp, String[] arr, char[] digits, int index) {
        if(index == digits.length) return tmp;
        List<String> next = new LinkedList<>();

        for(String it : tmp) {
            for(char ch : arr[digits[index] - '2'].toCharArray()) {
                it += ch;
                next.add(it);
            }
        }
        return addString(next, arr, digits, index + 1);
    }

    //深度优先搜索
    public List<String> letterCombinations1(String digits) {
        List<String> rst = new LinkedList<>();
        addString(rst, strArray, "", digits.toCharArray(), 0);
        return rst;
    }

    public void addString(List<String> rst, String[] arr, String currStr, char[] digits, int index) {
        if(index == digits.length){
            rst.add(currStr);
            return;
        }
        char[] nThKeyBoard = arr[digits[index] - '2'].toCharArray();
        for(int i = 0; i < nThKeyBoard.length; i++) {
            addString(rst, arr, currStr + nThKeyBoard[i], digits, index + 1);
        }
    }

    public static void main(String[] args) {
        String s = "123";
    }

}
