public class MyClass3 {
    public static void main(String[] args) {
        MyClass3 m3 = new MyClass3();

        for (String s : args) {
            System.out.println(m3.reversed(s));
        }
    }

    private String reversed(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return String.valueOf(sb);
    }
}
