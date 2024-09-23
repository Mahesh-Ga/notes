import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        String s = "Mahesh";
        String d = s.chars()
                    .distinct()
                    .mapToObj(c -> String.valueOf((char)c))
                    .collect(Collectors.joining());
        System.out.println(d);
    }
}
