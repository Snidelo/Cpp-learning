package easy;

public class PeakIndexInMountainArrayDemo {
    public static void main(String[] args) {
        System.out.println(new PeakIndexInMountainArrayDemo().peakIndexInMountainArray_1(new int[]{0,2,1,0}));
    }

    //=================solution_1================
    public int peakIndexInMountainArray_1(int[] A){
        int left = 0;
        int right = A.length - 1;
        return found(A, left, right);
    }

    public int found(int[] A, int left, int right){
        int mid = (left + right) / 2;
        if(left + 1 == right || left == right){
            return A[left] > A[right] ? left : right;
        }
        if(A[mid] < A[mid - 1]){
            return found(A, left, mid - 1);
        }else if (A[mid] > A[mid - 1]){
            return found(A, mid, right);
        }

        return 0;
    }

    //=================solution_2================
    public int peakIndexInMountainArray_2(int[] A){
        for(int i = 1; i < A.length; i++){
            if(A[i] < A[i - 1]){
                return i - 1;
            }
        }
        return -1;
    }

    //=================solution_3================
    public int peakIndexInMountainArray_3(int[] A){
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

}
