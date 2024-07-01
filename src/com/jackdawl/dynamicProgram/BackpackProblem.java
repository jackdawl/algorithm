package com.jackdawl.dynamicProgram;

public class BackpackProblem {


    public static void main(String[] args) {

        //goods info
        int n = 3;
        int[] weight = {10, 20, 40};
        int[] price = {60, 100, 120};

        //Backpack capacity
        int cap = 50;

        //The maximum value of the goods that can be loaded under the current weight
        int[][] value = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) { //goods added each time
            for (int cw = 1; cw <= cap; cw++) { //Splitting of backpacks
                if (weight[i-1] <= cw) { //goods can be added
                    value[i][cw] = Math.max(price[i - 1] + value[i - 1][cw - weight[i - 1]], value[i - 1][cw]);
                } else {
                    value[i][cw] = value[i - 1][cw];
                }
            }
        }
        System.out.println(value[n][cap]);

    }


}
