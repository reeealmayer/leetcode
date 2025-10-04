package proselyte_course.module_1_3.in_out;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InOutExamples {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] text = new String[100];
//
//        for (int i = 0; i < 100; i++) {
//            text[i] = br.readLine();
//            if (text[i].equals("stop")) {
//                break;
//            }
//        }
//
//        for (int i = 0; i < 100; i++) {
//            if (!text[i].equals("stop")) {
//                System.out.println(text[i]);
//            } else {
//                break;
//            }
//        }

        int b;

        b = 'A';
        System.out.println(b);

        System.out.write(b);
        System.out.write('\n');

        FileOutputStream fos = new FileOutputStream("file");

        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("asd");
    }
}
