package algrithm;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 1, 0, 1, 0};
        Map<Integer,Integer> dp = new HashMap<>(); //用整数位来计数
        int res =  new Rq().dfs(dp,input);
        System.out.println(res);
        //todo input

    }

    public int dfs(Map<Integer,Integer> dp,int[] card){
        //出牌 1. 单张，2.对子，3. 三连 或五连，4.三连对
        //枚举全部单张
        Integer hash = hash(card);
        if(hash==0)return 0;//牌出完了
        Integer cache = dp.get(hash);
        if(cache!=null) return cache;
        int min = Integer.MAX_VALUE;
        //枚举单张
        for(int i = 0;i < card.length;i++){
            if(card[i]!=0) {
                card[i]--;//打出去
                min = Math.min(dfs(dp, card) + 1, min);
                card[i]++;//收回去给下次迭代
            }
        }
        //枚举对子
        for(int i = 0;i < card.length;i++){
            if(card[i] > 1){
                card[i] -= 2;
                min = Math.min(dfs(dp, card) + 1, min);
                card[i]++;
            }
        }
        //枚举三连,包括三连对
        for(int i = 0;i < card.length -2;i++){
            //判断当前开始的是不是连续的,num,三连的张数
            for(int num = 1; num <=2;num++){
                if(testXContinues(card,i,num,3)){
                    for(int j = i;j < i+3;j++){
                        card[j] -= num;
                    }
                    min = Math.min(dfs(dp, card) + 1, min);
                    for(int j = i;j < i+3;j++){
                        card[j] += num;
                    }
                }
            }
        }
        //枚举五练
        for(int i = 0;i < card.length -4;i++){
            if(testXContinues(card,i,1,5)){
                for(int j = i;j < i + 5;j++){
                    card[j] -= 1;
                }
                min = Math.min(dfs(dp, card) + 1, min);
                for(int j = i;j < i + 5;j++){
                    card[j] += 1;
                }
            }
        }

        dp.put(hash,min);
        return min;
    }

    public int hash(int[] card){
        int res = 0;
        for(int i = 0;i < card.length;i++){
            res = res*10 + card[i];
        }
        return res;
    }
    //count连续的数量，idx开始处，num:每次需要连续多少张
    public boolean testXContinues(int[] card,int idx,int num,int count){
        for(int i = idx;i < idx + count;i++){
            if(card[i] < num){
                return false;
            }
        }
        return true;
    }

}