package Offer;

/**
 * 找到1~n之间所有数字中1的个数
 */
public class O43 {
    public int countDigitOne(int n) {
        if(n == 0) return 0;
        if(n < 10) return 1;
        String item = Integer.valueOf(n).toString();
        return getSumOne(item, n);

    }

    private int getSumOne(String item, int itemInt) {
        if(itemInt == 0) return 0;
        if(itemInt < 10) return 1;
        int len = item.length();
        int pow = (int)Math.pow(10, len - 1);

        int item1 = itemInt / pow * pow;
        int item2 = itemInt - item1;

        int rst = 0;

        if(item1 == pow) {
            rst += item2 + 1;
            rst += getDNum(item1);
        }else{
            rst += pow;
            int mul = item1 / pow;
            rst += mul * getDNum(pow);
        }
        rst += getSumOne(Integer.valueOf(item2).toString(), item2);

        return rst;
    }

    private int getDNum(int item) {
        if(item == 0) return 0;
        return item / 10 + 10 * getDNum(item / 10);
    }
}
