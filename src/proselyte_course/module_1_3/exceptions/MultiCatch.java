package proselyte_course.module_1_3.exceptions;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        int vals[] = {1, 2, 3};

        try {
            vals[23] = 20;
            int result = a / b;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение перехвачено: " + e);
        }
        System.out.println("После многократного перехвата.");
    }
}
