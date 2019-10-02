package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix3Demo {
    public static void main(String[] args) {
        //7,9,4,1;
        // 5,6,4,0
        int[][] arr = new SpiralMatrix3Demo().spiralMatrixIII(7,9,4,1);
        Arrays.toString(arr);
    }

    //======solution_1==========
    //经过仔细思考,这种方法比较麻烦,因为在边界的时候有多种情况
    /*public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        //其实就是一个走迷宫问题,走过的地方变成墙,直到遍历完整个矩阵
        ArrayList<Integer> list = new ArrayList<>();
        int sum = R * C - 1;
        list.add(r0, c0);
        while(sum != 0){
            //先向左走
            while(true){
                //在最后一个元素了,直接跳出,去向下走
                if(c0 == C - 1){

                }
                break;
            }
        }
    }*/

    //=========solution_2===========
    //再有一种方法就是,补全整个矩阵,使得遍历的时候都走在矩阵内,但是只有在范围内的坐标才会被记录
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        //其实就是一个走迷宫问题,走过的地方变成墙,直到遍历完整个矩阵
        int[][] ans = new int[R * C][2];

        //补全矩阵
        int maxRow = Math.max(r0, R - 1 - r0);
        int maxCol =  Math.max(c0, C - 1 - c0);
        int length = Math.max(maxRow, maxCol);
        int[][] full = new int[length * 2 + 1][length * 2 + 1];
        //补全后的矩阵的坐标以及起始点位置
        int fullX = length;
        int fullY = length;
        for(int i = 0; i < R * C;){
            //先向右走
            while(true){
                //首先将当前点置1,表示已经走过了
                full[fullX][fullY] = 1;
                //如果当前点在范围内,记录该点,i自加
                if(   ((0 <= fullX - length && R - 1 - r0 >= fullX - length) ||
                        (0 <= - fullX + length && r0 - 0 >= -fullX + length)) &&
                        ((0 <= fullY - length && C - 1 - c0 >= fullY - length) ||
                                (0 <= - fullY + length && c0 - 0 >= -fullY + length))){
                    ans[i++] = new int[]{fullX - length + r0, fullY - length + c0};
                }
                //向右走一步
                fullY++;
                if(fullY == 2 * length + 1){//该情况表示已经走到最后了
                    break;
                }
                //如果当前点可以往下走,那么就往下走,否则,继续向右走
                if(full[fullX + 1][fullY] == 0){//表示该点未走过
                    //表示下一个点可以向下走了,退出,进行向下走的循环
                    break;
                }

            }

            //向下走,如果向下走是1,直接break;进行这个判断是为了防止已经走到最后跳出的情况
            while(true){
                if(fullY == 2 * length + 1){
                    break;
                }
                //首先将当前点置1,表示已经走过了
                full[fullX][fullY] = 1;
                //如果当前点在范围内,记录该点,i自加
                if(   ((0 <= fullX - length && R - 1 - r0 >= fullX - length) ||
                        (0 <= - fullX + length && r0 - 0 >= -fullX + length)) &&
                        ((0 <= fullY - length && C - 1 - c0 >= fullY - length) ||
                                (0 <= - fullY + length && c0 - 0 >= -fullY + length))){
                    ans[i++] = new int[]{fullX - length + r0, fullY - length + c0};
                }
                //向下走一步
                fullX++;
                //如果当前点可以往左走,那么就往左走,否则,继续向下走
                if(full[fullX][fullY - 1] == 0){//表示该点未走过
                    //表示下一个点可以向左走了,退出,进行向左走的循环
                    break;
                }

            }
            //向左走,如果向左走是1,直接break;
            while(true){
                if(fullY == 2 * length + 1){
                    break;
                }
                //首先将当前点置1,表示已经走过了
                full[fullX][fullY] = 1;
                //如果当前点在范围内,记录该点,i自加
                if(   ((0 <= fullX - length && R - 1 - r0 >= fullX - length) ||
                        (0 <= - fullX + length && r0 - 0 >= -fullX + length)) &&
                        ((0 <= fullY - length && C - 1 - c0 >= fullY - length) ||
                                (0 <= - fullY + length && c0 - 0 >= -fullY + length))){
                    ans[i++] = new int[]{fullX - length + r0, fullY - length + c0};
                }
                //向下走一步
                fullY--;
                //如果当前点可以往上走,那么就往上走,否则,继续向左走
                if(full[fullX - 1][fullY] == 0){//表示该点未走过
                    //表示下一个点可以向左走了,退出,进行向左走的循环
                    break;
                }

            }
            //向上走,如果向上走是1,直接break;
            while(true){
                if(fullY == 2 * length + 1){
                    break;
                }
                //首先将当前点置1,表示已经走过了
                full[fullX][fullY] = 1;
                //如果当前点在范围内,记录该点,i自加
                if(   ((0 <= fullX - length && R - 1 - r0 >= fullX - length) ||
                        (0 <= - fullX + length && r0 - 0 >= -fullX + length)) &&
                        ((0 <= fullY - length && C - 1 - c0 >= fullY - length) ||
                                (0 <= - fullY + length && c0 - 0 >= -fullY + length))){
                    ans[i++] = new int[]{fullX - length + r0, fullY - length + c0};
                }
                //向上走一步
                fullX--;
                //如果当前点可以往上走,那么就往上走,否则,继续向左走
                if(full[fullX][fullY + 1] == 0){//表示该点未走过
                    //表示下一个点可以向左走了,退出,进行向左走的循环
                    break;
                }

            }
        }
        return ans;
    }

    //========solution_3=========
    //TODO:需要重新考虑一下这个算法,没怎么看懂
    //第一次看应该是,每次走都会是固定的步数,比如第一次向右走走一步,第二次向右走要走四步,同理其他方向的步数
    public int[][] spiralMatrixIII_3(int R, int C, int r0, int c0) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int[][] ans = new int[R*C][2];
        int t = 0;

        ans[t++] = new int[]{r0, c0};
        if (R * C == 1) return ans;

        for (int k = 1; k < 2*(R+C); k += 2)
            for (int i = 0; i < 4; ++i) {  // i: direction index
                int dk = k + (i / 2);  // number of steps in this direction
                for (int j = 0; j < dk; ++j) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        ans[t++] = new int[]{r0, c0};
                        if (t == R * C) return ans;
                    }
                }
            }
        throw null;
    }
}
