package Offer;

public class O5 {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] array = s.toCharArray();
        for(char ch : array) {
            if(ch != ' ') {
                stringBuffer.append(ch);
            }else{
                stringBuffer.append("%20");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        O5 o5 = new O5();
        System.out.println(o5.replaceSpace("  "));
    }
}
