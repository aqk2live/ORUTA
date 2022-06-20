

package pack1;

public class TestEncrypt
{
    public static void main(String arg[])
    {
       Caesar Caesar = new Caesar();     
       String plain = "hey whats up";
       String keyword = "2&$1a";
       String secret = Caesar.encrypt(plain, keyword);
       System.out.println(" ******** Caesar Cipher Encryption *********");
       System.out.println("PlainText: " + plain);
       System.out.println("Encrypted: " + secret);
    }
}
