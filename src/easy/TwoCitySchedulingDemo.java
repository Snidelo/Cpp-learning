package easy;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.Iterator;

public class TwoCitySchedulingDemo {
    public static void main(String[] args) {
        System.out.println(new TwoCitySchedulingDemo().twoCitySchedCost(new int[][]{{10,20},{210,200},{400,50},{30,20}}));
    }

    //==solution_1==
    //题目需要一半的人飞A城市,一半的人飞B城市,而且费用最少
    //分析:先都让他们飞往花费最少的城市,同时计算差值(一个循环),根据费用差值的大小,补足人数差值(第二个循环)
    public int twoCitySchedCost(int[][] costs) {
        //int[][] diffNCity = new int[costs.length][2];//[][0]表示差值,[][1]表示去的城市
        ArrayList<Integer> diffA = new ArrayList<>();
        ArrayList<Integer> diffB = new ArrayList<>();
        int tot = 0;
        int people = 0;
        for(int i = 0; i < costs.length; i++){
            if(costs[i][0] < costs[i][1]){
                diffA.add(costs[i][1] - costs[i][0]);
                tot += costs[i][0];
                people++;
            }else{
                diffB.add(costs[i][0] - costs[i][1]);
                tot += costs[i][1];
            }
        }
        if(people == costs.length / 2){
            return tot;
        }else if(people > costs.length / 2){
            diffA.sort(Integer::compareTo);
            Iterator<Integer> it = diffA.iterator();
            for(int i = people; i > costs.length / 2; i--){
                tot += it.next();

            }
        }else{
            diffB.sort(Integer::compareTo);
            Iterator<Integer> it = diffB.iterator();
            for(int i = people; i < costs.length / 2; i++){
                tot += it.next();
            }
        }
        return  tot;
    }
}
