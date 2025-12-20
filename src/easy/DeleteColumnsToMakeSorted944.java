package easy;

public class DeleteColumnsToMakeSorted944 {
    public static int minDeletionSize(String[] strs) {
        int result = 0;


//        if (strs.length == 2) {
//            if (strs[0].charAt(0) > strs[1].charAt(0)) {
//                return 1;
//            }
//            return 0;
//        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"x","q"}));
    }
}
