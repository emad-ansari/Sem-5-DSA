package hard;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/  [SOVLED]
public class FindingMinimumInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums0 = {-1,-1,-1,-1};
        int[] nums1 = {2,2,2,0,1};
        int[] nums2 = {1, 3, 5};
        int[] nums3 = {4, 5, 6, 6, 7, 0, 1, 2};
        int[] nums4 = {3, 3, 1, 3};
        int[] nums5 = {3, 3, 3, 4, 5, 1, 1, 2, 3};
        int[] nums6 = {10, 10, 10, 1, 1, 2, 2, 3, 3, 3};
        int[] nums7= {50, 50, 50, 50, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int[] nums8= {2, 2, 2, 3, 4, 5, 6, 1, 1, 1};
        int[] nums9= {4, 4, 4, 4, 1, 1, 2, 3, 3, 3};
        int[] nums10= {2, 0, 1, 2, 2, 2};
        int[] nums11= {1,2,3,3,0,1};
        int[] nums12= {9, 9, 9, 9, 1, 9, 9, 9, 9};
        int[] nums13= {3, 4, 5, 6, 6, 7, 0, 0};
        int[] nums14= {1,2,3,3,0,1, 1, 1, 1, 1, 1};


        System.out.println(findMin2(nums0));
        System.out.println(findMin2(nums1));
        System.out.println(findMin2(nums2));
        System.out.println(findMin2(nums3));
        System.out.println(findMin2(nums4));
        System.out.println(findMin2(nums5));
        System.out.println(findMin2(nums6));
        System.out.println(findMin2(nums7));
        System.out.println(findMin2(nums8));
        System.out.println(findMin2(nums9));
        System.out.println(findMin2(nums10));
        System.out.println(findMin2(nums11));
        System.out.println(findMin2(nums12));
        System.out.println(findMin2(nums13));
        System.out.println(findMin2(nums14));
    }
    
    public static int findMin2(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int s = 0, e = nums.length - 1;
        if (nums[e] > nums[s]) return nums[s];
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) return nums[m + 1];
            else if (m > s &&  nums[m] < nums[m - 1]) return nums[m];
            else if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
                continue;
            }
            if (nums[m] >= nums[s]) {
                if (nums[e] <= nums[s]) s = m + 1;
                else e = m - 1;
            }
            else e = m  - 1;
        }
        return nums[s];
    }
    
}
