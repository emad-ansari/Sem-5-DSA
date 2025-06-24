package hard;

public class NumberOfPowerfulInteger {
    public static void main(String[] args) {
        
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        if (finish < Integer.parseInt(s)) return 0;
        long cnt = 0L;
        long df = (long)Math.log10(finish) + 1;
        long ds = s.length();
        for (long i = df - ds; i >= 1; i--) {

        }
        return cnt;
    }
}
