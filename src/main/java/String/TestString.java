package String;

import java.util.*;
import java.util.stream.Collectors;

public class TestString {
    public static void test() {
        char s = 'a';
        int end = 'b' - 'a';
        char c = 'a' + 1;
        System.out.println(c);
        String str = "如果ABC abcEDF123,.\"':;!@#$";
        str.substring(0);
        str.length();
        String str1 = 'a' + str;
        System.out.println((char) ('a'+ 1));
        System.out.println('b' - 'a');
        List<String> list = new LinkedList();
        str.toCharArray();
        System.out.println('a' < 'b');
        Stack<String> stack = new Stack<String>();
        String tt = "" + s;
        stack.push("" + s);
        stack.empty();
        list.add("");
        list.size();
        list.toString();
        int[] arr = new int[10];
        Arrays.toString(list.toArray());
        char[] strCh = str.toCharArray();
        List<char[]> ssss = Arrays.asList(strCh);
        List<char[]> listChar = Arrays.asList(str.toCharArray());

        int[] aIn = {1, 2, 3};
        List<int[]> ints = Arrays.asList(aIn);

        List<Integer> collect = Arrays.stream(aIn).boxed().collect(Collectors.toList());
        //List<Object> objects = Arrays.asList({1, 2, 3});
//        LinkedList<Character> linkedList = new LinkedList(ints);

        System.out.println(Arrays.toString(arr));
        stack.peek();
        str.charAt(0);
        list.get(0);
//        Integer.valueOf(str);
//        switch (str.charAt(0)) {
//            case '1':
//                return;
//        }
        Stack<Character> sta= new Stack();
        tt += s;
        String tmp = "1";
        System.out.println(tmp.charAt(0));
        str.contains("a");

        String strT = "127..0.1";
        String[] out = strT.split("\\.");
        System.out.println(out[1].equals(""));
        System.out.println(Arrays.asList(out));
        try{
            int t = Integer.valueOf(str);

        }catch (Exception e) {
            System.out.println("error");
        }

        String t2 = "123:345";
        String[] strA = t2.split(":");
        int a =  strA.length;
        t2.startsWith("");
        List<String> ss = Arrays.asList(strA);
        System.out.println(Arrays.asList(strA));
        char ch = 'a';
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
//        str.getChars(0);

//        char[] chT = {'1', ' '};
    }

    public static void test1() {
        List<String> list = Arrays.asList(new String[]{"ask", "cye", "bye"});
//        Arrays.sort;
        list.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
    }


    public static void test2() {
        String str = "abcbca";
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
//        for(int)
    }

    public static void test3() {
        String str = "1";
        String substring = str.substring(1);
        System.out.println(substring == null);
        System.out.println(substring.equals(""));
    }

    public static void test4() {
        int[] a1 = {1, 3};
        int[] a2 = a1.clone();
        int m = 1, n = 2;
        int[] out = {m, n};
    }

    public static void test6() {
        String str = "123";
        str.substring(0);
        for(int i = 0; i < str.length(); ++i) {
            char item = str.charAt(i);
        }
    }

    public static int fib(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;
        int out = 0;
        int first = 0;
        int second = 1;
        while(n > 1) {
            out = first + second;
            first = second;
            second = out;
            --n;
            System.out.println(out);
        }

        return out;

    }

    public static void test7() {
        System.out.println(fib(45));
    }


    public static void test8() {
        String[] arr = {"1,", "2", "3"};
    }

    public static void test9(int t){
        List<List<Integer>> List = new LinkedList<>();
        Math.pow(1,2);
        LinkedList<Integer> list = new LinkedList<>();
        list.isEmpty();
        list.pop();

        String s = "1";
        s.toCharArray();

    }

    //import java.util.LinkedList;

    public static int removeElement(int[] nums, int val) {
        int first = -1;
        int second = -1;
        int len = nums.length;
        int temp;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                len--;
            }else{
                if(i - second > 1){
                    nums[second + 1] = nums[i];
                    second++;
                }else{
                    second = i;
                }
            }
        }
        return len;
    }

    public static void test10() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int tar = 2;
        int len = removeElement(nums, tar);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
        String str = "1";
        str.toLowerCase();
    }

    public static void test11() {
        String str = "1234567890";
        str = str.replace("*1", "");
        str.replaceFirst("1", "");
        System.out.println(str);
    }

    public static boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        if(name.length() == typed.length()) return name.equals(typed);

        char[] arr1 = name.toCharArray();
        char[] arr2 = typed.toCharArray();
        if(arr1[0] != arr2[0]) return false;
        int index = 1;
        for(int i = 1; i < arr1.length; i++) {
            if(index == arr2.length) return false;
            while(arr1[i] != arr2[index]) {
                index++;
                if(index == arr2.length || arr2[index - 1] != arr2[index - 2]) return false;
            }
            index++;
        }

        return true;
    }

    public static void test12() {
        String str1 = "alex";
        String str2 = "aaleex";
        System.out.println(isLongPressedName(str1, str2));
    }

    public static void test13() {
        LinkedList<Integer> list = new LinkedList<>();
        String[] arr = {"23", "2", "3"};
        arr[0].contains("12");
        System.out.println(arr[0].indexOf('1'));
        Collection<String> collection = Arrays.asList(arr);

//        int[] iarr = new int[26]{-1};
    }

    public static int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        boolean find = false;
        boolean hasChanged = false;
        boolean up = true;
        int max = 0;
        int currLen = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                hasChanged = true;
                if(up){
                    currLen++;
                }else{
                    up = true;
                    max = Math.max(currLen, max);
                    find = true;
                    currLen = 2;
                }
            }else if(A[i] < A[i - 1]){
                if(!up) {
                    currLen++;
                }else{
                    if(!hasChanged) {
                        currLen = 1;
                    }else{
                        up = false;
                        currLen++;
                    }
                }
            }else{
                currLen = 1;
                up = true;
            }
        }

        if(!up){
            find = true;
            max = Math.max(max, currLen);
        }


        if(!find) {
            return 0;
        }else{
            return max;
        }
    }

    public static void test14() {
        int[] arr1 = {1, 1};
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        arr1[0] = -1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(longestMountain(arr));
    }

    public static void test15(){
        int sum = 0;
        here:
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 5; j++){
                if(i == 4 && j == 4){
                    break here;
                }
                sum += 10;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        test1();
//        test3();
//        test10();
//        test11();
//        test12();
//        test13();
        test15();

        boolean o = false;
        while(true) {
            while(true){
                break ;
            }
        }
    }




    enum NET_MSG_TYPE {
        AUDIO,
        VIDEO,
        ICE,
        HTTP,
        WEBSOCKET
    }

    public static void test5() {


    }

    /**
     *
     * @param data 要发送的数据
     * @param len 发送数据的长度
     * @param type 发送数据的类型，AUDIO/VIEDO
     */
    public static void sendRtpMsg(int data, int len, NET_MSG_TYPE type){}


    /**
     *
     * @param msg 发送websocket消息
     */
    void sendWsMsg(int msg){}


    private class HttpMessage{}

    /**
     *
     * @param msg 要发送的http数据
     * @return 返回响应
     */
    void sendHttpMsg( HttpMessage msg ){}

    /**
     *
     * @param url 服务器地址
     * @return 返回ws连接的结果
     */
    void connectWs(String url){}


    /**
     *
     * @param localPort 本地端口
     * @param remoteIp 目的ip
     * @param remotePort 目的端口
     */
    void updateAudioSession(int localPort, int remoteIp, int remotePort){}

    /**
     * 断开ws连接
     */
    void disconnectWs(){}

    /**
     *
     * @param type 要关闭的rtp工具类型，可选Video或Audio
     */
    void closeRtpSession(int type){}

    /**
     * 每种类型相当于一个本地端口和一个远端端口的通道，本地端口不可重复
     */
    enum UDP_CHANNEL_TYPE{

        VIDEO,
        AUDIO,
        VIDEO4_P2P,
        AUDIO4_P2P,

        VIDEO_RTCP,
        AUDIO_RTCP,
        VIDEO4_P2P_RTCP,
        AUDIO4_P2P_RTCP
    }

    enum MEDIA_TYPE{
        VIDEO,
        AUDIO
    }


    /**
     * ========================udp通道接口=======================
     */
    /**
     *
     * @param udpChannelInfo udpChannel的描述信息
     * @param type 通道类型。
     */
    void createUdpChannel(int  udpChannelInfo, int type){}


}
