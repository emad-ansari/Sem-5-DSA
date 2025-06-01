package Easy;
// https://leetcode.com/problems/distribute-candies/description/

public class CandiesDistribution {
    public int distributeCandies(int[] candyType) {
        boolean[] seen = new boolean[200001];
        int n = candyType.length, unique = 0;
        int limit = n / 2;
        for (int i = 0; i < n; i++) {
            int candy = 100000 + candyType[i];
            if (!seen[candy]) {
                seen[candy] = true;
                unique++;
            }   
            if (unique == limit) break;
        }
        return unique;
    }
    
}
