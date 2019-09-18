package medium;

import java.util.Arrays;

public class MaxIncreaseToKeepCitySkylineDemo {
    public static void main(String[] args) {
        System.out.println(new MaxIncreaseToKeepCitySkylineDemo().increase_1(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
    //============solution_1============
    //首先要找到从左往右（从右往左）和从上往下（从下往上）看的最高点
    public int increase_1(int[][] grid){
        int count = 0;
        int[] left2Right = new int[grid.length];
        int[] top2Bottom = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(left2Right[i] < grid[i][j]){
                    left2Right[i] = grid[i][j];
                }
                if(top2Bottom[j] < grid[i][j]){
                    top2Bottom[j] = grid[i][j];
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                count += -grid[i][j] + Math.min(left2Right[i], top2Bottom[j]);
            }
        }
        return count;
    }
}
