package tree.fenwicktree;
import java.util.Scanner;


public class FenWick {
    int[] bit;
    FenWick(int size) {
        bit = new int[size + 1];
    } 
    
    public void buildTree(int[] nums) {
        int n= nums.length;
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }
    
    public void add(int i, int val) {
        int n = bit.length;
        i++;
        while (i < n) {
            bit[i] += val;
            i = i + (i & (-i));
        }
    }
    public int querySum(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += this.bit[i];
            i = i - (i & (-i));
        }
        return res;
    }
    public static void main(String[] args) {
        // implememnt fenwick tree
        Scanner input = new Scanner (System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = input.nextInt();
        FenWick ft = new FenWick(n);
        ft.buildTree(nums);

        
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            int type = input.nextInt();
            if (type == 1) {
                // means update
                int indx = input.nextInt() -1;
                int val = input.nextInt();  
                ft.add(indx, val - nums[indx]);
            }
            else {
                int l = input.nextInt()  -1;
                int r  = input.nextInt() -1;
                int ans = ft.querySum(r) - ft.querySum(l - 1);
                sb.append(ans).append('\n');
            }
        }
        System.out.println(sb.toString());
        input.close();

    }

}