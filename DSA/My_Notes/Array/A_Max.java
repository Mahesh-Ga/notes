import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_Max   
{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(103);
        list.add(88);
        list.add(66);
        list.add(102);
        list.add(6);
                   
        // Approach: 1
        int max  = list.stream()
                        .max((a,b) -> a-b) // Optional<Integer>
                        .get();

        // Approach: 2
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) > max2) {
                max2 = list.get(i); 
            }
        }

        // Approach: 3
        int index=-1;
        for(int i=0;i<list.size();i++) {
            boolean flag = true;
            for(int j=0;j<list.size();j++) {
                if(list.get(j) > list.get(i)) {
                    flag = false;
                    break;
                }
            } 
            if(flag == true)
                index = i;
        }

        System.out.println(max);
        System.out.println(max2);
        System.out.println(index);
    }
}