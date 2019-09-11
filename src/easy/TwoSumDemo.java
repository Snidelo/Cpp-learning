package easy;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 扩展：HashMap的学习
 */
public class TwoSumDemo {
    public static  void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(twoSum(arr,16)));
    }

    public static int[] twoSum(int[] arr, int target){
        int[] index = new int[2];
        if(arr == null || arr.length < 2){
            return new int[] {-1,-1};
        }
        //===================solution_1==================
        /*
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        System.out.println("未找到符合要求的数据");
        return new int[] {-1,-1};
        */
        //===================solution_2==================
        //对solution2的一点疑问，HashMap的containsKey操作底层如何实现，是否是遍历HashMap，这将影响该算法的复杂度
        //解答，HashMap中的containsKey()方法的时间复杂度是O(1) - O(n)，取决于哈希函数的选取，如果直接计算Key所在位置已被占用，需要在该位置的链表中遍历找到Key值
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(hashMap.containsKey(target - arr[i])){
                return new int[] {i,hashMap.get(target - arr[i])};
            }else{
                hashMap.put(arr[i],i);//将数值作为hashmap的key，数组索引作为hashmap的值
            }
        }
        System.out.println("未找到符合要求的数据");
        return new int[] {-1,-1};
    }
}
