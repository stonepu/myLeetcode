package leetCode.newhot;

import javaKnow.load.M;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class HotTest {
}

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 时间复杂度O()，空间复杂度O()
 */

class T1 {
    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 时间复杂度O()，空间复杂度O()
 */
class T2 {
    /**
     * 时间复杂度O(m + n)，空间复杂度O(max(m, n))
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int next = 0;
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + next;
            next = val > 9 ? 1 : 0;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + next;
            tmp.next = new ListNode(val % 10);
            next = val >= 10 ? 1 : 0;
            tmp = tmp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + next;
            tmp.next = new ListNode(val % 10);
            next = val >= 10 ? 1 : 0;
            tmp = tmp.next;
            l2 = l2.next;
        }

        if (next == 1) {
            tmp.next = new ListNode(1);
        }

        return head.next;
    }
}

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
class T3 {
    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int head = 0, tail = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (tail = 0; tail < s.length(); tail++) {

            if (map.containsKey(s.charAt(tail))) {
                head = Math.max(head, map.get(s.charAt(tail)) + 1);
            }
            map.put(s.charAt(tail), tail);

            max = Math.max(tail - head + 1, max);
        }

        return max;
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        String str = "dabcabcbbd";
        System.out.println(t3.lengthOfLongestSubstring(str));
    }
}

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 时间复杂度为 O(log (m+n))
 */
class T4 {
    /**
     * 参考了答案，时间复杂度O(log(min(m, n)))，空间复杂度O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int totalMid = m + (n - m + 1) / 2;

        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalMid - i;

            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int num1Left = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int num1Right = left == m ? Integer.MAX_VALUE : nums1[left];
        int num2Left = totalMid - left == 0 ? Integer.MIN_VALUE : nums2[totalMid - left - 1];
        int num2Right = totalMid - left == n ? Integer.MAX_VALUE : nums2[totalMid - left];

        if ((m + n) % 2 == 0) {
            return (Math.max(num1Left, num2Left) + Math.min(num1Right, num2Right)) / 2.0;
        } else {
            return Math.max(num1Left, num2Left);
        }
    }
}

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
class T5 {
    /**
     * 时间复杂度O(n^2)，空间复杂度O(n^2)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        int[][] dp = new int[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    dp[j][i] = 1;
                } else if (i - j == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = 1;
                } else if (dp[j + 1][i - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = 1;
                }

                if (dp[j][i] == 1 && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindrome1(String s) {
        if (s.length() == 0) {
            return "";
        }

        int[][] dp = new int[s.length()][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int end = 0, maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;

            if (i > dp[i - 1][0] && s.charAt(i) == s.charAt(i - dp[i - 1][0] - 1)) {
                dp[i][0] = dp[i - 1][0] + 2;
                dp[i][1] = 0;
            } //如果是相同的序列，那么dp的第二位置为1
            else if (dp[i - 1][1] == 1 && s.charAt(i) == s.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                end = i;
            }

        }
        return s.substring(end - maxLen + 1, end + 1);

    }


    public static void main(String[] args) {

        T5 t5 = new T5();
        System.out.println(t5.longestPalindrome1("cddb"));
        System.out.println(t5.longestPalindrome1("ababd"));
        String str = "1234";
        System.out.println(str.substring(1, 3));
    }
}


/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * "*"考虑的不全面，*可能会让前面的字符消失
 */
class T10 {
    /**
     * 时间复杂度O(n^2)，空间复杂度O(n^2)。不容易不容易，做了几天，特殊情况还是要多考虑清楚
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        int index = 0;
        while (p.length() > 0 && p.charAt(index) == '*') {
            ++index;
        }
        p = p.length() == 0 ? p : p.substring(index);

        int sLen = s.length();
        int pLen = p.length();

        if (sLen == 0 && pLen == 0) {
            return true;
        }

        if (sLen != 0 && pLen == 0) {
            return false;
        }

        if (sLen == 0) {
            int alpha = 0;
            for (int i = 0; i < pLen; i++) {
                if (p.charAt(i) == '*') {
                    alpha = Math.max(0, alpha - 1);
                } else {
                    ++alpha;
                }
            }
            return alpha == 0;
        }


        boolean[][] dp = new boolean[pLen][sLen];
        dp[0][0] = p.charAt(0) == '.' || (p.charAt(0) == s.charAt(0));

        int alphaNum = 0;
        if (p.charAt(0) == '.' || (p.charAt(0) >= 'a' && p.charAt(0) <= 'z')) {
            alphaNum = 1;
        }
        for (int i = 1; i < pLen; i++) {
            char ch = p.charAt(i);
            if ((ch == '.' || ch == s.charAt(0)) && alphaNum == 0) {
                dp[i][0] = true;
            }
            if (ch == '*') {
                alphaNum = Math.max(0, alphaNum - 1);
                if (dp[i - 1][0] || (i > 1 && dp[i - 2][0])) {
                    dp[i][0] = true;
                }
            }

            if (ch == '.' || (ch >= 'a' && ch <= 'z')) {
                alphaNum++;
            }
        }


        for (int i = 1; i < pLen; i++) {
            for (int j = 1; j < sLen; j++) {
                if (dp[i - 1][j - 1] && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.')) {
                    dp[i][j] = true;
                } else if (p.charAt(i) == '*' && (dp[i - 1][j] || (i > 1 && dp[i - 2][j]))) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j - 1] && p.charAt(i) == '*' && s.charAt(j) == s.charAt(j - 1)) {
                    dp[i][j] = true;
                } else if ((dp[i - 1][j - 1] || dp[i][j - 1]) && p.charAt(i - 1) == '.' && p.charAt(i) == '*') {
                    dp[i][j] = true;
                }
            }
        }

        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[pLen - 1][sLen - 1];
    }

    public static void main(String[] args) {
//        boolean[] d = new boolean[1];
//        System.out.println(d[0]);
        T10 t10 = new T10();
//        System.out.println(t10.isMatch("ab", "a*"));
//        System.out.println(t10.isMatch("aa", "c*aa"));
        System.out.println(t10.isMatch("aaa", "ab*ac*a"));
        System.out.println(t10.isMatch("aaa", ".*"));

//        String s1 = "abc**a"; //error
//        String s2 = "aa";
//        System.out.println(s2.matches(s1));
    }

}


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class T11 {
    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}


/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
class T15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> findMap = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        }


        for (int i = 1; i < nums.length; i++) {
            right.put(nums[i], right.get(nums[i]) - 1);
            for (int j = 0; j < i; j++) {
                if (right.getOrDefault(-nums[i] - nums[j], 0) > 0) {
                    int min, max;
                    min = Math.min(Math.min(nums[i], nums[j]), -nums[i] - nums[j]);
                    max = Math.max(Math.max(nums[i], nums[j]), -nums[i] - nums[j]);
                    if (!findMap.containsKey(min) || !findMap.get(min).contains(max)) {
                        HashSet<Integer> set = findMap.getOrDefault(min, new HashSet<Integer>());
                        set.add(max);
                        findMap.put(min, set);

                        rst.add(Arrays.asList(min, max, -min - max));
                    }
                }
            }


        }
        return rst;
    }

    public List<List<Integer>> threeSum1(int[] nums) {

        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }


        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        T15 t15 = new T15();

        int[] arr = {1, 1, -2, 3, -4, 1};
        System.out.println(t15.threeSum1(arr));
    }
}

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
class T17 {

    final String[] strArray = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> rst = new LinkedList<>();

    /**
     * 时间复杂度O(3^n)，空间复杂度O(n)
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return rst;
        }
        letterCombinations(new StringBuffer(), digits);
        return rst;
    }

    public void letterCombinations(StringBuffer str, String digits) {
        if (digits == null || digits.length() == 0) {
            rst.add(str.toString());
            return;
        }

        int num = digits.charAt(0) - '2';
        String sub = digits.substring(1);
        for (int i = 0; i < strArray[num].length(); i++) {
            str.append(strArray[num].charAt(i));
            letterCombinations(str, sub);
            str.deleteCharAt(str.length() - 1);
        }

    }
}

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
class T19 {
    /**
     * 时间复杂度O(n)，空间复杂度O(n)，满足最后的要求，只遍历一次，但是空间复杂度可以继续优化，
     * 可以考虑双指针，中间的距离就为n，当快的节点遍历到尾部时即停止
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }

        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(++index, head);
            head = head.next;
        }

        if (n > index) {
            return map.get(1);
        }

        int realN = index - n + 1;
        if (realN == 1) {
            return map.get(2);
        }

        map.get(realN - 1).next = map.get(realN).next;

        return map.get(1);
    }

}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
class T20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[' || ch == '{' || ch == '(') {
                stack.addLast(ch);
            } else {
                if (ch == '}') {
                    if (stack.isEmpty() || stack.peekLast() != '{') {
                        return false;
                    } else {
                        stack.pollLast();
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peekLast() != '[') {
                        return false;
                    } else {
                        stack.pollLast();
                    }
                } else {
                    if (stack.isEmpty() || stack.peekLast() != '(') {
                        return false;
                    } else {
                        stack.pollLast();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class T21 {
    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        while (l1 != null) {
            tmp.next = l1;
            tmp = tmp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }
        return head.next;
    }
}

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
class T22 {
    List<String> rst = new LinkedList<>();

    /**
     * 时间复杂度O(4^n/n^0.5)，空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        addItem(new StringBuffer(), n, n);
        return rst;
    }

    private void addItem(StringBuffer sb, int left, int right) {
        if (left == 0 && right == 0) {
            rst.add(sb.toString());
        }

        if (left > 0) {
            sb.append('(');
            addItem(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > left) {
            sb.append(')');
            addItem(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        T22 t22 = new T22();
        System.out.println(t22.generateParenthesis(3));
    }
}

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
class T23 {
    /**
     * 时间复杂度O(n*max(li))，空间复杂度O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (true) {
            int index = -1;
            ListNode currMin = null;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(currMin == null || currMin.val > lists[i].val) {
                        currMin = lists[i];
                        index = i;
                    }
                }
            }

            if(index == -1) {
                break;
            }
            tmp.next = currMin;
            tmp = tmp.next;
            lists[index] = lists[index].next;
        }

        return head.next;
    }

    /**
     * 时间复杂度O(n*max(li))，空间复杂度O(n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        int idx = 0;
        for (ListNode list : lists) {
            if (list != null) {
                map.put(idx++, list);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (!map.isEmpty()) {
            int index = -1;
            ListNode currMin = null;
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext()) {
                int i = iterator.next();
                if(map.get(i) == null) {
                    iterator.remove();
                }
                else if (currMin == null || currMin.val > map.get(i).val) {
                    currMin = map.get(i);
                    index = i;
                }
            }

            if(index == -1) {
                continue;
            }
            tmp.next = currMin;
            tmp = tmp.next;
            map.put(index, map.get(index).next);
        }

        return head.next;

    }

    /**
     * 时间复杂度O(llog(l))，空间复杂度O(l)，l为所有数组中元素的和
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        int len = 0;
        for (ListNode list : lists) {
            while (list != null) {
                tmp.next = list;
                tmp = tmp.next;
                ++len;
                list = list.next;
            }
        }

        if(len == 0) {
            return null;
        }

        ListNode[] arr = new ListNode[len];
        tmp = head;
        for (int i = 0; i < len; i++) {
            arr[i] = tmp.next;
            tmp = tmp.next;
        }

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, len - 1);
        System.out.println(Arrays.toString(arr));


        return arr[0];
    }

    private void quickSort(ListNode[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int head = left, tail = right;
        while(head < tail) {
            while(head < tail && arr[head].val < arr[right].val){
                ++head;
            }

            while(head < tail && arr[tail].val >= arr[right].val) {
                --tail;
            }

            if(head == tail) {
                break;
            }

            swap(arr, head, tail);
        }

        swap(arr, head, right);
        quickSort(arr, left, head - 1);
        quickSort(arr, head + 1, right);
    }

    private void swap(ListNode[] arr, int p, int q) {
        if(p == q) {
            return;
        }
        int min = Math.min(p, q);
        int max = p + q - min;

        ListNode tmp = arr[min];
        arr[min] = arr[max];
        arr[max] = tmp;

        arr[min].next = arr[min + 1];
        if(min != 0) {
            arr[min - 1].next = arr[min];
        }

        arr[max - 1].next = arr[max];
        if(max < arr.length - 1) {
            arr[max].next = arr[max + 1];
        }else{
            arr[max].next = null;
        }
    }

    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < 5; i++) {
//            map.put(i, i);
//        }
//
//        Iterator<Integer> iterator = map.keySet().iterator();
//        int index = -1;
//        while(iterator.hasNext()) {
//            int i = iterator.next();
//            if(i == 1) {
//                iterator.remove();
//            }
//
//            if(i == 3) {
//                iterator.remove();
//            }
//
//            System.out.println(i + " => " + map.get(i));
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println("after: " + i + " => " + map.get(i));
//        }

        T23 t23 = new T23();
        int[] a1 = {1, 4 ,5};
        int[] a2 = {1, 3, 4};
        int[] a3 = {2, 6};
        ListNode[] arr = {ListNode.generateList(a1), ListNode.generateList(a2), ListNode.generateList(a3)};
        t23.mergeKLists2(arr);
    }
}

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class T31{
    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int first = -1;
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]){
                first = i - 1;
                break;
            }
        }

        if(first == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        int second = -1;
        for (int i = len - 1; i >= 0; i--) {
            if(nums[i] > nums[first]) {
                second = i;
                break;
            }
        }

        swap(nums, first, second);
        reverse(nums, first + 1, len - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
class T32{
    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        Deque<Integer> stack = new LinkedList<>();
        int rst = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.addLast(i);
            }else{
                if(!stack.isEmpty()) {
                    dp[i] = i - stack.peekLast() + 1 + dp[Math.max(stack.pollLast() - 1, 0)];
                    rst = Math.max(rst, dp[i]);
                }
            }
        }

        return rst;
    }
}

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class T33{
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                if(target > nums[left]) {
                    right = mid - 1;
                }else if(target< nums[left]){
                    if(nums[mid] >= nums[left]) {
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }else{
                    return left;
                }

            }else{
                if(target <= nums[right]) {
                    left = mid + 1;
                }else {
                    if(nums[mid] >= nums[left]) {
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        T33 t33 = new T33();
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(t33.search(arr, 5));
    }

}
