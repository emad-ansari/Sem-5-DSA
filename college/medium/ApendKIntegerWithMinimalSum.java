package medium;

import java.util.Arrays;
// https://leetcode.com/problems/append-k-integers-with-minimal-sum/description/  [SOLVED]
public class ApendKIntegerWithMinimalSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84};
        System.out.println(minimalKSum1(nums, 41));
    
    }
    
    public static long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);
        long ms = 0L;
        int n = nums.length, cnt = 0;
        // handle first part
        int d = nums[0] - 1;
        if (d >= k) {
            ms += (long)k * (k + 1) / 2;
            return ms;
        }
        else {
            ms += (long)d * (d + 1) / 2;
            cnt += d;
        }
        
        for (int i = 0; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            int m = diff - 1;
            if (m <= 0) continue;
            if ((k - cnt) >= m){
                ms += ((long)m * nums[i]) + ((long)m * (m + 1) / 2);
                cnt += m;
                if (cnt == k) break;
            }
            else {
                int r = k - cnt;
                ms += ((long)r * nums[i]) + ((long)r * (r + 1) / 2);
                cnt += r;
                if (cnt == k) break;
            }
        }

        if (cnt < k) {
            int rem = k - cnt;
            ms += ((long)nums[n - 1] * rem) + ((long)rem * (rem + 1) / 2); 
        }

        return ms;        
    }
  

    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int prevM = 0;
        for (int i = 0; i < nums.length; i++) {
            int cm = nums[i] - i - 1;
            int tmn = cm - prevM;
            if(tmn > k) {
                sum += k * (k + 1) / 2;
                prevM = k;
                break;
            }
            else if (tmn != 0) {
                sum += tmn * nums[i] - (tmn * (tmn + 1) / 2);
            }
            prevM = tmn > prevM ? tmn : prevM;
            if(prevM == k) break;
        }

        // if the loop end and still 
        if (prevM < k) {
            int left = k - prevM;
            sum +=  left * nums[nums.length - 1] + (left * (left + 1) / 2);
        }
        return sum;
    }
}
