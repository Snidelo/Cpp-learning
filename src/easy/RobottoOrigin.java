package easy;

public class RobottoOrigin {
    public static void main(String[] args) {
        System.out.println(new RobottoOrigin().judgeCircle("LDRRLRUULR"));
    }

    public boolean judgeCircle(String moves) {
        char[] C = moves.toCharArray();
        int hrizontal = 0;
        int vertical = 0;

        for(char c : C){
            switch(c){
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    hrizontal++;
                    break;
                case 'R':
                    hrizontal--;
                    break;
            }
        }
        return hrizontal == 0 && vertical == 0;
    }
}
