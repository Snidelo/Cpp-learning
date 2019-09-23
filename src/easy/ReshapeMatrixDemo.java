package easy;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeMatrixDemo {

    //===========solution_1============
    public int[][] reshape(int[][] nums, int r, int c){
        if(r * c > nums.length * nums[0].length){
            return nums;
        }

        int[][] newNums = new int[r][c];
        int row = 0;
        int col = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                newNums[i][j] = nums[row][col];
                col++;
                if(col > nums[0].length-1){
                    row++;
                    col = 0;
                }
            }
        }
        return newNums;
    }

    //===========solution_2==========
    //上面的可以用取余符号来精简
    public int[][] reshape_2(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }

    //============solution_3=================
    //可以使用队列,时间复杂度O(2*m*n)
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        Queue< Integer > queue = new LinkedList< >();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
}
