package leetcode.medium;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));

    }

    // Brute force approach
  public static List<List<Integer>> threeSum(int[] nums){

      Set<List<Integer>> set  = new HashSet<>();
     for (int i = 0; i < nums.length; i++){
          for (int j = i + 1; j < nums.length; j++){
              for (int k = j + 1; k < nums.length; k++){
                  if (nums[i] + nums[j] + nums[k] == 0){
                      // this can be my answer
                      List<Integer> temp = new ArrayList<>();
                      temp.add(nums[i]);
                      temp.add(nums[j]);
                      temp.add(nums[k]);
                      Collections.sort(temp);
                      set.add(temp);
                  }
              }
          }
      }
      List<List<Integer>> ans = new ArrayList<>(set);
      return ans;
  }

  // Better approach
    public static List<List<Integer>> threeSum1(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int target = -(nums[i] + nums[j]);
                if(map.containsKey(target)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target);
                    Collections.sort(temp); // after adding sort the element
                    set.add(temp);
                }
                // before incrementing j put the num[j] to map;
                map.put(nums[j], j);
            }
            // once internal loop over remove all element from map
            map.clear();
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // Optimized solution

    public static List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
