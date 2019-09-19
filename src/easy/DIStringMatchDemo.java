package easy;

public class DIStringMatchDemo {

    //===========solution_1=============
    public int[] diStringMatch(String S) {
        int max = S.length();
        int min = 0;
        int[] res = new int[max + 1];
        for(int i = 0; i < res.length - 1; i++){
            //#1此段if代码可以修改为：res[i] = S.charAt(i) == 'I' ? left++ : right--;
            if(S.charAt(i) == 'I'){
                res[i] = min++;
            }else{
                res[i] = max--;
            }
        }
        res[res.length - 1] = min;
        return res;
    }
}
