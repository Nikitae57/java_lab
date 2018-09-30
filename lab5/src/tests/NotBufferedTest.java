package tests;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class NotBufferedTest {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add("very ");
        }
        arrayList.add("big array");

        long start = System.currentTimeMillis();
        try {
            File file = new File("out1.txt");
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            arrayList.forEach(str -> {
                try {
                    fos.write(str.getBytes());
                } catch (IOException ignored) {}
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Not buffered: " + (System.currentTimeMillis() - start));
    }
}
