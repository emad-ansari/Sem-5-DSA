package medium;

// https://leetcode.com/problems/push-dominoes/description/ [SOLVED]
public class PushDoominoes {
    public static void main(String[] args) {
        String s = ".R....RLRR......RL...L..L....R.L.......L..R.....L........RL.L..LR......L...L..RL.R...LRL.....R......";
        System.out.println(pushDominoes(s));
        
    }
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length(), curr = 0, next = 1;
        char[] d = dominoes.toCharArray();
        while (curr < n && next < n) {
            while (next < n && d[next] == '.') next++;
            if (curr == next) {
                curr++;
                next++;
            }
            else {
                update(d, curr, next);
                curr = next;
                next++;
            }
            
        }
        StringBuilder ans = new StringBuilder();
        for (char c: d) ans.append(c);
        return ans.toString();
    }
    public static void update(char[] d, int curr, int next) {
        int n = d.length;
        if (d[curr] == '.' && next == n) return;
        if (d[curr] == 'L' && next == n) return;
        else if (d[curr] == 'R' && next == n) {
            while (curr < n) {
                d[curr] = 'R';
                curr++;
            }
            return;
        }
        else if ((d[curr] == '.' && d[next] == '.' )|| (d[curr] == 'L' && d[next] == 'R')) return;
        else if (d[curr] == '.' && d[next] == 'L') {
            while (curr < next) {
                d[curr] = 'L';
                curr++;
            }
            return;
        }
        else if (d[curr] == 'R' && d[next] == 'L'){
            while (curr < next) {
                d[curr] = 'R';
                d[next] = 'L';
                curr++;
                next--;
            }
            return;
        }
        else if (d[curr] == 'L' && d[next] == 'L') {
            // L-L
            while (curr < next) {
                d[curr] = 'L';
                curr++;
            }
            return;
        }
        else {
            // ......R
            if (d[curr] == '.' ) return;
            else { // R....R
                while (curr < next) {
                    d[curr] = 'R';
                    curr++;
                }
            }
            return;
            
        }
    }
    
}
