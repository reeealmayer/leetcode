package proselyte_course.module_1_3.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.HerbSchildt.com/Articles");

        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getFile());
        System.out.println(url.toExternalForm());

        URLConnection urlConnection = url.openConnection();
    }
}
