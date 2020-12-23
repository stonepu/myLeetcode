package leetCode;

public class T11 {
    //暴力解法
    public int maxArea(int[] height) {
        int maxRst = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                maxRst = Math.max(maxRst, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxRst;
    }

    //双指针
    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int maxarea = 0;
        while(left < right){
            maxarea = Math.max(Math.min(height[left], height[right]) * (right - left), maxarea);
            if(height[left] > height[right]) {
                right--;
            }else{
                left++;
            }
        }
        return maxarea;
    }
}
