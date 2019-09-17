package easy;

import java.util.Arrays;

public class SquarsofSortedArrayDemo {
    public static void main(String[] args) {

    }

    //================solution_1==================
    public int[] SquarsofSortedArray_1(int[] A){
        //数组本来就有序，那么平方后的最大值次大值，肯定都在两边（三种情况，都是负数，都是正数，有正有负）
        //那么从两边找较大值,赋值到一个新数组中去
        int[] B = new int[A.length];
        for(int i = 0, j = A.length - 1, p = A.length - 1; p >=0; p--){
            if(Math.abs(A[i]) > Math.abs(A[j])){
                B[p] = A[i] * A[i];
                i++;
            }else{
                B[p] = A[j] * A[j];
                j--;
            }
        }
        return B;
    }

    //================solution_2==================
    public int[] SquarsofSortedArray_2(int[] A){
        //先平方，后排序
        for(int p = A.length - 1; p >=0; p--){
           A[p] *= A[p];
        }
        Arrays.sort(A);
        return A;
    }

    //================solution_3==================
    //与第一种方法差不多，但是是从中间往两边去找。先找到最小的值（刚刚从负到正的地方，或者都是负数的结尾，或者都是正数的开头），再往两边去找较小值
    public int[] SquarsofSortedArray_3(int[] A){
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
