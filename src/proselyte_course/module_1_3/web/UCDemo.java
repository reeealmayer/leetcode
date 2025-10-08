package proselyte_course.module_1_3.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws IOException {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpCon = hp.openConnection();


        long date = hpCon.getDate();
        if (date != 0) {
            System.out.println(new Date(date));
        }

        long lastModified = hpCon.getLastModified();
        System.out.println(new Date(lastModified));


    }
}
