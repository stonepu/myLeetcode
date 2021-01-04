package leetCode;

public class T509 {
    public int fib(int n) {
        if(n <= 1) return n;
        int first = 0;
        int second = 1;
        int rst = 0;

        for(int i = 2; i <= n; i++) {
            rst = first + second;
            first = second;
            second = rst;
        }

        return rst;
    }
}
