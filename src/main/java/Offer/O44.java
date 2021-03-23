package Offer;

/**
 * 找规律，要注意初始位置
 */
public class O44 {
    public int findNthDigit(long n) {
        if(n < 10) return (int)n;
        long currNum = n - 9;
        int len = 2;
        long pow = 10;
        while(currNum > 9L * len * pow) {
            currNum -= 9L * len * pow;
            pow *= 10;
            ++len;
        }
        long num = (currNum + len - 1) / len + (long)Math.pow(10, len - 1) - 1;
        long pos = currNum % len == 0 ? len : currNum % len;
        return (int)((num / (long)Math.pow(10, len - pos)) % 10);
    }

    public int findNthDigit1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        System.out.println(n + "===");
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        O44 o44 = new O44();
//        System.out.println(o44.findNthDigit(1000000000));
//        System.out.println(o44.findNthDigit1(1000000000));

//        System.out.println(o44.findNthDigit(10));
        System.out.println(o44.findNthDigit(11));


        System.out.println(o44.findNthDigit(189));
        System.out.println(o44.findNthDigit(190));
        System.out.println(o44.findNthDigit(191));
        System.out.println(o44.findNthDigit(192));
        System.out.println(o44.findNthDigit(193));
    }
}
