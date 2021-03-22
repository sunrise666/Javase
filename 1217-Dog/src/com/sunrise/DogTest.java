package com.sunrise;/**
 * @author: pc
 * @data:2020/12/17
 */

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName: DogTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2020/12/17 17:08
 *@Version: 1.0
 **/

public class DogTest {
    public static void main(String[] args) {
//
//        for (int i = 0; i < s1.length(); i++) {
//
//        }
//        Dog dog = new Teddy("xiao bai",4);
//        dog.food();
//        dog.play();
//        dog.shout();
//        String s1 = "abd";
//        String s2 = "abcde";
//        System.out.println(isSubsequenceV1(s1,s2));
//        int[] nums = {2,5,6,7,9};
//        int target = 7;
//        int[] res = twoSum(nums, target);
//        for(int i = 0;i < res.length; i++){
//            System.out.println(res[i]);
//        }

        int[] can = {1,2,4,3,6,3,1};
        System.out.println(candy(can));
        int i = 1534236469;

        System.out.println(reverse(i));
        String t = "IX";
        System.out.println(romanToInt(t));
    }


    //子串问题
    public static boolean isSubsequenceV1(String s, String t) {
        int i1 = 0;
        for (int i = 0; i < s.length(); i++) {
            for (; i1 < t.length();i1++) {
                if (s.charAt(i) == t.charAt(i1)) {
                    i1++;
                    break;
                }
            }
            if( i1 == t.length()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubsequenceV2(String s,String t){
        int i1 = 0;
        for(char ch: s.toCharArray()){
            while (i1 < t.length() && ch != t.charAt(i1)) i1++;
            if(i1++ >= t.length()) break;
        }
        return i1 <= t.length();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target-nums[i])){
                return new int[]{hash.get(target-nums[i]),i};
            }
            hash.put(nums[i],i);
        }
        return new int[]{0};
    }
    public static int romanToInt(String s) {
        int v = 0;
        for (int i = s.length()-1; i >= 0; i--) {

            if(s.charAt(i) == 'V' ){
                if(i !=0 &&s.charAt(i-1) == 'I') {
                    v += 4;
                    i--;
                }
                else v += 5;
            }
            else if(s.charAt(i) == 'X'){
                if(i !=0 &&s.charAt(i-1) == 'I') {
                    v += 9;i--;
                }
                else v+= 10;
            }
            else if(s.charAt(i) == 'L'){
                if(i !=0 &&s.charAt(i-1) == 'X') {v += 40;i--;}
                else v+= 50;
            }
            else if(s.charAt(i) == 'C'){
                if(i !=0 &&s.charAt(i-1) == 'X') {v += 90;i--;}
                else v+= 100;
            }
            else if(s.charAt(i) == 'D') {
                if(i !=0 &&s.charAt(i-1) == 'C'){v += 400;i--;}
                else v+= 500;
            }
            else if(s.charAt(i) == 'M') {
                if(i !=0 &&s.charAt(i-1) == 'C'){v += 900;i--;}
                else v+= 1000;
            }
            else if(s.charAt(i) == 'I')
                v += 1;
        }
        return v;
    }

    public static int reverse(int x) {
        String s = Integer.toString(x);
        long v=0L;
        int n = s.length()-1;
        if(s.charAt(0) == '-') {
            while (n>=1){
                v -= (s.charAt(n)-48)*Math.pow(10,n-1);
                n--;
            }

        }
        else {
            while (n>=0){
                v += (s.charAt(n)-48)*Math.pow(10,n);
                n--;
            }
        }
        if(v>Math.pow(2,31)-1 || v<Math.pow(-2,31))
            return 0;
        return (int)v;

    }
    /*
        输入：[1,2,4,6,3,2,1,2,5,3]
        首先，[1,1,1,2,1,1,1,1,2,1]

        如果输入：[5,4,3,2,1]
        [2,1,1,1,1]
     */
    public static int candy(int[] ratings) {
        int candyNum = 0;
        int i = 0;
        while (i < ratings.length){
            if(i == 0 ){
                if(ratings[i+1]<= ratings[i])
                    candyNum += 2;
                else candyNum+=1;

            }
            else if(i == ratings.length -1 ){
                if(ratings[i] >= ratings[i-1])
                    candyNum += 2;
                else candyNum += 1;
            }
            else {
                if (ratings[i] >= ratings[i - 1] && ratings[i] >= ratings[i + 1])
                    candyNum += 2;
                else candyNum += 1;
            }
            i++;
        }
        return candyNum;
    }
}
