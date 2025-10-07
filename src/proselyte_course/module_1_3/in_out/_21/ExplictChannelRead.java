package proselyte_course.module_1_3.in_out._21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplictChannelRead {
    public static void main(String[] args) {
        int count;
        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))) {
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mBuf);
                if (count != -1) {
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.println((char) mBuf.get());
                    }
                }
            } while (count != -1);

        } catch (InvalidPathException e) {
            System.out.println("Path error " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
