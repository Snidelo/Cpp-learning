package easy;

public class HammingDistanceDemo {

    //=================solution_1================
    public int hammingDistance_1(int x, int y){
        int k = x ^ y;
        int count = 0;
        for(int c = k; k > 0; k /= 2){
            if(k % 2 != 0){
                count++;
            }
        }
        return count;
    }

    //=================solution_2================
    //用Integer的库函数
    public int hammingDistance_2(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}
