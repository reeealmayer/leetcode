package proselyte_course.module_1_3.in_out._20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;
        try (FileInputStream f = new FileInputStream("test.txt")) {
            size = f.available();
            System.out.println("Общее количество доступных байтов: " + size);

            int n = size / 40;
            System.out.println("Первые " + n);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
