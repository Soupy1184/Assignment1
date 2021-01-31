import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

    public String getPermutationKey(){
        return Arrays.toString(encryptionKey);
    }

    public String getPermutationM(){
        return String.valueOf(m);
    }

    private void attack(){
        String string1 = "";
        String string2 = "";

        for (int i = 2; i < 10; i++){
            List<String> cipherList = getParts(ciphertext, i);
            List<String> plainList = getParts(plaintext, i);
            int distance = 0;
            
            for(int j = 0; j < cipherList.size(); j++){
                string1 = sortString(cipherList.get(j));
                string2 = sortString(plainList.get(j));

                //System.out.printf("Round %d:\n", j);

                for (int m = 0; m < string1.length(); m++) {
                    //System.out.printf("%s %s \n", string1.charAt(m), string2.charAt(m));
                    if (string1.charAt(m) != string2.charAt(m)){
                      distance++;
                    }
                }
                //System.out.printf("Distance %d, m = %d:\n", distance, this.m);
            }

            if (distance == 0){
                this.m = i;
                break;
            }
        }
        
        encryptionKey = new int[m];
        for (int i = 0; i < encryptionKey.length; i++){
            for (int j = 0; j < encryptionKey.length; j++){
                if (plaintext.charAt(i) == ciphertext.charAt(j)){
                    encryptionKey[i] = j;
                }
            }
        }
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
}
