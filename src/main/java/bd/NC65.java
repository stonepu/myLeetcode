package bd;

/**
 * 斐波那契数列
 */
public class NC65 {
    public int Fibonacci(int n) {
        if(n < 2) return n;
        int pre = 0, curr = 1;
        for(int i = 2; i <= n; i++) {
            curr += pre;
            pre = curr - pre;
        }
        return curr;
    }
}
