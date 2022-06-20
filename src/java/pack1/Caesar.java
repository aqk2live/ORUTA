

package pack1;

public class Caesar extends Cipher {
    private static int k = 0;

    public String encode(String word, String key) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char ch2 = word.charAt(i);
            ch2 = (char)('a' + (ch2 -'a'+ (Caesar.calcShift(key)) ) % 26);
            result.append(ch2);
        }

        //Just one line was needed here

        result.append(" ");
        return result.toString();
    }//encode

    public static int calcShift(String key) {
        for (int j = 0; j < 15; j++)
            key = key + key;

        char ch = key.charAt(k);
        int shift = ((ch - 'a') % 26);
        k++;

        return shift; 
    }//calcs which letter shifts how many spaces
}
