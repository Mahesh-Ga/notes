import java.util.ArrayList;
import java.util.List;

public class D_Reverse {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(103);
        list.add(88);
        list.add(88);
        list.add(102);
        list.add(120);

        // Approach: 1
        // Collections.reverse(list);

        //Approach: 2
        int start = 0 ,end = list.size() - 1;

        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end)); // Collections.swap(arr,i,j)
            list.set(end,temp);
            start++;
            end--;
        }


        System.out.println(list);
    }
}
