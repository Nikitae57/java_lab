public class MyClass5 {
    public static void main(String[] args) {
        int number = Integer.valueOf(args[0]);
        int n = 1;

        for (int i = 1; i <= number; i++) {
            n *= i;
        }

        System.out.println(n);
    }
}
