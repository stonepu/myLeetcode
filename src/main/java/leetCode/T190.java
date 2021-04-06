package leetCode;

public class T190 {
    public int reverseBits(int n) {

        int rst = 0;
        for(int i = 0; i < 32; i++) {
            rst = (rst << 1) + (n % 2);
            n >>>= 1;
        }

        return rst;

    }

    public static void main(String[] args) {

    }
}
