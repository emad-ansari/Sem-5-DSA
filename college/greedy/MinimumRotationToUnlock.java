package greedy;

public class MinimumRotationToUnlock {
    public static void main(String[] args) {
        System.out.println(rotationCount(2345, 5432));
    }

    public static int rotationCount(long R, long D) {
        // code here
        int minRotation = 0;
        while (R != 0 && D != 0) {
            int digitR = (int) (R % 10);
            int digitD = (int) (D % 10);
            int first = Math.abs(digitR - digitD);
            int second = 0;
            if (digitR > digitD) {
                second = (10 - digitR) + digitD;
            } else if (digitD > digitR) {
                second = (10 - digitD) + digitR;
            }
            minRotation += Math.min(first, second);
            R /= 10;
            D /= 10;
        }
        return minRotation;
    }

}
