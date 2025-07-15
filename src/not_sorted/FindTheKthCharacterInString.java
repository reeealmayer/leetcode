package not_sorted;

public class FindTheKthCharacterInString {
    public static final String WORD = "abbcbccdbccdcddebccdcddecddedeefbccdcddecddedeefcddedeefdeefeffgbccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghbccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghcddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhibccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghcddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhicddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhideefeffgeffgfggheffgfgghfgghghhieffgfgghfgghghhifgghghhighhihiij";
    public static char kthCharacter(int k) {
//        StringBuilder word = new StringBuilder("a");
//
//        while (word.length() < k) {
//            word.append(next(word));
//        }
        return WORD.charAt(k - 1);
    }

    private static String next(StringBuilder word) {
        StringBuilder result = new StringBuilder();
        for (char ch : word.toString().toCharArray()) {
            result.append((char) ((ch - 'a' + 1) % 26 + 'a'));
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(kthCharacter(5));
    }
}
