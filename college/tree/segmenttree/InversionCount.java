package tree.segmenttree;
// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

public class InversionCount {
    
    static int inversionCount(int arr[]) {
        // Your Code Here

        int max = arr[0];
        for (int num: arr) max = Math.max(max, num);
        int[] pref = new int[max + 1];
        
        for (int num: arr) pref[num]++;
        int[] seg = new int[4 * max];
        
        buildTree(pref, seg, 0, max, 0);
        
        int cnt = 0;
        for (int num: arr) {
            pref[num]--;
            update(seg, 0, max, 0, num);
            cnt += sum(seg, 0, max, 1, num - 1, 0);
        }
        return cnt;
    }
    
    public static void buildTree(int[] pref, int[] seg, int s, int e, int i) {
        if (s == e) {
            seg[i] = pref[s];
            return;
        }
        
        int m = s + (e - s) / 2;
        buildTree(pref, seg, s, m, 2 * i + 1);
        buildTree(pref, seg, m + 1, e, 2 * i + 2);
        
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }
    public static int sum(int[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) return seg[i];
        else if (e < l || r < s) return 0;
        else {
            int m = s + (e- s) /2 ;
            int left = sum(seg, s, m, l, r, 2 * i + 1);
            int right = sum(seg, m + 1, e, l, r, 2 * i + 2);
            return left + right;
        }
    }
    
    public static void update(int[] seg, int s, int e, int i, int index) {
        if (s == e) {
            seg[i] -= 1;
            return;
        }
        
        int m = s + (e - s) / 2;
        
        if (index <= m) {
            update(seg, s, m, 2 * i + 1, index);
        }
        else update(seg, m + 1, e, 2 * i + 2, index);
        
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }
    
}
