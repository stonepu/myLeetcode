package Offer;

import java.util.HashMap;

public class O16 {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(x == 0) return 0;
        long b = n;
        double rst = 1;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) rst *= x;
            x *= x;
            b = b >> 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        O16 o16 = new O16();
        System.out.println(o16.myPow(2, 10));
    }
}
