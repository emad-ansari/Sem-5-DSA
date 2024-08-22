package leetcode.easy;

//https://leetcode.com/problems/maximum-population-year/ - [SOLVED]

public class MaximumPopulationYear {
    public static void main(String[] args){
        int[][] logs = {{1993, 1999},{2000, 2010}};
        System.out.println("Max year: " + maximumPopulation(logs));

    }
    public static int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];
        for (int[] log: logs) {
            years[log[0]] += 1;
            years[log[1]] -= 1;
        }
        // find the prefix array
        int max = years[1950];
        int maxYear = 1950;
        for (int i = 1951; i < years.length; i++){
            years[i] += years[i -1]; // generating cumulative sum.
            if (years[i] > max ){
                max = years[i];
                maxYear = i;
            }
        }

        return maxYear;
    }
}
