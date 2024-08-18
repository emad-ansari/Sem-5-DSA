package leetcode.easy;

// https://leetcode.com/problems/find-the-highest-altitude/ [SOLVED]

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println("Highest Altitude: " + largestAltitude(gain));
    }
    public  static int largestAltitude(int[] gain) {
        int higestAltitude = 0;
        int currentPoint = 0;
        for (int point: gain){
            currentPoint += point;
            if (currentPoint >  higestAltitude){
                higestAltitude = currentPoint;
            }
        }
        return higestAltitude;
    }
}
