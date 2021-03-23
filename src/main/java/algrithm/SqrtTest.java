package algrithm;

public class SqrtTest {

    public static double sqrt(int num, double delta){
        double low = 0, high = num;
        double mid = low + (high - low) / 2;
        while(abs(mid * mid - num) > delta) {
            if(mid * mid > num) {
                high = mid;
            }else{
                low = mid;
            }

            mid = low + (high - low) / 2;
        }
        return mid;
    }

    public static double abs(double num) {
        return num >= 0 ? num : 0 - num;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(5, 0.0001));
    }
}
