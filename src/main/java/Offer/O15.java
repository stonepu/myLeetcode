package Offer;

public class O15 {
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int count = 0;
        for(int i = 31; i >= 0; i--){
            if(n >>> i == 1){
                ++count;
                n -= 1 << i;
            }

        }
        return count;
    }
}
