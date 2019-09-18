package easy;

public class RemoveDuplicatesfromSortArrayDemo {



    //===========solution_1=================
    //TODO: 没想通这个题，过段时间回来想
    public int removeDuplicates(int[] A){
        int count = A.length;
        int pre = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[pre]){
                pre = i;
            }else {

                count--;
            }
        }
        return count;
    }
}
