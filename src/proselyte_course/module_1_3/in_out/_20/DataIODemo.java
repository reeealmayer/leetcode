package proselyte_course.module_1_3.in_out._20;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(96.2);
            dout.writeInt(100);
            dout.writeBoolean(true);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double v = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println(v);
            System.out.println(i);
            System.out.println(b);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
