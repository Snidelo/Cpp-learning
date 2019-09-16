package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个2N长度的数组中有一个数重复了N次，找出来
 */
public class N_RepeatedElementDemo {
    public static void main(String[] args) {
        int[] A = {1,2,5,4,6,6,6,6};
        System.out.println(new N_RepeatedElementDemo().repeatedNTimes(A));
    }

    //=================solution_1==================
    //这个题目的条件是，只有一个数字是重复的，其他所有数字都是不重复的，要理解这个条件，就会特别简单，只要遍历到重复的值，直接返回
    public int repeatedNTimes(int[] A){
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){

            if(m.containsValue(A[i])){
                return A[i];
            }else{
                m.put(i, A[i]);
            }
        }
        return -1;
    }

    //===========solution_2===========
    public int repeatedNTimes_2(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;

        throw null;
    }

    //================solution_3=================
    public int repeatedNTimes_3(int[] A) {
        for (int k = 1; k <= 3; ++k)//k的值为什么是1到3
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }

}
