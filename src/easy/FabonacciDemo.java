package easy;

//#509
public class FabonacciDemo {

    //=============solution_1============
    // recursion，最常规的解法——递归
    public int fib_1(int N) {
        if(N > 1){
            return fib_1(N - 1) + fib_1(N - 2);
        }else{
            return N;
        }
    }

    //=============solution_2============
    //从第一个数字开始写出fabonacci数列并记录在数组中，累加到索引之后，也就找到了
    public int fib_2(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize_2(N);
    }

    public int memoize_2(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }

    //==========solution_3============
    //同solution_2一样，但是方向相反
    private Integer[] cache = new Integer[31];

    public int fib_3(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize_3(N);
    }

    public int memoize_3(int N) {
        if (cache[N] != null) {
            return cache[N];
        }
        cache[N] = memoize_3(N-1) + memoize_3(N-2);
        return memoize_3(N);
    }
}
