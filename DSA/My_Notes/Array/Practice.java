import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
       
        Arrays.stream(a).distinct();
        
    }
}