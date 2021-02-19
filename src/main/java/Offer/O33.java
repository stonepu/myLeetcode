package Offer;

/**
 * 验证二叉搜索树后续遍历
 */
public class O33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int head, int tail) {
        if(head >= tail) return true;
        int index = -1;
        for(int i = head; i < tail; i++) {
            if(index == -1) {
                if(postorder[i] < postorder[tail]) continue;
                index = i;
            }else{
                if(postorder[i] < postorder[tail]) return false;
            }
        }

        if(index == -1) return verifyPostorder(postorder, head, tail - 1);

        return verifyPostorder(postorder, head, index - 1) && verifyPostorder(postorder, index, tail - 1);
    }
}
