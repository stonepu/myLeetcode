package Offer;

public class O67 {
    public int strToInt(String str) {
        str = str.replaceAll(" ", "");
        int len = str.length();
        if(len == 0 || (str.charAt(0) != '-' &&
                str.charAt(0) != '+' && !isNum(str.charAt(0)))) return 0;

        long rst = 0;
        boolean isPos = str.charAt(0) == '-' ? false : true;
        System.out.println(isPos);
        for(int i = 0; i < len; i++) {
            if(isNum(str.charAt(i))) {
                rst = rst * 10 + (str.charAt(i) - '0');
                if(isPos && rst > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(!isPos && -rst < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        if(!isPos) return 0 - (int)rst;
        return (int)rst;
    }

    public boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        O67 o67 = new O67();
        System.out.println(o67.strToInt("-91283472332"));
    }
}
