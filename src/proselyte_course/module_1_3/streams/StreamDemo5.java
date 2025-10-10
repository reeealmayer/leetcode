package proselyte_course.module_1_3.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larri", "555-5555", "1@mail.ru"));
        myList.add(new NamePhoneEmail("James", "444-444", "4@mail.ru"));
        myList.add(new NamePhoneEmail("Kristina", "333-333", "3@mail.ru"));

        myList.forEach(System.out::println);

        Stream<NamePhone> namePhoneStream = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNum));

        namePhoneStream.forEach(System.out::println);
    }
}

class NamePhoneEmail {
    String name;
    String phoneNum;
    String email;

    public NamePhoneEmail(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String toString() {
        return "NamePhoneEmail{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


class NamePhone {
    String name;
    String phoneNum;

    public NamePhone(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "NamePhone{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}