package bd;

import java.util.HashMap;
import java.util.Scanner;

public class t3 {

    private static class Node{
        public int le;
        public int ri;

        public Node(){
            this(0, 0);
        }

        public Node(int le, int ri) {
            this.le = le;
            this.ri = ri;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj) return true;

            if(obj instanceof Node) {
                if(((Node) obj).le == this.le && ((Node)obj).ri == this.ri) return true;
                return false;
            }
            return false;
        }

        @Override
        public int hashCode() {
            StringBuilder sb = new StringBuilder();
            sb.append(le);
            sb.append(ri);
            char[] charArr = sb.toString().toCharArray();
            int hash = 0;
            for(char ch : charArr) {
                hash = hash * 131 + ch;
            }
            return hash;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            HashMap<Node, Integer> lastMap = new HashMap<>();
            int max = 0;
            for(int pn = 0; pn < p; pn++) {
                HashMap<Node, Integer> map = new HashMap<>();
                int g = sc.nextInt();
                Node node = new Node();
                for(int it = 0; it < g * 2; it++) {
                    int curr = sc.nextInt();
                    if(it % 2 == 0 || it == 0) {
                        node.le = curr;
                    }else{
                        node.ri = curr;
                        Node store = new Node(node.le, node.ri);
                        int last = lastMap.getOrDefault(store, 0);
                        map.put(store, map.getOrDefault(node, 0) + 1 + last);
                        max = Math.max(max, map.get(node));
                    }
                }
                lastMap = map;
            }
            System.out.println(max);
        }
    }
}
