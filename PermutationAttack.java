import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationAttack {
    String ciphertext;
    String plaintext;
    int m;
    int[] encryptionKey;
    int[] decryptionKey;

    public PermutationAttack(String ciphertext, String plaintext){
        this.ciphertext = ciphertext;
        this.plaintext = plaintext;

        attack();
    }

    public String getEncryptionKey(){
        return Arrays.toString(encryptionKey);
    }

    public String getDecryptionKey(){
        return Arrays.toString(decryptionKey);
    }

    public String getPermutationM(){
        return String.valueOf(m);
    }

    private void attack(){
        String string1 = "";
        String string2 = "";
        char[] plaintextArray;
        char[] ciphertextArray;

        //Using hamming distance to find m
        //When it loops through an entire string with 
        //0 distance index i is the length of the permutation
        for (int i = 2; i < 10; i++){
            List<String> cipherList = getParts(ciphertext, i);
            List<String> plainList = getParts(plaintext, i);
            
            int distance = 0;

            for (int j = 0; j < cipherList.size(); j++) {
                string1 = sortString(cipherList.get(j));
                string2 = sortString(plainList.get(j));

                for (int m = 0; m < string1.length(); m++) {
                    if (string1.charAt(m) != string2.charAt(m)) {
                        distance++;
                    }
                }
            }

            if (distance == 0) {
                this.m = i;
                break;
            }
        }
        
        //this step uses the m to place the numbers into the 
        //key array
        decryptionKey = new int[m];
        plaintextArray = plaintext.toCharArray();
        ciphertextArray = ciphertext.toCharArray();
        //Creates a list of strings with size of the key
        List<String> plainCheck = getParts(plaintext, m);
        List<String> cipherCheck = getParts(ciphertext, m);

        //Loop through the list until you find one with no duplicates
        for (int i = 0; i < plainCheck.size(); i++){
            if(!check(plainCheck.get(i))){
                plaintextArray = plainCheck.get(i).toCharArray();
                ciphertextArray = cipherCheck.get(i).toCharArray();
                break;
            }
        }
        
        //Finds the decryption key
        for (int i = 0; i < decryptionKey.length; i++){
            for (int j = 0; j < decryptionKey.length; j++){
                if (plaintextArray[i] == ciphertextArray[j]){
                    decryptionKey[i] = j;
                    ciphertextArray[j] = '_';
                    break;
                }
            }
        }
        //Takes the inverse of the decryption key to find the encryption key
        this.encryptionKey = new int[m];
        encryptionKey = findEncryptionKey(decryptionKey);
    }


    //Method grabbed from this source: 
    //https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    // Method to sort a string alphabetically 
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    }

    //Method grabbed from this source:
    //https://stackoverflow.com/questions/2297347/splitting-a-string-at-every-n-th-character
    private List<String> getParts(String string, int m) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=m)
        {
            parts.add(string.substring(i, Math.min(len, i + m)));
        }
        return parts;
    }

    //function that checks for duplicates
    public static boolean check(String g) {
        for (int i = 0; i < g.length(); i++) {
            for (int j = i + 1; j < g.length(); j++) {
                if (g.charAt(i) == g.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //inverse permutation of decryption key
    private int[] findEncryptionKey(int[] decryptionKey){
        for (int i = 0; i < m; i++) {
            encryptionKey[decryptionKey[i]] = i;
        }

        return encryptionKey;
    }
}
