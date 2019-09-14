package easy;

public class DefangingIPDemo {
    public static void main(String args[]){
        System.out.println(DefangingIP("255.255.255.255"));
    }

    public static String DefangingIP(String address){
        String[] s = address.split("\\.");//注意用split做分割的时候某些特殊字符要用转义符
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            sb.append(s[i]);
            if(i != s.length - 1){
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}
