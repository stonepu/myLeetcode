package Offer;

public class O20 {
    public boolean isNumber(String s) {
        int len = s.length();
        if(len == 0) return false;
        char[] chArray = s.toCharArray();
        boolean findE = false, findDo = false, noMoreBlank = false, findNum = false, findRealNum = false;
        StringBuffer doub = new StringBuffer();
        StringBuffer ex = new StringBuffer();
        for(int i = 0; i < len; i++) {
            char ch = chArray[i];
            if(isNum(ch)) {
                findRealNum = true;
                findNum = true;
                if(noMoreBlank) return false;
                if(findE) {
                    ex.append(ch);
                }else{
                    doub.append(ch);
                }
            }else if(ch == 'e' || ch == 'E') {
                findRealNum = false;
                findNum = false;
                noMoreBlank = false;
                if(findE) return false;
                findE = true;
            }else if(ch == '.') {
                findNum = true;
                if(noMoreBlank) return false;
                if(findE || findDo) return false;
                doub.append(ch);
                findDo = true;
            }else if(ch == '-' || ch == '+') {
                findNum = true;
                if(noMoreBlank) return false;
                if(findE) {
                    if(ex.length() != 0) return false;
                    ex.append(ch);
                }else{
                    if(doub.length() != 0) return  false;
                    doub.append(ch);
                }
            }else if(ch == ' '){
//                if(findNum && noMoreBlank) return false;
                if(findNum) noMoreBlank = true;
//                if(i == len - 1 || i == 0 || chArray[i + 1] == 'e' || chArray[i + 1] == 'E')
//                    continue;
//                return false;
            }else return false;
        }
        if(findE && (ex.length() == 0 || !findRealNum)) return false;
        if(doub.length() == 0) return false;
        char last = doub.charAt(doub.length() - 1);
        if(last == '+' || last == '-') return false;
        if(last == '.') {
            if(doub.length() == 1 || !isNum(doub.charAt(doub.length() - 2))) return false;
        }
        return true;

    }

    public boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        O20 offer20 = new O20();
        String str = "1  ";
        System.out.println(offer20.isNumber(str));
    }
}
