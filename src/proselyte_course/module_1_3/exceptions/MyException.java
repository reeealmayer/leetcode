package proselyte_course.module_1_3.exceptions;

import java.rmi.ServerError;

public class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail='" + detail + '\'' +
                '}';
    }
}

class ExceptionDemo {
    static void compute(int a) throws MyException {
        System.out.println("Вызван метод compute(" + a + ")");
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("Нормальное завершение");
    }

    static void returnExample() {
        try {
//            throw new Exception();
            System.out.println(2 + 2);
            return;
        } catch (Exception e) {
            System.out.println("cached");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    public static double sqr(double arg) {
        long time = System.currentTimeMillis();

        if (time % 2 == 0) {
            return arg * arg;
        } else if (time % 2 == 1) {
            while(true);
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
//        sqr(10);
//        returnExample();
//        try {
//            compute(1);
//            compute(20);
//        } catch (MyException e) {
//            System.out.println("Перехвачено исключение: " + e);
//        }
//        throw null;

//        try {
//            throw new MyException(2);
//        } catch (Exception e) {
//            if (e instanceof RuntimeException) {
//                RuntimeException re = (RuntimeException) e;
//                System.out.println("Это RuntimeException на самом деле");
//            } else {
//                System.err.println("В каком смысле не RuntimeException???");
//            }
//        }
        try {
            Throwable t = new Exception();
//            throw t;
        } catch (Exception e) {
            System.out.println("Перехвачено");
        }
    }
}
