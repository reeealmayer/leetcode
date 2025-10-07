package proselyte_course.module_1_3.in_out._21;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(128);

            int count;

            do {
                count = channel.read(bf);
                if (count != -1) {
                    bf.rewind();

                }
            } while (count != -1);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("test.txt")))) {
            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
