package proselyte_course.module_1_3.in_out._20;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File f1 = new File("~/IdeaProjects/leetcode/java/COPYRIGHT");
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
        System.out.println(f1.exists());
    }
}
