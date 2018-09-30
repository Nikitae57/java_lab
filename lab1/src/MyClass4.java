public class MyClass4 {
    public static void main(String[] args) {
        int one = 0;
        int two = 1;
        int three = one + two;

        System.out.println(0);
        System.out.println(1);

        int n = Integer.valueOf(args[0]);
        for (int i = 0; i < n; i++) {
            System.out.println(three);

            one = two;
            two = three;
            three = one + two;
        }
    }
}
