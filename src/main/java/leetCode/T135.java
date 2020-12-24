package leetCode;

public class T135 {
    //回溯算法，超时，观察答案知道可以遍历2遍数组
    public int minCount = 0;

    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int[] candyArray = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candyArray[i] = 1;
        }
        candyArray[0] = 1;
        while (!giveCandy(ratings, candyArray, 1)) {
            candyArray[0]++;
        }


        for (int i = 0; i < candyArray.length; i++) {
            minCount += candyArray[i];
        }
        return minCount;

    }

    public boolean giveCandy(int[] ratings, int[] candyArray, int index) {
        if (index == ratings.length) return true;

        boolean lessThanBefore = ratings[index] < ratings[index - 1];

        if (ratings[index] > ratings[index - 1]) {
            candyArray[index] = candyArray[index - 1] + 1;
        } else {
            if (lessThanBefore && candyArray[index] >= candyArray[index - 1])
                return false;
        }

        while (!giveCandy(ratings, candyArray, index + 1)) {
            candyArray[index]++;
            if (lessThanBefore && candyArray[index] >= candyArray[index - 1]) return false;
        }

        return true;
    }


    //遍历2遍数组
    public int candy1(int[] ratings) {
        if(ratings.length <= 1) return ratings.length;
        int[] candyArray = new int[ratings.length];
        candyArray[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1])
                candyArray[i] = candyArray[i - 1] + 1;
            else
                candyArray[i] = 1;
        }

        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]){
                candyArray[i] = candyArray[i+1] + 1;
            }
        }

        for (int i = 0; i < candyArray.length; i++) {
            minCount+= candyArray[i];
        }
        return minCount;
    }
}