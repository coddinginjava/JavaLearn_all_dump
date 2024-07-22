package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3 abc
        System.out.println(lengthOfLongestSubstring("bbbbb")); //1 b
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3 wke
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s.length() ==1)
            return 1;

        Set<Character> ch = new HashSet<>();
        int max = 0;
        int count = 0 ;
        char[] str = s.toCharArray();
        for(char c : str){

            if(ch.contains(c)){
                max = Integer.max(max , count);
                count = 0;
                ch = new HashSet<>();
                ch.add(c);
                count=1;
            }else {
                ch.add(c);
                count ++;

            }


        }


        return  Integer.max(max,count);



    }
}
