package proselyte_course.module_1_3.in_out._20.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println(object1);
            objectOutputStream.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Исключение при серeализации: " + e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass object = (MyClass) objectInputStream.readObject();
            System.out.println(object);
        } catch (Exception e) {
            System.out.println("Исключение при десиреализации: " + e);
        }
    }
}
