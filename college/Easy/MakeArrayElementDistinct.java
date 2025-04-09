package Easy;

public class MakeArrayElementDistinct {
    public static void main(String[] args) {
        
    }

    public int minimumOperations1(int[] nums) {
        int n = nums.length;
        boolean[] freq = new boolean[101];
        for (int i = n - 1; i >= 0; i++) {
            if (freq[nums[i]]) return i / 3 + 1;
            freq[nums[i]] = true;
        }
        return 0 ;
    }


    public int minimumOperations(int[] nums) {
        int min = nums[0], max = nums[0], m = nums.length;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int n = max - min + 1;
        int[] freq = new int[n];
        for (int num: nums) freq[max - num]++;
        if (isDistinct(freq)) return 0;
        int cnt = 0, mno = 0;
        for (int i = 0; i < m; i++) {
            cnt++;
            freq[max - nums[i]]--;
            if (m - i < 3) {
                mno++;
                break;
            }
            if (cnt == 3){
                mno++;
                if (isDistinct(freq)) break;
                cnt = 0;
            }
        }

        return mno;
    }
    public static boolean isDistinct(int[] freq) {
        for (int f: freq) {
            if (f > 1) return false;
        }
        return true;
    }
}
