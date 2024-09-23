import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Loop through all possible combinations using a bitmask
        for (int mask = 1; mask < Math.pow(2,n); mask++) {
            List<Integer> subsequence = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    subsequence.add(nums[i]);
                }
            }
            // if (subsequence.size() >= 2) {
                result.add(subsequence);
            // }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsequences = findSubsequences(nums);

        // Print the subsequences
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }
}
