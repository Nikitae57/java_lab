import seven.MyRectangle;

public class TestDrive {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        MyRectangle r2 = new MyRectangle(3, 3);
        MyRectangle r3 = new MyRectangle(-2, 1, 1, -2);

        System.out.println("Initialized:\n");

        System.out.println("r1:");
        r1.print();
        System.out.println();

        System.out.println("r2:");
        r2.print();
        System.out.println();

        System.out.println("r3:");
        r3.print();
        System.out.println('\n');

        r1.move(1, -1);
        r2.move(0, 0);
        r3.move(2, 3);

        System.out.println();
        System.out.println("r1: dx 1 dy -1");
        r1.print();
        System.out.println();

        System.out.println("r2: dx 0 dy 0");
        r2.print();
        System.out.println();

        System.out.println("r3: dx 2 dy 3");
        r3.print();
        System.out.println('\n');

        System.out.println("r2 union r3:");
        r2.union(r3).print();
    }
}
