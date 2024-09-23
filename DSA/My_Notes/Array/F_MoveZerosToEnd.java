import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  F_MoveZerosToEnd {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(103);
        list.add(88);
        list.add(88);
        list.add(102);
        list.add(120);

        //Approach 1 O(n^2)
        for(int i=0;i<list.size();i++) {
            if(list.get(i) == 0) {
                for(int  j=i+1;j<list.size();j++){
                    if(list.get(j) !=0)
                        Collections.swap(list, i, j);
                }
            }
        }
        System.out.println(list);

         //Approach 2 => O(n)
        int count = 0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) != 0) {
               Collections.swap(list, i, count);
               count++;
            }
        }

        System.out.println(list);

        
        /// Approach 3 (Preserve Positions) => O(n),

        int[] nums =  {1, 0, 0, 0, 103, 88, 88, 102, 120};;
        int nonZeroIndex = 0;  // Pointer for non-zero elements
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // If the current element is non-zero, swap it with the element at nonZeroIndex
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the rest of the array with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

         System.out.println("After moving zeros: " + Arrays.toString(nums));
    }
}