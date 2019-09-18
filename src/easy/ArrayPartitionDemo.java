package easy;

import java.util.Arrays;

public class ArrayPartitionDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrayPartitionDemo().sort(new int[]{1,4,3,2})));
    }

    public int[] sort(int[] nums){
        //insert sort
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i;
            while(j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
    //================solution_1=================
    //数组中抛去最大值后的次大值相加，（最大值做出牺牲，保护次大值）
    //这是网上大佬的数学分析：
    //Assume in each pair i, bi >= ai.
    //Denote Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn). The biggest Sm is the answer of this problem. Given 1, Sm = a1 + a2 + ... + an.
    //Denote Sa = a1 + b1 + a2 + b2 + ... + an + bn. Sa is constant for a given input.
    //Denote di = |ai - bi|. Given 1, di = bi - ai. Denote Sd = d1 + d2 + ... + dn.
    //So Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + dn = 2Sm + Sd => Sm = (Sa - Sd) / 2. To get the max Sm, given Sa is constant, we need to make Sd as small as possible.
    //So this problem becomes finding pairs in an array that makes sum of di (distance between ai and bi) as small as possible.
    //Apparently, sum of these distances of adjacent elements is the smallest. If that's not intuitive enough, see attached picture. Case 1 has the smallest Sd.
    public int arrayPartition(int[] nums){
        nums = this.sort(nums);
       // Arrays.sort(nums);
        //Arrays.sort()底层是如何实现的
        int res = 0;
        for(int i = nums.length - 2; i >= 0; i -= 2){
            res += nums[i];
        }
        return res;
    }
}



