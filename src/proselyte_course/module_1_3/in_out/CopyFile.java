package proselyte_course.module_1_3.in_out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;

        System.out.println(args[0]);
        System.out.println(args[1]);

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            do {
                i = fin.read();
                fout.write(i);
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
