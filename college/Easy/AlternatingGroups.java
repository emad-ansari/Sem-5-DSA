package Easy;
// https://leetcode.com/problems/alternating-groups-i/description/  [SOLVED]
public class AlternatingGroups {
    public static void main(String[] args) {
        int[] colors = {0,1,0,0,1};
        System.out.println(numberOfAlternatingGroups(colors));

    }
    
    public static int numberOfAlternatingGroups(int[] colors) {
        int cnt = 0, n = colors.length;
        for (int i = 0; i < n; i++) {
            if (colors[i % n] != colors[(i + 1) % n] && colors[(i + 1) % n] != colors[(i + 2) % n]) {
                cnt++;
            }
        }
        return cnt;
    }
    
}
