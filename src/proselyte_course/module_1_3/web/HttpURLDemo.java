package proselyte_course.module_1_3.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws IOException {
        URL hp = new URL("http://google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println(hpCon.getRequestMethod());
        System.out.println(hpCon.getResponseCode());
        System.out.println(hpCon.getResponseMessage());

        Map<String, List<String>> headerFields = hpCon.getHeaderFields();
        Set<String> strings = headerFields.keySet();
        for (String s : strings) {
            System.out.println(s + " " + headerFields.get(s));
        }
    }
}
