package proselyte_course.module_1_3.exceptions;

public class ChainExcDemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("Верхний уровень");

        e.initCause(new ArithmeticException("причина"));

        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Перехваченое исключение: " + e);

            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
