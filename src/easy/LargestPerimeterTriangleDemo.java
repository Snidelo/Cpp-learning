package easy;

import java.util.Arrays;

//#976
public class LargestPerimeterTriangleDemo {
    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangleDemo().largestPerimeter(new int[]{1,2,1}));;
    }
    //======solution_1======
    //public int largestPerimeter(int[] A) {


    //}
    public int largestPerimeter(int[] A) {
        if(A.length < 3){
            return 0;
        }
        //sort
        sort(A);
        for(int i = 0; i < A.length - 2; i++){
            if(A[i] < A[i + 1] + A[i + 2]){
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;

    }

    //归并排序
    private int[] temp;
    public int[] sort(int[] A){
        temp = new int[A.length];
        this.divide(A, 0, A.length - 1);
        return temp;
    }

    public void divide(int[] A, int left, int right){
        if(left != right) {
            int mid = (left + right) / 2;
            divide(A, left, mid);
            divide(A, mid + 1, right);
            merge(left, mid, right, A);
        }
    }


    public void merge(int left, int mid, int right, int[] A) {
        int i = left;
        int j = mid + 1;
        while (i < mid + 1 && j < right + 1) {
            if (A[i] > A[j]) {
                temp[left] = A[i];
                i++;
                left++;
            } else {
                temp[left] = A[j];
                j++;
                left++;
            }
        }
        //退出循环，必有一边已经放完了
        while (i < mid + 1) {
            temp[left++] = A[i++];
        }
        while (j < right + 1) {
            temp[left++] = A[j++];
        }
        while(left > 0){
            A[right--] = temp[--left];
        }
    }
}
