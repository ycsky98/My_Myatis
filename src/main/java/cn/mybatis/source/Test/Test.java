package cn.mybatis.source.Test;

import java.util.*;

public class Test {
    public static void main(String[] args){
        //1,4,16,64
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入付款金额:");
        int count  = scan.nextInt();
        int count64 = 0;
        int count16 = 0;
        int count4 = 0;
        int count1 = 0;
        int all = 0;
        int sy = 0;
        int y = count%64;
        if (y!=0){
            sy = count-(count/64)*64;
            count64 = count/64;
            int sy1 = sy%16;
            if (sy1!=0){
                count16 = sy/16;
                sy = sy - (sy/16)*16;
                if (sy%4!=0){
                    count4 = sy/4;
                    sy = sy - (sy/4)*4;
                    count1 = sy;
                }else {
                    count4 = sy/4;
                }
            }else{
                count16 = count/16;
            }
        }else{
            count64 = count/64;
        }
        all = count64+count16+count4+count1;
        System.out.println("最少需要"+all+"硬币");
        System.out.println("64=>"+count64+",16=>"+count16+",4=>"+count4+",1=>"+count1);

        /*Scanner sca = new Scanner(System.in);
        System.out.println("请出入数据:");
        String str = sca.nextLine();
        char[] arr = str.toCharArray();
        if (arr.length>=4){
            for (int i = 0; i < arr.length-3; i++){
                if(arr[i]==arr[i+1] && arr[i+2]==arr[i+3]){
                    arr[i+3] = '&';
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++){
            if (arr[i]!='&'){
                newArr[i] = arr[i];
            }
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(newArr);
        System.out.println(buffer.toString());*/

    }
}
