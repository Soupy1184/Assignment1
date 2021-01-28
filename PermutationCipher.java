import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCipher {
    int m;
    int[] encryptionKey;
    int[] decryptionKey;

    public PermutationCipher(int[] key, int m){
        this.m = m;
        this.encryptionKey = key;
        this.decryptionKey = new int[m];

        findDecryptionKey(encryptionKey);  
    }

    public String encrypt(String plaintext) {
        String cipherText = "";
        String plainText = plaintext.toLowerCase();

        if (plainText.length() % m != 0){
            int add = m - (plainText.length() % m);
            for (int i = 0; i < add; i++){
                plainText += 'x';
            }
        }

        List<String> cipherArray = getParts(plainText);
        
        for (String string : cipherArray) {
            for (int i = 0; i < string.length(); i++){
                cipherText += string.charAt(encryptionKey[i]);
            }
        }
        
        return cipherText;
    }

    public String decrypt(String ciphertext){
        String plainText = "";
        String cipherText = ciphertext.toLowerCase();
        List<String> plainArray = getParts(cipherText);
        
        for (String string : plainArray) {
            for (int i = 0; i < string.length(); i++){
                plainText += string.charAt(decryptionKey[i]);
            }
        }
        
        return plainText;
    }

    public String getEncryptionKey(){
        return Arrays.toString(encryptionKey);
    }

    public String getDecryptionKey(){
        return Arrays.toString(decryptionKey);
    }

    //This method grabbed from this source:
    //https://stackoverflow.com/questions/2297347/splitting-a-string-at-every-n-th-character
    private List<String> getParts(String string) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=m)
        {
            parts.add(string.substring(i, Math.min(len, i + m)));
        }
        return parts;
    }

    private int[] findDecryptionKey(int[] encryptionKey){
        for (int i = 0; i < m; i++) {
            decryptionKey[encryptionKey[i]] = i;
        }

        return decryptionKey;
    }
}
