 import java.util.ArrayList;
import java.util.List;

public class G_Max_ConsecutiveOne {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0); 
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(0);

        int currentMax = 0, count =0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) == 1) {
                count++;
            }    
            else if(list.get(i)==0) {
                currentMax = Integer.max(currentMax, count);
                count=0;
            }
        }
        System.out.println(currentMax);
    }
}