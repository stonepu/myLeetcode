package leetCode;

import java.util.HashMap;
import java.util.List;

public class T399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int index = 0;
        int eSize = equations.size();
        int qSize = queries.size();
        double[] rst = new double[qSize];
        Union union = new Union(eSize);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < eSize; i++) {
            List<String> list = equations.get(i);
            String var1 = list.get(0);
            String var2 = list.get(1);
            if(!map.containsKey(var1)) {
                map.put(var1, index++);
            }

            if(!map.containsKey(var2)){
                map.put(var2, index++);
            }
            union.union(map.get(var1), map.get(var2), values[i]);
        }

        for(int i = 0; i < qSize; i++) {
            List<String> list = queries.get(i);
            String var1 = list.get(0);
            String var2 = list.get(1);
            Integer num1 = map.get(var1);
            Integer num2 = map.get(var2);

            if(num1 == null || num2 == null) {
                rst[i] = -1;
            }else{
                rst[i] = union.isConnect(num1, num2);
            }
        }

        return rst;
    }

        private class Union{
        int[] parent;
        double[] weight;

        public Union(int n) {
            parent = new int[n];
            weight = new double[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int x, int y, double value) {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;

            weight[rootx] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if(x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }

            return parent[x];
        }

        public double isConnect(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                return -1;
            }else{
                return weight[x] / weight[y];
            }
        }

    }
}
