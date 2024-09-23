public class Armstrong {
    public static void main(String[] args) {
        int n = 407;
        int temp = n;
        int sum = 0;
        int r=0;
        while(n!=0) {
            r = n % 10;
            sum += Math.pow(r, 3);
            n= n/10;
        }
        System.out.println("Original number" + temp );
        System.out.println("Sum of cubes" + sum );
    }
}
