package easy;

import java.util.HashSet;

public class FairCandySwapDemo {

    public static void main(String[] args) {
        new FairCandySwapDemo().fairCandySwap(new int[]{1,1}, new int[]{2,2});
    }
    //=============solution_1=============
    //像这一类，需要在两个数组之间匹配值，且不关注Index的可以用HashSet解决
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;

        HashSet<Integer> hashSetB = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            sumA = sumA + A[i];
        }
        for(int i = 0; i < B.length; i++){
            sumB = sumB + B[i];
            hashSetB.add(B[i]);
        }
        int cha = (sumB - sumA)/2;
        for(int a : A){
            if(hashSetB.contains(a + cha)){
                return new int[]{a,a+cha};
            }
        }
        return null;
    }
}
