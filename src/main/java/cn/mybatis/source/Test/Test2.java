package cn.mybatis.source.Test;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args){
        //System.out.println(Test2.isPalindrome(null));
    }
    /*public static boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x>-1 && x<10) return true;
        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length/2; i++){
            if (arr[i]!=arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }*/

    public static boolean isPalindrome(LinkNode head) {
        if(head==null) return false;
        char[] intarr = new char[1];
        int count = 0;
        while(head.next!=null){
            intarr[count] = (char)head.val;
            System.arraycopy(intarr,0,new char[intarr.length+1],0,intarr.length);
            count++;
            head = head.next;
        }
        char[] arr = intarr;
        for (int i = 0; i < arr.length/2; i++){
            if (arr[i]!=arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }
    private static class LinkNode{
        public int val;
        public LinkNode next;
        LinkNode(int val){
            this.val = val;
        }
    }
}
