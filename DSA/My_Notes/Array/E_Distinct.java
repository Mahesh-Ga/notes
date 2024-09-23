import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class E_Distinct {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(103);
        list.add(103);
        list.add(88);
        list.add(88);
        list.add(102);
        list.add(120);
        list.add(120);

        // Approach: 1
        List<Integer> distinctList =  list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        //Approach: 2
        int res=1;
        // Arrays.sort();
        for(int i=1;i< list.size();i++) {
            if(list.get(i) != list.get(res-1)) {
                list.set(res, list.get(i));
                res++;
            }
        }
        System.out.println(list.subList(0, res));

        //Approach 3
        HashSet<Integer> set = new HashSet<>(list);
        List<Integer> listDistinct = new ArrayList<>(set);
        System.out.println(listDistinct);


    }
}
