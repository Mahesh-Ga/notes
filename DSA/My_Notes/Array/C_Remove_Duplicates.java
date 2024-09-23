import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class C_Remove_Duplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(103);
        list.add(88);
        list.add(88);
        list.add(102);
        list.add(120);
        
        //Conversion from array to ArrayList
        int arr[] = {1,2,3,4,5,5,5,5};
    //     List<Integer> arrayList = Arrays.stream(arr).boxed().toList();
    //     arrayList.forEach(i->System.out.println(i));

    //     //Approach 1: 
    //    List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
    //    System.out.println(distinctList);

       //Approach 2 :
       for (int i = 0; i < arr.length; i++)
       {
            boolean isDuplicate = false;
           for (int j = 0; j < i; j++)  {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.print(arr[i] + " ");
            }
       }

        // Approach 3 :
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] +" ");

            while (i < (arr.length - 1) && arr[i] == arr[i + 1])
                i++;
        }

        Integer[] array = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> uniqueSet = new HashSet<>(Arrays.asList(array));
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println(uniqueList); // [1, 2, 3, 4, 5]

    }
}
