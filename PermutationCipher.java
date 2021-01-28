import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCipher {
    int m;
    int[] encKey;
    int[] decKey;

    public PermutationCipher(int[] key, int m){
        this.encKey = key;
        this.m = m;

        this.decKey = new int[m];
        findDecryptionKey(encKey);
        
    }

    

    public String encrypt(String plaintext) {
        String cipherText = "";
        String plainText = plaintext.toLowerCase();
        List<String> cipherArray = getParts(plainText);
        
        for (String string : cipherArray) {
            for (int i = 0; i < string.length(); i++){
                cipherText += string.charAt(encKey[i]);
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
                plainText += string.charAt(decKey[i]);
            }
        }
        
        return plainText;
    }

    public String getEncKey(){
        return Arrays.toString(encKey);
    }

    public String getDecKey(){
        return Arrays.toString(decKey);
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

    private int[] findDecryptionKey(int[] encKey){
        for (int i = 0; i < m; i++) {
            decKey[encKey[i]] = i;
        }

        return decKey;
    }
}
