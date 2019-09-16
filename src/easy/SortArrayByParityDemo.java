package easy;

import java.util.Arrays;

//输出偶数，后面跟着奇数
public class SortArrayByParityDemo {
    public static void main(String[] args) {
        //int[] A = {4,1,2,5,2,0,2,3,6,9,8,7,4,4,5,5,1,8};
        int[] A = {4,4,2,4};
        SortArrayByParityDemo so = new SortArrayByParityDemo();
        System.out.println(Arrays.toString(so.sortArray_3(A)));
    }

    //====================solution_1===================
    //1、这个题好像几种排序算法，可以像shell排序那样实现，或者快速排序那样实现

    //先用类似shell排序的实现
    //leetcode提交显示时间值超过8%的提交
    public int[] sortArray_1(int[] A){
        for(int i = 1; i < A.length; i++){
            if(A[i] % 2 == 0){
                //往前插入，直到前一个是数组头或者偶数
                for(int j = i ; j > -1; j--) {
                    if(j == 0){
                        int temp = A[j];
                        A[j] = A[i];
                        A[i] = temp;
                        break;
                    }
                    if (A[j - 1] % 2 == 0) {
                        int temp = A[j];
                        A[j] = A[i];
                        A[i] = temp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    //====================solution_2===================
    //构建一个新数组，把原数组中的值传进去
    public int[] sortArray_2(int[] A){
        int[] B = new int[A.length];
        int head = 0;
        int tail = A.length - 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                B[head++] = A[i];
            }else{
                B[tail--] = A[i];
            }
        }
        return B;
    }

    //====================solution_3===================
    //从前找一个奇数，从后找一个偶数，交换，直到前后索引换位
    public int[] sortArray_3(int[] A){
        int head = 0;
        int tail = A.length - 1;
        int temp;

        while(head < tail){
            while(A[head] % 2 == 0){
                if(head == A.length - 1)
                    break;
                head++;
            }
            //跳出循环，找到奇数
            while(A[tail] % 2 != 0){
                if(tail == 0)
                    break;
                tail--;
            }
            //跳出循环，找到偶数
            if(head < tail) {
                temp = A[head];
                A[head] = A[tail];
                A[tail] = temp;
            }
        }
        return A;
    }



    //////以下是网上的几种solution
    public int[] sortArrayByParity_4(int[] A) {
            Integer[] B = new Integer[A.length];
            for (int t = 0; t < A.length; ++t)
                B[t] = A[t];

            Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

            for (int t = 0; t < A.length; ++t)
                A[t] = B[t];
            return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }

    //solution_3的简洁写法
    public int[] sortArrayByParity_5(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
