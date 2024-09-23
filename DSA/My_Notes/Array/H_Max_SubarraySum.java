import java.util.ArrayList;
import java.util.List;

public class H_Max_SubarraySum {

        // Subsequence vs subarray => subarray is contiguous  
     static void generateStringSubsequences(String str) {
        int n = str.length();
        
        // There are 2^n possible subsequences
        int totalSubsequences = 2^n; // 2^n = (1 << n)

        // Iterate over all possible subsequences
        for (int i = 0; i < totalSubsequences; i++) {
            StringBuilder subsequence = new StringBuilder();
            
            // For each bit position, check if it is set
            for (int j = 0; j < n; j++) {
                // If the j-th bit in i is set, include str[j]
                if ((i & (1 << j)) != 0) { // Checking which bit in 'i' is set
                    subsequence.append(str.charAt(j));
                }
            }

            // Print the generated subsequence
            if (subsequence.length() > 0) {
                System.out.println(subsequence);
            }
        }
    }

    static void generateArraySubsequences(int[] array) {
        int n = array.length;

        // There are 2^n possible subsequences
        int totalSubsequences = (2 ^ n);  // 2^n = (1 << n)

        // Iterate over all possible subsequences
        for (int i = 0; i < totalSubsequences; i++) {
            List<Integer> subsequence = new ArrayList<>();

            // For each bit position, check if it is set
            for (int j = 0; j < n; j++) {
                // If the j-th bit in i is set, include array[j]
                if ((i & (1 << j)) != 0) {
                    subsequence.add(array[j]);
                }
            }
            System.out.println(subsequence);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(-8); 
        list.add(7);
        list.add(-1);
        list.add(2);
        list.add(3);


        int maxSum = Integer.MIN_VALUE;


        //Approach:1
        for(int i=0;i<list.size();i++) {
            for(int j=i+1;j<list.size();j++){
                int sum = list.subList(i, j+1).stream().reduce(0,(acc, l) -> acc + l);
                maxSum = Integer.max(maxSum, sum); 
            }
        }
        
        System.out.println(maxSum);
        

        // Approach:2
        // Kadane's algorithm
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        if (nums == null || nums.length == 0) {
            System.out.println(0);
            // return 0;
        }  
        int maxiSum = nums[0];
        int currentSum = nums[0];
                
        for (int i = 1; i < nums.length; i++) {
            // At each step, decide whether to extend the current subarray or start a new one.
            currentSum = Math.max(nums[i], currentSum + nums[i]);
                    
            // Update the maximum sum if the current subarray sum is greater.
            maxiSum = Math.max(maxiSum, currentSum);
        }
                
        System.out.println(maxiSum);
        }
}
