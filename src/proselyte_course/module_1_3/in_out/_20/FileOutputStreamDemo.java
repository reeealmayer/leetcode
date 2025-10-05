package proselyte_course.module_1_3.in_out._20;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = " Now i s the t ime for all good men\n" +
                " to соте to the aid o f the i r count ry\n" +
                " and рау thei r due taxes . ";

        byte buf[] = source.getBytes();

        try (FileOutputStream f0 = new FileOutputStream("file1.txt");
             FileOutputStream f1 = new FileOutputStream("file2.txt");
             FileOutputStream f2 = new FileOutputStream("file3.txt")) {
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }

            f1.write(buf);

            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
