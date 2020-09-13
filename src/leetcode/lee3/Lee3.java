package leetcode.lee3;

import java.util.*;

public class Lee3 {

    public static void main(String[] args) {
        String str = "abcdecbb";
        int maxLen = lengthOfLongestSubstring(str);
        System.out.println(maxLen);
    }

    /**
     * 其实用map反而快，这样是一遍过
     * @param s
     * @return
     */
//    public static int lengthOfLongestSubstring(String s){
//
//        Map<Character,Integer> map = new HashMap<>();
//
//        int maxLen = 0;
//
//        for(int i=0,j=0;j<s.length();j++){
//
//            if(map.containsKey(s.charAt(j))){
//
//                i =  Math.max(map.get(s.charAt(j)),i);//非常核心的一步，并不需要删除重复j之前的元素
//            }
//            maxLen = Math.max(maxLen,j-i+1);
//            map.put(s.charAt(j),j+1);
//        }
//        return maxLen;
//    }

    /**
     * 用数组也是可以的
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){

        int[] index = new int[128];

        int maxLen = 0;

        for(int i=0,j=0;j<s.length();j++){

            i = Math.max(index[s.charAt(j)],i);
            maxLen = Math.max(maxLen,j-i+1);

            index[s.charAt(j)] = j+1;
        }
        return maxLen;
    }
}
