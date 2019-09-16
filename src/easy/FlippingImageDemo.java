package easy;

public class FlippingImageDemo {
    public static void main(String[] args){
        int[][] A = {{1,1,0,1},{1,1,0,0},{0,1,0,1},{0,1,1,0},{0,1,1,1},{1,1,1,0},{1,0,1,0}};
        new FlippingImageDemo().flippingImage(A);
    }

    public int[][] flippingImage(int[][] A){
        for(int i = 0; i < A.length; i++){
            int head = 0;
            int tail = A[i].length - 1;
             while(!(head > tail)) {
                 if (A[i][head] == A[i][tail]) {
                     A[i][head] ^= 1;
                     A[i][tail] ^= 1;
                 }if(head == tail){
                     A[i][head] ^= 1;
                 }
                 head++;
                 tail--;
             }
        }
        return A;
    }
    //网上大佬的做法
    public int[][] flippingImage_2(int[][] A){
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}
