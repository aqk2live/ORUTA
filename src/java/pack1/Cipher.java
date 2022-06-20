

package pack1;

import java.util.StringTokenizer;


public abstract class Cipher
{
    public String encrypt(String s, String key)
    {
        StringBuffer result = new StringBuffer("");
        StringTokenizer words = new StringTokenizer(s);

        while (words.hasMoreTokens())
        {
            result.append(encode( (words.nextToken()), key));
        }
        return result.toString();
    }//splits into words

    public abstract String encode(String word, String key);
}
