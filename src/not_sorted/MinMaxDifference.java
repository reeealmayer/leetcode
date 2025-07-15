package not_sorted;

public class MinMaxDifference {
    public static int minMaxDifference(int num) {
        String s = Integer.toString(num);

        char characterToReplaceToMax = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (c != '9') {
                characterToReplaceToMax = c;
                break;
            }
        }

        String maxString = s.replace(characterToReplaceToMax, '9');

        char characterToReplaceToMin = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (c != '0') {
                characterToReplaceToMin = c;
                break;
            }
        }

        String minString = s.replace(characterToReplaceToMin, '0');

        return Integer.parseInt(maxString) - Integer.parseInt(minString);
    }

    public static void main(String[] args) {

    }
}
