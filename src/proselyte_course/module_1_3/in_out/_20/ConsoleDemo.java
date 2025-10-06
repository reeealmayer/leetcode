package proselyte_course.module_1_3.in_out._20;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        con = System.console();

        if (con == null) {
            return;
        }

        str = con.readLine("Введите строку: ");
        con.printf("Введенная вами строка: %s\n", str);
    }
}
