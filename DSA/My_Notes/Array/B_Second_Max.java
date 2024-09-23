import java.util.ArrayList;
import java.util.List;

public class B_Second_Max {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(103);
        list.add(88);
        list.add(66);
        list.add(102);
        list.add(120);

        int max = list.get(0);
        
        int secondMax = Integer.MIN_VALUE;
        for(int i = 1 ; i < list.size(); i++){
            if(list.get(i) > max) {
                secondMax = max;
                max = list.get(i);
            }
            else if(list.get(i) != max) {
                if(secondMax == Integer.MIN_VALUE || list.get(i) > secondMax ) 
                    secondMax = list.get(i) ;
            }
        }
        System.out.println(secondMax);
    }
}
