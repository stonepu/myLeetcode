package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class T394 {
    Deque<String> stack;

    public String decodeString(String s) {
        stack = new ArrayDeque();
        String str = "";
        char[] sArray = s.toCharArray();
        for (char ch : sArray) {
            if (ch == '[' && !str.equals("")) {
                stack.add(str);
                str = "";
            } else if (ch == ']') {
                if(!str.equals("")) {
                    if(stack.isEmpty()) pushStr(str);
                    else{
                        if(!isNum(stack.peekLast())) {
                            str = stack.pollLast() + str;
                        }
                        str = getRepeat(Integer.valueOf(stack.pollLast()), str);
                        pushStr(str);
                    }
                }else{
                    str = stack.pollLast();
                    str = getRepeat(Integer.valueOf(stack.pollLast()), str);
                    pushStr(str);
                }
                str = "";

            } else if (isNum(ch)) {
                if (!str.equals("") && !isNum(str)) {
                    pushStr(str);
                    str = "";
                }
                str += ch;
            } else {
                str += ch;
            }
        }

        if(stack.isEmpty()) return str;

        return stack.pollLast() + str;
    }

    void pushStr(String str) {
        if(stack.isEmpty() || isNum(stack.peekLast())) stack.add(str);
        else stack.add(stack.pollLast() + str);
    }

    boolean isNum(String str) {
        char ch = str.charAt(0);
        return ch >= '0' && ch <= '9';
    }

    boolean isNum(char ch) {
        return Character.isDigit(ch);
    }

    String getRepeat(int times, String str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < times; i++) {
            buffer.append(str);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        T394 t394 = new T394();
        String str = "3[a2[c]]";
        String str1 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String str2 = "2[ab3[cd]]4[xy]";
        String str3 = "3[ab2[cd]e]fg10[h]";

        System.out.println(t394.decodeString(str));

        System.out.println(t394.decodeString(str3));
    }
}
