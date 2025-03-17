package Easy;



public class NumberOFGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int[] nums2 = {1,1, 1, 1};
        int[] nums3= {1,2, 3};

        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticalPairs(nums2));
        System.out.println(numIdenticalPairs(nums3));

    }
    public static int numIdenticalPairs(int[] nums ) {
        int[] freq = new int[101];
        int pairs = 0;

        for (int num: nums) freq[num] += 1;
        for (int num: freq) {
            pairs += num * (num - 1) / 2;
        }
        return pairs;
    }

}
