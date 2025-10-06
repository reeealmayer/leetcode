package proselyte_course.module_1_3.in_out._20;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("file2.txt")) {
            int c;

            while ((c = fr.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода");
        }
    }
}
