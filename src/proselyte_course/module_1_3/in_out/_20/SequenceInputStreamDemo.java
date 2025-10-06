package proselyte_course.module_1_3.in_out._20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");

        InputStreamEnumerator ise = new InputStreamEnumerator(files);

        try (InputStream input = new SequenceInputStream(ise)){
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("Ошибка открытия файла");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("file1.txt");
             PrintStream printStream = new PrintStream(fileOutputStream)) {
            printStream.println("test");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
