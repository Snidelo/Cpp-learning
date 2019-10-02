package easy;

public class ProjectArea3DDemo {


    //======soluiton_1======
    //和之前有一题比较像,都是找各行各列的最大值
    public int solution_1(int[][] grid){
        //找出行列最大值就好了
        int sum = 0;
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    sum += 1;
                }
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        for(int i = 0; i < grid.length; i++){
            sum += rowMax[i] + colMax[i];
        }
        return sum;
    }


    //=========solution_2==========
    //solution_1速度慢(O(N^2)),空间占用大
    //一种改进方法就是把行列最大值写到第一个for循环里面
    public int projectionArea(int[][] grid) {
        int z = 0, x = 0, y = 0;
        for (int i = 0; i < grid.length; ++i) {
            int mx = 0, my = 0; // max of x & y values.
            for (int j = 0; j < grid.length; ++j) {
                //ATTENTION!!! 这里的索引变了,同时找了行和列的最大值,可以这么做的原因是grid行列相等
                mx = Math.max(mx, grid[j][i]); // see above 1
                my = Math.max(my, grid[i][j]); // see above 2
                if (grid[i][j] > 0) { ++z; } // only the cell with positive value has a projection area of size 1 in z direction (on x-y plane).
            }
            x += mx; y += my; // x & y projection accumulation.
        }
        return x + y + z;
    }
}
