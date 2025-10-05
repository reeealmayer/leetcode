package proselyte_course.module_1_3.in_out._20;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Эти данные должны быть выведены в массив";
        byte[] buf = s.getBytes();

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Ошибка записи в буфер");
        }

        System.out.println("Буфер в виде символьной строки");
        System.out.println(f);
        System.out.println("В массив");
        byte[] b = f.toByteArray();

        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }

    }
}
