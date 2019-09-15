package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWordsDemo {
    public static void main(String[] args) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    }

    //================solution_1==================
    //暴力解法，先words转换成morse密码表示，然后.equal();
    //这是错误解法，后面会特别复杂
    public static int unique_1(String[] morse, String[] words){
        int type = 1;
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++){
                sb.append(morse[words[i].charAt(j)-'a']);
            }
            words[i] = sb.toString();
        }
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[i].equals(words[j]))
                    type++;
            }
        }
        return type;
    }

    //================solution_2==================
    //网上的解法，将words先转化成morse密码，然后将其加入一个hashset中，因为set中的元素是不会重复的，所以其size就是morse的种类数目
    //还是对hashset，hashtable，hashmap不熟悉，做完简单题后再次总结学习
    public static int unique_2(String[] morse, String[] words){
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);//或者在StringBuilder的地方定义一个String temp = ""; 这里可以写成temp += MORSE[c - 'a']
            //两者的区别：
            /*
            str += "a"; 你要分解来看：str = str + "a";
            而str + "a" 会创建一个新的String对象，就慢了。
            要知道String对象一旦创建就是不能被改变的，要达到字符串拼接的效果，就得不停创建新对象。
            StringBuilder直到最后sb.toString()才会创建String对象，之前都没有创建新对象
            （在你的例子中是的，但是如果你append的总长度超过一定范围——默认是16——就会创建一个新的数组，来装下更多的String）
            */
            seen.add(code.toString());
        }

        return seen.size();
    }
}
