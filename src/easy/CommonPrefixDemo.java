package easy;

/**
 * 我好菜
 */
public class CommonPrefixDemo {
    public static void main(String[] args){
        String[] s = {"asdf", "asdfhgjk"};
        System.out.println(s[0].substring(0,1));
    }

    //=================solution_1=================
    // * 这题是直接看的答案，自带的库函数不熟悉。需要学习
    // * String类中的indexOf()方法，substring()方法
    public static String longestCommonPrefix_1(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String prefix = strs[0];
        for(int i = 0; i < strs.length; i++){
            while(strs[0].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.length() == 0){
                    return "";
                }
            }
        }
        return prefix;
    }
    //=================solution_2=================
    //第二种算法是垂直比较，比较每一个String的相同索引的char是否相同，如果相同，则继续比较下一个位置，如果不相同（与的关系，有一个不同，其他的都没必要再比了），就直接返回了
    //对该算法的改进：先找到最短的String。该算法的最坏时间复杂度和算法1一样（此时各个String长度相等）。限制其最好情况下的复杂度的因素是最短的String的长度
    public static String longestCommonPrefix_2(String[] strs){
        String prefix = "";
        for(int i = 0; i < strs[0].length(); i++){//外层循环，循环每一位
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){//内层循环，循环当前位的所有strs
                if(strs[j].charAt(i) != c || i == strs[j].length()) {//两种情况退出循环，直接返回，第一种，找到了最长的prefix，第二种，当前的i已经是当前考察的strs[j]的长度了
                    return strs[0].substring(0,i);//
                }
            }
        }
        return strs[0];
    }

    //=================solution_3=================
    //ATTENTION: Divide & Conquer
    //第三种算法是分治算法。分治，先分再治,再加上驱动函数，总共需要三个函数
    //分治实际是一种递归，要理解递归部分的执行逻辑
    public static String longestCommonPrefix_3(String[] strs){
        if(strs == null || strs.length == 0)
            return "";
        return divide(strs,0,strs.length);
    }
    private static String divide(String[] strs, int left, int right){
        int mid = (left + right) / 2;
        if(left != right){
            //步骤：找到左边的prefix，找到右边的prefix，找到两者的prefix
            String sLeft = divide(strs,left,mid);//找到本层递归的左边prefix
            String sRight = divide(strs,mid + 1,right);//找到本层递归的右边prefix
            return conquer(sLeft,sRight);//找到本层左右两边的prefix的prefix作为本层的prefix，返回给上一层递归（本层可能是左递归，也可能是右递归）
        }else{
            return strs[left];//strs[left] == strs[right]
        }
    }
    private static String conquer(String sLeft,String sRight){
        int minLength = Math.min(sLeft.length(),sRight.length());
        for(int i = 0; i < minLength; i++){
            if(sLeft.charAt(i) != sRight.charAt(i)){
                return sLeft.substring(0,i);
            }
        }
        return sLeft.substring(0,minLength);
    }

    //=================solution_4=================
    //ATTENTION: BST solution
    //二叉树解法
    public static String longestCommonPrefix_4(String[] strs){
        return "";
    }

}
