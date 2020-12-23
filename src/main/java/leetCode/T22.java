package leetCode;

import java.util.LinkedList;
import java.util.List;

public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new LinkedList();
        if(n <= 0) return rst;

        addString(rst, "(", n - 1, n);
        return rst;
    }

    public void addString(List<String> list, String str, int left, int right) {
        if(left == 0 && right == 0) {
            list.add(str);
            return;
        }

        if(left == right) {
            addString(list, str + '(', left - 1, right);
        }else if(left == 0) {
            addString(list, str + ')', left, right - 1);
        }else{
            addString(list, str + '(', left - 1, right);
            addString(list, str + ')', left, right - 1);
        }
    }
}
