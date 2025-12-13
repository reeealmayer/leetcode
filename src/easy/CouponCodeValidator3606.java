package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CouponCodeValidator3606 {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        List<String> arr3 = new ArrayList<>();
        List<String> arr4 = new ArrayList<>();

        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");

        for (int i = 0; i < code.length; i++) {
            if (pattern.matcher(code[i]).matches() && isActive[i]) {
                if (businessLine[i].equals("electronics"))
                    arr1.add(code[i]);
                else if (businessLine[i].equals("grocery"))
                    arr2.add(code[i]);
                else if (businessLine[i].equals("pharmacy"))
                    arr3.add(code[i]);
                else if (businessLine[i].equals("restaurant"))
                    arr4.add(code[i]);
            }
        }

        Collections.sort(arr1);
        Collections.sort(arr2);
        Collections.sort(arr3);
        Collections.sort(arr4);

        arr1.addAll(arr2);
        arr1.addAll(arr3);
        arr1.addAll(arr4);

        return arr1;
    }
}
