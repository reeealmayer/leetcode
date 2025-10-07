package proselyte_course.module_1_3.in_out._21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        try (InputStream fin = Files.newInputStream(Paths.get("test.txt"))) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка пути");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
