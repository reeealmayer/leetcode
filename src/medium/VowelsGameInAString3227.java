package medium;

public class VowelsGameInAString3227 {
    public boolean doesAliceWin(String s) {
        int countOfVowels = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                countOfVowels++;
            }
        }

        if (countOfVowels == 0) {
            return false;
        }

        return true;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
