package easy;

public class BitsSumDemo {

    //======solution_1=========
    //TODO:这个题目是个好题,多做几遍
    //需要一个时间复杂度为O(n)的算法
    //按照一般的做法的时间复杂度为O(n*log2),现在只能根据前面的信息来得到后一个数的信息,比如,14是一个 基(2^3)加上前一个分段(2^2-2^3)中的6,如果知道6的二进制位数和,就能知道14的值(基的位数和为1)
    public int[] solution_1(int num){
        int[] ans = new int[num + 1];
        ans[0] = 0;
        int radix = 1;

        for(int i = 1; i < num + 1; i++){
            if(i == radix * 2) radix *= 2;
            ans[i] = 1 + ans[i - radix];
        }

        return ans;
    }

    //=====solution_2=======
    //同样的,利用前一个数的信息//
    //TODO:时间关系,没看懂,下次再看
    public int[] solution_2(int num){
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
