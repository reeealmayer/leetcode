package proselyte_course.module_1_3.lambdas_interfaces._2;

public class InstanceMethWithObjectRefDemo {
    static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) {
                count++;
            }
        }

        return count;
    }

    public static <T> boolean someFunction2(MyFunc<T> f, T v1, T v2) {
        return f.func(v1, v2);
    }

    public static boolean someFunction3(MyFunc2 f, int a, int b) {
        return f.func(a, b);
    }

    public static boolean someFunction(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {
        int count;

        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83),
        };

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));

        System.out.println(count);

        System.out.println(someFunction2(InstanceMethWithObjectRefDemo::someFunction, 1, 2));
        System.out.println(someFunction3(InstanceMethWithObjectRefDemo::someFunction, 3, 3));
    }
}
