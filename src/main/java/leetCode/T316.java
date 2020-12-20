package leetCode;

import java.util.ArrayDeque;

public class T316 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] times = new int[26];
        for (int i = 0; i < len; i++) {
            times[charArray[i] - 'a'] += 1;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean[] visited = new boolean[26];

        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) {
                times[charArray[i] - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && charArray[i] <= stack.peekFirst() && times[stack.peekFirst() - 'a'] > 1 && visited[stack.peekFirst() - 'a']) {
                char top = stack.pop();
                visited[top - 'a'] = false;
                times[top - 'a']--;

            }
            if (visited[charArray[i] - 'a']) continue;
            stack.push(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        boolean[] arr = new boolean[1];
        System.out.println(arr[0]);
    }
}
